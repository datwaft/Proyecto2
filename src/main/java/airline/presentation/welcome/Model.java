package airline.presentation.welcome;

import airline.logic.Flight;
import airline.logic.Trip;
import java.util.*;

public class Model extends Observable
{
  private Controller controller;
  private airline.presentation.mainwindow.Controller windowController;
  
  private final airline.presentation.admin.Model adminModel;
  private final airline.presentation.admin.View adminView;
  public final airline.presentation.admin.Controller adminController;
  
  private static Vector<String> searchTypesTrip = null;
  private static Vector<String> searchTypesFlight = null;
  private static Vector<String> weekdays = null;
  private final TableModelFlight tableModelFlight;
  private final TableModelTrip tableModelTrip;
  
  public Model()
  {
    adminModel = new airline.presentation.admin.Model();
    adminView = new airline.presentation.admin.View();
    adminController = new airline.presentation.admin.Controller(adminModel, adminView);
    
    tableModelFlight = new TableModelFlight();
    tableModelTrip = new TableModelTrip();
  }
  
  public Trip getElementTrip(int row)
  {
    return this.tableModelTrip.getElement(row);
  }
  
  public Flight getElementFlight(int row)
  {
    return this.tableModelFlight.getElement(row);
  }
  
  public TableModelTrip getTableModelTrip()
  {
    return tableModelTrip;
  }
  
  public TableModelFlight getTableModelFlight()
  {
    return tableModelFlight;
  }

  public void updateTableModelTrip(List<Trip> list)
  {
    this.tableModelTrip.setList(list);
    this.setChanged();
    this.notifyObservers();   
  }
  
  public void updateTableModelFlight(List<Flight> list)
  {
    this.tableModelFlight.setList(list);
    this.setChanged();
    this.notifyObservers();   
  }
  
  public static Vector<String> getWeekdays()
  {
    if(weekdays == null)
    {
      weekdays = new Vector<>();
      weekdays.add("Cualquiera");
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
  
  public static Vector<String> getSearchTypesFlight()
  {
    if(searchTypesFlight == null)
    {
      searchTypesFlight = new Vector<>();
      searchTypesFlight.add("Tipo de busqueda");
      searchTypesFlight.add("Identificador");
      searchTypesFlight.add("Día");
      searchTypesFlight.add("Partida");
      searchTypesFlight.add("Duración");
      searchTypesFlight.add("LLegada");
      searchTypesFlight.add("Precio");
      searchTypesFlight.add("Descuento");
    }
    return searchTypesFlight;
  }
  
  public static Vector<String> getSearchTypesTrip()
  {
    if(searchTypesTrip == null)
    {
      searchTypesTrip = new Vector<>();
      searchTypesTrip.add("Identificador");
      searchTypesTrip.add("Fecha de salida");
      searchTypesTrip.add("Fecha de regreso");
    }
    return searchTypesTrip;
  }
  
  public Controller getController()
  {
    return controller;
  }

  public void setController(Controller controller)
  {
    this.controller = controller;
    this.setChanged();
    this.notifyObservers();  
  }
  
  public airline.presentation.mainwindow.Controller getWindowController()
  {
    return windowController;
  }

  public void setWindowController(airline.presentation.mainwindow.Controller windowController)
  {
    this.windowController = windowController;
    
    adminModel.setWindowController(this.windowController);
    this.windowController.addWindow(adminView, "admin");
  }
  
  @Override
  public void addObserver(Observer o)
  {
    super.addObserver(o);
    this.setChanged();
    this.notifyObservers();   
  }
}