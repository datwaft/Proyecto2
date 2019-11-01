package airline.data;

import airline.exceptions.IllegalOrphanException;
import airline.exceptions.NonexistentEntityException;
import airline.logic.*;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

public class ReservationJpaController implements Serializable
{
  public ReservationJpaController(EntityManagerFactory emf)
  {
    this.emf = emf;
  }
  private EntityManagerFactory emf = null;

  public EntityManager getEntityManager()
  {
    return emf.createEntityManager();
  }

  public void create(Reservation reservation)
  {
    if (reservation.getTicketList() == null)
    {
      reservation.setTicketList(new ArrayList<Ticket>());
    }
    EntityManager em = null;
    try
    {
      em = getEntityManager();
      em.getTransaction().begin();
      Payment payment = reservation.getPayment();
      if (payment != null)
      {
        payment = em.getReference(payment.getClass(), payment.getId());
        reservation.setPayment(payment);
      }
      User user = reservation.getUser();
      if (user != null)
      {
        user = em.getReference(user.getClass(), user.getUsername());
        reservation.setUser(user);
      }
      List<Ticket> attachedTicketList = new ArrayList<Ticket>();
      for (Ticket ticketListTicketToAttach : reservation.getTicketList())
      {
        ticketListTicketToAttach = em.getReference(ticketListTicketToAttach.getClass(), ticketListTicketToAttach.getId());
        attachedTicketList.add(ticketListTicketToAttach);
      }
      reservation.setTicketList(attachedTicketList);
      em.persist(reservation);
      if (payment != null)
      {
        payment.getReservationList().add(reservation);
        payment = em.merge(payment);
      }
      if (user != null)
      {
        user.getReservationList().add(reservation);
        user = em.merge(user);
      }
      for (Ticket ticketListTicket : reservation.getTicketList())
      {
        Reservation oldReservationOfTicketListTicket = ticketListTicket.getReservation();
        ticketListTicket.setReservation(reservation);
        ticketListTicket = em.merge(ticketListTicket);
        if (oldReservationOfTicketListTicket != null)
        {
          oldReservationOfTicketListTicket.getTicketList().remove(ticketListTicket);
          oldReservationOfTicketListTicket = em.merge(oldReservationOfTicketListTicket);
        }
      }
      em.getTransaction().commit();
    }
    finally
    {
      if (em != null)
      {
        em.close();
      }
    }
  }

  public void edit(Reservation reservation) throws IllegalOrphanException, NonexistentEntityException, Exception
  {
    EntityManager em = null;
    try
    {
      em = getEntityManager();
      em.getTransaction().begin();
      Reservation persistentReservation = em.find(Reservation.class, reservation.getId());
      Payment paymentOld = persistentReservation.getPayment();
      Payment paymentNew = reservation.getPayment();
      User userOld = persistentReservation.getUser();
      User userNew = reservation.getUser();
      List<Ticket> ticketListOld = persistentReservation.getTicketList();
      List<Ticket> ticketListNew = reservation.getTicketList();
      List<String> illegalOrphanMessages = null;
      for (Ticket ticketListOldTicket : ticketListOld)
      {
        if (!ticketListNew.contains(ticketListOldTicket))
        {
          if (illegalOrphanMessages == null)
          {
            illegalOrphanMessages = new ArrayList<String>();
          }
          illegalOrphanMessages.add("You must retain Ticket " + ticketListOldTicket + " since its reservation field is not nullable.");
        }
      }
      if (illegalOrphanMessages != null)
      {
        throw new IllegalOrphanException(illegalOrphanMessages);
      }
      if (paymentNew != null)
      {
        paymentNew = em.getReference(paymentNew.getClass(), paymentNew.getId());
        reservation.setPayment(paymentNew);
      }
      if (userNew != null)
      {
        userNew = em.getReference(userNew.getClass(), userNew.getUsername());
        reservation.setUser(userNew);
      }
      List<Ticket> attachedTicketListNew = new ArrayList<Ticket>();
      for (Ticket ticketListNewTicketToAttach : ticketListNew)
      {
        ticketListNewTicketToAttach = em.getReference(ticketListNewTicketToAttach.getClass(), ticketListNewTicketToAttach.getId());
        attachedTicketListNew.add(ticketListNewTicketToAttach);
      }
      ticketListNew = attachedTicketListNew;
      reservation.setTicketList(ticketListNew);
      reservation = em.merge(reservation);
      if (paymentOld != null && !paymentOld.equals(paymentNew))
      {
        paymentOld.getReservationList().remove(reservation);
        paymentOld = em.merge(paymentOld);
      }
      if (paymentNew != null && !paymentNew.equals(paymentOld))
      {
        paymentNew.getReservationList().add(reservation);
        paymentNew = em.merge(paymentNew);
      }
      if (userOld != null && !userOld.equals(userNew))
      {
        userOld.getReservationList().remove(reservation);
        userOld = em.merge(userOld);
      }
      if (userNew != null && !userNew.equals(userOld))
      {
        userNew.getReservationList().add(reservation);
        userNew = em.merge(userNew);
      }
      for (Ticket ticketListNewTicket : ticketListNew)
      {
        if (!ticketListOld.contains(ticketListNewTicket))
        {
          Reservation oldReservationOfTicketListNewTicket = ticketListNewTicket.getReservation();
          ticketListNewTicket.setReservation(reservation);
          ticketListNewTicket = em.merge(ticketListNewTicket);
          if (oldReservationOfTicketListNewTicket != null && !oldReservationOfTicketListNewTicket.equals(reservation))
          {
            oldReservationOfTicketListNewTicket.getTicketList().remove(ticketListNewTicket);
            oldReservationOfTicketListNewTicket = em.merge(oldReservationOfTicketListNewTicket);
          }
        }
      }
      em.getTransaction().commit();
    }
    catch (Exception ex)
    {
      String msg = ex.getLocalizedMessage();
      if (msg == null || msg.length() == 0)
      {
        Integer id = reservation.getId();
        if (findReservation(id) == null)
        {
          throw new NonexistentEntityException("The reservation with id " + id + " no longer exists.");
        }
      }
      throw ex;
    }
    finally
    {
      if (em != null)
      {
        em.close();
      }
    }
  }

