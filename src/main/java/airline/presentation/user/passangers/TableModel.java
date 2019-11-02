package airline.presentation.user.passangers;

import java.util.*;
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel
{
  List<String> list;

  public TableModel(int number)
  {
    list = new ArrayList<>();
    for(int i = 0; i < number; ++i)
      list.add("");
  }

  public TableModel(List<String> list)
  {
    this.list = list;
  }

  public List<String> getList()
  {
    return list;
  }

  public void setList(List<String> list)
  {
    this.list = list;
    this.fireTableStructureChanged();
  }
  
  public void changeList(int number)
  {
    if(number == list.size())
      return;
    if(number < list.size())
    {
      list = list.subList(0, number);
    }
    else
    {
      for(int i = 0; i < number - list.size(); ++i)
        list.add("");
    }
    this.fireTableStructureChanged();
  }
  
  public String getElement(int index)
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
    return 1;
  }

  @Override    
  public String getColumnName(int columnIndex)
  {
    switch(columnIndex)
    {
      case 0: return "Nombre";
      default: return "";
    }
  }
  
  @Override
  public Object getValueAt(int rowIndex, int columnIndex)
  {
    String object = list.get(rowIndex);
    switch(columnIndex)
    {
      case 0: return object;
      default: return "";
    }
  }
  
  @Override
  public void setValueAt(Object aValue, int rowIndex, int columnIndex)
  {
    list.set(rowIndex, aValue.toString());
  }
  
  public Object getValueAt(int rowIndex)
  {
    String object = list.get(rowIndex);
    return object;
  }
  
  @Override
  public boolean isCellEditable(int rowIndex, int columnIndex)
  {
      return true;
  }
}
