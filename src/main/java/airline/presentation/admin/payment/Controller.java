package airline.presentation.admin.payment;

import airline.data.*;
import airline.logic.Payment;
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
      case 0: list = PaymentDao.getInstance().findById(string); break;
      case 1: list = PaymentDao.getInstance().findByName(string); break;
      default: list = null; break;
    }
    model.updateTableModel(list);
  }
  
  public void update()
  {
    List<Payment> list = PaymentDao.getInstance().findAll();
    model.updateTableModel(list);
  }
  
  public void delete(Payment object) throws Exception
  {
    PaymentDao.getInstance().destroy(object.getId());
    this.update();
  }
  
  public void delete(int[] list) throws Exception
  {
    for(int i = 0; i < list.length; ++i)
      PaymentDao.getInstance().destroy(model.getElement(list[i]).getId());
    this.update();
  }
}
