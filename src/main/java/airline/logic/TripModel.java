package airline.logic;

import airline.data.TripDao;
import airline.exceptions.IllegalOrphanException;
import airline.exceptions.NonexistentEntityException;
import java.util.List;

public class TripModel 
{
  TripDao dao = TripDao.getInstance();
  
  private TripModel()
  {
  
  }

  public void create(Trip object) throws Exception
  {
    dao.create(object);
  }
  
  public void update(Trip object)
  {
    dao.update(object);
  }
  
  public void destroy(Integer integer) throws IllegalOrphanException, NonexistentEntityException
  {
    dao.destroy(integer);
  }
  
  public List<Trip> findAll()
  {
    return dao.findAll();
  }
  
  public List<Trip> findByIdentifier(String string, Object plane, Object outward, Object inward)
  {
    return dao.findByIdentifier(string, plane, outward, inward);
  }
  
  public List<Trip> findByDeparture(String string, Object plane, Object outward, Object inward)
  {
    return dao.findByDeparture(string, plane, outward, inward);
  }
  
  public List<Trip> findByArrival(String string, Object plane, Object outward, Object inward)
  {
    return dao.findByArrival(string, plane, outward, inward);
  }
  
  public List<Trip> findByPassengers(String string, Object plane, Object outward, Object inward)
  {
    return dao.findByPassengers(string, plane, outward, inward);
  }
  
  public static TripModel getInstance() 
  {
    return TripModelHolder.INSTANCE;
  }

  private static class TripModelHolder 
  {
    private static final TripModel INSTANCE = new TripModel();
  }
}
