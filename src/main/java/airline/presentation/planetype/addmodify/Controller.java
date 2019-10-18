package airline.presentation.planetype.addmodify;

import airline.data.PersistenceManager;
import airline.data.PlanetypeJpaController;
import airline.logic.Planetype;

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
  
  public void Add(Planetype object) throws Exception
  {
    PlanetypeJpaController jpacontroller = new PlanetypeJpaController(PersistenceManager.getInstance().getEntityManagerFactory());
    jpacontroller.create(object);
    model.getParentController().search("", 0);
  }
  
  public void Modify(Planetype object) throws Exception
  {
    PlanetypeJpaController jpacontroller = new PlanetypeJpaController(PersistenceManager.getInstance().getEntityManagerFactory());
    jpacontroller.edit(object);
    model.getParentController().search("", 0);
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
