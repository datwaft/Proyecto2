package airline.presentation.admin.city.addmodify;

import airline.data.*;
import airline.logic.City;
import airline.logic.Country;
import java.util.List;
import java.util.Vector;

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
  
  public static Vector<Object> getParents()
  {
    List<Country> countries = CountryDao.getInstance().findAll();
    
    Vector<Object> vector = new Vector<>();
    for(int i = 0; i < countries.size(); ++i)
      vector.add(countries.get(i));
    
    return vector;
  }
  
  public void Add(City object) throws Exception
  {
    CityDao.getInstance().create(object);
    model.getParentController().update();
  }
  
  public void Modify(City object) throws Exception
  {
    CityDao.getInstance().update(object);
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
