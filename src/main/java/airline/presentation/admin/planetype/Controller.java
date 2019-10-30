package airline.presentation.admin.planetype;

import airline.logic.Planetype;
import airline.logic.PlanetypeModel;
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
    List<Planetype> list;
    switch (selection)
    {
      case 0: list = PlanetypeModel.getInstance().findByIdentifier(string); break;
      case 1: list = PlanetypeModel.getInstance().findByYear(string); break;
      case 2: list = PlanetypeModel.getInstance().findByModel(string); break;
      case 3: list = PlanetypeModel.getInstance().findByBrand(string); break;
      case 4: list = PlanetypeModel.getInstance().findByRownumber(string); break;
      case 5: list = PlanetypeModel.getInstance().findByRowseats(string); break;
      default: list = null; break;
    }
    model.updateTableModel(list);
  }
  
  public void update()
  {
    List<Planetype> list = PlanetypeModel.getInstance().findAll();
    model.updateTableModel(list);
  }
  
  public void initialize()
  {
    this.update();
    view.initialize();
  }
  
  public void delete(Planetype object) throws Exception
  {
    PlanetypeModel.getInstance().destroy(object.getIdentifier());
    this.update();
  }
  
  public void delete(int[] list) throws Exception
  {
    for(int i = 0; i < list.length; ++i)
      PlanetypeModel.getInstance().destroy(model.getElement(list[i]).getIdentifier());
    this.update();
  }
}
