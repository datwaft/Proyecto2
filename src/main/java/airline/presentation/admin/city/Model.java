package airline.presentation.admin.city;

import airline.logic.City;
import java.util.*;

public class Model extends Observable
{
  private Controller controller;
  private airline.presentation.mainwindow.Controller windowController;
  private static Vector<String> searchTypes = null;
  private TableModel tableModel;

  public Model()
  {
    tableModel = new TableModel();
  }
  
  public City getElement(int row)
  {
    return this.tableModel.getElement(row);
  }
  
  public TableModel getTableModel()
  {
    return tableModel;
  }

  public void updateTableModel(List<City> list)
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

  public static Vector<String> getSearchTypes()
  {
    if(searchTypes == null)
    {
      searchTypes = new Vector<>();
      searchTypes.add("Código");
      searchTypes.add("Nombre");
      searchTypes.add("Ciudad");
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