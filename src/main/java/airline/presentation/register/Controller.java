package airline.presentation.register;

import airline.logic.User;
import airline.logic.UserModel;

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
  
  public void Add(User object) throws Exception
  {
    UserModel.getInstance().create(object);
  }
  
  public void Modify(User object) throws Exception
  {
    UserModel.getInstance().update(object);
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
