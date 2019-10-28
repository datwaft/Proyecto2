package airline.data;

import airline.logic.Country;
import java.util.List;
import javax.persistence.EntityManager;

public class CountryDao extends CountryJpaController
{
  private CountryDao()
  {
    super(PersistenceManager.getInstance().getEntityManagerFactory());
  }
  
  public void update(Country object)
  {
    EntityManager em = getEntityManager();
    try
    {
      Country other = em.find(Country.class, object.getCode());

      em.getTransaction().begin();
      other.setName(object.getName());
      em.getTransaction().commit();
    }
    finally
    {
      em.close();
    }
  }
  
  public List<Country> findAll()
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT c FROM Country c")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
  
  public List<Country> findByCode(String code)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT c FROM Country c WHERE c.code like :code")
        .setParameter("code", "%" + code + "%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
  
  public List<Country> findByName(String name)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT c FROM Country c WHERE c.name like :name")
        .setParameter("name", "%" + name + "%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
  
  public static CountryDao getInstance()
  {
    return CountryDaoHolder.INSTANCE;
  }
  
  private static class CountryDaoHolder
  {
    private static final CountryDao INSTANCE = new CountryDao();
  }
}
