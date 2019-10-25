package airline.data;

import airline.exceptions.*;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import airline.logic.City;
import airline.logic.Country;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

public class CountryJpaController implements Serializable
{
  public CountryJpaController(EntityManagerFactory emf)
  {
    this.emf = emf;
  }
  private EntityManagerFactory emf = null;

  public EntityManager getEntityManager()
  {
    return emf.createEntityManager();
  }

  public void create(Country country) throws PreexistingEntityException, Exception
  {
    if (country.getCityList() == null)
    {
      country.setCityList(new ArrayList<City>());
    }
    EntityManager em = null;
    try
    {
      em = getEntityManager();
      em.getTransaction().begin();
      List<City> attachedCityList = new ArrayList<City>();
      for (City cityListCityToAttach : country.getCityList())
      {
        cityListCityToAttach = em.getReference(cityListCityToAttach.getClass(), cityListCityToAttach.getCode());
        attachedCityList.add(cityListCityToAttach);
      }
      country.setCityList(attachedCityList);
      em.persist(country);
      for (City cityListCity : country.getCityList())
      {
        Country oldCountryOfCityListCity = cityListCity.getCountry();
        cityListCity.setCountry(country);
        cityListCity = em.merge(cityListCity);
        if (oldCountryOfCityListCity != null)
        {
          oldCountryOfCityListCity.getCityList().remove(cityListCity);
          oldCountryOfCityListCity = em.merge(oldCountryOfCityListCity);
        }
      }
      em.getTransaction().commit();
    }
    catch (Exception ex)
    {
      if (findCountry(country.getCode()) != null)
      {
        throw new PreexistingEntityException("Country " + country + " already exists.", ex);
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

  public void edit(Country country) throws IllegalOrphanException, NonexistentEntityException, Exception
  {
    EntityManager em = null;
    try
    {
      em = getEntityManager();
      em.getTransaction().begin();
      Country persistentCountry = em.find(Country.class, country.getCode());
      List<City> cityListOld = persistentCountry.getCityList();
      List<City> cityListNew = country.getCityList();
      List<String> illegalOrphanMessages = null;
      for (City cityListOldCity : cityListOld)
      {
        if (!cityListNew.contains(cityListOldCity))
        {
          if (illegalOrphanMessages == null)
          {
            illegalOrphanMessages = new ArrayList<String>();
          }
          illegalOrphanMessages.add("You must retain City " + cityListOldCity + " since its country field is not nullable.");
        }
      }
      if (illegalOrphanMessages != null)
      {
        throw new IllegalOrphanException(illegalOrphanMessages);
      }
      List<City> attachedCityListNew = new ArrayList<City>();
      for (City cityListNewCityToAttach : cityListNew)
      {
        cityListNewCityToAttach = em.getReference(cityListNewCityToAttach.getClass(), cityListNewCityToAttach.getCode());
        attachedCityListNew.add(cityListNewCityToAttach);
      }
      cityListNew = attachedCityListNew;
      country.setCityList(cityListNew);
      country = em.merge(country);
      for (City cityListNewCity : cityListNew)
      {
        if (!cityListOld.contains(cityListNewCity))
        {
          Country oldCountryOfCityListNewCity = cityListNewCity.getCountry();
          cityListNewCity.setCountry(country);
          cityListNewCity = em.merge(cityListNewCity);
          if (oldCountryOfCityListNewCity != null && !oldCountryOfCityListNewCity.equals(country))
          {
            oldCountryOfCityListNewCity.getCityList().remove(cityListNewCity);
            oldCountryOfCityListNewCity = em.merge(oldCountryOfCityListNewCity);
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
        String id = country.getCode();
        if (findCountry(id) == null)
        {
          throw new NonexistentEntityException("The country with id " + id + " no longer exists.");
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
      Country country;
      try
      {
        country = em.getReference(Country.class, id);
        country.getCode();
      }
      catch (EntityNotFoundException enfe)
      {
        throw new NonexistentEntityException("The country with id " + id + " no longer exists.", enfe);
      }
      List<String> illegalOrphanMessages = null;
      List<City> cityListOrphanCheck = country.getCityList();
      for (City cityListOrphanCheckCity : cityListOrphanCheck)
      {
        if (illegalOrphanMessages == null)
        {
          illegalOrphanMessages = new ArrayList<String>();
        }
        illegalOrphanMessages.add("This Country (" + country + ") cannot be destroyed since the City " + cityListOrphanCheckCity + " in its cityList field has a non-nullable country field.");
      }
      if (illegalOrphanMessages != null)
      {
        throw new IllegalOrphanException(illegalOrphanMessages);
      }
      em.remove(country);
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

  public List<Country> findCountryEntities()
  {
    return findCountryEntities(true, -1, -1);
  }

  public List<Country> findCountryEntities(int maxResults, int firstResult)
  {
    return findCountryEntities(false, maxResults, firstResult);
  }

  private List<Country> findCountryEntities(boolean all, int maxResults, int firstResult)
  {
    EntityManager em = getEntityManager();
    try
    {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      cq.select(cq.from(Country.class));
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

  public Country findCountry(String id)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.find(Country.class, id);
    }
    finally
    {
      em.close();
    }
  }

  public int getCountryCount()
  {
    EntityManager em = getEntityManager();
    try
    {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      Root<Country> rt = cq.from(Country.class);
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
