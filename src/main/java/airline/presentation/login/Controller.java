package airline.presentation.login;

import airline.logic.User;
import airline.logic.UserModel;
import java.util.List;

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
  
  public List<User> findNormalUsers()
  {
    return UserModel.getInstance().findByAdmin(false);
  }
  
  public List<User> findAdminUsers()
  {
    return UserModel.getInstance().findByAdmin(true);
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
