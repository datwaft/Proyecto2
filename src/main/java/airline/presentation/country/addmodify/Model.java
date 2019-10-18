package airline.presentation.country.addmodify;

import airline.logic.Country;
import java.util.*;
import javax.swing.JDialog;

public class Model extends Observable
{
  private final airline.presentation.country.Controller parentController;
  private Controller controller;
  private Country object;
  private JDialog parent;

  public Model(Country object, JDialog parent, airline.presentation.country.Controller parentController)
  {
    this.object = object;
    this.parent = parent;
    this.parentController = parentController;
  }

  public airline.presentation.country.Controller getParentController()
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

  public Country getObject()
  {
    return object;
  }

  public void setObject(Country object)
  {
    this.object = object;
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
