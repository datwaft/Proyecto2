package airline.presentation.mainwindow;

import java.util.Observable;
import java.util.Observer;

public class Model extends Observable
{
  private Controller controller;
  
  private final airline.presentation.welcome.Model welcomeModel;
  private final airline.presentation.welcome.View welcomeView;
  public final airline.presentation.welcome.Controller welcomeController;
  
  public Model()
  {
    welcomeModel = new airline.presentation.welcome.Model();
    welcomeView = new airline.presentation.welcome.View();
    welcomeController = new airline.presentation.welcome.Controller(welcomeModel, welcomeView);
  }
  
  public Controller getController()
  {
    return controller;
  }

  public void setController(Controller controller)
  {
    this.controller = controller;
    
    welcomeModel.setWindowController(this.controller);
    this.controller.addWindow(welcomeView, "welcome");
  }
  
  @Override
  public void addObserver(Observer o)
  {
    super.addObserver(o);
    this.setChanged();
    this.notifyObservers();   
  }
}