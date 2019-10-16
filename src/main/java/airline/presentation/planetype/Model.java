package airline.presentation.planetype;

import java.util.Observable;
import java.util.Observer;

public class Model extends Observable
{
  private Controller controller;

  private airline.presentation.mainwindow.Controller windowController;

  public Model()
  {
    
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
  }
  
  public airline.presentation.mainwindow.Controller getWindowController()
  {
    return windowController;
  }

  public void setWindowController(airline.presentation.mainwindow.Controller windowController)
  {
    this.windowController = windowController;
  }

  @Override
  public void addObserver(Observer o)
  {
    super.addObserver(o);
    this.setChanged();
    this.notifyObservers();   
  }
}