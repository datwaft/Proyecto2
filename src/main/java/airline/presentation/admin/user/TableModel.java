package airline.presentation.admin.user;

import airline.logic.User;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel
{
  List<User> list;

  public TableModel()
  {
    list = new ArrayList<>();
  }

  public TableModel(List<User> list)
  {
    this.list = list;
  }

  public List<User> getList()
  {
    return list;
  }

  public void setList(List<User> list)
  {
    this.list = list;
    this.fireTableStructureChanged();
  }
  
  public User getElement(int index)
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
    return 5;
  }

  @Override    
  public String getColumnName(int columnIndex)
  {
    switch(columnIndex)
    {
      case 0: return "Nombre de usuario";
      case 1: return "Nombre";
      case 2: return "Apellido";
      case 3: return "Correo electrónico";
      case 4: return "Fecha de nacimiento";
      default: return "";
    }
  }
  
  @Override
  public Object getValueAt(int rowIndex, int columnIndex)
  {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
    
    User object = list.get(rowIndex);
    switch(columnIndex)
    {
      case 0: return object.getUsername();
      case 1: return object.getName();
      case 2: return object.getLastname();
      case 3: return object.getEmail();
      case 4: return formatter.format(object.getBirthday());
      default: return "";
    }
  }
}
