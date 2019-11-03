package airline.presentation.user.selectseats;

import airline.logic.Ticket;
import airline.logic.TicketModel;
import java.util.ArrayList;
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
  
  public void changeWindow(String window)
  {
    switch(window)
    {
      
    }
    
    model.getWindowController().swapWindow(window);
  }
  
  public void initiliaze()
  {
    view.initialize();
  }
  
  public List<Ticket> getTripSeats()
  {
    return TicketModel.getInstance().findByTrip(Model.getSelectedTrip());
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
