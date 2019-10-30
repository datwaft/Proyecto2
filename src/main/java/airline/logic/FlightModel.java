package airline.logic;

import airline.data.FlightDao;
import airline.exceptions.IllegalOrphanException;
import airline.exceptions.NonexistentEntityException;
import java.util.List;

public class FlightModel 
{
  FlightDao dao = FlightDao.getInstance();
  
  private FlightModel()
  {
  
  }

  public void create(Flight object) throws Exception
  {
    dao.create(object);
  }
  
  public void update(Flight object)
  {
    dao.update(object);
  }
  
  public void destroy(Integer integer) throws IllegalOrphanException, NonexistentEntityException
  {
    dao.destroy(integer);
  }
  
  public List<Flight> findAll()
  {
    return dao.findAll();
  }
  
  public List<Flight> findByCities(City origin, City destination)
  {
    return dao.findByCities(origin, destination);
  }
  
  public List<Flight> findByIdentifier(String identifier, City origin, City destination)
  {
    return dao.findByIdentifier(identifier, origin, destination);
  }
  
  public List<Flight> findByWeekday(String weekday, City origin, City destination)
  {
    return dao.findByWeekday(weekday, origin, destination);
  }
  
  public List<Flight> findByDeparture(String departure, City origin, City destination)
  {
    return dao.findByDeparture(departure, origin, destination);
  }
  
  public List<Flight> findByDuration(String duration, City origin, City destination)
  {
    return dao.findByDuration(duration, origin, destination);
  }
  
  public List<Flight> findByArrival(String arrival, City origin, City destination)
  {
    return dao.findByArrival(arrival, origin, destination);
  }
  
  public List<Flight> findByPrice(String price, City origin, City destination)
  {
    return dao.findByPrice(price, origin, destination);
  }
  
  public List<Flight> findByDiscount(String discount, City origin, City destination)
  {
    return dao.findByDiscount(discount, origin, destination);
  }

  public static FlightModel getInstance() 
  {
    return FlightModelHolder.INSTANCE;
  }

  private static class FlightModelHolder 
  {
    private static final FlightModel INSTANCE = new FlightModel();
  }
}
