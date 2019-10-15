package airline.logic.mvc;

import java.util.Observable;
import java.util.Observer;

public class View implements Observer
{
  Model model;
  Controller controller;
  
  public Model getModel()
  {
    return model;
  }

  public void setModel(Model model) 
  {
    this.model = model;
    model.addObserver(this);
  }

  public Controller getController() 
  {
    return controller;
  }

  public void setController(Controller controller)
  {
    this.controller = controller;
  }
  
  @Override
  public void update(Observable o, Object arg)
  {
    
  }
}
