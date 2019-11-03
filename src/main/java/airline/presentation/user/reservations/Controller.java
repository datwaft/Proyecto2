package airline.presentation.user.reservations;

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

  public Model getModel()
  {
    return model;
  }

  public View getView()
  {
    return view;
  }
  
  public static Vector<Object> getTrips()
  {
    List<Trip> list = TripModel.getInstance().findAll();
    
    Vector<Object> vector = new Vector<>();
    vector.add("Cualquiera");
    for(int i = 0; i < list.size(); ++i)
      vector.add(list.get(i));
    
    return vector;
  }
  
  public static Vector<Object> getPayments()
  {
    List<Payment> list = PaymentModel.getInstance().findAll();
    
    Vector<Object> vector = new Vector<>();
    vector.add("Cualquiera");
    for(int i = 0; i < list.size(); ++i)
      vector.add(list.get(i));
    
    return vector;
  }
  
  public void search(String string, int selection)
  {
    List<Reservation> list;
    if(model.getUser() != null)
    {
      switch (selection)
      {
        case 0: list = ReservationModel.getInstance().findById(string, model.getUser()); break;
        case 3: list = ReservationModel.getInstance().findByAmount(string, model.getUser()); break;
        case 4: list = ReservationModel.getInstance().findByTimestamp(string, model.getUser()); break;
        default: list = null; break;
      }
    }
    else
    {
      list = new ArrayList<>();
    }
    model.updateTableModel(list);
  }
  
  public void searchByTrip(Trip trip)
  {
    model.updateTableModel(ReservationModel.getInstance().findByTrip(trip, model.getUser()));
  }
  
  public void searchByPayment(Payment payment)
  {
    model.updateTableModel(ReservationModel.getInstance().findByPayment(payment, model.getUser()));
  }
  
  public void searchAll()
  {
    if(model.getUser() != null)
      model.updateTableModel(ReservationModel.getInstance().findAll(model.getUser()));
    else
      model.updateTableModel(new ArrayList<>());
  }
  
  public void update()
  {
    List<Reservation> list;
    if(model.getUser() != null)
      list = ReservationModel.getInstance().findAll(model.getUser());
    else
      list = new ArrayList<>();
    model.updateTableModel(list);
  }
  
  public void initialize()
  {
    model.setUser(airline.presentation.user.Model.getLoggedUser());
    this.update();
    view.initialize();
  }
}
