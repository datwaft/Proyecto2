package airline.data;

import airline.exceptions.*;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import airline.logic.Reservation;
import airline.logic.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

public class UserJpaController implements Serializable
{
  public UserJpaController(EntityManagerFactory emf)
  {
    this.emf = emf;
  }
  private EntityManagerFactory emf = null;

  public EntityManager getEntityManager()
  {
    return emf.createEntityManager();
  }

  public void create(User user) throws PreexistingEntityException, Exception
  {
    if (user.getReservationList() == null)
    {
      user.setReservationList(new ArrayList<Reservation>());
    }
    EntityManager em = null;
    try
    {
      em = getEntityManager();
      em.getTransaction().begin();
      List<Reservation> attachedReservationList = new ArrayList<Reservation>();
      for (Reservation reservationListReservationToAttach : user.getReservationList())
      {
        reservationListReservationToAttach = em.getReference(reservationListReservationToAttach.getClass(), reservationListReservationToAttach.getId());
        attachedReservationList.add(reservationListReservationToAttach);
      }
      user.setReservationList(attachedReservationList);
      em.persist(user);
      for (Reservation reservationListReservation : user.getReservationList())
      {
        User oldUserOfReservationListReservation = reservationListReservation.getUser();
        reservationListReservation.setUser(user);
        reservationListReservation = em.merge(reservationListReservation);
        if (oldUserOfReservationListReservation != null)
        {
          oldUserOfReservationListReservation.getReservationList().remove(reservationListReservation);
          oldUserOfReservationListReservation = em.merge(oldUserOfReservationListReservation);
        }
      }
      em.getTransaction().commit();
    }
    catch (Exception ex)
    {
      if (findUser(user.getUsername()) != null)
      {
        throw new PreexistingEntityException("User " + user + " already exists.", ex);
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

  public void edit(User user) throws IllegalOrphanException, NonexistentEntityException, Exception
  {
    EntityManager em = null;
    try
    {
      em = getEntityManager();
      em.getTransaction().begin();
      User persistentUser = em.find(User.class, user.getUsername());
      List<Reservation> reservationListOld = persistentUser.getReservationList();
      List<Reservation> reservationListNew = user.getReservationList();
      List<String> illegalOrphanMessages = null;
      for (Reservation reservationListOldReservation : reservationListOld)
      {
        if (!reservationListNew.contains(reservationListOldReservation))
        {
          if (illegalOrphanMessages == null)
          {
            illegalOrphanMessages = new ArrayList<String>();
          }
          illegalOrphanMessages.add("You must retain Reservation " + reservationListOldReservation + " since its user field is not nullable.");
        }
      }
      if (illegalOrphanMessages != null)
      {
        throw new IllegalOrphanException(illegalOrphanMessages);
      }
      List<Reservation> attachedReservationListNew = new ArrayList<Reservation>();
      for (Reservation reservationListNewReservationToAttach : reservationListNew)
      {
        reservationListNewReservationToAttach = em.getReference(reservationListNewReservationToAttach.getClass(), reservationListNewReservationToAttach.getId());
        attachedReservationListNew.add(reservationListNewReservationToAttach);
      }
      reservationListNew = attachedReservationListNew;
      user.setReservationList(reservationListNew);
      user = em.merge(user);
      for (Reservation reservationListNewReservation : reservationListNew)
      {
        if (!reservationListOld.contains(reservationListNewReservation))
        {
          User oldUserOfReservationListNewReservation = reservationListNewReservation.getUser();
          reservationListNewReservation.setUser(user);
          reservationListNewReservation = em.merge(reservationListNewReservation);
          if (oldUserOfReservationListNewReservation != null && !oldUserOfReservationListNewReservation.equals(user))
          {
            oldUserOfReservationListNewReservation.getReservationList().remove(reservationListNewReservation);
            oldUserOfReservationListNewReservation = em.merge(oldUserOfReservationListNewReservation);
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
        String id = user.getUsername();
        if (findUser(id) == null)
        {
          throw new NonexistentEntityException("The user with id " + id + " no longer exists.");
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
      User user;
      try
      {
        user = em.getReference(User.class, id);
        user.getUsername();
      }
      catch (EntityNotFoundException enfe)
      {
        throw new NonexistentEntityException("The user with id " + id + " no longer exists.", enfe);
      }
      List<String> illegalOrphanMessages = null;
      List<Reservation> reservationListOrphanCheck = user.getReservationList();
      for (Reservation reservationListOrphanCheckReservation : reservationListOrphanCheck)
      {
        if (illegalOrphanMessages == null)
        {
          illegalOrphanMessages = new ArrayList<String>();
        }
        illegalOrphanMessages.add("This User (" + user + ") cannot be destroyed since the Reservation " + reservationListOrphanCheckReservation + " in its reservationList field has a non-nullable user field.");
      }
      if (illegalOrphanMessages != null)
      {
        throw new IllegalOrphanException(illegalOrphanMessages);
      }
      em.remove(user);
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

  public List<User> findUserEntities()
  {
    return findUserEntities(true, -1, -1);
  }

  public List<User> findUserEntities(int maxResults, int firstResult)
  {
    return findUserEntities(false, maxResults, firstResult);
  }

  private List<User> findUserEntities(boolean all, int maxResults, int firstResult)
  {
    EntityManager em = getEntityManager();
    try
    {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      cq.select(cq.from(User.class));
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

  public User findUser(String id)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.find(User.class, id);
    }
    finally
    {
      em.close();
    }
  }

  public int getUserCount()
  {
    EntityManager em = getEntityManager();
    try
    {
      CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
      Root<User> rt = cq.from(User.class);
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
