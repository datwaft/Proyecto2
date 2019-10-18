package airline.presentation.country;

import airline.data.*;
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
    List<Country> list;
    switch (selection)
    {
      case 0: list = CountryDao.getInstance().findByCode(string); break;
      case 1: list = CountryDao.getInstance().findByName(string); break;
      default: list = null; break;
    }
    model.updateTableModel(list);
  }
  
  public void update()
  {
    List<Country> list = CountryDao.getInstance().findAll();
    model.updateTableModel(list);
  }
  
  public void delete(Country object) throws Exception
  {
    CountryDao.getInstance().destroy(object.getCode());
    this.update();
  }
  
  public void delete(int[] list) throws Exception
  {
    for(int i = 0; i < list.length; ++i)
      CountryDao.getInstance().destroy(model.getElement(list[i]).getCode());
    this.update();
  }
}
