package airline.logic;

import airline.data.CityDao;
import airline.exceptions.IllegalOrphanException;
import airline.exceptions.NonexistentEntityException;
import java.util.List;

public class CityModel 
{
  CityDao dao = CityDao.getInstance();
  
  private CityModel()
  {
    
  }

  public void create(City object) throws Exception
  {
    dao.create(object);
  }
  
  public void update(City object)
  {
    dao.update(object);
  }
  
  public void destroy(String string) throws IllegalOrphanException, NonexistentEntityException
  {
    dao.destroy(string);
  }
  
  public List<City> findAll()
  {
    return dao.findAll();
  }
  
  public List<City> findByCode(String code)
  {
    return dao.findByCode(code);
  }
  
  public List<City> findByName(String name)
  {
    return dao.findByName(name);
  }
  
  public List<City> findByCountry(Country country)
  {
    return dao.findByCountry(country);
  }
  
  public static CityModel getInstance() 
  {
    return CityModelHolder.INSTANCE;
  }

  private static class CityModelHolder 
  {
    private static final CityModel INSTANCE = new CityModel();
  }
}
