package airline.presentation.admin.flight.addmodify;

import airline.logic.Flight;
import java.util.*;
import javax.swing.JDialog;

public class Model extends Observable
{
  private final airline.presentation.admin.flight.Controller parentController;
  private Controller controller;
  private Flight planetype;
  private JDialog parent;

  public Model(Flight planetype, JDialog parent, airline.presentation.admin.flight.Controller parentController)
  {
    this.planetype = planetype;
    this.parent = parent;
    this.parentController = parentController;
  }

  public airline.presentation.admin.flight.Controller getParentController()
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

  public Flight getObject()
  {
    return planetype;
  }

  public void setPlanetype(Flight planetype)
  {
    this.planetype = planetype;
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
