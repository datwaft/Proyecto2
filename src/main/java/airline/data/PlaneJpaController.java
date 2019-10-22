package airline.data;

import airline.exceptions.NonexistentEntityException;
import airline.exceptions.PreexistingEntityException;
import airline.logic.Plane;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import airline.logic.Planetype;
import java.util.List;
import javax.persistence.*;

public class PlaneJpaController implements Serializable
{
  public PlaneJpaController(EntityManagerFactory emf)
  {
    this.emf = emf;
  }
  private EntityManagerFactory emf = null;

  public EntityManager getEntityManager()
  {
    return emf.createEntityManager();
  }

  public void create(Plane plane) throws PreexistingEntityException, Exception
  {
    EntityManager em = null;
    try
    {
      em = getEntityManager();
      em.getTransaction().begin();
      Planetype type = plane.getType();
      if (type != null)
      {
        type = em.getReference(type.getClass(), type.getIdentifier());
        plane.setType(type);
      }
      em.persist(plane);
      if (type != null)
      {
        type.getPlaneList().add(plane);
        type = em.merge(type);
      }
      em.getTransaction().commit();
    }
    catch (Exception ex)
    {
      if (findPlane(plane.getIdentifier()) != null)
      {
        throw new PreexistingEntityException("Plane " + plane + " already exists.", ex);
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

  public void edit(Plane plane) throws NonexistentEntityException, Exception
  {
    EntityManager em = null;
    try
    {
      em = getEntityManager();
      em.getTransaction().begin();
      Plane persistentPlane = em.find(Plane.class, plane.getIdentifier());
      Planetype typeOld = persistentPlane.getType();
      Planetype typeNew = plane.getType();
      if (typeNew != null)
      {
        typeNew = em.getReference(typeNew.getClass(), typeNew.getIdentifier());
        plane.setType(typeNew);
      }
      plane = em.merge(plane);
      if (typeOld != null && !typeOld.equals(typeNew))
      {
        typeOld.getPlaneList().remove(plane);
        typeOld = em.merge(typeOld);
      }
      if (typeNew != null && !typeNew.equals(typeOld))
      {
        typeNew.getPlaneList().add(plane);
        typeNew = em.merge(typeNew);
      }
      em.getTransaction().commit();
    }
    catch (Exception ex)
    {
      String msg = ex.getLocalizedMessage();
      if (msg == null || msg.length() == 0)
      {
        String id = plane.getIdentifier();
        if (findPlane(id) == null)
        {
          throw new NonexistentEntityException("The plane with id " + id + " no longer exists.");
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
      Plane plane;
      try
      {
        plane = em.getReference(Plane.class, id);
        plane.getIdentifier();
      }
      catch (EntityNotFoundException enfe)
      {
        throw new NonexistentEntityException("The plane with id " + id + " no longer exists.", enfe);
      }
      Planetype type = plane.getType();
      if (type != null)
      {
        type.getPlaneList().remove(plane);
        type = em.merge(type);
      }
      em.remove(plane);
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

  public List<Plane> findPlaneEntities()
  {
    return findPlaneEntities(true, -1, -1);
  }

  public List<Plane> findPlaneEntities(int maxResults, int firstResult)
  {
    return findPlaneEntities(false, maxResults, firstResult);
  }

  private List<Plane> findPlaneEntities(boolean all, int maxResults, int firstResult)
  {
    EntityManager em = getEntityManager();
    try
    {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      cq.select(cq.from(Plane.class));
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

  public Plane findPlane(String id)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.find(Plane.class, id);
    }
    finally
    {
      em.close();
    }
  }

  public int getPlaneCount()
  {
    EntityManager em = getEntityManager();
    try
    {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      Root<Plane> rt = cq.from(Plane.class);
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
