package airline.presentation.city.addmodify;

import airline.data.*;
import airline.logic.City;

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
  
  public void Add(City object) throws Exception
  {
    CityDao.getInstance().create(object);
    model.getParentController().update();
  }
  
  public void Modify(City object) throws Exception
  {
    CityDao.getInstance().edit(object);
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
