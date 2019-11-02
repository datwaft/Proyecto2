package airline.data;

import airline.logic.*;
import java.util.List;
import javax.persistence.EntityManager;

public class TicketDao extends TicketJpaController
{
  private TicketDao()
  {
    super(PersistenceManager.getInstance().getEntityManagerFactory());
  }
  
  public List<Ticket> findByTrip(Trip trip)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT t FROM Ticket t WHERE t.reservation.trip.identifier = :identifier")
        .setParameter("identifier", trip.getIdentifier())
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
  
  public List<Ticket> findByReservation(Reservation reservation)
  {
    EntityManager em = getEntityManager();
    try
    {
      return em.createQuery("SELECT t FROM Ticket t WHERE t.reservation.id = :id")
        .setParameter("id", reservation.getId())
        .getResultList();
    }
    finally
    {
      em.close();
    }
  }
  
  public static TicketDao getInstance() 
  {
    return TicketDaoHolder.INSTANCE;
  }

  private static class TicketDaoHolder 
  {
    private static final TicketDao INSTANCE = new TicketDao();
  }
}
