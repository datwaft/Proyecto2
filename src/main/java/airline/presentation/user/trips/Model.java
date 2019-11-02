package airline.presentation.user.trips;

import airline.logic.Trip;
import java.util.*;

public class Model extends Observable
{
  private Controller controller;

  private airline.presentation.mainwindow.Controller windowController;
  private airline.presentation.user.Controller userController;
  
  private static Vector<String> searchTypes = null;
  private TableModel tableModel;

  public Model()
  {
    tableModel = new TableModel();
  }
  
  public Trip getElement(int row)
  {
    return this.tableModel.getElement(row);
  }
  
  public TableModel getTableModel()
  {
    return tableModel;
  }

  public void updateTableModel(List<Trip> list)
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

  public airline.presentation.user.Controller getUserController()
  {
    return userController;
  }

  public void setUserController(airline.presentation.user.Controller userController)
  {
    this.userController = userController;
  }
  
  public static Vector<String> getSearchTypes()
  {
    if(searchTypes == null)
    {
      searchTypes = new Vector<>();
      searchTypes.add("Identificador");
      searchTypes.add("Fecha de salida");
      searchTypes.add("Fecha de regreso");
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