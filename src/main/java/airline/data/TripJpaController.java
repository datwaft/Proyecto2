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
    if (trip.getTicketList() == null)
    {
      trip.setTicketList(new ArrayList<Ticket>());
    }
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
      List<Ticket> attachedTicketList = new ArrayList<Ticket>();
      for (Ticket ticketListTicketToAttach : trip.getTicketList())
      {
        ticketListTicketToAttach = em.getReference(ticketListTicketToAttach.getClass(), ticketListTicketToAttach.getId());
        attachedTicketList.add(ticketListTicketToAttach);
      }
      trip.setTicketList(attachedTicketList);
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
      for (Ticket ticketListTicket : trip.getTicketList())
      {
        Trip oldTripOfTicketListTicket = ticketListTicket.getTrip();
        ticketListTicket.setTrip(trip);
        ticketListTicket = em.merge(ticketListTicket);
        if (oldTripOfTicketListTicket != null)
        {
          oldTripOfTicketListTicket.getTicketList().remove(ticketListTicket);
          oldTripOfTicketListTicket = em.merge(oldTripOfTicketListTicket);
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

  public void edit(Trip trip) throws IllegalOrphanException, NonexistentEntityException, Exception
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
      List<Ticket> ticketListOld = persistentTrip.getTicketList();
      List<Ticket> ticketListNew = trip.getTicketList();
      List<String> illegalOrphanMessages = null;
      for (Ticket ticketListOldTicket : ticketListOld)
      {
        if (!ticketListNew.contains(ticketListOldTicket))
        {
          if (illegalOrphanMessages == null)
          {
            illegalOrphanMessages = new ArrayList<String>();
          }
          illegalOrphanMessages.add("You must retain Ticket " + ticketListOldTicket + " since its trip field is not nullable.");
        }
      }
      if (illegalOrphanMessages != null)
      {
        throw new IllegalOrphanException(illegalOrphanMessages);
      }
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
      List<Ticket> attachedTicketListNew = new ArrayList<Ticket>();
      for (Ticket ticketListNewTicketToAttach : ticketListNew)
      {
        ticketListNewTicketToAttach = em.getReference(ticketListNewTicketToAttach.getClass(), ticketListNewTicketToAttach.getId());
        attachedTicketListNew.add(ticketListNewTicketToAttach);
      }
      ticketListNew = attachedTicketListNew;
      trip.setTicketList(ticketListNew);
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
      for (Ticket ticketListNewTicket : ticketListNew)
      {
        if (!ticketListOld.contains(ticketListNewTicket))
        {
          Trip oldTripOfTicketListNewTicket = ticketListNewTicket.getTrip();
          ticketListNewTicket.setTrip(trip);
          ticketListNewTicket = em.merge(ticketListNewTicket);
          if (oldTripOfTicketListNewTicket != null && !oldTripOfTicketListNewTicket.equals(trip))
          {
            oldTripOfTicketListNewTicket.getTicketList().remove(ticketListNewTicket);
            oldTripOfTicketListNewTicket = em.merge(oldTripOfTicketListNewTicket);
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

  public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException
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
      List<String> illegalOrphanMessages = null;
      List<Ticket> ticketListOrphanCheck = trip.getTicketList();
      for (Ticket ticketListOrphanCheckTicket : ticketListOrphanCheck)
      {
        if (illegalOrphanMessages == null)
        {
          illegalOrphanMessages = new ArrayList<String>();
        }
        illegalOrphanMessages.add("This Trip (" + trip + ") cannot be destroyed since the Ticket " + ticketListOrphanCheckTicket + " in its ticketList field has a non-nullable trip field.");
      }
      if (illegalOrphanMessages != null)
      {
        throw new IllegalOrphanException(illegalOrphanMessages);
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
