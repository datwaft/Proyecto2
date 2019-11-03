package airline.presentation.admin.reservation.ticket;

import airline.logic.Ticket;
import java.util.*;
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel
{
  List<Ticket> list;

  public TableModel()
  {
    list = new ArrayList<>();
  }

  public TableModel(List<Ticket> list)
  {
    this.list = list;
  }

  public List<Ticket> getList()
  {
    return list;
  }

  public void setList(List<Ticket> list)
  {
    this.list = list;
    this.fireTableStructureChanged();
  }
  
  public Ticket getElement(int index)
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
    return 3;
  }

  @Override    
  public String getColumnName(int columnIndex)
  {
    switch(columnIndex)
    {
      case 0: return "Nombre";
      case 1: return "Número de fila";
      case 2: return "Letra de asiento";
      default: return "";
    }
  }
  
  @Override
  public Object getValueAt(int rowIndex, int columnIndex)
  {
    Ticket object = list.get(rowIndex);
    switch(columnIndex)
    {
      case 0: return object.getName();
      case 1: return object.getRownumber();
      case 2: return object.getSeatletter();
      default: return "";
    }
  }
}
