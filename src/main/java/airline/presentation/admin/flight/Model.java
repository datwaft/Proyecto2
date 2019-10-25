package airline.presentation.admin.flight;

import airline.logic.Flight;
import java.util.*;

public class Model extends Observable
{
  private Controller controller;

  private airline.presentation.mainwindow.Controller windowController;
  
  private static Vector<String> searchTypes = null;
  private static Vector<String> weekdays = null;
  private TableModel tableModel;

  public Model()
  {
    tableModel = new TableModel();
  }
  
  public Flight getElement(int row)
  {
    return this.tableModel.getElement(row);
  }
  
  public TableModel getTableModel()
  {
    return tableModel;
  }

  public void updateTableModel(List<Flight> list)
  {
    this.tableModel.setList(list);
    this.setChanged();
    this.notifyObservers();   
  }

  public Model(airline.presentation.mainwindow.Controller windowController)
  {
    this.windowController = windowController;
  }
  
  public Controller getController()
  {
    return controller;
  }

  public void setController(Controller controller)
  {
    this.controller = controller;
    this.controller.update();
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
  
  public static Vector<String> getSearchTypes()
  {
    if(searchTypes == null)
    {
      searchTypes = new Vector<>();
      searchTypes.add("Tipo de busqueda");
      searchTypes.add("Identificador");
      searchTypes.add("Día");
      searchTypes.add("Partida");
      searchTypes.add("Duración");
      searchTypes.add("LLegada");
      searchTypes.add("Precio");
      searchTypes.add("Descuento");
    }
    return searchTypes;
  }
  
  @Override
  public void addObserver(Observer o)
  {
    super.addObserver(o);
    this.setChanged();
    this.notifyObservers();   
  }
}