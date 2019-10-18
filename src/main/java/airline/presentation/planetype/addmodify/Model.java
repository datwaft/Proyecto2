package airline.presentation.planetype.addmodify;

import airline.logic.Planetype;
import java.util.*;
import javax.swing.JDialog;

public class Model extends Observable
{
  private final airline.presentation.planetype.Controller parentController;
  private Controller controller;
  private Planetype planetype;
  private JDialog parent;

  public Model(Planetype planetype, JDialog parent, airline.presentation.planetype.Controller parentController)
  {
    this.planetype = planetype;
    this.parent = parent;
    this.parentController = parentController;
  }

  public airline.presentation.planetype.Controller getParentController()
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

  public Planetype getPlanetype()
  {
    return planetype;
  }

  public void setPlanetype(Planetype planetype)
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
