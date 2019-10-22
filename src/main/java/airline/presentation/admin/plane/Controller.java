package airline.presentation.admin.plane;

import airline.data.*;
import airline.logic.Plane;
import airline.logic.Planetype;
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
    List<Planetype> list = PlanetypeDao.getInstance().findAll();
    
    Vector<Object> vector = new Vector<>();
    vector.add("Cualquiera");
    for(int i = 0; i < list.size(); ++i)
      vector.add(list.get(i));
    
    return vector;
  }
  
  public void search(String string, int selection)
  {
    List<Plane> list;
    switch (selection)
    {
      case 0: list = PlaneDao.getInstance().findByIdentifier(string); break;
      default: list = null; break;
    }
    model.updateTableModel(list);
  }
  
  public void searchByParent(Planetype planetype)
  {
    model.updateTableModel(PlaneDao.getInstance().findByPlanetype(planetype));
  }
  
  public void searchAll()
  {
    model.updateTableModel(PlaneDao.getInstance().findAll());
  }
  
  public void update()
  {
    List<Plane> list = PlaneDao.getInstance().findAll();
    model.updateTableModel(list);
  }
  
  public void delete(Plane object) throws Exception
  {
    PlaneDao.getInstance().destroy(object.getIdentifier());
    this.update();
  }
  
  public void delete(int[] list) throws Exception
  {
    for(int i = 0; i < list.length; ++i)
      PlaneDao.getInstance().destroy(model.getElement(list[i]).getIdentifier());
    this.update();
  }
}
