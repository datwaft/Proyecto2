package airline.presentation.admin.city.addmodify;

import airline.data.CountryDao;
import airline.logic.City;
import airline.logic.Country;
import java.util.*;
import javax.swing.JDialog;

public class Model extends Observable
{
  private final airline.presentation.admin.city.Controller parentController;
  private Controller controller;
  private City object;
  private JDialog parent;

  public Model(City object, JDialog parent, airline.presentation.admin.city.Controller parentController)
  {
    this.object = object;
    this.parent = parent;
    this.parentController = parentController;
  }
  
  public airline.presentation.admin.city.Controller getParentController()
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

  public City getObject()
  {
    return object;
  }

  public void setObject(City object)
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
