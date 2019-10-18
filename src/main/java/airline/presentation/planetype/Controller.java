package airline.presentation.planetype;

import airline.data.*;
import airline.logic.Planetype;
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
      case 0: list = PlanetypeDao.getInstance().findByIdentifier(string); break;
      case 1: list = PlanetypeDao.getInstance().findByYear(string); break;
      case 2: list = PlanetypeDao.getInstance().findByModel(string); break;
      case 3: list = PlanetypeDao.getInstance().findByBrand(string); break;
      case 4: list = PlanetypeDao.getInstance().findByRownumber(string); break;
      case 5: list = PlanetypeDao.getInstance().findByRowseats(string); break;
      default: list = null; break;
    }
    model.updateTableModel(list);
  }
  
  public void update()
  {
    List<Planetype> list = PlanetypeDao.getInstance().findAll();
    model.updateTableModel(list);
  }
  
  public void delete(Planetype object) throws Exception
  {
    PlanetypeDao.getInstance().destroy(object.getIdentifier());
    this.update();
  }
}
