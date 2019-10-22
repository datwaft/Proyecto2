package airline.presentation.mainwindow;

import java.util.Observable;
import java.util.Observer;

public class Model extends Observable
{
  private Controller controller;
  
  private final airline.presentation.admin.planetype.Model planetypeModel;
  private final airline.presentation.admin.planetype.View planetypeView;
  private final airline.presentation.admin.planetype.Controller planetypeController;
  
  private final airline.presentation.admin.country.Model countryModel;
  private final airline.presentation.admin.country.View countryView;
  private final airline.presentation.admin.country.Controller countryController;
  
  private final airline.presentation.admin.city.Model cityModel;
  private final airline.presentation.admin.city.View cityView;
  private final airline.presentation.admin.city.Controller cityController;
  
  private final airline.presentation.admin.payment.Model paymentModel;
  private final airline.presentation.admin.payment.View paymentView;
  private final airline.presentation.admin.payment.Controller paymentController;
  
  private final airline.presentation.admin.plane.Model planeModel;
  private final airline.presentation.admin.plane.View planeView;
  private final airline.presentation.admin.plane.Controller planeController;
  
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
  }
  
  public Controller getController()
  {
    return controller;
  }

  public void setController(Controller controller)
  {
    this.controller = controller;
    
    planetypeModel.setWindowController(controller);
    controller.addWindow(planetypeView, "planetype");
    
    countryModel.setWindowController(controller);
    controller.addWindow(countryView, "country");
    
    cityModel.setWindowController(controller);
    controller.addWindow(cityView, "city");
    
    paymentModel.setWindowController(controller);
    controller.addWindow(paymentView, "payment");
    
    planeModel.setWindowController(controller);
    controller.addWindow(planeView, "plane");
  }
  
  @Override
  public void addObserver(Observer o)
  {
    super.addObserver(o);
    this.setChanged();
    this.notifyObservers();   
  }
}