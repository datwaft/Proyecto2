package airline.presentation.city;

import airline.data.*;
import airline.logic.City;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel
{
  List<City> list;

  public TableModel()
  {
    list = CityDao.getInstance().findCityEntities();
  }

  public TableModel(List<City> list)
  {
    this.list = list;
  }

  public List<City> getList()
  {
    return list;
  }

  public void setList(List<City> list)
  {
    this.list = list;
    this.fireTableStructureChanged();
  }
  
  public City getElement(int index)
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
      case 0: return "Código";
      case 1: return "Nombre";
      case 2: return "País";
      default: return "";
    }
  }
  
  @Override
  public Object getValueAt(int rowIndex, int columnIndex)
  {
    City object = list.get(rowIndex);
    switch(columnIndex)
    {
      case 0: return object.getCode();
      case 1: return object.getName();
      case 2: return object.getCountry().getName();
      default: return "";
    }
  }
}
