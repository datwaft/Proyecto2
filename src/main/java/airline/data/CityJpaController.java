package airline.data;

import airline.exceptions.*;
import airline.logic.*;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

public class CityJpaController implements Serializable
{
  public CityJpaController(EntityManagerFactory emf)
  {
    this.emf = emf;
  }
  private EntityManagerFactory emf = null;

  public EntityManager getEntityManager()
  {
    return emf.createEntityManager();
  }

  public void create(City city) throws PreexistingEntityException, Exception
  {
    if (city.getFlightList() == null)
    {
      city.setFlightList(new ArrayList<Flight>());
    }
    if (city.getFlightList1() == null)
    {
      city.setFlightList1(new ArrayList<Flight>());
    }
    EntityManager em = null;
    try
    {
      em = getEntityManager();
      em.getTransaction().begin();
      Country country = city.getCountry();
      if (country != null)
      {
        country = em.getReference(country.getClass(), country.getCode());
        city.setCountry(country);
      }
      List<Flight> attachedFlightList = new ArrayList<Flight>();
      for (Flight flightListFlightToAttach : city.getFlightList())
      {
        flightListFlightToAttach = em.getReference(flightListFlightToAttach.getClass(), flightListFlightToAttach.getIdentifier());
        attachedFlightList.add(flightListFlightToAttach);
      }
      city.setFlightList(attachedFlightList);
      List<Flight> attachedFlightList1 = new ArrayList<Flight>();
      for (Flight flightList1FlightToAttach : city.getFlightList1())
      {
        flightList1FlightToAttach = em.getReference(flightList1FlightToAttach.getClass(), flightList1FlightToAttach.getIdentifier());
        attachedFlightList1.add(flightList1FlightToAttach);
      }
      city.setFlightList1(attachedFlightList1);
      em.persist(city);
      if (country != null)
      {
        country.getCityList().add(city);
        country = em.merge(country);
      }
      for (Flight flightListFlight : city.getFlightList())
      {
        City oldOriginOfFlightListFlight = flightListFlight.getOrigin();
        flightListFlight.setOrigin(city);
        flightListFlight = em.merge(flightListFlight);
        if (oldOriginOfFlightListFlight != null)
        {
          oldOriginOfFlightListFlight.getFlightList().remove(flightListFlight);
          oldOriginOfFlightListFlight = em.merge(oldOriginOfFlightListFlight);
        }
      }
      for (Flight flightList1Flight : city.getFlightList1())
      {
        City oldDestinationOfFlightList1Flight = flightList1Flight.getDestination();
        flightList1Flight.setDestination(city);
        flightList1Flight = em.merge(flightList1Flight);
        if (oldDestinationOfFlightList1Flight != null)
        {
          oldDestinationOfFlightList1Flight.getFlightList1().remove(flightList1Flight);
          oldDestinationOfFlightList1Flight = em.merge(oldDestinationOfFlightList1Flight);
        }
      }
      em.getTransaction().commit();
    }
    catch (Exception ex)
    {
      if (findCity(city.getCode()) != null)
      {
        throw new PreexistingEntityException("City " + city + " already exists.", ex);
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

  public void edit(City city) throws IllegalOrphanException, NonexistentEntityException, Exception
  {
    EntityManager em = null;
    try
    {
      em = getEntityManager();
      em.getTransaction().begin();
      City persistentCity = em.find(City.class, city.getCode());
      Country countryOld = persistentCity.getCountry();
      Country countryNew = city.getCountry();
      List<Flight> flightListOld = persistentCity.getFlightList();
      List<Flight> flightListNew = city.getFlightList();
      List<Flight> flightList1Old = persistentCity.getFlightList1();
      List<Flight> flightList1New = city.getFlightList1();
      List<String> illegalOrphanMessages = null;
      for (Flight flightListOldFlight : flightListOld)
      {
        if (!flightListNew.contains(flightListOldFlight))
        {
          if (illegalOrphanMessages == null)
          {
            illegalOrphanMessages = new ArrayList<String>();
          }
          illegalOrphanMessages.add("You must retain Flight " + flightListOldFlight + " since its origin field is not nullable.");
        }
      }
      for (Flight flightList1OldFlight : flightList1Old)
      {
        if (!flightList1New.contains(flightList1OldFlight))
        {
          if (illegalOrphanMessages == null)
          {
            illegalOrphanMessages = new ArrayList<String>();
          }
          illegalOrphanMessages.add("You must retain Flight " + flightList1OldFlight + " since its destination field is not nullable.");
        }
      }
      if (illegalOrphanMessages != null)
      {
        throw new IllegalOrphanException(illegalOrphanMessages);
      }
      if (countryNew != null)
      {
        countryNew = em.getReference(countryNew.getClass(), countryNew.getCode());
        city.setCountry(countryNew);
      }
      List<Flight> attachedFlightListNew = new ArrayList<Flight>();
      for (Flight flightListNewFlightToAttach : flightListNew)
      {
        flightListNewFlightToAttach = em.getReference(flightListNewFlightToAttach.getClass(), flightListNewFlightToAttach.getIdentifier());
        attachedFlightListNew.add(flightListNewFlightToAttach);
      }
      flightListNew = attachedFlightListNew;
      city.setFlightList(flightListNew);
      List<Flight> attachedFlightList1New = new ArrayList<Flight>();
      for (Flight flightList1NewFlightToAttach : flightList1New)
      {
        flightList1NewFlightToAttach = em.getReference(flightList1NewFlightToAttach.getClass(), flightList1NewFlightToAttach.getIdentifier());
        attachedFlightList1New.add(flightList1NewFlightToAttach);
      }
      flightList1New = attachedFlightList1New;
      city.setFlightList1(flightList1New);
      city = em.merge(city);
      if (countryOld != null && !countryOld.equals(countryNew))
      {
        countryOld.getCityList().remove(city);
        countryOld = em.merge(countryOld);
      }
      if (countryNew != null && !countryNew.equals(countryOld))
      {
        countryNew.getCityList().add(city);
        countryNew = em.merge(countryNew);
      }
      for (Flight flightListNewFlight : flightListNew)
      {
        if (!flightListOld.contains(flightListNewFlight))
        {
          City oldOriginOfFlightListNewFlight = flightListNewFlight.getOrigin();
          flightListNewFlight.setOrigin(city);
          flightListNewFlight = em.merge(flightListNewFlight);
          if (oldOriginOfFlightListNewFlight != null && !oldOriginOfFlightListNewFlight.equals(city))
          {
            oldOriginOfFlightListNewFlight.getFlightList().remove(flightListNewFlight);
            oldOriginOfFlightListNewFlight = em.merge(oldOriginOfFlightListNewFlight);
          }
        }
      }
      for (Flight flightList1NewFlight : flightList1New)
      {
        if (!flightList1Old.contains(flightList1NewFlight))
        {
          City oldDestinationOfFlightList1NewFlight = flightList1NewFlight.getDestination();
          flightList1NewFlight.setDestination(city);
          flightList1NewFlight = em.merge(flightList1NewFlight);
          if (oldDestinationOfFlightList1NewFlight != null && !oldDestinationOfFlightList1NewFlight.equals(city))
          {
            oldDestinationOfFlightList1NewFlight.getFlightList1().remove(flightList1NewFlight);
            oldDestinationOfFlightList1NewFlight = em.merge(oldDestinationOfFlightList1NewFlight);
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
        String id = city.getCode();
        if (findCity(id) == null)
        {
          throw new NonexistentEntityException("The city with id " + id + " no longer exists.");
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

  public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException
  {
    EntityManager em = null;
    try
    {
      em = getEntityManager();
      em.getTransaction().begin();
      City city;
      try
      {
        city = em.getReference(City.class, id);
        city.getCode();
      }
      catch (EntityNotFoundException enfe)
      {
        throw new NonexistentEntityException("The city with id " + id + " no longer exists.", enfe);
      }
      List<String> illegalOrphanMessages = null;
      List<Flight> flightListOrphanCheck = city.getFlightList();
      for (Flight flightListOrphanCheckFlight : flightListOrphanCheck)
      {
        if (illegalOrphanMessages == null)
        {
          illegalOrphanMessages = new ArrayList<String>();
        }
        illegalOrphanMessages.add("This City (" + city + ") cannot be destroyed since the Flight " + flightListOrphanCheckFlight + " in its flightList field has a non-nullable origin field.");
      }
      List<Flight> flightList1OrphanCheck = city.getFlightList1();
      for (Flight flightList1OrphanCheckFlight : flightList1OrphanCheck)
      {
        if (illegalOrphanMessages == null)
        {
          illegalOrphanMessages = new ArrayList<String>();
        }
        illegalOrphanMessages.add("This City (" + city + ") cannot be destroyed since the Flight " + flightList1OrphanCheckFlight + " in its flightList1 field has a non-nullable destination field.");
      }
      if (illegalOrphanMessages != null)
      {
        throw new IllegalOrphanException(illegalOrphanMessages);
      }
      Country country = city.getCountry();
      if (country != null)
      {
        country.getCityList().remove(city);
        country = em.merge(country);
      }
      em.remove(city);
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

  public List<City> findCityEntities()
  {
    return findCityEntities(true, -1, -1);
  }

  public List<City> findCityEntities(int maxResults, int firstResult)
  {
    return findCityEntities(false, maxResults, firstResult);
  }

  private List<City> findCityEntities(boolean all, int maxResults, int firstResult)
  {
    EntityManager em = getEntityManager();
    try
    {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      cq.select(cq.from(City.class));
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

  public City findCity(String id)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.find(City.class, id);
    }
    finally
    {
      em.close();
    }
  }

  public int getCityCount()
  {
    EntityManager em = getEntityManager();
    try
    {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      Root<City> rt = cq.from(City.class);
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