  public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException
  {
    EntityManager em = null;
    try
    {
      em = getEntityManager();
      em.getTransaction().begin();
      Reservation reservation;
      try
      {
        reservation = em.getReference(Reservation.class, id);
        reservation.getId();
      }
      catch (EntityNotFoundException enfe)
      {
        throw new NonexistentEntityException("The reservation with id " + id + " no longer exists.", enfe);
      }
      List<String> illegalOrphanMessages = null;
      List<Ticket> ticketListOrphanCheck = reservation.getTicketList();
      for (Ticket ticketListOrphanCheckTicket : ticketListOrphanCheck)
      {
        if (illegalOrphanMessages == null)
        {
          illegalOrphanMessages = new ArrayList<String>();
        }
        illegalOrphanMessages.add("This Reservation (" + reservation + ") cannot be destroyed since the Ticket " + ticketListOrphanCheckTicket + " in its ticketList field has a non-nullable reservation field.");
      }
      if (illegalOrphanMessages != null)
      {
        throw new IllegalOrphanException(illegalOrphanMessages);
      }
      Payment payment = reservation.getPayment();
      if (payment != null)
      {
        payment.getReservationList().remove(reservation);
        payment = em.merge(payment);
      }
      User user = reservation.getUser();
      if (user != null)
      {
        user.getReservationList().remove(reservation);
        user = em.merge(user);
      }
      em.remove(reservation);
      em.getTransaction().commit();
    }
    finally
    {
      if (em != null)
      {
        em.close();
      }
    }
  }

  public List<Reservation> findReservationEntities()
  {
    return findReservationEntities(true, -1, -1);
  }

  public List<Reservation> findReservationEntities(int maxResults, int firstResult)
  {
    return findReservationEntities(false, maxResults, firstResult);
  }

  private List<Reservation> findReservationEntities(boolean all, int maxResults, int firstResult)
  {
    EntityManager em = getEntityManager();
    try
    {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      cq.select(cq.from(Reservation.class));
      Query q = em.createQuery(cq);
      if (!all)
      {
        q.setMaxResults(maxResults);
        q.setFirstResult(firstResult);
      }
      return q.getResultList();
    }
    finally
    {
      em.close();
    }
  }

  public Reservation findReservation(Integer id)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.find(Reservation.class, id);
    }
    finally
    {
      em.close();
    }
  }

  public int getReservationCount()
  {
    EntityManager em = getEntityManager();
    try
    {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      Root<Reservation> rt = cq.from(Reservation.class);
      cq.select(em.getCriteriaBuilder().count(rt));
      Query q = em.createQuery(cq);
      return ((Long) q.getSingleResult()).intValue();
    }
    finally
    {
      em.close();
    }
  }

}
