package airline.presentation.admin.reservation;

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
  
  public void setUser(Object user)
  {
    if(user.getClass() == User.class)
    {
      model.setUser((User) user);
    }
    else
    {
      model.setUser(null);
    }
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
  
  public static Vector<Object> getUsers()
  {
    List<User> list = UserModel.getInstance().findByAdmin(false);
    
    Vector<Object> vector = new Vector<>();
    vector.add("Cualquiera");
    for(int i = 0; i < list.size(); ++i)
      vector.add(list.get(i));
    
    return vector;
  }
  
  public void search(String string, int selection)
  {
    List<Reservation> list;
    switch (selection)
    {
      case 0: list = ReservationModel.getInstance().findById(string, model.getUser()); break;
      case 3: list = ReservationModel.getInstance().findByAmount(string, model.getUser()); break;
      case 4: list = ReservationModel.getInstance().findByTimestamp(string, model.getUser()); break;
      default: list = null; break;
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
    model.updateTableModel(ReservationModel.getInstance().findAll(model.getUser()));
  }
  
  public void update()
  {
    List<Reservation> list;
    list = ReservationModel.getInstance().findAll(model.getUser());
    model.updateTableModel(list);
  }
  
  public void initialize()
  {
    this.update();
    view.initialize();
  }
}
