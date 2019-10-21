package airline.presentation.admin.payment;

import airline.data.*;
import airline.logic.Payment;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel
{
  List<Payment> list;

  public TableModel()
  {
    list = PaymentDao.getInstance().findPaymentEntities();
  }

  public TableModel(List<Payment> list)
  {
    this.list = list;
  }

  public List<Payment> getList()
  {
    return list;
  }

  public void setList(List<Payment> list)
  {
    this.list = list;
    this.fireTableStructureChanged();
  }
  
  public Payment getElement(int index)
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
      case 0: return "Id";
      case 1: return "Nombre";
      default: return "";
    }
  }
  
  @Override
  public Object getValueAt(int rowIndex, int columnIndex)
  {
    Payment object = list.get(rowIndex);
    switch(columnIndex)
    {
      case 0: return object.getId();
      case 1: return object.getName();
      default: return "";
    }
  }
}
