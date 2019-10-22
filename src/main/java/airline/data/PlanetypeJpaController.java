package airline.data;

import airline.exceptions.*;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import airline.logic.Plane;
import airline.logic.Planetype;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

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
    if (planetype.getPlaneList() == null)
    {
      planetype.setPlaneList(new ArrayList<Plane>());
    }
    EntityManager em = null;
    try
    {
      em = getEntityManager();
      em.getTransaction().begin();
      List<Plane> attachedPlaneList = new ArrayList<Plane>();
      for (Plane planeListPlaneToAttach : planetype.getPlaneList())
      {
        planeListPlaneToAttach = em.getReference(planeListPlaneToAttach.getClass(), planeListPlaneToAttach.getIdentifier());
        attachedPlaneList.add(planeListPlaneToAttach);
      }
      planetype.setPlaneList(attachedPlaneList);
      em.persist(planetype);
      for (Plane planeListPlane : planetype.getPlaneList())
      {
        Planetype oldTypeOfPlaneListPlane = planeListPlane.getType();
        planeListPlane.setType(planetype);
        planeListPlane = em.merge(planeListPlane);
        if (oldTypeOfPlaneListPlane != null)
        {
          oldTypeOfPlaneListPlane.getPlaneList().remove(planeListPlane);
          oldTypeOfPlaneListPlane = em.merge(oldTypeOfPlaneListPlane);
        }
      }
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

  public void edit(Planetype planetype) throws IllegalOrphanException, NonexistentEntityException, Exception
  {
    EntityManager em = null;
    try
    {
      em = getEntityManager();
      em.getTransaction().begin();
      Planetype persistentPlanetype = em.find(Planetype.class, planetype.getIdentifier());
      List<Plane> planeListOld = persistentPlanetype.getPlaneList();
      List<Plane> planeListNew = planetype.getPlaneList();
      List<String> illegalOrphanMessages = null;
      for (Plane planeListOldPlane : planeListOld)
      {
        if (!planeListNew.contains(planeListOldPlane))
        {
          if (illegalOrphanMessages == null)
          {
            illegalOrphanMessages = new ArrayList<String>();
          }
          illegalOrphanMessages.add("You must retain Plane " + planeListOldPlane + " since its type field is not nullable.");
        }
      }
      if (illegalOrphanMessages != null)
      {
        throw new IllegalOrphanException(illegalOrphanMessages);
      }
      List<Plane> attachedPlaneListNew = new ArrayList<Plane>();
      for (Plane planeListNewPlaneToAttach : planeListNew)
      {
        planeListNewPlaneToAttach = em.getReference(planeListNewPlaneToAttach.getClass(), planeListNewPlaneToAttach.getIdentifier());
        attachedPlaneListNew.add(planeListNewPlaneToAttach);
      }
      planeListNew = attachedPlaneListNew;
      planetype.setPlaneList(planeListNew);
      planetype = em.merge(planetype);
      for (Plane planeListNewPlane : planeListNew)
      {
        if (!planeListOld.contains(planeListNewPlane))
        {
          Planetype oldTypeOfPlaneListNewPlane = planeListNewPlane.getType();
          planeListNewPlane.setType(planetype);
          planeListNewPlane = em.merge(planeListNewPlane);
          if (oldTypeOfPlaneListNewPlane != null && !oldTypeOfPlaneListNewPlane.equals(planetype))
          {
            oldTypeOfPlaneListNewPlane.getPlaneList().remove(planeListNewPlane);
            oldTypeOfPlaneListNewPlane = em.merge(oldTypeOfPlaneListNewPlane);
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

  public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException
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
      List<String> illegalOrphanMessages = null;
      List<Plane> planeListOrphanCheck = planetype.getPlaneList();
      for (Plane planeListOrphanCheckPlane : planeListOrphanCheck)
      {
        if (illegalOrphanMessages == null)
        {
          illegalOrphanMessages = new ArrayList<String>();
        }
        illegalOrphanMessages.add("This Planetype (" + planetype + ") cannot be destroyed since the Plane " + planeListOrphanCheckPlane + " in its planeList field has a non-nullable type field.");
      }
      if (illegalOrphanMessages != null)
      {
        throw new IllegalOrphanException(illegalOrphanMessages);
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

}
