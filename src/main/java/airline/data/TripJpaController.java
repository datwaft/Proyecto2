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

public class TripJpaController implements Serializable
{
  public TripJpaController(EntityManagerFactory emf)
  {
    this.emf = emf;
  }
  private EntityManagerFactory emf = null;

  public EntityManager getEntityManager()
  {
    return emf.createEntityManager();
  }

  public void create(Trip trip)
  {
    EntityManager em = null;
    try
    {
      em = getEntityManager();
      em.getTransaction().begin();
      Flight outward = trip.getOutward();
      if (outward != null)
      {
        outward = em.getReference(outward.getClass(), outward.getIdentifier());
        trip.setOutward(outward);
      }
      Flight inward = trip.getInward();
      if (inward != null)
      {
        inward = em.getReference(inward.getClass(), inward.getIdentifier());
        trip.setInward(inward);
      }
      Plane plane = trip.getPlane();
      if (plane != null)
      {
        plane = em.getReference(plane.getClass(), plane.getIdentifier());
        trip.setPlane(plane);
      }
      em.persist(trip);
      if (outward != null)
      {
        outward.getTripList().add(trip);
        outward = em.merge(outward);
      }
      if (inward != null)
      {
        inward.getTripList().add(trip);
        inward = em.merge(inward);
      }
      if (plane != null)
      {
        plane.getTripList().add(trip);
        plane = em.merge(plane);
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

  public void edit(Trip trip) throws NonexistentEntityException, Exception
  {
    EntityManager em = null;
    try
    {
      em = getEntityManager();
      em.getTransaction().begin();
      Trip persistentTrip = em.find(Trip.class, trip.getIdentifier());
      Flight outwardOld = persistentTrip.getOutward();
      Flight outwardNew = trip.getOutward();
      Flight inwardOld = persistentTrip.getInward();
      Flight inwardNew = trip.getInward();
      Plane planeOld = persistentTrip.getPlane();
      Plane planeNew = trip.getPlane();
      if (outwardNew != null)
      {
        outwardNew = em.getReference(outwardNew.getClass(), outwardNew.getIdentifier());
        trip.setOutward(outwardNew);
      }
      if (inwardNew != null)
      {
        inwardNew = em.getReference(inwardNew.getClass(), inwardNew.getIdentifier());
        trip.setInward(inwardNew);
      }
      if (planeNew != null)
      {
        planeNew = em.getReference(planeNew.getClass(), planeNew.getIdentifier());
        trip.setPlane(planeNew);
      }
      trip = em.merge(trip);
      if (outwardOld != null && !outwardOld.equals(outwardNew))
      {
        outwardOld.getTripList().remove(trip);
        outwardOld = em.merge(outwardOld);
      }
      if (outwardNew != null && !outwardNew.equals(outwardOld))
      {
        outwardNew.getTripList().add(trip);
        outwardNew = em.merge(outwardNew);
      }
      if (inwardOld != null && !inwardOld.equals(inwardNew))
      {
        inwardOld.getTripList().remove(trip);
        inwardOld = em.merge(inwardOld);
      }
      if (inwardNew != null && !inwardNew.equals(inwardOld))
      {
        inwardNew.getTripList().add(trip);
        inwardNew = em.merge(inwardNew);
      }
      if (planeOld != null && !planeOld.equals(planeNew))
      {
        planeOld.getTripList().remove(trip);
        planeOld = em.merge(planeOld);
      }
      if (planeNew != null && !planeNew.equals(planeOld))
      {
        planeNew.getTripList().add(trip);
        planeNew = em.merge(planeNew);
      }
      em.getTransaction().commit();
    }
    catch (Exception ex)
    {
      String msg = ex.getLocalizedMessage();
      if (msg == null || msg.length() == 0)
      {
        Integer id = trip.getIdentifier();
        if (findTrip(id) == null)
        {
          throw new NonexistentEntityException("The trip with id " + id + " no longer exists.");
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
      Trip trip;
      try
      {
        trip = em.getReference(Trip.class, id);
        trip.getIdentifier();
      }
      catch (EntityNotFoundException enfe)
      {
        throw new NonexistentEntityException("The trip with id " + id + " no longer exists.", enfe);
      }
      Flight outward = trip.getOutward();
      if (outward != null)
      {
        outward.getTripList().remove(trip);
        outward = em.merge(outward);
      }
      Flight inward = trip.getInward();
      if (inward != null)
      {
        inward.getTripList().remove(trip);
        inward = em.merge(inward);
      }
      Plane plane = trip.getPlane();
      if (plane != null)
      {
        plane.getTripList().remove(trip);
        plane = em.merge(plane);
      }
      em.remove(trip);
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

  public List<Trip> findTripEntities()
  {
    return findTripEntities(true, -1, -1);
  }

  public List<Trip> findTripEntities(int maxResults, int firstResult)
  {
    return findTripEntities(false, maxResults, firstResult);
  }

  private List<Trip> findTripEntities(boolean all, int maxResults, int firstResult)
  {
    EntityManager em = getEntityManager();
    try
    {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      cq.select(cq.from(Trip.class));
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

  public Trip findTrip(Integer id)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.find(Trip.class, id);
    }
    finally
    {
      em.close();
    }
  }

  public int getTripCount()
  {
    EntityManager em = getEntityManager();
    try
    {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      Root<Trip> rt = cq.from(Trip.class);
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
