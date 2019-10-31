package airline.presentation.login;

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
}
