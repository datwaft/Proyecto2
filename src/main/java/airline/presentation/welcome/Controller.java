package airline.presentation.welcome;

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
  
  public static Vector<Object> getCities()
  {
    List<City> list = CityModel.getInstance().findAll();
    Vector<Object> vector = new Vector<>();
    vector.add(new City("", "Cualquiera"));
    for(int i = 0; i < list.size(); ++i)
      vector.add(list.get(i));
    return vector;
  }
  
  public static Vector<Object> getFlights()
  {
    List<Flight> list = FlightModel.getInstance().findAll();
    Vector<Object> vector = new Vector<>();
    vector.add("Cualquiera");
    for(int i = 0; i < list.size(); ++i)
      vector.add(list.get(i));
    return vector;
  }
  
  public static Vector<Object> getFlightsWithNone()
  {
    List<Flight> list = FlightModel.getInstance().findAll();
    Vector<Object> vector = new Vector<>();
    vector.add("Cualquiera");
    vector.add("Ninguno");
    for(int i = 0; i < list.size(); ++i)
      vector.add(list.get(i));
    return vector;
  }
  
  public static Vector<Object> getPlanes()
  {
    List<Plane> list = PlaneModel.getInstance().findAll();
    Vector<Object> vector = new Vector<>();
    vector.add("Cualquiera");
    for(int i = 0; i < list.size(); ++i)
      vector.add(list.get(i));
    return vector;
  }
  
  public void searchTrip(String string, Object plane, Object outward, Object inward, int selection)
  {
    if(inward.getClass() == String.class && "Ninguno".equals(inward.toString()))
      inward = null;
      
    List<Trip> list;
    switch (selection)
    {
      case 0: list = TripModel.getInstance().findByIdentifier(string, plane, outward, inward); break;
      case 1: list = TripModel.getInstance().findByDeparture(string, plane, outward, inward); break;
      case 2: list = TripModel.getInstance().findByArrival(string, plane, outward, inward); break;
      default: list = null; break;
    }
    model.updateTableModelTrip(list);
  }
  
  public void searchFlight(String string, City origin, City destination, int selection)
  {
    List<Flight> list;
    switch (selection)
    {
      case 0: list = FlightModel.getInstance().findByIdentifier("", origin, destination); break;
      case 1: list = FlightModel.getInstance().findByIdentifier(string, origin, destination); break;
      case 2: list = FlightModel.getInstance().findByWeekday(parseWeekday(string), origin, destination); break;
      case 3: list = FlightModel.getInstance().findByDeparture(string, origin, destination); break;
      case 4: list = FlightModel.getInstance().findByDuration(string, origin, destination); break;
      case 5: list = FlightModel.getInstance().findByArrival(string, origin, destination); break;
      case 6: list = FlightModel.getInstance().findByPrice(string, origin, destination); break;
      case 7: list = FlightModel.getInstance().findByDiscount(string, origin, destination); break;
      default: list = null; break;
    }
    model.updateTableModelFlight(list);
  }
  
  public void updateTrip()
  {
    List<Trip> list = TripModel.getInstance().findAll();
    model.updateTableModelTrip(list);
  }
  
  public void updateFlight()
  {
    List<Flight> list = FlightModel.getInstance().findAll();
    model.updateTableModelFlight(list);
  }
  
  public void initialize()
  {
    this.updateTrip();
    this.updateFlight();
    view.initialize();
  }
  
  private String parseWeekday(String weekday)
  {
    switch(weekday)
    {
      case "Lunes": return "1";
      case "Martes": return "2";
      case "Miercoles": return "3";
      case "Jueves": return "4";
      case "Viernes": return "5";
      case "Sábado": return "6";
      case "Domingo": return "7";
      default: return "";
    }
  }
}
