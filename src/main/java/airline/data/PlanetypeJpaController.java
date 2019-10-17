package airline.data;

import airline.exceptions.NonexistentEntityException;
import airline.exceptions.PreexistingEntityException;
import airline.logic.Planetype;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class PlanetypeJpaController implements Serializable
{
  public PlanetypeJpaController(EntityManagerFactory emf)
  {
    this.emf = emf;
  }
  private EntityManagerFactory emf = null;

  public EntityManager getEntityManager()
  {
    return emf.createEntityManager();
  }

  public void create(Planetype planetype) throws PreexistingEntityException, Exception
  {
    EntityManager em = null;
    try
    {
      em = getEntityManager();
      em.getTransaction().begin();
      em.persist(planetype);
      em.getTransaction().commit();
    }
    catch (Exception ex)
    {
      if (findPlanetype(planetype.getIdentifier()) != null)
      {
        throw new PreexistingEntityException("Planetype " + planetype + " already exists.", ex);
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

  public void edit(Planetype planetype) throws NonexistentEntityException, Exception
  {
    EntityManager em = null;
    try
    {
      em = getEntityManager();
      em.getTransaction().begin();
      planetype = em.merge(planetype);
      em.getTransaction().commit();
    }
    catch (Exception ex)
    {
      String msg = ex.getLocalizedMessage();
      if (msg == null || msg.length() == 0)
      {
        String id = planetype.getIdentifier();
        if (findPlanetype(id) == null)
        {
          throw new NonexistentEntityException("The planetype with id " + id + " no longer exists.");
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
      Planetype planetype;
      try
      {
        planetype = em.getReference(Planetype.class, id);
        planetype.getIdentifier();
      }
      catch (EntityNotFoundException enfe)
      {
        throw new NonexistentEntityException("The planetype with id " + id + " no longer exists.", enfe);
      }
      em.remove(planetype);
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

  public List<Planetype> findPlanetypeEntities()
  {
    return findPlanetypeEntities(true, -1, -1);
  }

  public List<Planetype> findPlanetypeEntities(int maxResults, int firstResult)
  {
    return findPlanetypeEntities(false, maxResults, firstResult);
  }

  private List<Planetype> findPlanetypeEntities(boolean all, int maxResults, int firstResult)
  {
    EntityManager em = getEntityManager();
    try
    {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      cq.select(cq.from(Planetype.class));
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

  public Planetype findPlanetype(String id)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.find(Planetype.class, id);
    }
    finally
    {
      em.close();
    }
  }

  public int getPlanetypeCount()
  {
    EntityManager em = getEntityManager();
    try
    {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      Root<Planetype> rt = cq.from(Planetype.class);
      cq.select(em.getCriteriaBuilder().count(rt));
      Query q = em.createQuery(cq);
      return ((Long) q.getSingleResult()).intValue();
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
      return em.createNamedQuery("Planetype.findByIdentifier")
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
      return em.createNamedQuery("Planetype.findByYear")
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
      return em.createNamedQuery("Planetype.findByModel")
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
      return em.createNamedQuery("Planetype.findByBrand")
        .setParameter("brand", "%" + brand + "%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
  
  public List<Planetype> findByRowCount(String rowCount)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createNamedQuery("Planetype.findByRowCount")
        .setParameter("rowCount", "%" + rowCount + "%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
  
  public List<Planetype> findBySeatsRow(String seatsRow)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createNamedQuery("Planetype.findBySeatsRow")
        .setParameter("seatsRow", "%" + seatsRow + "%")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
}
