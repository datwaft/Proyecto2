package airline.presentation.admin.trip.addmodify;

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
  
  public static Vector<Object> getPlanes()
  {
    List<Plane> aux = PlaneDao.getInstance().findAll();
    Vector<Object> vector = new Vector<>();
    for(int i = 0; i < aux.size(); ++i)
    {
      vector.add(aux.get(i));
    }
    return vector;
  }
  
  public static Vector<Object> getFlights()
  {
    List<Flight> aux = FlightDao.getInstance().findAll();
    Vector<Object> vector = new Vector<>();
    for(int i = 0; i < aux.size(); ++i)
    {
      vector.add(aux.get(i));
    }
    return vector;
  }
  
  public static Vector<Object> getFlightsWithNone(Flight flight)
  {
    List<Flight> aux = FlightDao.getInstance().findByCities(flight.getDestination(), flight.getOrigin());
    Vector<Object> vector = new Vector<>();
    vector.add("Ninguno");
    for(int i = 0; i < aux.size(); ++i)
    {
      vector.add(aux.get(i));
    }
    return vector;
  }
  
  public String parseWeekday(int weekday)
  {
    switch(weekday)
    {
      case 1: return "Lunes";
      case 2: return "Martes";
      case 3: return "Miercoles";
      case 4: return "Jueves";
      case 5: return "Viernes";
      case 6: return "Sábado";
      case 7: return "Domingo";
      default: return "";
    }
  }
  
  public void Add(Trip object) throws Exception
  {
    TripDao.getInstance().create(object);
    model.getParentController().update();
  }
  
  public void Modify(Trip object) throws Exception
  {
    TripDao.getInstance().update(object);
    model.getParentController().update();
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
