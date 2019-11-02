package airline.logic;

import airline.data.TicketDao;
import java.util.List;

public class TicketModel 
{
  private final TicketDao dao = TicketDao.getInstance();
  
  private TicketModel()
  {
  
  }

  public List<Ticket> findByTrip(Trip trip)
  {
    return dao.findByTrip(trip);
  }
  
  public Integer TicketsPerTrip(Trip trip)
  {
    List<Ticket> list = this.findByTrip(trip);
    return list.size();
  }
  
  public List<Ticket> findByReservation(Reservation reservation)
  {
    return dao.findByReservation(reservation);
  }
  
  public static TicketModel getInstance() 
  {
    return TicketModelHolder.INSTANCE;
  }

  private static class TicketModelHolder 
  {
    private static final TicketModel INSTANCE = new TicketModel();
  }
}
