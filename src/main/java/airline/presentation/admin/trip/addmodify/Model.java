package airline.presentation.admin.trip.addmodify;

import airline.logic.Trip;
import java.util.*;
import javax.swing.JDialog;

public class Model extends Observable
{
  private final airline.presentation.admin.trip.Controller parentController;
  private Controller controller;
  private Trip planetype;
  private JDialog parent;

  public Model(Trip planetype, JDialog parent, airline.presentation.admin.trip.Controller parentController)
  {
    this.planetype = planetype;
    this.parent = parent;
    this.parentController = parentController;
  }

  public airline.presentation.admin.trip.Controller getParentController()
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

  public Trip getTrip()
  {
    return planetype;
  }

  public void setTrip(Trip planetype)
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
