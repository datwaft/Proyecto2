package airline.presentation.admin.payment;

import airline.logic.Payment;
import airline.logic.PaymentModel;
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
    List<Payment> list;
    switch (selection)
    {
      case 0: list = PaymentModel.getInstance().findById(string); break;
      case 1: list = PaymentModel.getInstance().findByName(string); break;
      default: list = null; break;
    }
    model.updateTableModel(list);
  }
  
  public void update()
  {
    List<Payment> list = PaymentModel.getInstance().findAll();
    model.updateTableModel(list);
  }
  
  public void initialize()
  {
    this.update();
    view.initialize();
  }
  
  public void delete(Payment object) throws Exception
  {
    PaymentModel.getInstance().destroy(object.getId());
    this.update();
  }
  
  public void delete(int[] list) throws Exception
  {
    for(int i = 0; i < list.length; ++i)
      PaymentModel.getInstance().destroy(model.getElement(list[i]).getId());
    this.update();
  }
}
