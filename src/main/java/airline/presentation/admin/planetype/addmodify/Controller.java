package airline.presentation.admin.planetype.addmodify;

import airline.data.*;
import airline.logic.Planetype;

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
    PlanetypeDao.getInstance().create(object);
    model.getParentController().update();
  }
  
  public void Modify(Planetype object) throws Exception
  {
    PlanetypeDao.getInstance().update(object);
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
