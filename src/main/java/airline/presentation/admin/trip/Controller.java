package airline.presentation.admin.trip;

import airline.data.*;
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

  public Model getModel()
  {
    return model;
  }

  public View getView()
  {
    return view;
  }
  
  public static Vector<Object> getFlights()
  {
    List<Flight> list = FlightDao.getInstance().findAll();
    Vector<Object> vector = new Vector<>();
    vector.add("Cualquiera");
    for(int i = 0; i < list.size(); ++i)
      vector.add(list.get(i));
    return vector;
  }
  
  public static Vector<Object> getFlightsWithNone()
  {
    List<Flight> list = FlightDao.getInstance().findAll();
    Vector<Object> vector = new Vector<>();
    vector.add("Cualquiera");
    vector.add("Ninguno");
    for(int i = 0; i < list.size(); ++i)
      vector.add(list.get(i));
    return vector;
  }
  
  public static Vector<Object> getPlanes()
  {
    List<Plane> list = PlaneDao.getInstance().findAll();
    Vector<Object> vector = new Vector<>();
    vector.add("Cualquiera");
    for(int i = 0; i < list.size(); ++i)
      vector.add(list.get(i));
    return vector;
  }
  
  public void search(String string, Object plane, Object outward, Object inward, int selection)
  {
    if(inward.getClass() == String.class && "Ninguno".equals(inward.toString()))
      inward = null;
      
    List<Trip> list;
    switch (selection)
    {
      case 0: list = TripDao.getInstance().findByIdentifier(string, plane, outward, inward); break;
      case 1: list = TripDao.getInstance().findByDeparture(string, plane, outward, inward); break;
      case 2: list = TripDao.getInstance().findByArrival(string, plane, outward, inward); break;
      default: list = null; break;
    }
    model.updateTableModel(list);
  }
  
  public void update()
  {
    List<Trip> list = TripDao.getInstance().findAll();
    model.updateTableModel(list);
  }
  
  public void initialize()
  {
    this.update();
    view.initialize();
  }
  
  public void delete(Trip object) throws Exception
  {
    TripDao.getInstance().destroy(object.getIdentifier());
    this.update();
  }
  
  public void delete(int[] list) throws Exception
  {
    for(int i = 0; i < list.length; ++i)
      TripDao.getInstance().destroy(model.getElement(list[i]).getIdentifier());
    this.update();
  }
}
