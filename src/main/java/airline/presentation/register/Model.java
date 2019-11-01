package airline.presentation.register;

import airline.logic.User;
import java.util.*;
import javax.swing.JDialog;

public class Model extends Observable
{
  private Controller controller;
  private JDialog parent;
  private User object;

  public User getObject()
  {
    return object;
  }

  public void setObject(User object)
  {
    this.object = object;
  }

  public Model(User object, JDialog parent)
  {
    this.parent = parent;
    this.object = object;
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
