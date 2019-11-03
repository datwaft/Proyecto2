package airline.data;

import airline.logic.*;
import java.util.List;
import javax.persistence.EntityManager;

public class ReservationDao extends ReservationJpaController
{
  private ReservationDao()
  {
    super(PersistenceManager.getInstance().getEntityManagerFactory());
  }

  public static ReservationDao getInstance() 
  {
    return ReservationDaoHolder.INSTANCE;
  }

  public List<Reservation> findAll(User user)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT r FROM Reservation r WHERE r.user.username = :user")
        .setParameter("user", user.getUsername())
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }

  public List<Reservation> findByAmount(String string, User user)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT r FROM Reservation r WHERE r.user.username = :user AND CAST(r.amount AS CHAR) like :amount")
        .setParameter("user", user.getUsername())
        .setParameter("amount", "%"+string+"%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }

  public List<Reservation> findByTimestamp(String string, User user)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT r FROM Reservation r WHERE r.user.username = :user AND CAST(r.timestamp AS CHAR) like :timestamp")
        .setParameter("user", user.getUsername())
        .setParameter("timestamp", "%"+string+"%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }

  public List<Reservation> findById(String string, User user)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT r FROM Reservation r WHERE r.user.username = :user AND CAST(r.id AS CHAR) like :id")
        .setParameter("user", user.getUsername())
        .setParameter("id", "%"+string+"%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }

  public List<Reservation> findByTrip(Trip trip, User user)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT r FROM Reservation r WHERE r.user.username = :user AND r.trip.identifier = :trip")
        .setParameter("user", user.getUsername())
        .setParameter("trip", trip.getIdentifier())
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }

  public List<Reservation> findByPayment(Payment payment, User user)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT r FROM Reservation r WHERE r.user.username = :user AND r.payment.id = :payment")
        .setParameter("user", user.getUsername())
        .setParameter("payment", payment.getId())
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
  
  public List<Reservation> findAll()
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT r FROM Reservation r")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }

  public List<Reservation> findByAmount(String string)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT r FROM Reservation r WHERE CAST(r.amount AS CHAR) like :amount")
        .setParameter("amount", "%"+string+"%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }

  public List<Reservation> findByTimestamp(String string)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT r FROM Reservation r WHERE CAST(r.timestamp AS CHAR) like :timestamp")
        .setParameter("timestamp", "%"+string+"%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }

  public List<Reservation> findById(String string)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT r FROM Reservation r WHERE CAST(r.id AS CHAR) like :id")
        .setParameter("id", "%"+string+"%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }

  public List<Reservation> findByTrip(Trip trip)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT r FROM Reservation r WHERE r.trip.identifier = :trip")
        .setParameter("trip", trip.getIdentifier())
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }

  public List<Reservation> findByPayment(Payment payment)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT r FROM Reservation r WHERE r.payment.id = :payment")
        .setParameter("payment", payment.getId())
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }

  private static class ReservationDaoHolder 
  {
    private static final ReservationDao INSTANCE = new ReservationDao();
  }
}
