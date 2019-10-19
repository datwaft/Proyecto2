package airline.data;

import airline.exceptions.NonexistentEntityException;
import airline.exceptions.PreexistingEntityException;
import airline.logic.City;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import airline.logic.Country;
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
      em.persist(city);
      if (country != null)
      {
        country.getCityList().add(city);
        country = em.merge(country);
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

  public void edit(City city) throws NonexistentEntityException, Exception
  {
    EntityManager em = null;
    try
    {
      em = getEntityManager();
      em.getTransaction().begin();
      City persistentCity = em.find(City.class, city.getCode());
      Country countryOld = persistentCity.getCountry();
      Country countryNew = city.getCountry();
      if (countryNew != null)
      {
        countryNew = em.getReference(countryNew.getClass(), countryNew.getCode());
        city.setCountry(countryNew);
      }
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

  public void destroy(String id) throws NonexistentEntityException
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
