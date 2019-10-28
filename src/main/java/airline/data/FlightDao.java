package airline.data;

import airline.logic.City;
import airline.logic.Flight;
import java.util.List;
import javax.persistence.EntityManager;

public class FlightDao extends FlightJpaController
{ 
  private FlightDao()
  {
    super(PersistenceManager.getInstance().getEntityManagerFactory());
  }

  public static FlightDao getInstance() 
  {
    return FlightDaoHolder.INSTANCE;
  }

  public void update(Flight object)
  {
    EntityManager em = getEntityManager();
    try
    {
      Flight other = em.find(Flight.class, object.getIdentifier());

      em.getTransaction().begin();
      other.setOrigin(object.getOrigin());
      other.setDestination(object.getDestination());
      other.setWeekday(object.getWeekday());
      other.setDeparture(object.getDeparture());
      other.setDuration(object.getDuration());
      other.setPrice(object.getPrice());
      other.setDiscount(object.getDiscount());
      em.getTransaction().commit();
      em.getEntityManagerFactory().getCache().evict(Flight.class, object.getIdentifier());
    }
    finally
    {
      em.close();
    }
  }
  
  public List<Flight> findAll()
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT f FROM Flight f")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
  
  public List<Flight> findByCities(City origin, City destination)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT f FROM Flight f WHERE f.origin.code LIKE :origin AND f.destination.code LIKE :destination")
        .setParameter("origin", "%"+origin.getCode()+"%")
        .setParameter("destination", "%"+destination.getCode()+"%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
  
  public List<Flight> findByIdentifier(String identifier, City origin, City destination)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT f FROM Flight f WHERE CAST(f.identifier AS CHAR) LIKE :identifier AND f.origin.code LIKE :origin AND f.destination.code LIKE :destination")
        .setParameter("identifier", "%" + identifier + "%")
        .setParameter("origin", "%"+origin.getCode()+"%")
        .setParameter("destination", "%"+destination.getCode()+"%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
  
  public List<Flight> findByWeekday(String weekday, City origin, City destination)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT f FROM Flight f WHERE CAST(f.weekday AS CHAR) LIKE :weekday AND f.origin.code LIKE :origin AND f.destination.code LIKE :destination")
        .setParameter("weekday", "%"+weekday+"%")
        .setParameter("origin", "%"+origin.getCode()+"%")
        .setParameter("destination", "%"+destination.getCode()+"%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
  
  public List<Flight> findByDeparture(String departure, City origin, City destination)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT f FROM Flight f WHERE CAST(f.departure AS CHAR) LIKE :departure AND f.origin.code LIKE :origin AND f.destination.code LIKE :destination")
        .setParameter("departure", "%" + departure + "%")
        .setParameter("origin", "%"+origin.getCode()+"%")
        .setParameter("destination", "%"+destination.getCode()+"%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
  
  public List<Flight> findByDuration(String duration, City origin, City destination)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT f FROM Flight f WHERE CAST(f.duration AS CHAR) LIKE :duration AND f.origin.code LIKE :origin AND f.destination.code LIKE :destination")
        .setParameter("duration", "%" + duration + "%")
        .setParameter("origin", "%"+origin.getCode()+"%")
        .setParameter("destination", "%"+destination.getCode()+"%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
  
  public List<Flight> findByArrival(String arrival, City origin, City destination)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT f FROM Flight f WHERE CAST(f.arrival AS CHAR) LIKE :arrival AND f.origin.code LIKE :origin AND f.destination.code LIKE :destination")
        .setParameter("arrival", "%" + arrival + "%")
        .setParameter("origin", "%"+origin.getCode()+"%")
        .setParameter("destination", "%"+destination.getCode()+"%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
  
  public List<Flight> findByPrice(String price, City origin, City destination)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT f FROM Flight f WHERE CAST(f.price AS CHAR) LIKE :price AND f.origin.code LIKE :origin AND f.destination.code LIKE :destination")
        .setParameter("price", "%" + price + "%")
        .setParameter("origin", "%"+origin.getCode()+"%")
        .setParameter("destination", "%"+destination.getCode()+"%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
  
  public List<Flight> findByDiscount(String discount, City origin, City destination)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT f FROM Flight f WHERE CAST(f.discount*100 AS CHAR) LIKE :discount AND f.origin.code LIKE :origin AND f.destination.code LIKE :destination")
        .setParameter("discount", "%" + discount + "%")
        .setParameter("origin", "%"+origin.getCode()+"%")
        .setParameter("destination", "%"+destination.getCode()+"%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }

  private static class FlightDaoHolder 
  {
    private static final FlightDao INSTANCE = new FlightDao();
  }
}
