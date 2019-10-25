package airline.presentation.admin.flight;

import airline.exceptions.IllegalOrphanException;
import airline.logic.City;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import javax.swing.table.TableColumnModel;

public class View extends javax.swing.JPanel implements Observer
{ 
  Model model;
  Controller controller;
  
  public View()
  {
    initComponents();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents()
  {

    LabelTitle = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    Table = new javax.swing.JTable();
    ButtonAdd = new javax.swing.JButton();
    ButtonSearch = new javax.swing.JButton();
    TextField = new javax.swing.JTextField();
    ComboBoxTypes = new javax.swing.JComboBox<>();
    ButtonEliminar = new javax.swing.JButton();
    ComboBoxOrigin = new javax.swing.JComboBox<>();
    ComboBoxDestination = new javax.swing.JComboBox<>();
    ComboBoxWeekdays = new javax.swing.JComboBox<>();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();

    setMaximumSize(new java.awt.Dimension(800, 500));
    setMinimumSize(new java.awt.Dimension(800, 500));

    LabelTitle.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
    LabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    LabelTitle.setText("Gestión de vuelos");

    Table.setAutoCreateRowSorter(true);
    Table.setModel(new TableModel());
    Table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
    Table.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseClicked(java.awt.event.MouseEvent evt)
      {
        TableMouseClicked(evt);
      }
    });
    jScrollPane1.setViewportView(Table);

