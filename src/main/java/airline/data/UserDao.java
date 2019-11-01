package airline.data;

import airline.logic.User;
import java.util.List;
import javax.persistence.EntityManager;

public class UserDao extends UserJpaController
{
  private UserDao()
  {
    super(PersistenceManager.getInstance().getEntityManagerFactory());
  }

  public void update(User object)
  {
    EntityManager em = getEntityManager();
    try
    {
      User other = em.find(User.class, object.getUsername());

      em.getTransaction().begin();
      other.setPassword(object.getPassword());
      other.setAddress(object.getAddress());
      other.setAdmin(object.getAdmin());
      other.setBirthday(object.getBirthday());
      other.setCellphone(object.getCellphone());
      other.setEmail(object.getEmail());
      other.setWorkphone(object.getWorkphone());
      em.getTransaction().commit();
    }
    finally
    {
      em.close();
    }
  }
  
  public List<User> findAll()
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT u FROM User u")
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
  
  public List<User> findByAdmin(boolean admin)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT u FROM User u WHERE u.admin = :admin")
        .setParameter("admin", admin)
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
  
  public static UserDao getInstance() 
  {
    return UserDaoHolder.INSTANCE;
  }

  private static class UserDaoHolder 
  {
    private static final UserDao INSTANCE = new UserDao();
  }
}
