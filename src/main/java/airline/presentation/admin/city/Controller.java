package airline.presentation.admin.city;

import airline.data.*;
import airline.logic.City;
import airline.logic.Country;
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
    List<City> list;
    switch (selection)
    {
      case 0: list = CityDao.getInstance().findByCode(string); break;
      case 1: list = CityDao.getInstance().findByName(string); break;
      default: list = null; break;
    }
    model.updateTableModel(list);
  }
  
  public void searchByCountry(Country country)
  {
    model.updateTableModel(CityDao.getInstance().findByCountry(country));
  }
  
  public void update()
  {
    List<City> list = CityDao.getInstance().findAll();
    model.updateTableModel(list);
  }
  
  public void delete(City object) throws Exception
  {
    CityDao.getInstance().destroy(object.getCode());
    this.update();
  }
  
  public void delete(int[] list) throws Exception
  {
    for(int i = 0; i < list.length; ++i)
      CityDao.getInstance().destroy(model.getElement(list[i]).getCode());
    this.update();
  }
}
