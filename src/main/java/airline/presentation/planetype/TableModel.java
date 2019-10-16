package airline.presentation.planetype;

import airline.data.PersistenceManager;
import airline.data.PlanetypeJpaController;
import airline.logic.Planetype;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel
{
  List<Planetype> list;

  public TableModel()
  {
    list = new PlanetypeJpaController(PersistenceManager.getInstance().getEntityManagerFactory()).findPlanetypeEntities();
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
    Planetype object = list.get(rowIndex);
    switch(columnIndex)
    {
      case 0: return object.getIdentifier();
      case 1: return object.getYear();
      case 2: return object.getModel();
      case 3: return object.getBrand();
      case 4: return object.getRowCount();
      case 5: return object.getSeatsRow();
      default: return "";
    }
  }
}
