package airline.presentation.login;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JDialog;

public class Model extends Observable
{
  private Controller controller;
  private final airline.presentation.welcome.Controller parentController;
  private JDialog parent;
  
  public boolean adminMode;
  
  public Model(boolean adminMode, JDialog parent, airline.presentation.welcome.Controller parentController)
  {
    this.adminMode = adminMode;
    this.parent = parent;
    this.parentController = parentController;
  }

  public boolean isAdminMode()
  {
    return adminMode;
  }

  public void setAdminMode(boolean adminMode)
  {
    this.adminMode = adminMode;
  }
  
  public airline.presentation.welcome.Controller getParentController()
  {
    return parentController;
  }

  public Controller getController()
  {
    return controller;
  }

  public JDialog getParent()
  {
    return parent;
  }

  public void setParent(JDialog parent)
  {
    this.parent = parent;
  }

  public void setController(Controller controller)
  {
    this.controller = controller;
    this.setChanged();
    this.notifyObservers();  
  }
  
  @Override
  public void addObserver(Observer o)
  {
    super.addObserver(o);
    this.setChanged();
    this.notifyObservers();   
  }
}