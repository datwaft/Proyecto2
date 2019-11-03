package airline.presentation.mainwindow;

import javax.swing.JPanel;

public class Controller
{
  Model model;
  View view;

  public Controller(Model model, View view)
  {
    this.model = model;
    this.view = view;
    view.setModel(model);
    view.setController(this);
    model.setController(this);
  }
  
  public Model getModel()
  {
    return model;
  }

  public View getView()
  {
    return view;
  }
  
  public void addWindow(JPanel window, String name)
  {
    view.addWindow(window, name);
  }
  
  public void swapWindow(String window)
  {
    view.swapWindow(window);
  }
  
  public void changeWindow(String window)
  {
    switch(window)
    {
      case "welcome": model.welcomeController.initialize();  break;
    }
    this.swapWindow(window);
  }
}
