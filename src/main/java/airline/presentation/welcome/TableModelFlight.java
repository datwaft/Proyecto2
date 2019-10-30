package airline.presentation.welcome;

import airline.logic.Flight;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.table.AbstractTableModel;

public class TableModelFlight extends AbstractTableModel
{
  List<Flight> list;

  public TableModelFlight()
  {
    list = new ArrayList<>();
  }

  public TableModelFlight(List<Flight> list)
  {
    this.list = list;
  }

  public List<Flight> getList()
  {
    return list;
  }

  public void setList(List<Flight> list)
  {
    this.list = list;
    this.fireTableStructureChanged();
  }
  
  public Flight getElement(int index)
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
    return 9;
  }

  @Override    
  public String getColumnName(int columnIndex)
  {
    switch(columnIndex)
    {
      case 0: return "Identificador";
      case 1: return "Origen";
      case 2: return "Destino";
      case 3: return "Día";
      case 4: return "Partida";
      case 5: return "Duración";
      case 6: return "Llegada";
      case 7: return "Precio";
      case 8: return "Descuento";
      default: return "";
    }
  }
  
  @Override
  public Object getValueAt(int rowIndex, int columnIndex)
  {
    Flight object = list.get(rowIndex);
    
    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
    formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
    
    switch(columnIndex)
    {
      case 0: return object.getIdentifier();
      case 1: return object.getOrigin();
      case 2: return object.getDestination();
      case 3: return parseWeekday(object.getWeekday());
      case 4: return formatter.format(object.getDeparture());
      case 5: return formatter.format(object.getDuration());
      case 6: return formatter.format(object.getArrival());
      case 7: return "$" + Double.toString(object.getPrice());
      case 8: return object.getDiscount().multiply(BigDecimal.valueOf(100)).toString() + "%";
      default: return "";
    }
  }
  
  private String parseWeekday(int weekday)
  {
    switch(weekday)
    {
      case 1: return "Lunes";
      case 2: return "Martes";
      case 3: return "Miercoles";
      case 4: return "Jueves";
      case 5: return "Viernes";
      case 6: return "Sábado";
      case 7: return "Domingo";
      default: return "";
    }
  }
}