package airline.presentation.user;

import airline.logic.UserModel;
import airline.logic.User;

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
  
  public void changeWindow(String window)
  {
    switch(window)
    {
      case "trips": model.tripsController.initialize(); break;
      case "seats": model.seatsController.initiliaze(); break;
      case "reservations": model.reservationController.initialize(); break;
    }
    
    model.getWindowController().swapWindow(window);
  }
  
  public void initiliaze()
  {
    view.initialize();
  }
  
  public User findUser(String string)
  {
    return UserModel.getInstance().findUser(string);
  }
  
  public Model getModel()
  {
    return model;
  }

  public View getView()
  {
    return view;
  }
}
