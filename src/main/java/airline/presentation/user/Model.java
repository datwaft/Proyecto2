package airline.presentation.user;

import airline.logic.User;
import java.util.Observable;
import java.util.Observer;

public class Model extends Observable
{
  private Controller controller;
  private airline.presentation.mainwindow.Controller windowController;
  
  private final airline.presentation.user.trips.Model tripsModel;
  private final airline.presentation.user.trips.View tripsView;
  public final airline.presentation.user.trips.Controller tripsController;
  
  private static User loggedUser = null;

  public static User getLoggedUser()
  {
    return loggedUser;
  }

  public static void setLoggedUser(User loggedUser)
  {
    Model.loggedUser = loggedUser;
  }
  
  public Model()
  {
    tripsModel = new airline.presentation.user.trips.Model();
    tripsView = new airline.presentation.user.trips.View();
    tripsController = new airline.presentation.user.trips.Controller(tripsModel, tripsView);
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
    
    tripsModel.setWindowController(this.windowController);
    this.windowController.addWindow(tripsView, "trips");
  }
  
  @Override
  public void addObserver(Observer o)
  {
    super.addObserver(o);
    this.setChanged();
    this.notifyObservers();   
  }
}