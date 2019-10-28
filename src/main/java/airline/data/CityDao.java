package airline.data;

import airline.logic.City;
import airline.logic.Country;
import java.util.List;
import javax.persistence.EntityManager;

public class CityDao extends CityJpaController
{
  private CityDao()
  {
    super(PersistenceManager.getInstance().getEntityManagerFactory());
  }
  
  public void update(City object)
  {
    EntityManager em = getEntityManager();
    try
    {
      City other = em.find(City.class, object.getCode());

      em.getTransaction().begin();
      other.setName(object.getName());
      other.setCountry(object.getCountry());
      em.getTransaction().commit();
    }
    finally
    {
      em.close();
    }
  }
  
  public List<City> findAll()
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT c FROM City c")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
  
  public List<City> findByCode(String code)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT c FROM City c WHERE c.code like :code")
        .setParameter("code", "%" + code + "%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
  
  public List<City> findByName(String name)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT c FROM City c WHERE c.name like :name")
        .setParameter("name", "%" + name + "%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
  
  public List<City> findByCountry(Country country)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT c FROM City c WHERE c.country = :country")
        .setParameter("country", country)
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
  
  public static CityDao getInstance()
  {
    return CityDaoHolder.INSTANCE;
  }
  
  private static class CityDaoHolder
  {
    private static final CityDao INSTANCE = new CityDao();
  }
}
