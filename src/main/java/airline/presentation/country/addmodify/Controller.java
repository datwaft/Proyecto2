package airline.presentation.country.addmodify;

import airline.data.*;
import airline.logic.Country;

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
  
  public void Add(Country object) throws Exception
  {
    CountryDao.getInstance().create(object);
    model.getParentController().update();
  }
  
  public void Modify(Country object) throws Exception
  {
    CountryDao.getInstance().edit(object);
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
