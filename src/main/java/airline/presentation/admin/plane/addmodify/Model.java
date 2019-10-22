package airline.presentation.admin.plane.addmodify;

import airline.logic.Plane;
import java.util.*;
import javax.swing.JDialog;

public class Model extends Observable
{
  private final airline.presentation.admin.plane.Controller parentController;
  private Controller controller;
  private Plane object;
  private JDialog parent;

  public Model(Plane object, JDialog parent, airline.presentation.admin.plane.Controller parentController)
  {
    this.object = object;
    this.parent = parent;
    this.parentController = parentController;
  }
  
  public airline.presentation.admin.plane.Controller getParentController()
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

  public Plane getObject()
  {
    return object;
  }

  public void setObject(Plane object)
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
