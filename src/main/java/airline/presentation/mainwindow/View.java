package airline.presentation.mainwindow;

import java.util.Observable;
import java.util.Observer;

public class View implements Observer
{
  Model model;
  Controller controller;
  
  public View()
  {
    
  }
  
  @Override
  public void update(Observable o, Object arg)
  {

  }
  
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
}
