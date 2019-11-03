package airline.logic;

import airline.data.ReservationDao;

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
  
  public static ReservationModel getInstance() 
  {
    return ReservationModelHolder.INSTANCE;
  }

  private static class ReservationModelHolder 
  {
    private static final ReservationModel INSTANCE = new ReservationModel();
  }
}
