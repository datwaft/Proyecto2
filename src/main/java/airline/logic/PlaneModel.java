package airline.logic;

import airline.data.PlaneDao;
import airline.exceptions.IllegalOrphanException;
import airline.exceptions.NonexistentEntityException;
import java.util.List;

public class PlaneModel 
{
  PlaneDao dao = PlaneDao.getInstance();
  
  private PlaneModel()
  {
  
  }

  public void create(Plane object) throws Exception
  {
    dao.create(object);
  }
  
  public void update(Plane object)
  {
    dao.update(object);
  }
  
  public void destroy(String string) throws IllegalOrphanException, NonexistentEntityException
  {
    dao.destroy(string);
  }
  
  public List<Plane> findAll()
  {
    return dao.findAll();
  }
  
  public List<Plane> findByIdentifier(String identifier)
  {
    return dao.findByIdentifier(identifier);
  }
  
  public List<Plane> findByPlanetype(Planetype type)
  {
    return dao.findByPlanetype(type);
  }
  
  public static PlaneModel getInstance() 
  {
    return PlaneModelHolder.INSTANCE;
  }

  private static class PlaneModelHolder 
  {
    private static final PlaneModel INSTANCE = new PlaneModel();
  }
}
