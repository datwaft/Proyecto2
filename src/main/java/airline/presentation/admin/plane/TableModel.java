package airline.presentation.admin.plane;

import airline.logic.Plane;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel
{
  List<Plane> list;

  public TableModel()
  {
    list = new ArrayList<>();
  }

  public TableModel(List<Plane> list)
  {
    this.list = list;
  }

  public List<Plane> getList()
  {
    return list;
  }

  public void setList(List<Plane> list)
  {
    this.list = list;
    this.fireTableStructureChanged();
  }
  
  public Plane getElement(int index)
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
      case 0: return "Identificador";
      case 1: return "Año";
      case 2: return "Modelo";
      case 3: return "Marca";
      case 4: return "Filas";
      case 5: return "Asientos por fila";
      default: return "";
    }
  }
  
  @Override
  public Object getValueAt(int rowIndex, int columnIndex)
  {
    Plane object = list.get(rowIndex);
    switch(columnIndex)
    {
      case 0: return object.getIdentifier();
      case 1: return object.getType().getYear();
      case 2: return object.getType().getModel();
      case 3: return object.getType().getBrand();
      case 4: return object.getType().getRownumber();
      case 5: return object.getType().getRowseats();
      default: return "";
    }
  }
}
