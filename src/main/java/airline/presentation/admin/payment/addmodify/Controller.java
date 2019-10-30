package airline.presentation.admin.payment.addmodify;

import airline.logic.Payment;
import airline.logic.PaymentModel;

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
    PaymentModel.getInstance().create(object);
    model.getParentController().update();
  }
  
  public void Modify(Payment object) throws Exception
  {
    PaymentModel.getInstance().update(object);
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
