package airline.data;

import airline.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import airline.logic.City;
import airline.logic.Flight;
import java.util.List;
import javax.persistence.*;

public class FlightJpaController implements Serializable
{
  public FlightJpaController(EntityManagerFactory emf)
  {
    this.emf = emf;
  }
  private EntityManagerFactory emf = null;

  public EntityManager getEntityManager()
  {
    return emf.createEntityManager();
  }

  public void create(Flight flight)
  {
    EntityManager em = null;
    try
    {
      em = getEntityManager();
      em.getTransaction().begin();
      City origin = flight.getOrigin();
      if (origin != null)
      {
        origin = em.getReference(origin.getClass(), origin.getCode());
        flight.setOrigin(origin);
      }
      City destination = flight.getDestination();
      if (destination != null)
      {
        destination = em.getReference(destination.getClass(), destination.getCode());
        flight.setDestination(destination);
      }
      em.persist(flight);
      if (origin != null)
      {
        origin.getFlightList().add(flight);
        origin = em.merge(origin);
      }
      if (destination != null)
      {
        destination.getFlightList().add(flight);
        destination = em.merge(destination);
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

  public void edit(Flight flight) throws NonexistentEntityException, Exception
  {
    EntityManager em = null;
    try
    {
      em = getEntityManager();
      em.getTransaction().begin();
      Flight persistentFlight = em.find(Flight.class, flight.getIdentifier());
      City originOld = persistentFlight.getOrigin();
      City originNew = flight.getOrigin();
      City destinationOld = persistentFlight.getDestination();
      City destinationNew = flight.getDestination();
      if (originNew != null)
      {
        originNew = em.getReference(originNew.getClass(), originNew.getCode());
        flight.setOrigin(originNew);
      }
      if (destinationNew != null)
      {
        destinationNew = em.getReference(destinationNew.getClass(), destinationNew.getCode());
        flight.setDestination(destinationNew);
      }
      flight = em.merge(flight);
      if (originOld != null && !originOld.equals(originNew))
      {
        originOld.getFlightList().remove(flight);
        originOld = em.merge(originOld);
      }
      if (originNew != null && !originNew.equals(originOld))
      {
        originNew.getFlightList().add(flight);
        originNew = em.merge(originNew);
      }
      if (destinationOld != null && !destinationOld.equals(destinationNew))
      {
        destinationOld.getFlightList().remove(flight);
        destinationOld = em.merge(destinationOld);
      }
      if (destinationNew != null && !destinationNew.equals(destinationOld))
      {
        destinationNew.getFlightList().add(flight);
        destinationNew = em.merge(destinationNew);
      }
      em.getTransaction().commit();
    }
    catch (Exception ex)
    {
      String msg = ex.getLocalizedMessage();
      if (msg == null || msg.length() == 0)
      {
        Integer id = flight.getIdentifier();
        if (findFlight(id) == null)
        {
          throw new NonexistentEntityException("The flight with id " + id + " no longer exists.");
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
      Flight flight;
      try
      {
        flight = em.getReference(Flight.class, id);
        flight.getIdentifier();
      }
      catch (EntityNotFoundException enfe)
      {
        throw new NonexistentEntityException("The flight with id " + id + " no longer exists.", enfe);
      }
      City origin = flight.getOrigin();
      if (origin != null)
      {
        origin.getFlightList().remove(flight);
        origin = em.merge(origin);
      }
      City destination = flight.getDestination();
      if (destination != null)
      {
        destination.getFlightList().remove(flight);
        destination = em.merge(destination);
      }
      em.remove(flight);
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

  public List<Flight> findFlightEntities()
  {
    return findFlightEntities(true, -1, -1);
  }

  public List<Flight> findFlightEntities(int maxResults, int firstResult)
  {
    return findFlightEntities(false, maxResults, firstResult);
  }

  private List<Flight> findFlightEntities(boolean all, int maxResults, int firstResult)
  {
    EntityManager em = getEntityManager();
    try
    {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      cq.select(cq.from(Flight.class));
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

  public Flight findFlight(Integer id)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.find(Flight.class, id);
    }
    finally
    {
      em.close();
    }
  }

  public int getFlightCount()
  {
    EntityManager em = getEntityManager();
    try
    {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      Root<Flight> rt = cq.from(Flight.class);
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
