package airline.presentation.user.passangers;

import airline.logic.*;
import java.util.List;
import java.util.Vector;

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
  
  public static Vector<Object> getPayment()
  {
    List<Payment> list = PaymentModel.getInstance().findAll();
    Vector<Object> vector = new Vector<>();
    for(int i = 0; i < list.size(); ++i)
      vector.add(list.get(i));
    return vector;
  }
  
  public static Integer getAvailableSeats(Trip trip)
  {
    return (trip.getPlane().getType().getRownumber() * trip.getPlane().getType().getRowseats())
        - TicketModel.getInstance().TicketsPerTrip(trip);
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
