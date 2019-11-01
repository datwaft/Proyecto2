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
  
  public static UserModel getInstance() 
  {
    return UserModelHolder.INSTANCE;
  }

  private static class UserModelHolder 
  {
    private static final UserModel INSTANCE = new UserModel();
  }
}