    ButtonAdd.setText("Añadir");
    ButtonAdd.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ButtonAddActionPerformed(evt);
      }
    });

    ButtonSearch.setText("Buscar");
    ButtonSearch.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ButtonSearchActionPerformed(evt);
      }
    });

    TextField.setEnabled(false);
    TextField.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        TextFieldActionPerformed(evt);
      }
    });

    ComboBoxTypes.setModel(new DefaultComboBoxModel<>(Model.getSearchTypes()));
    ComboBoxTypes.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ComboBoxTypesActionPerformed(evt);
      }
    });

    ButtonEliminar.setText("Eliminar");
    ButtonEliminar.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ButtonEliminarActionPerformed(evt);
      }
    });

    ComboBoxOrigin.setModel(new DefaultComboBoxModel<>(Controller.getCities()));

    ComboBoxDestination.setModel(new DefaultComboBoxModel<>(Controller.getCities()));

    ComboBoxWeekdays.setModel(new DefaultComboBoxModel<>(Model.getWeekdays()));
    ComboBoxWeekdays.setEnabled(false);

    jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel2.setText("País de destino");
    jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

    jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel3.setText("País de origen");
    jLabel3.setToolTipText("");
    jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(ComboBoxOrigin, 0, 153, Short.MAX_VALUE)
              .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addComponent(ComboBoxWeekdays, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addComponent(ComboBoxTypes, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(ComboBoxDestination, 0, 150, Short.MAX_VALUE)
              .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(ButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(LabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addComponent(ButtonAdd)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ButtonEliminar))
          .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(LabelTitle)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
          .addComponent(ComboBoxTypes)
          .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(ComboBoxWeekdays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(ComboBoxDestination, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(ButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(ComboBoxOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(ButtonAdd)
          .addComponent(ButtonEliminar))
        .addContainerGap())
    );
  }// </editor-fold>//GEN-END:initComponents

  private void ButtonSearchActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonSearchActionPerformed
  {//GEN-HEADEREND:event_ButtonSearchActionPerformed
    if (ComboBoxTypes.getSelectedIndex() == 2)
    {
      controller.search((String)ComboBoxWeekdays.getSelectedItem(), (City)ComboBoxOrigin.getSelectedItem()
        , (City)ComboBoxDestination.getSelectedItem(), ComboBoxTypes.getSelectedIndex());
    }
    else
    {
      controller.search(TextField.getText(), (City)ComboBoxOrigin.getSelectedItem()
        , (City)ComboBoxDestination.getSelectedItem(), ComboBoxTypes.getSelectedIndex());
    }
  }//GEN-LAST:event_ButtonSearchActionPerformed

  private void ButtonAddActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonAddActionPerformed
  {//GEN-HEADEREND:event_ButtonAddActionPerformed
    JDialog dialog = new JDialog(this.model.getWindowController().getView(), "Añadir tipo de avión", true);
    dialog.setResizable(false);
    
    airline.presentation.admin.flight.addmodify.Model addmodifyModel = 
            new airline.presentation.admin.flight.addmodify.Model(null, dialog, controller);
    airline.presentation.admin.flight.addmodify.View addmodifyView = 
            new airline.presentation.admin.flight.addmodify.View();
    airline.presentation.admin.flight.addmodify.Controller addmodifyController =
            new airline.presentation.admin.flight.addmodify.Controller(addmodifyModel, addmodifyView);
    
    dialog.getContentPane().add(addmodifyView);
    dialog.pack();
    dialog.setLocationRelativeTo(this.model.getWindowController().getView());
    dialog.setVisible(true);
  }//GEN-LAST:event_ButtonAddActionPerformed

  private void TableMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_TableMouseClicked
  {//GEN-HEADEREND:event_TableMouseClicked
    if(evt.getClickCount() == 2)
    {
      int row = this.Table.getSelectedRow();
      JDialog dialog = new JDialog(this.model.getWindowController().getView(), "Modificar tipo de avión", true);
      dialog.setResizable(false);

      airline.presentation.admin.flight.addmodify.Model addmodifyModel = 
              new airline.presentation.admin.flight.addmodify.Model(model.getElement(Table.convertRowIndexToModel(row)), dialog, controller);
      airline.presentation.admin.flight.addmodify.View addmodifyView = 
              new airline.presentation.admin.flight.addmodify.View();
      airline.presentation.admin.flight.addmodify.Controller addmodifyController =
              new airline.presentation.admin.flight.addmodify.Controller(addmodifyModel, addmodifyView);
    
      dialog.getContentPane().add(addmodifyView);
      dialog.pack();
      dialog.setLocationRelativeTo(this.model.getWindowController().getView());
      dialog.setVisible(true);
    }
  }//GEN-LAST:event_TableMouseClicked

  private void ButtonEliminarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonEliminarActionPerformed
  {//GEN-HEADEREND:event_ButtonEliminarActionPerformed
    int[] selectedRows = this.Table.getSelectedRows();
    if(selectedRows.length == 0)
    {
      JLabel label = new JLabel("<html><center> No hay ninguna entrada seleccionada</center></html>");
      Object[] options = {"Aceptar"};
      JOptionPane dialog = new JOptionPane();
      JOptionPane.showOptionDialog(this
            , label
            , "Ha ocurrido un error"
            , JOptionPane.DEFAULT_OPTION
            , JOptionPane.ERROR_MESSAGE
            , null
            , options
            , options[0]);
      return;
    }
    {
      Object[] options = {"Confimar", "Cancelar"};
      JOptionPane dialog = new JOptionPane();
      Object selection = JOptionPane.showOptionDialog(this
            , "¿Está seguro de que desea eliminar "
            + (selectedRows.length == 1 ? "la entrada" :(selectedRows.length + " entradas"))
            + "? Esta acción no se puede deshacer"
            , "Confirmación de eliminación"
            , JOptionPane.OK_CANCEL_OPTION
            , JOptionPane.WARNING_MESSAGE
            , null
            , options
            , options[1]);
      if(selection.equals(1))
        return;
    }
    try
    {
      for (int i = 0; i < selectedRows.length; i++)
        selectedRows[i] = Table.convertRowIndexToModel(selectedRows[i]);
      controller.delete(selectedRows);
    }
    catch(IllegalOrphanException ex)
    {
      JLabel label = new JLabel("<html><center>No se puede eliminar porque hay ciudades que quedarían sin país</center></html>");
      Object[] options = {"Aceptar"};
      JOptionPane dialog = new JOptionPane();
      JOptionPane.showOptionDialog(this
            , label
            , "Ha ocurrido un error"
            , JOptionPane.DEFAULT_OPTION
            , JOptionPane.ERROR_MESSAGE
            , null
            , options
            , options[0]);
    }
    catch(Exception ex)
    {
      JLabel label = new JLabel("<html><center>"+ ex.getMessage() +"</center></html>");
      Object[] options = {"Aceptar"};
      JOptionPane dialog = new JOptionPane();
      JOptionPane.showOptionDialog(this
            , label
            , "Ha ocurrido un error"
            , JOptionPane.DEFAULT_OPTION
            , JOptionPane.ERROR_MESSAGE
            , null
            , options
            , options[0]);
    }
  }//GEN-LAST:event_ButtonEliminarActionPerformed

  private void TextFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_TextFieldActionPerformed
  {//GEN-HEADEREND:event_TextFieldActionPerformed
    ButtonSearchActionPerformed(evt);
  }//GEN-LAST:event_TextFieldActionPerformed

  private void ComboBoxTypesActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ComboBoxTypesActionPerformed
  {//GEN-HEADEREND:event_ComboBoxTypesActionPerformed
    switch (ComboBoxTypes.getSelectedIndex())
    {
      case 0:
        TextField.setEnabled(false);
        ComboBoxWeekdays.setEnabled(false);
        break;
      case 2:
        TextField.setEnabled(false);
        ComboBoxWeekdays.setEnabled(true);
        break;
      default:
        TextField.setEnabled(true);
        ComboBoxWeekdays.setEnabled(false);
        break;
    }
  }//GEN-LAST:event_ComboBoxTypesActionPerformed

  @Override
  public void update(Observable o, Object arg)
  {
    Table.setModel(model.getTableModel());
    setColumnWidths(Table, 70, 140, 140, 70, 70, 70, 70, 70);
  }
  
  public static void setColumnWidths(JTable table, int... widths) 
  {
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    TableColumnModel columnModel = table.getColumnModel();
    for (int i = 0; i < widths.length; i++) 
    {
      if (i < columnModel.getColumnCount())
      {
        columnModel.getColumn(i).setMinWidth(widths[i]);
        columnModel.getColumn(i).setPreferredWidth(widths[i]);
        columnModel.getColumn(i).setMaxWidth(widths[i]);
      }
      else 
        break;
    }
    table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
  }
  
  public Model getModel()
  {
    return model;
  }

  public void setModel(Model model) 
  {
    this.model = model;
    model.addObserver(this);
  }

  public Controller getController() 
  {
    return controller;
  }

  public void setController(Controller controller)
  {
    this.controller = controller;
  }
  
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton ButtonAdd;
  private javax.swing.JButton ButtonEliminar;
  private javax.swing.JButton ButtonSearch;
  private javax.swing.JComboBox<Object> ComboBoxDestination;
  private javax.swing.JComboBox<Object> ComboBoxOrigin;
  private javax.swing.JComboBox<String> ComboBoxTypes;
  private javax.swing.JComboBox<String> ComboBoxWeekdays;
  private javax.swing.JLabel LabelTitle;
  private javax.swing.JTable Table;
  private javax.swing.JTextField TextField;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JScrollPane jScrollPane1;
  // End of variables declaration//GEN-END:variables
}
