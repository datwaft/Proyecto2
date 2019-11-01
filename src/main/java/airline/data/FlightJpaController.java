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
    if (flight.getTripList() == null)
    {
      flight.setTripList(new ArrayList<Trip>());
    }
    if (flight.getTripList1() == null)
    {
      flight.setTripList1(new ArrayList<Trip>());
    }
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
      List<Trip> attachedTripList = new ArrayList<Trip>();
      for (Trip tripListTripToAttach : flight.getTripList())
      {
        tripListTripToAttach = em.getReference(tripListTripToAttach.getClass(), tripListTripToAttach.getIdentifier());
        attachedTripList.add(tripListTripToAttach);
      }
      flight.setTripList(attachedTripList);
      List<Trip> attachedTripList1 = new ArrayList<Trip>();
      for (Trip tripList1TripToAttach : flight.getTripList1())
      {
        tripList1TripToAttach = em.getReference(tripList1TripToAttach.getClass(), tripList1TripToAttach.getIdentifier());
        attachedTripList1.add(tripList1TripToAttach);
      }
      flight.setTripList1(attachedTripList1);
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
      for (Trip tripListTrip : flight.getTripList())
      {
        Flight oldOutwardOfTripListTrip = tripListTrip.getOutward();
        tripListTrip.setOutward(flight);
        tripListTrip = em.merge(tripListTrip);
        if (oldOutwardOfTripListTrip != null)
        {
          oldOutwardOfTripListTrip.getTripList().remove(tripListTrip);
          oldOutwardOfTripListTrip = em.merge(oldOutwardOfTripListTrip);
        }
      }
      for (Trip tripList1Trip : flight.getTripList1())
      {
        Flight oldInwardOfTripList1Trip = tripList1Trip.getInward();
        tripList1Trip.setInward(flight);
        tripList1Trip = em.merge(tripList1Trip);
        if (oldInwardOfTripList1Trip != null)
        {
          oldInwardOfTripList1Trip.getTripList1().remove(tripList1Trip);
          oldInwardOfTripList1Trip = em.merge(oldInwardOfTripList1Trip);
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

  public void edit(Flight flight) throws IllegalOrphanException, NonexistentEntityException, Exception
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
      List<Trip> tripListOld = persistentFlight.getTripList();
      List<Trip> tripListNew = flight.getTripList();
      List<Trip> tripList1Old = persistentFlight.getTripList1();
      List<Trip> tripList1New = flight.getTripList1();
      List<String> illegalOrphanMessages = null;
      for (Trip tripListOldTrip : tripListOld)
      {
        if (!tripListNew.contains(tripListOldTrip))
        {
          if (illegalOrphanMessages == null)
          {
            illegalOrphanMessages = new ArrayList<String>();
          }
          illegalOrphanMessages.add("You must retain Trip " + tripListOldTrip + " since its outward field is not nullable.");
        }
      }
      if (illegalOrphanMessages != null)
      {
        throw new IllegalOrphanException(illegalOrphanMessages);
      }
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
      List<Trip> attachedTripListNew = new ArrayList<Trip>();
      for (Trip tripListNewTripToAttach : tripListNew)
      {
        tripListNewTripToAttach = em.getReference(tripListNewTripToAttach.getClass(), tripListNewTripToAttach.getIdentifier());
        attachedTripListNew.add(tripListNewTripToAttach);
      }
      tripListNew = attachedTripListNew;
      flight.setTripList(tripListNew);
      List<Trip> attachedTripList1New = new ArrayList<Trip>();
      for (Trip tripList1NewTripToAttach : tripList1New)
      {
        tripList1NewTripToAttach = em.getReference(tripList1NewTripToAttach.getClass(), tripList1NewTripToAttach.getIdentifier());
        attachedTripList1New.add(tripList1NewTripToAttach);
      }
      tripList1New = attachedTripList1New;
      flight.setTripList1(tripList1New);
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
      for (Trip tripListNewTrip : tripListNew)
      {
        if (!tripListOld.contains(tripListNewTrip))
        {
          Flight oldOutwardOfTripListNewTrip = tripListNewTrip.getOutward();
          tripListNewTrip.setOutward(flight);
          tripListNewTrip = em.merge(tripListNewTrip);
          if (oldOutwardOfTripListNewTrip != null && !oldOutwardOfTripListNewTrip.equals(flight))
          {
            oldOutwardOfTripListNewTrip.getTripList().remove(tripListNewTrip);
            oldOutwardOfTripListNewTrip = em.merge(oldOutwardOfTripListNewTrip);
          }
        }
      }
      for (Trip tripList1OldTrip : tripList1Old)
      {
        if (!tripList1New.contains(tripList1OldTrip))
        {
          tripList1OldTrip.setInward(null);
          tripList1OldTrip = em.merge(tripList1OldTrip);
        }
      }
      for (Trip tripList1NewTrip : tripList1New)
      {
        if (!tripList1Old.contains(tripList1NewTrip))
        {
          Flight oldInwardOfTripList1NewTrip = tripList1NewTrip.getInward();
          tripList1NewTrip.setInward(flight);
          tripList1NewTrip = em.merge(tripList1NewTrip);
          if (oldInwardOfTripList1NewTrip != null && !oldInwardOfTripList1NewTrip.equals(flight))
          {
            oldInwardOfTripList1NewTrip.getTripList1().remove(tripList1NewTrip);
            oldInwardOfTripList1NewTrip = em.merge(oldInwardOfTripList1NewTrip);
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

  public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException
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
      List<String> illegalOrphanMessages = null;
      List<Trip> tripListOrphanCheck = flight.getTripList();
      for (Trip tripListOrphanCheckTrip : tripListOrphanCheck)
      {
        if (illegalOrphanMessages == null)
        {
          illegalOrphanMessages = new ArrayList<String>();
        }
        illegalOrphanMessages.add("This Flight (" + flight + ") cannot be destroyed since the Trip " + tripListOrphanCheckTrip + " in its tripList field has a non-nullable outward field.");
      }
      if (illegalOrphanMessages != null)
      {
        throw new IllegalOrphanException(illegalOrphanMessages);
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
      List<Trip> tripList1 = flight.getTripList1();
      for (Trip tripList1Trip : tripList1)
      {
        tripList1Trip.setInward(null);
        tripList1Trip = em.merge(tripList1Trip);
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
