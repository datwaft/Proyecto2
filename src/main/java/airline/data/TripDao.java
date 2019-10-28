package airline.data;

import airline.logic.*;
import java.util.List;
import javax.persistence.EntityManager;

public class TripDao extends TripJpaController
{
  private TripDao()
  {
    super(PersistenceManager.getInstance().getEntityManagerFactory());
  }
  
  public void update(Trip object)
  {
    EntityManager em = getEntityManager();
    try
    {
      Trip other = em.find(Trip.class, object.getIdentifier());

      em.getTransaction().begin();
      other.setPlane(object.getPlane());
      other.setOutward(object.getOutward());
      other.setDeparture(object.getDeparture());
      other.setInward(object.getInward());
      other.setArrival(object.getArrival());
      em.getTransaction().commit();
    }
    finally
    {
      em.close();
    }
  }
  
  public List<Trip> findAll()
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT t FROM Trip t")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
  
  public List<Trip> findByIdentifier(String string, Object plane, Object outward, Object inward)
  {
    EntityManager em = getEntityManager();
    try
    {
      if(inward == null)
      {
        return em.createQuery("SELECT t FROM Trip t WHERE CAST(t.identifier AS CHAR) LIKE :identifier "
        + "AND t.plane.identifier LIKE :plane "
        + "AND CAST(t.outward.identifier AS CHAR) LIKE :outward "
        + "AND t.inward IS NULL")
        .setParameter("identifier", "%" + string + "%")
        .setParameter("plane", (plane.getClass() == Plane.class ? ((Plane)plane).getIdentifier() : "%%"))
        .setParameter("outward", (outward.getClass() == Flight.class ? ((Flight)outward).getIdentifier() : "%%"))
        .getResultList();
      }
      else if(inward.getClass() == String.class)
      {
        return em.createQuery("SELECT t FROM Trip t WHERE CAST(t.identifier AS CHAR) LIKE :identifier "
        + "AND t.plane.identifier LIKE :plane "
        + "AND CAST(t.outward.identifier AS CHAR) LIKE :outward")
        .setParameter("identifier", "%" + string + "%")
        .setParameter("plane", (plane.getClass() == Plane.class ? ((Plane)plane).getIdentifier() : "%%"))
        .setParameter("outward", (outward.getClass() == Flight.class ? ((Flight)outward).getIdentifier() : "%%"))
        .getResultList();
      }
      else
      {
        return em.createQuery("SELECT t FROM Trip t WHERE CAST(t.identifier AS CHAR) LIKE :identifier "
        + "AND t.plane.identifier LIKE :plane "
        + "AND CAST(t.outward.identifier AS CHAR) LIKE :outward "
        + "AND CAST(t.inward.identifier AS CHAR) LIKE :inward"
        + (inward.getClass() == String.class ? " OR t.inward IS NULL" : ""))
        .setParameter("identifier", "%" + string + "%")
        .setParameter("plane", (plane.getClass() == Plane.class ? ((Plane)plane).getIdentifier() : "%%"))
        .setParameter("outward", (outward.getClass() == Flight.class ? ((Flight)outward).getIdentifier() : "%%"))
        .setParameter("inward", ((Flight)inward).getIdentifier())
        .getResultList();
      }
    }
    finally
    {
      em.close();
    }
  }
  
  public List<Trip> findByDeparture(String string, Object plane, Object outward, Object inward)
  {
    EntityManager em = getEntityManager();
    try
    {
      if(inward == null)
      {
        return em.createQuery("SELECT t FROM Trip t WHERE CAST(t.departure AS CHAR) LIKE :departure "
        + "AND t.plane.identifier LIKE :plane "
        + "AND CAST(t.outward.identifier AS CHAR) LIKE :outward "
        + "AND t.inward IS NULL")
        .setParameter("departure", "%" + string + "%")
        .setParameter("plane", (plane.getClass() == Plane.class ? ((Plane)plane).getIdentifier() : "%%"))
        .setParameter("outward", (outward.getClass() == Flight.class ? ((Flight)outward).getIdentifier() : "%%"))
        .getResultList();
      }
      else if(inward.getClass() == String.class)
      {
        return em.createQuery("SELECT t FROM Trip t WHERE CAST(t.departure AS CHAR) LIKE :departure "
        + "AND t.plane.identifier LIKE :plane "
        + "AND CAST(t.outward.identifier AS CHAR) LIKE :outward")
        .setParameter("departure", "%" + string + "%")
        .setParameter("plane", (plane.getClass() == Plane.class ? ((Plane)plane).getIdentifier() : "%%"))
        .setParameter("outward", (outward.getClass() == Flight.class ? ((Flight)outward).getIdentifier() : "%%"))
        .getResultList();
      }
      else
      {
        return em.createQuery("SELECT t FROM Trip t WHERE CAST(t.departure AS CHAR) LIKE :departure "
        + "AND t.plane.identifier LIKE :plane "
        + "AND CAST(t.outward.identifier AS CHAR) LIKE :outward "
        + "AND CAST(t.inward.identifier AS CHAR) LIKE :inward"
        + (inward.getClass() == String.class ? " OR t.inward IS NULL" : ""))
        .setParameter("departure", "%" + string + "%")
        .setParameter("plane", (plane.getClass() == Plane.class ? ((Plane)plane).getIdentifier() : "%%"))
        .setParameter("outward", (outward.getClass() == Flight.class ? ((Flight)outward).getIdentifier() : "%%"))
        .setParameter("inward", ((Flight)inward).getIdentifier())
        .getResultList();
      }
    }
    finally
    {
      em.close();
    }
  }
  
