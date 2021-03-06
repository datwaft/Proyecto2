package airline.data;

import airline.exceptions.IllegalOrphanException;
import airline.exceptions.NonexistentEntityException;
import airline.logic.Payment;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import airline.logic.Reservation;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

public class PaymentJpaController implements Serializable
{
  public PaymentJpaController(EntityManagerFactory emf)
  {
    this.emf = emf;
  }
  private EntityManagerFactory emf = null;

  public EntityManager getEntityManager()
  {
    return emf.createEntityManager();
  }

  public void create(Payment payment)
  {
    if (payment.getReservationList() == null)
    {
      payment.setReservationList(new ArrayList<Reservation>());
    }
    EntityManager em = null;
    try
    {
      em = getEntityManager();
      em.getTransaction().begin();
      List<Reservation> attachedReservationList = new ArrayList<Reservation>();
      for (Reservation reservationListReservationToAttach : payment.getReservationList())
      {
        reservationListReservationToAttach = em.getReference(reservationListReservationToAttach.getClass(), reservationListReservationToAttach.getId());
        attachedReservationList.add(reservationListReservationToAttach);
      }
      payment.setReservationList(attachedReservationList);
      em.persist(payment);
      for (Reservation reservationListReservation : payment.getReservationList())
      {
        Payment oldPaymentOfReservationListReservation = reservationListReservation.getPayment();
        reservationListReservation.setPayment(payment);
        reservationListReservation = em.merge(reservationListReservation);
        if (oldPaymentOfReservationListReservation != null)
        {
          oldPaymentOfReservationListReservation.getReservationList().remove(reservationListReservation);
          oldPaymentOfReservationListReservation = em.merge(oldPaymentOfReservationListReservation);
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

  public void edit(Payment payment) throws IllegalOrphanException, NonexistentEntityException, Exception
  {
    EntityManager em = null;
    try
    {
      em = getEntityManager();
      em.getTransaction().begin();
      Payment persistentPayment = em.find(Payment.class, payment.getId());
      List<Reservation> reservationListOld = persistentPayment.getReservationList();
      List<Reservation> reservationListNew = payment.getReservationList();
      List<String> illegalOrphanMessages = null;
      for (Reservation reservationListOldReservation : reservationListOld)
      {
        if (!reservationListNew.contains(reservationListOldReservation))
        {
          if (illegalOrphanMessages == null)
          {
            illegalOrphanMessages = new ArrayList<String>();
          }
          illegalOrphanMessages.add("You must retain Reservation " + reservationListOldReservation + " since its payment field is not nullable.");
        }
      }
      if (illegalOrphanMessages != null)
      {
        throw new IllegalOrphanException(illegalOrphanMessages);
      }
      List<Reservation> attachedReservationListNew = new ArrayList<Reservation>();
      for (Reservation reservationListNewReservationToAttach : reservationListNew)
      {
        reservationListNewReservationToAttach = em.getReference(reservationListNewReservationToAttach.getClass(), reservationListNewReservationToAttach.getId());
        attachedReservationListNew.add(reservationListNewReservationToAttach);
      }
      reservationListNew = attachedReservationListNew;
      payment.setReservationList(reservationListNew);
      payment = em.merge(payment);
      for (Reservation reservationListNewReservation : reservationListNew)
      {
        if (!reservationListOld.contains(reservationListNewReservation))
        {
          Payment oldPaymentOfReservationListNewReservation = reservationListNewReservation.getPayment();
          reservationListNewReservation.setPayment(payment);
          reservationListNewReservation = em.merge(reservationListNewReservation);
          if (oldPaymentOfReservationListNewReservation != null && !oldPaymentOfReservationListNewReservation.equals(payment))
          {
            oldPaymentOfReservationListNewReservation.getReservationList().remove(reservationListNewReservation);
            oldPaymentOfReservationListNewReservation = em.merge(oldPaymentOfReservationListNewReservation);
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
        Integer id = payment.getId();
        if (findPayment(id) == null)
        {
          throw new NonexistentEntityException("The payment with id " + id + " no longer exists.");
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
      Payment payment;
      try
      {
        payment = em.getReference(Payment.class, id);
        payment.getId();
      }
      catch (EntityNotFoundException enfe)
      {
        throw new NonexistentEntityException("The payment with id " + id + " no longer exists.", enfe);
      }
      List<String> illegalOrphanMessages = null;
      List<Reservation> reservationListOrphanCheck = payment.getReservationList();
      for (Reservation reservationListOrphanCheckReservation : reservationListOrphanCheck)
      {
        if (illegalOrphanMessages == null)
        {
          illegalOrphanMessages = new ArrayList<String>();
        }
        illegalOrphanMessages.add("This Payment (" + payment + ") cannot be destroyed since the Reservation " + reservationListOrphanCheckReservation + " in its reservationList field has a non-nullable payment field.");
      }
      if (illegalOrphanMessages != null)
      {
        throw new IllegalOrphanException(illegalOrphanMessages);
      }
      em.remove(payment);
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

  public List<Payment> findPaymentEntities()
  {
    return findPaymentEntities(true, -1, -1);
  }

  public List<Payment> findPaymentEntities(int maxResults, int firstResult)
  {
    return findPaymentEntities(false, maxResults, firstResult);
  }

  private List<Payment> findPaymentEntities(boolean all, int maxResults, int firstResult)
  {
    EntityManager em = getEntityManager();
    try
    {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      cq.select(cq.from(Payment.class));
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

  public Payment findPayment(Integer id)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.find(Payment.class, id);
    }
    finally
    {
      em.close();
    }
  }

  public int getPaymentCount()
  {
    EntityManager em = getEntityManager();
    try
    {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      Root<Payment> rt = cq.from(Payment.class);
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
