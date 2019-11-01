package airline.presentation.admin.user;

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

  public Model getModel()
  {
    return model;
  }

  public View getView()
  {
    return view;
  }
  
  public void search(String string, int selection)
  {
    List<User> list;
    switch (selection)
    {
      case 0: list = UserModel.getInstance().findByUsername(string); break;
      case 1: list = UserModel.getInstance().findByName(string); break;
      case 2: list = UserModel.getInstance().findByLastname(string); break;
      case 3: list = UserModel.getInstance().findByEmail(string); break;
      case 4: list = UserModel.getInstance().findByBirthday(string); break;
      default: list = null; break;
    }
    model.updateTableModel(list);
  }
  
  public void update()
  {
    List<User> list = UserModel.getInstance().findAll();
    model.updateTableModel(list);
  }
  
  public void initialize()
  {
    this.update();
    view.initialize();
  }
}
