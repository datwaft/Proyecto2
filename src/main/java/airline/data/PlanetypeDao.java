package airline.data;

import airline.logic.Planetype;
import java.util.List;
import javax.persistence.EntityManager;

public class PlanetypeDao extends PlanetypeJpaController
{
  private PlanetypeDao()
  {
    super(PersistenceManager.getInstance().getEntityManagerFactory());
  }
  
  public List<Planetype> findAll()
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT p FROM Planetype p")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
  
  public List<Planetype> findByIdentifier(String identifier)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT p FROM Planetype p WHERE p.identifier like :identifier")
        .setParameter("identifier", "%" + identifier + "%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
  
  public List<Planetype> findByYear(String year)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT p FROM Planetype p WHERE cast(p.year as char) like :year")
        .setParameter("year", "%" + year + "%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
  
  public List<Planetype> findByModel(String model)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT p FROM Planetype p WHERE p.model like :model")
        .setParameter("model", "%" + model + "%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
  
  public List<Planetype> findByBrand(String brand)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT p FROM Planetype p WHERE p.brand like :brand")
        .setParameter("brand", "%" + brand + "%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
  
  public List<Planetype> findByRownumber(String rownumber)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT p FROM Planetype p WHERE cast(p.rownumber as char) like :rownumber")
        .setParameter("rownumber", "%" + rownumber + "%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
  
  public List<Planetype> findByRowseats(String rowseats)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT p FROM Planetype p WHERE cast(p.rowseats as char) like :rowseats")
        .setParameter("rowseats", "%" + rowseats + "%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
  
  public static PlanetypeDao getInstance()
  {
    return PlanetypeDaoHolder.INSTANCE;
  }
  
  private static class PlanetypeDaoHolder
  {
    private static final PlanetypeDao INSTANCE = new PlanetypeDao();
  }
}
