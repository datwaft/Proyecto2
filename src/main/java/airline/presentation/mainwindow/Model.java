package airline.presentation.mainwindow;

import java.util.Observable;
import java.util.Observer;

public class Model extends Observable
{
  private Controller controller;
  
  private final airline.presentation.planetype.Model planetypeModel;
  private final airline.presentation.planetype.View planetypeView;
  private final airline.presentation.planetype.Controller planetypeController;
  
  public Model()
  {
    planetypeModel = new airline.presentation.planetype.Model();
    planetypeView = new airline.presentation.planetype.View();
    planetypeController = new airline.presentation.planetype.Controller(planetypeModel, planetypeView);
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
  }
  
  @Override
  public void addObserver(Observer o)
  {
    super.addObserver(o);
    this.setChanged();
    this.notifyObservers();   
  }
}