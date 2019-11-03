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
  
  private final airline.presentation.user.selectseats.Model seatsModel;
  private final airline.presentation.user.selectseats.View seatsView;
  public final airline.presentation.user.selectseats.Controller seatsController;
  
  private final airline.presentation.user.reservations.Model reservationsModel;
  private final airline.presentation.user.reservations.View reservationsView;
  public final airline.presentation.user.reservations.Controller reservationController;
  
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
    
    seatsModel = new airline.presentation.user.selectseats.Model();
    seatsView = new airline.presentation.user.selectseats.View();
    seatsController = new airline.presentation.user.selectseats.Controller(seatsModel, seatsView);
    
    reservationsModel = new airline.presentation.user.reservations.Model();
    reservationsView = new airline.presentation.user.reservations.View();
    reservationController = new airline.presentation.user.reservations.Controller(reservationsModel, reservationsView);
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
    tripsModel.setUserController(controller);
    this.windowController.addWindow(tripsView, "trips");
    
    seatsModel.setWindowController(this.windowController);
    seatsModel.setUserController(controller);
    this.windowController.addWindow(seatsView, "seats");
    
    reservationsModel.setWindowController(this.windowController);
    this.windowController.addWindow(reservationsView, "reservations");
  }
  
  @Override
  public void addObserver(Observer o)
  {
    super.addObserver(o);
    this.setChanged();
    this.notifyObservers();   
  }
}