package airline.logic;

import airline.data.CountryDao;
import airline.exceptions.IllegalOrphanException;
import airline.exceptions.NonexistentEntityException;
import java.util.List;

public class CountryModel 
{
  CountryDao dao = CountryDao.getInstance();
  
  private CountryModel()
  {
  
  }

  public void create(Country object) throws Exception
  {
    dao.create(object);
  }
  
  public void update(Country object)
  {
    dao.update(object);
  }
  
  public void destroy(String string) throws IllegalOrphanException, NonexistentEntityException
  {
    dao.destroy(string);
  }
  
  public List<Country> findAll()
  {
    return dao.findAll();
  }
  
  public List<Country> findByCode(String code)
  {
    return dao.findByName(code);
  }
  
  public List<Country> findByName(String name)
  {
    return dao.findByName(name);
  }
  
  public static CountryModel getInstance() 
  {
    return CountryModelHolder.INSTANCE;
  }

  private static class CountryModelHolder 
  {
    private static final CountryModel INSTANCE = new CountryModel();
  }
}
