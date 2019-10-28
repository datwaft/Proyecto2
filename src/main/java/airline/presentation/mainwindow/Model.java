package airline.presentation.mainwindow;

import java.util.Observable;
import java.util.Observer;

public class Model extends Observable
{
  private Controller controller;
  
  private final airline.presentation.admin.Model adminModel;
  private final airline.presentation.admin.View adminView;
  private final airline.presentation.admin.Controller adminController;
  
  public Model()
  {
    adminModel = new airline.presentation.admin.Model();
    adminView = new airline.presentation.admin.View();
    adminController = new airline.presentation.admin.Controller(adminModel, adminView);
  }
  
  public Controller getController()
  {
    return controller;
  }

  public void setController(Controller controller)
  {
    this.controller = controller;
    
    adminModel.setWindowController(this.controller);
    this.controller.addWindow(adminView, "admin");
  }
  
  @Override
  public void addObserver(Observer o)
  {
    super.addObserver(o);
    this.setChanged();
    this.notifyObservers();   
  }
}