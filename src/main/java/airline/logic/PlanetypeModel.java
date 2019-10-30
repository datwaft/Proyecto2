package airline.logic;

import airline.data.PlanetypeDao;
import airline.exceptions.IllegalOrphanException;
import airline.exceptions.NonexistentEntityException;
import java.util.List;

public class PlanetypeModel 
{
  PlanetypeDao dao = PlanetypeDao.getInstance();
  
  private PlanetypeModel()
  {
  
  }

  public void create(Planetype object) throws Exception
  {
    dao.create(object);
  }
  
  public void update(Planetype object)
  {
    dao.update(object);
  }
  
  public void destroy(String string) throws IllegalOrphanException, NonexistentEntityException
  {
    dao.destroy(string);
  }
  
  public List<Planetype> findAll()
  {
    return dao.findAll();
  }
  
  public List<Planetype> findByIdentifier(String identifier)
  {
    return dao.findByIdentifier(identifier);
  }
  
  public List<Planetype> findByYear(String year)
  {
    return dao.findByYear(year);
  }
  
  public List<Planetype> findByModel(String model)
  {
    return dao.findByModel(model);
  }
  
  public List<Planetype> findByBrand(String brand)
  {
    return dao.findByBrand(brand);
  }
  
  public List<Planetype> findByRownumber(String rownumber)
  {
    return dao.findByRownumber(rownumber);
  }
  
  public List<Planetype> findByRowseats(String rowseats)
  {
    return dao.findByRowseats(rowseats);
  }
  
  public static PlanetypeModel getInstance() 
  {
    return PlanetypeModelHolder.INSTANCE;
  }

  private static class PlanetypeModelHolder 
  {
    private static final PlanetypeModel INSTANCE = new PlanetypeModel();
  }
}
