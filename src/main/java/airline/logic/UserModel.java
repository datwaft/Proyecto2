package airline.logic;

import airline.data.UserDao;
import java.util.List;

public class UserModel 
{
  UserDao dao = UserDao.getInstance();
  
  private UserModel()
  {
    
  }

  public void create(User object) throws Exception
  {
    dao.create(object);
  }
  
  public void update(User object)
  {
    dao.update(object);
  }
  
  public List<User> findAll()
  {
    return dao.findAll();
  }
  
  public List<User> findByAdmin(boolean admin)
  {
    return dao.findByAdmin(admin);
  }
  
  public User findUser(String string)
  {
    return dao.findUser(string);
  }
  
  public static UserModel getInstance() 
  {
    return UserModelHolder.INSTANCE;
  }

  public List<User> findByUsername(String string)
  {
    return dao.findByUsername(string);
  }

  public List<User> findByName(String string)
  {
    return dao.findByName(string);
  }

  public List<User> findByLastname(String string)
  {
    return dao.findByLastname(string);
  }

  public List<User> findByEmail(String string)
  {
    return dao.findByEmail(string);
  }

  public List<User> findByBirthday(String string)
  {
    return dao.findByBirthday(string);
  }

  private static class UserModelHolder 
  {
    private static final UserModel INSTANCE = new UserModel();
  }
}
