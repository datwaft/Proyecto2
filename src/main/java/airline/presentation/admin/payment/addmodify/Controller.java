package airline.presentation.admin.payment.addmodify;

import airline.data.*;
import airline.logic.Payment;

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
  
  public void Add(Payment object) throws Exception
  {
    PaymentDao.getInstance().create(object);
    model.getParentController().update();
  }
  
  public void Modify(Payment object) throws Exception
  {
    PaymentDao.getInstance().update(object);
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