  public List<Trip> findByArrival(String string, Object plane, Object outward, Object inward)
  {
    EntityManager em = getEntityManager();
    try
    {
      if(string.isEmpty())
      {
        if(inward == null)
        {
          return em.createQuery("SELECT t FROM Trip t WHERE "
          + "t.plane.identifier LIKE :plane "
          + "AND CAST(t.outward.identifier AS CHAR) LIKE :outward "
          + "AND t.inward IS NULL")
          .setParameter("plane", (plane.getClass() == Plane.class ? ((Plane)plane).getIdentifier() : "%%"))
          .setParameter("outward", (outward.getClass() == Flight.class ? ((Flight)outward).getIdentifier() : "%%"))
          .getResultList();
        }
        else if(inward.getClass() == String.class)
        {
          return em.createQuery("SELECT t FROM Trip t WHERE "
          + "t.plane.identifier LIKE :plane "
          + "AND CAST(t.outward.identifier AS CHAR) LIKE :outward")
          .setParameter("plane", (plane.getClass() == Plane.class ? ((Plane)plane).getIdentifier() : "%%"))
          .setParameter("outward", (outward.getClass() == Flight.class ? ((Flight)outward).getIdentifier() : "%%"))
          .getResultList();
        }
        else
        {
          return em.createQuery("SELECT t FROM Trip t WHERE "
          + "t.plane.identifier LIKE :plane "
          + "AND CAST(t.outward.identifier AS CHAR) LIKE :outward "
          + "AND CAST(t.inward.identifier AS CHAR) LIKE :inward"
          + (inward.getClass() == String.class ? " OR t.inward IS NULL" : ""))
          .setParameter("plane", (plane.getClass() == Plane.class ? ((Plane)plane).getIdentifier() : "%%"))
          .setParameter("outward", (outward.getClass() == Flight.class ? ((Flight)outward).getIdentifier() : "%%"))
          .setParameter("inward", ((Flight)inward).getIdentifier())
          .getResultList();
        }
      }
      else
      {
        if(inward == null)
        {
          return em.createQuery("SELECT t FROM Trip t WHERE CAST(t.arrival AS CHAR) LIKE :arrival "
          + "AND t.plane.identifier LIKE :plane "
          + "AND CAST(t.outward.identifier AS CHAR) LIKE :outward "
          + "AND t.inward IS NULL")
          .setParameter("arrival", "%" + string + "%")
          .setParameter("plane", (plane.getClass() == Plane.class ? ((Plane)plane).getIdentifier() : "%%"))
          .setParameter("outward", (outward.getClass() == Flight.class ? ((Flight)outward).getIdentifier() : "%%"))
          .getResultList();
        }
        else if(inward.getClass() == String.class)
        {
          return em.createQuery("SELECT t FROM Trip t WHERE CAST(t.arrival AS CHAR) LIKE :arrival "
          + "AND t.plane.identifier LIKE :plane "
          + "AND CAST(t.outward.identifier AS CHAR) LIKE :outward")
          .setParameter("arrival", "%" + string + "%")
          .setParameter("plane", (plane.getClass() == Plane.class ? ((Plane)plane).getIdentifier() : "%%"))
          .setParameter("outward", (outward.getClass() == Flight.class ? ((Flight)outward).getIdentifier() : "%%"))
          .getResultList();
        }
        else
        {
          return em.createQuery("SELECT t FROM Trip t WHERE CAST(t.arrival AS CHAR) LIKE :arrival "
          + "AND t.plane.identifier LIKE :plane "
          + "AND CAST(t.outward.identifier AS CHAR) LIKE :outward "
          + "AND CAST(t.inward.identifier AS CHAR) LIKE :inward"
          + (inward.getClass() == String.class ? " OR t.inward IS NULL" : ""))
          .setParameter("arrival", "%" + string + "%")
          .setParameter("plane", (plane.getClass() == Plane.class ? ((Plane)plane).getIdentifier() : "%%"))
          .setParameter("outward", (outward.getClass() == Flight.class ? ((Flight)outward).getIdentifier() : "%%"))
          .setParameter("inward", ((Flight)inward).getIdentifier())
          .getResultList();
        }
      }
    }
    finally
    {
      em.close();
    }
  }
  
  public static TripDao getInstance() 
  {
    return TripDaoHolder.INSTANCE;
  }

  private static class TripDaoHolder 
  {
    private static final TripDao INSTANCE = new TripDao();
  }
}
