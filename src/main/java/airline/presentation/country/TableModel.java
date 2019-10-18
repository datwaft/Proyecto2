package airline.presentation.country;

import airline.data.*;
import airline.logic.Country;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel
{
  List<Country> list;

  public TableModel()
  {
    list = CountryDao.getInstance().findCountryEntities();
  }

  public TableModel(List<Country> list)
  {
    this.list = list;
  }

  public List<Country> getList()
  {
    return list;
  }

  public void setList(List<Country> list)
  {
    this.list = list;
    this.fireTableStructureChanged();
  }
  
  public Country getElement(int index)
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
    return 2;
  }

  @Override    
  public String getColumnName(int columnIndex)
  {
    switch(columnIndex)
    {
      case 0: return "Código";
      case 1: return "Nombre";
      default: return "";
    }
  }
  
  @Override
  public Object getValueAt(int rowIndex, int columnIndex)
  {
    Country object = list.get(rowIndex);
    switch(columnIndex)
    {
      case 0: return object.getCode();
      case 1: return object.getName();
      default: return "";
    }
  }
}
