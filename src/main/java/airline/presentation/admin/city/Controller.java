package airline.presentation.admin.city;

import airline.logic.*;
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

  public Model getModel()
  {
    return model;
  }

  public View getView()
  {
    return view;
  }
  
  public static Vector<Object> getParents()
  {
    List<Country> list = CountryModel.getInstance().findAll();
    
    Vector<Object> vector = new Vector<>();
    vector.add("Cualquiera");
    for(int i = 0; i < list.size(); ++i)
      vector.add(list.get(i));
    
    return vector;
  }
  
  public void search(String string, int selection)
  {
    List<City> list;
    switch (selection)
    {
      case 0: list = CityModel.getInstance().findByCode(string); break;
      case 1: list = CityModel.getInstance().findByName(string); break;
      default: list = null; break;
    }
    model.updateTableModel(list);
  }
  
  public void searchByParent(Country country)
  {
    model.updateTableModel(CityModel.getInstance().findByCountry(country));
  }
  
  public void searchAll()
  {
    model.updateTableModel(CityModel.getInstance().findAll());
  }
  
  public void update()
  {
    List<City> list = CityModel.getInstance().findAll();
    model.updateTableModel(list);
  }
  
  public void initialize()
  {
    this.update();
    view.initialize();
  }
  
  public void delete(City object) throws Exception
  {
    CityModel.getInstance().destroy(object.getCode());
    this.update();
  }
  
  public void delete(int[] list) throws Exception
  {
    for(int i = 0; i < list.length; ++i)
      CityModel.getInstance().destroy(model.getElement(list[i]).getCode());
    this.update();
  }
}
