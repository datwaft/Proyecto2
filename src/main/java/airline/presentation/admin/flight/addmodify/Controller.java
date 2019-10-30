package airline.presentation.admin.flight.addmodify;

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
  
  public static Vector<Object> getCities()
  {
    List<City> list = CityModel.getInstance().findAll();
    Vector<Object> vector = new Vector<>();
    for(int i = 0; i < list.size(); ++i)
      vector.add(list.get(i));
    return vector;
  }
  
  public static Vector<String> getWeekdays()
  {
    Vector<String> weekdays = null;
    if(weekdays == null)
    {
      weekdays = new Vector<>();
      weekdays.add("Lunes");
      weekdays.add("Martes");
      weekdays.add("Miercoles");
      weekdays.add("Jueves");
      weekdays.add("Viernes");
      weekdays.add("Sábado");
      weekdays.add("Domingo");
    }
    return weekdays;
  }
  
  public static String parseWeekday(int weekday)
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
  
  public void Add(Flight object) throws Exception
  {
    FlightModel.getInstance().create(object);
    model.getParentController().update();
  }
  
  public void Modify(Flight object) throws Exception
  {
    FlightModel.getInstance().update(object);
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
