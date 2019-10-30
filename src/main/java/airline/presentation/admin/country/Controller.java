package airline.presentation.admin.country;

import airline.logic.Country;
import airline.logic.CountryModel;
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
      case 0: list = CountryModel.getInstance().findByCode(string); break;
      case 1: list = CountryModel.getInstance().findByName(string); break;
      default: list = null; break;
    }
    model.updateTableModel(list);
  }
  
  public void update()
  {
    List<Country> list = CountryModel.getInstance().findAll();
    model.updateTableModel(list);
  }
  
  public void initialize()
  {
    this.update();
    view.initialize();
  }
  
  public void delete(Country object) throws Exception
  {
    CountryModel.getInstance().destroy(object.getCode());
    this.update();
  }
  
  public void delete(int[] list) throws Exception
  {
    for(int i = 0; i < list.length; ++i)
      CountryModel.getInstance().destroy(model.getElement(list[i]).getCode());
    this.update();
  }
}
