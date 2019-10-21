package airline.presentation.admin.payment.addmodify;

import airline.logic.Payment;
import java.util.*;
import javax.swing.JDialog;

public class Model extends Observable
{
  private final airline.presentation.admin.payment.Controller parentController;
  private Controller controller;
  private Payment object;
  private JDialog parent;

  public Model(Payment object, JDialog parent, airline.presentation.admin.payment.Controller parentController)
  {
    this.object = object;
    this.parent = parent;
    this.parentController = parentController;
  }

  public airline.presentation.admin.payment.Controller getParentController()
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

  public Payment getObject()
  {
    return object;
  }

  public void setObject(Payment object)
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
