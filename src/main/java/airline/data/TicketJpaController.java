package airline.data;

import airline.exceptions.NonexistentEntityException;
import airline.logic.*;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import javax.persistence.*;

public class TicketJpaController implements Serializable
{
  public TicketJpaController(EntityManagerFactory emf)
  {
    this.emf = emf;
  }
  private EntityManagerFactory emf = null;

  public EntityManager getEntityManager()
  {
    return emf.createEntityManager();
  }

  public void create(Ticket ticket)
  {
    EntityManager em = null;
    try
    {
      em = getEntityManager();
      em.getTransaction().begin();
      Reservation reservation = ticket.getReservation();
      if (reservation != null)
      {
        reservation = em.getReference(reservation.getClass(), reservation.getId());
        ticket.setReservation(reservation);
      }
      Trip trip = ticket.getTrip();
      if (trip != null)
      {
        trip = em.getReference(trip.getClass(), trip.getIdentifier());
        ticket.setTrip(trip);
      }
      em.persist(ticket);
      if (reservation != null)
      {
        reservation.getTicketList().add(ticket);
        reservation = em.merge(reservation);
      }
      if (trip != null)
      {
        trip.getTicketList().add(ticket);
        trip = em.merge(trip);
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

  public void edit(Ticket ticket) throws NonexistentEntityException, Exception
  {
    EntityManager em = null;
    try
    {
      em = getEntityManager();
      em.getTransaction().begin();
      Ticket persistentTicket = em.find(Ticket.class, ticket.getId());
      Reservation reservationOld = persistentTicket.getReservation();
      Reservation reservationNew = ticket.getReservation();
      Trip tripOld = persistentTicket.getTrip();
      Trip tripNew = ticket.getTrip();
      if (reservationNew != null)
      {
        reservationNew = em.getReference(reservationNew.getClass(), reservationNew.getId());
        ticket.setReservation(reservationNew);
      }
      if (tripNew != null)
      {
        tripNew = em.getReference(tripNew.getClass(), tripNew.getIdentifier());
        ticket.setTrip(tripNew);
      }
      ticket = em.merge(ticket);
      if (reservationOld != null && !reservationOld.equals(reservationNew))
      {
        reservationOld.getTicketList().remove(ticket);
        reservationOld = em.merge(reservationOld);
      }
      if (reservationNew != null && !reservationNew.equals(reservationOld))
      {
        reservationNew.getTicketList().add(ticket);
        reservationNew = em.merge(reservationNew);
      }
      if (tripOld != null && !tripOld.equals(tripNew))
      {
        tripOld.getTicketList().remove(ticket);
        tripOld = em.merge(tripOld);
      }
      if (tripNew != null && !tripNew.equals(tripOld))
      {
        tripNew.getTicketList().add(ticket);
        tripNew = em.merge(tripNew);
      }
      em.getTransaction().commit();
    }
    catch (Exception ex)
    {
      String msg = ex.getLocalizedMessage();
      if (msg == null || msg.length() == 0)
      {
        Integer id = ticket.getId();
        if (findTicket(id) == null)
        {
          throw new NonexistentEntityException("The ticket with id " + id + " no longer exists.");
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

  public void destroy(Integer id) throws NonexistentEntityException
  {
    EntityManager em = null;
    try
    {
      em = getEntityManager();
      em.getTransaction().begin();
      Ticket ticket;
      try
      {
        ticket = em.getReference(Ticket.class, id);
        ticket.getId();
      }
      catch (EntityNotFoundException enfe)
      {
        throw new NonexistentEntityException("The ticket with id " + id + " no longer exists.", enfe);
      }
      Reservation reservation = ticket.getReservation();
      if (reservation != null)
      {
        reservation.getTicketList().remove(ticket);
        reservation = em.merge(reservation);
      }
      Trip trip = ticket.getTrip();
      if (trip != null)
      {
        trip.getTicketList().remove(ticket);
        trip = em.merge(trip);
      }
      em.remove(ticket);
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

  public List<Ticket> findTicketEntities()
  {
    return findTicketEntities(true, -1, -1);
  }

  public List<Ticket> findTicketEntities(int maxResults, int firstResult)
  {
    return findTicketEntities(false, maxResults, firstResult);
  }

  private List<Ticket> findTicketEntities(boolean all, int maxResults, int firstResult)
  {
    EntityManager em = getEntityManager();
    try
    {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      cq.select(cq.from(Ticket.class));
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

  public Ticket findTicket(Integer id)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.find(Ticket.class, id);
    }
    finally
    {
      em.close();
    }
  }

  public int getTicketCount()
  {
    EntityManager em = getEntityManager();
    try
    {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      Root<Ticket> rt = cq.from(Ticket.class);
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
