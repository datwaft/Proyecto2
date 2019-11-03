package airline.presentation.admin.reservation.ticket;

import airline.logic.*;
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
  
  public List<Ticket> findAll()
  {
    return TicketModel.getInstance().findByReservation(model.getReservation());
  }
  
  public Model getModel()
  {
    return model;
  }

  public View getView()
  {
    return view;
  }

  public void update()
  {
    model.updateTableModel(findAll());
  }
}
