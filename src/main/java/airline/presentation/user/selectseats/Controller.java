package airline.presentation.user.selectseats;

import airline.logic.*;
import java.util.*;

public class Controller
{
  Model model;
  View view;

  public Controller(Model model, View view)
  {
    this.model = model;
    this.view = view;
    view.setModel(model);
    view.setController(this);
    model.setController(this);
  }
  
  public void initiliaze()
  {
    view.initialize();
  }
  
  public void processPurchase() throws Exception
  {
    try
    {
      Reservation reservation = new Reservation();
      reservation.setUser(Model.getLoggedUser());
      reservation.setTrip(Model.getSelectedTrip());
      reservation.setPayment(Model.getPaymentType());
      reservation.setAmount(Model.getPrice());
      reservation.setTimestamp(new Date());
      ReservationModel.getInstance().create(reservation);
      
      Ticket ticket;
      for(int i = 0; i < model.getSelected().size(); ++i)
      {
        ticket = new Ticket();
        ticket.setReservation(reservation);
        ticket.setName(Model.getNames().get(i));
        ticket.setRow(model.getSelected().get(i).fst);
        ticket.setSeat(model.getSelected().get(i).snd.toString());
        TicketModel.getInstance().create(ticket);
      }
    }
    catch(Exception ex)
    {
      System.err.println("Ha ocurrido un error procesando el pago");
      throw ex;
    }
  }
  
  public List<Ticket> getTripSeats()
  {
    return TicketModel.getInstance().findByTrip(Model.getSelectedTrip());
  }
  
  public Model getModel()
  {
    return model;
  }

  public View getView()
  {
    return view;
  }
}
