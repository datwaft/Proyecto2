package airline.presentation.user.passangers;

import airline.logic.Trip;
import java.util.*;
import javax.swing.JDialog;

public class Model extends Observable
{
  private Controller controller;
  private airline.presentation.user.Controller userController;
  private JDialog parent;
  private Trip trip;

  public Model(Trip trip, JDialog parent, airline.presentation.user.Controller userController)
  {
    this.trip = trip;
    this.parent = parent;
    this.userController = userController;
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

  public airline.presentation.user.Controller getUserController()
  {
    return userController;
  }

  public void setUserController(airline.presentation.user.Controller userController)
  {
    this.userController = userController;
  }

  public Trip getTrip()
  {
    return trip;
  }

  public void setTrip(Trip trip)
  {
    this.trip = trip;
  }
  
  @Override
  public void addObserver(Observer o)
  {
    super.addObserver(o);
    this.setChanged();
    this.notifyObservers();   
  }
}
