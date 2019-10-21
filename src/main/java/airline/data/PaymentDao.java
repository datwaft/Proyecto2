package airline.data;

import airline.logic.Payment;
import java.util.List;
import javax.persistence.EntityManager;

public class PaymentDao extends PaymentJpaController
{
  private PaymentDao()
  {
    super(PersistenceManager.getInstance().getEntityManagerFactory());
  }
  
  public List<Payment> findAll()
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT p FROM Payment p")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
  
  public List<Payment> findById(String id)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT p FROM Payment p WHERE cast(p.id as char) like :id")
        .setParameter("id", "%" + id + "%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
  
  public List<Payment> findByName(String name)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT p FROM Payment p WHERE p.name like :name")
        .setParameter("name", "%" + name + "%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
  
  public static PaymentDao getInstance()
  {
    return PaymentDaoHolder.INSTANCE;
  }
  
  private static class PaymentDaoHolder
  {
    private static final PaymentDao INSTANCE = new PaymentDao();
  }
}
