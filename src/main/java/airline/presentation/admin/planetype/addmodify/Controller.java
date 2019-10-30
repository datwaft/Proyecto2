package airline.presentation.admin.planetype.addmodify;

import airline.logic.Planetype;
import airline.logic.PlanetypeModel;

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
  
  public void Add(Planetype object) throws Exception
  {
    PlanetypeModel.getInstance().create(object);
    model.getParentController().update();
  }
  
  public void Modify(Planetype object) throws Exception
  {
    PlanetypeModel.getInstance().update(object);
    model.getParentController().update();
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
