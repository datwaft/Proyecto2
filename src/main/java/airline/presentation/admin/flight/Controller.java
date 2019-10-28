package airline.presentation.admin.flight;

import airline.data.*;
import airline.logic.Flight;
import airline.logic.City;
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
    List<City> list = CityDao.getInstance().findAll();
    Vector<Object> vector = new Vector<>();
    vector.add(new City("", "Cualquiera"));
    for(int i = 0; i < list.size(); ++i)
      vector.add(list.get(i));
    return vector;
  }
  
  public void search(String string, City origin, City destination, int selection)
  {
    List<Flight> list;
    switch (selection)
    {
      case 0: list = FlightDao.getInstance().findByIdentifier("", origin, destination); break;
      case 1: list = FlightDao.getInstance().findByIdentifier(string, origin, destination); break;
      case 2: list = FlightDao.getInstance().findByWeekday(parseWeekday(string), origin, destination); break;
      case 3: list = FlightDao.getInstance().findByDeparture(string, origin, destination); break;
      case 4: list = FlightDao.getInstance().findByDuration(string, origin, destination); break;
      case 5: list = FlightDao.getInstance().findByArrival(string, origin, destination); break;
      case 6: list = FlightDao.getInstance().findByPrice(string, origin, destination); break;
      case 7: list = FlightDao.getInstance().findByDiscount(string, origin, destination); break;
      default: list = null; break;
    }
    model.updateTableModel(list);
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
  
  public void update()
  {
    List<Flight> list = FlightDao.getInstance().findAll();
    model.updateTableModel(list);
  }
  
  public void initialize()
  {
    this.update();
    view.initialize();
  }
  
  public void delete(Flight object) throws Exception
  {
    FlightDao.getInstance().destroy(object.getIdentifier());
    this.update();
  }
  
  public void delete(int[] list) throws Exception
  {
    for(int i = 0; i < list.length; ++i)
      FlightDao.getInstance().destroy(model.getElement(list[i]).getIdentifier());
    this.update();
  }
}
