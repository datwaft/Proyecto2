package airline.data;

public class ReservationDao extends ReservationJpaController
{
  private ReservationDao()
  {
    super(PersistenceManager.getInstance().getEntityManagerFactory());
  }

  public static ReservationDao getInstance() 
  {
    return ReservationDaoHolder.INSTANCE;
  }

  private static class ReservationDaoHolder 
  {
    private static final ReservationDao INSTANCE = new ReservationDao();
  }
}
