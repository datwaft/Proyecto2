package airline.presentation.admin;

import airline.logic.User;
import java.util.Observable;
import java.util.Observer;

public class Model extends Observable
{
  private Controller controller;
  private airline.presentation.mainwindow.Controller windowController;
  
  private final airline.presentation.admin.planetype.Model planetypeModel;
  private final airline.presentation.admin.planetype.View planetypeView;
  public final airline.presentation.admin.planetype.Controller planetypeController;
  
  private final airline.presentation.admin.country.Model countryModel;
  private final airline.presentation.admin.country.View countryView;
  public final airline.presentation.admin.country.Controller countryController;
  
  private final airline.presentation.admin.city.Model cityModel;
  private final airline.presentation.admin.city.View cityView;
  public final airline.presentation.admin.city.Controller cityController;
  
  private final airline.presentation.admin.payment.Model paymentModel;
  private final airline.presentation.admin.payment.View paymentView;
  public final airline.presentation.admin.payment.Controller paymentController;
  
  private final airline.presentation.admin.plane.Model planeModel;
  private final airline.presentation.admin.plane.View planeView;
  public final airline.presentation.admin.plane.Controller planeController;
  
  private final airline.presentation.admin.flight.Model flightModel;
  private final airline.presentation.admin.flight.View flightView;
  public final airline.presentation.admin.flight.Controller flightController;
  
  private final airline.presentation.admin.trip.Model tripModel;
  private final airline.presentation.admin.trip.View tripView;
  public final airline.presentation.admin.trip.Controller tripController;
  
  private final airline.presentation.admin.user.Model userModel;
  private final airline.presentation.admin.user.View userView;
  public final airline.presentation.admin.user.Controller userController;
  
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
    planetypeModel = new airline.presentation.admin.planetype.Model();
    planetypeView = new airline.presentation.admin.planetype.View();
    planetypeController = new airline.presentation.admin.planetype.Controller(planetypeModel, planetypeView);
    
    countryModel = new airline.presentation.admin.country.Model();
    countryView = new airline.presentation.admin.country.View();
    countryController = new airline.presentation.admin.country.Controller(countryModel, countryView);
    
    cityModel = new airline.presentation.admin.city.Model();
    cityView = new airline.presentation.admin.city.View();
    cityController = new airline.presentation.admin.city.Controller(cityModel, cityView);
    
    paymentModel = new airline.presentation.admin.payment.Model();
    paymentView = new airline.presentation.admin.payment.View();
    paymentController = new airline.presentation.admin.payment.Controller(paymentModel, paymentView);
    
    planeModel = new airline.presentation.admin.plane.Model();
    planeView = new airline.presentation.admin.plane.View();
    planeController = new airline.presentation.admin.plane.Controller(planeModel, planeView);
    
    flightModel = new airline.presentation.admin.flight.Model();
    flightView = new airline.presentation.admin.flight.View();
    flightController = new airline.presentation.admin.flight.Controller(flightModel, flightView);
    
    tripModel = new airline.presentation.admin.trip.Model();
    tripView = new airline.presentation.admin.trip.View();
    tripController = new airline.presentation.admin.trip.Controller(tripModel, tripView);
    
    userModel = new airline.presentation.admin.user.Model();
    userView = new airline.presentation.admin.user.View();
    userController = new airline.presentation.admin.user.Controller(userModel, userView);
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
    
    planetypeModel.setWindowController(this.windowController);
    this.windowController.addWindow(planetypeView, "planetype");
    
    countryModel.setWindowController(this.windowController);
    this.windowController.addWindow(countryView, "country");
    
    cityModel.setWindowController(this.windowController);
    this.windowController.addWindow(cityView, "city");
    
    paymentModel.setWindowController(this.windowController);
    this.windowController.addWindow(paymentView, "payment");
    
    planeModel.setWindowController(this.windowController);
    this.windowController.addWindow(planeView, "plane");
    
    flightModel.setWindowController(this.windowController);
    this.windowController.addWindow(flightView, "flight");
    
    tripModel.setWindowController(this.windowController);
    this.windowController.addWindow(tripView, "trip");
    
    userModel.setWindowController(this.windowController);
    this.windowController.addWindow(userView, "userview");
  }
  
  @Override
  public void addObserver(Observer o)
  {
    super.addObserver(o);
    this.setChanged();
    this.notifyObservers();   
  }
}