package airline.presentation.admin.reservation;

import airline.logic.Reservation;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel
{
  List<Reservation> list;

  public TableModel()
  {
    list = new ArrayList<>();
  }

  public TableModel(List<Reservation> list)
  {
    this.list = list;
  }

  public List<Reservation> getList()
  {
    return list;
  }

  public void setList(List<Reservation> list)
  {
    this.list = list;
    this.fireTableStructureChanged();
  }
  
  public Reservation getElement(int index)
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
    return 6;
  }

  @Override    
  public String getColumnName(int columnIndex)
  {
    switch(columnIndex)
    {
      case 0: return "ID";
      case 1: return "Usuario";
      case 2: return "Viaje";
      case 3: return "Tipo de pago";
      case 4: return "Precio";
      case 5: return "Timestamp";
      default: return "";
    }
  }
  
  @Override
  public Object getValueAt(int rowIndex, int columnIndex)
  {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
    
    Reservation object = list.get(rowIndex);
    switch(columnIndex)
    {
      case 0: return object.getId();
      case 1: return object.getUser();
      case 2: return object.getTrip();
      case 3: return object.getPayment();
      case 4: return object.getAmount();
      case 5: return formatter.format(object.getTimestamp());
      default: return "";
    }
  }
}
