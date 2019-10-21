package airline.data;

import airline.exceptions.NonexistentEntityException;
import airline.logic.Payment;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
    EntityManager em = null;
    try
    {
      em = getEntityManager();
      em.getTransaction().begin();
      em.persist(payment);
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

  public void edit(Payment payment) throws NonexistentEntityException, Exception
  {
    EntityManager em = null;
    try
    {
      em = getEntityManager();
      em.getTransaction().begin();
      payment = em.merge(payment);
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

  public void destroy(Integer id) throws NonexistentEntityException
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
