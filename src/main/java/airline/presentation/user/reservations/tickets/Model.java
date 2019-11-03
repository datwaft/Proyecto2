package airline.presentation.user.reservations.tickets;

import airline.logic.Reservation;
import airline.logic.Ticket;
import java.util.*;
import javax.swing.JDialog;

public class Model extends Observable
{
  private final airline.presentation.user.reservations.Controller parentController;
  private Controller controller;
  private Reservation reservation;
  private TableModel tableModel;
  private JDialog parent;

  public Model(Reservation reservation, JDialog parent, airline.presentation.user.reservations.Controller parentController)
  {
    this.reservation = reservation;
    this.parent = parent;
    this.parentController = parentController;
    tableModel = new TableModel();
  }

  public Ticket getElement(int row)
  {
    return this.tableModel.getElement(row);
  }
  
  public TableModel getTableModel()
  {
    return tableModel;
  }

  public void updateTableModel(List<Ticket> list)
  {
    this.tableModel.setList(list);
    this.setChanged();
    this.notifyObservers();   
  }
  
  public airline.presentation.user.reservations.Controller getParentController()
  {
    return parentController;
  }

  public Controller getController()
  {
    return controller;
  }

  public JDialog getParent()
  {
    return parent;
  }

  public void setParent(JDialog parent)
  {
    this.parent = parent;
  }

  public Reservation getReservation()
  {
    return reservation;
  }

  public void setReservation(Reservation reservation)
  {
    this.reservation = reservation;
  }

  public void setController(Controller controller)
  {
    this.controller = controller;
    this.controller.update();
    this.setChanged();
    this.notifyObservers();  
  }
  
  @Override
  public void addObserver(Observer o)
  {
    super.addObserver(o);
    this.setChanged();
    this.notifyObservers();   
  }
}
