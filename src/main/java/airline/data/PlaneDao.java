package airline.data;

import airline.logic.Plane;
import airline.logic.Planetype;
import java.util.List;
import javax.persistence.EntityManager;

public class PlaneDao extends PlaneJpaController
{
  private PlaneDao()
  {
    super(PersistenceManager.getInstance().getEntityManagerFactory());
  }

  public List<Plane> findAll()
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT p FROM Plane p")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
  
  public List<Plane> findByIdentifier(String identifier)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT p FROM Plane p WHERE p.identifier like :identifier")
        .setParameter("identifier", "%" + identifier + "%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
  
  public List<Plane> findByPlanetype(Planetype type)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT p FROM Plane p WHERE p.type = :type")
        .setParameter("type", type)
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
  
  public static PlaneDao getInstance() 
  {
    return PlaneDaoHolder.INSTANCE;
  }

  private static class PlaneDaoHolder 
  {
    private static final PlaneDao INSTANCE = new PlaneDao();
  }
}
