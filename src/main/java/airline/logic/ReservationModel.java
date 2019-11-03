package airline.logic;

import airline.data.ReservationDao;
import java.util.List;

public class ReservationModel 
{
  ReservationDao dao = ReservationDao.getInstance();
  
  private ReservationModel()
  {
  
  }

  public void create(Reservation object) throws Exception
  {
    dao.create(object);
  }
  
  public List<Reservation> findAll(User user)
  {
    if(user != null)
      return dao.findAll(user);
    else
      return dao.findAll();
  }
  
  public static ReservationModel getInstance() 
  {
    return ReservationModelHolder.INSTANCE;
  }

  public List<Reservation> findById(String string, User user)
  {
    if(user != null)
      return dao.findById(string, user);
    else
      return dao.findById(string);
  }

  public List<Reservation> findByAmount(String string, User user)
  {
    if(user != null)
      return dao.findByAmount(string, user);
    else
      return dao.findByAmount(string);
  }

  public List<Reservation> findByTimestamp(String string, User user)
  {
    if(user != null)
      return dao.findByTimestamp(string, user);
    else
      return dao.findByTimestamp(string);
  }

  public List<Reservation> findByTrip(Trip trip, User user)
  {
    if(user != null)
      return dao.findByTrip(trip, user);
    else
      return dao.findByTrip(trip);
  }

  public List<Reservation> findByPayment(Payment payment, User user)
  {
    if(user != null)
      return dao.findByPayment(payment, user);
    else
      return dao.findByPayment(payment);
  }

  private static class ReservationModelHolder 
  {
    private static final ReservationModel INSTANCE = new ReservationModel();
  }
}
