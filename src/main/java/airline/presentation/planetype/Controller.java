package airline.presentation.planetype;

import airline.data.PersistenceManager;
import airline.data.PlanetypeJpaController;
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
  
  public void search(String string, int selection)
  {
    List<Planetype> list;
    switch (selection)
    {
      case 0: list = new PlanetypeJpaController(PersistenceManager.getInstance().getEntityManagerFactory()).findByIdentifier(string); break;
      case 1: list = new PlanetypeJpaController(PersistenceManager.getInstance().getEntityManagerFactory()).findByYear(string); break;
      case 2: list = new PlanetypeJpaController(PersistenceManager.getInstance().getEntityManagerFactory()).findByModel(string); break;
      case 3: list = new PlanetypeJpaController(PersistenceManager.getInstance().getEntityManagerFactory()).findByBrand(string); break;
      case 4: list = new PlanetypeJpaController(PersistenceManager.getInstance().getEntityManagerFactory()).findByRowCount(string); break;
      case 5: list = new PlanetypeJpaController(PersistenceManager.getInstance().getEntityManagerFactory()).findBySeatsRow(string); break;
      default: list = null; break;
    }
    model.updateTableModel(list);
  }
}
