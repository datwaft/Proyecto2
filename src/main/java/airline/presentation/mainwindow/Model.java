package airline.presentation.mainwindow;

import java.util.Observable;
import java.util.Observer;

public class Model extends Observable
{
  private Controller controller;
  
  private final airline.presentation.planetype.Model planetypeModel;
  private final airline.presentation.planetype.View planetypeView;
  private final airline.presentation.planetype.Controller planetypeController;
  
  private final airline.presentation.country.Model countryModel;
  private final airline.presentation.country.View countryView;
  private final airline.presentation.country.Controller countryController;
  
  private final airline.presentation.city.Model cityModel;
  private final airline.presentation.city.View cityView;
  private final airline.presentation.city.Controller cityController;
  
  public Model()
  {
    planetypeModel = new airline.presentation.planetype.Model();
    planetypeView = new airline.presentation.planetype.View();
    planetypeController = new airline.presentation.planetype.Controller(planetypeModel, planetypeView);
    
    countryModel = new airline.presentation.country.Model();
    countryView = new airline.presentation.country.View();
    countryController = new airline.presentation.country.Controller(countryModel, countryView);
    
    cityModel = new airline.presentation.city.Model();
    cityView = new airline.presentation.city.View();
    cityController = new airline.presentation.city.Controller(cityModel, cityView);
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
  }
  
  @Override
  public void addObserver(Observer o)
  {
    super.addObserver(o);
    this.setChanged();
    this.notifyObservers();   
  }
}