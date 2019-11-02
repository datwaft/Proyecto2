package airline.presentation.user.trips;

import airline.logic.TicketModel;
import airline.logic.Trip;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel
{
  List<Trip> list;

  public TableModel()
  {
    list = new ArrayList<>();
  }

  public TableModel(List<Trip> list)
  {
    this.list = list;
  }

  public List<Trip> getList()
  {
    return list;
  }

  public void setList(List<Trip> list)
  {
    this.list = list;
    this.fireTableStructureChanged();
  }
  
  public Trip getElement(int index)
  {
    return this.list.get(index);
  }
  
  @Override
  public int getRowCount()
  {
    return list.size();
  }

  @Override
  public int getColumnCount()
  {
    return 7;
  }

  @Override    
  public String getColumnName(int columnIndex)
  {
    switch(columnIndex)
    {
      case 0: return "Identificador";
      case 1: return "Avión";
      case 2: return "Viaje de ida";
      case 3: return "Fecha de salida";
      case 4: return "Viaje de vuelta";
      case 5: return "Fecha de regreso";
      case 6: return "Asientos disponibles";
      default: return "";
    }
  }
  
  @Override
  public Object getValueAt(int rowIndex, int columnIndex)
  {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
    
    Trip object = list.get(rowIndex);
    switch(columnIndex)
    {
      case 0: return object.getIdentifier();
      case 1: return object.getPlane();
      case 2: return object.getOutward();
      case 3: return formatter.format(object.getDeparture());
      case 4: return (object.getInward() == null ? "N/A" : object.getInward());
      case 5: return (object.getArrival() == null ? "N/A" : formatter.format(object.getArrival()));
      case 6: return (object.getPlane().getType().getRownumber() * object.getPlane().getType().getRowseats())
        - TicketModel.getInstance().TicketsPerTrip(object);
      default: return "";
    }
  }
}
