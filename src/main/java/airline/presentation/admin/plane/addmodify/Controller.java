package airline.presentation.admin.plane.addmodify;

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
  
  public static Vector<Object> getParents()
  {
    List<Planetype> list = PlanetypeDao.getInstance().findAll();
    
    Vector<Object> vector = new Vector<>();
    for(int i = 0; i < list.size(); ++i)
      vector.add(list.get(i));
    
    return vector;
  }
  
  public void Add(Plane object) throws Exception
  {
    PlaneDao.getInstance().create(object);
    model.getParentController().update();
  }
  
  public void Modify(Plane object) throws Exception
  {
    PlaneDao.getInstance().update(object);
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
