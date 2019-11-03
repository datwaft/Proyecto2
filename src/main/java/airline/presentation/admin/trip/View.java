package airline.presentation.admin.trip;

import airline.exceptions.IllegalOrphanException;
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
    ComboBoxOutward = new javax.swing.JComboBox<>();
    ComboBoxInward = new javax.swing.JComboBox<>();
    ComboBoxPlanes = new javax.swing.JComboBox<>();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel1 = new javax.swing.JLabel();
    ButtonReturn = new javax.swing.JButton();

    setMaximumSize(new java.awt.Dimension(800, 500));
    setMinimumSize(new java.awt.Dimension(800, 500));
    setPreferredSize(new java.awt.Dimension(800, 500));

    LabelTitle.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
    LabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    LabelTitle.setText("Gestión de viajes");

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

    TextField.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        TextFieldActionPerformed(evt);
      }
    });

    ComboBoxTypes.setModel(new DefaultComboBoxModel<>(Model.getSearchTypes()));

    ButtonEliminar.setText("Eliminar");
    ButtonEliminar.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ButtonEliminarActionPerformed(evt);
      }
    });

    ComboBoxOutward.setModel(new DefaultComboBoxModel<>(Controller.getFlights()));

    ComboBoxInward.setModel(new DefaultComboBoxModel<>(Controller.getFlightsWithNone()));

    ComboBoxPlanes.setModel(new DefaultComboBoxModel<>(Controller.getPlanes()));

    jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel2.setText("Vuelo de vuelta");
    jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

    jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel3.setText("Vuelo de ida");
    jLabel3.setToolTipText("");
    jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

    jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Avión");
    jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

    ButtonReturn.setText("Regresar");
    ButtonReturn.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ButtonReturnActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(55, 55, 55)
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(10, 10, 10)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(10, 10, 10)
            .addComponent(ComboBoxTypes, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(8, 8, 8)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addGap(55, 55, 55)
            .addComponent(ComboBoxOutward, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(10, 10, 10)
            .addComponent(ComboBoxPlanes, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(10, 10, 10)
            .addComponent(TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(6, 6, 6)
            .addComponent(ComboBoxInward, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(6, 6, 6)
            .addComponent(ButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addGap(10, 10, 10)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addGap(0, 10, Short.MAX_VALUE))
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(ButtonAdd)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ButtonEliminar)
            .addContainerGap())
          .addGroup(layout.createSequentialGroup()
            .addComponent(ButtonReturn)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(LabelTitle)
            .addGap(310, 310, 310))))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(6, 6, 6)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(LabelTitle)
          .addComponent(ButtonReturn))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(4, 4, 4)
            .addComponent(jLabel3))
          .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(ComboBoxTypes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(6, 6, 6)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(ComboBoxOutward, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(ComboBoxPlanes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(ButtonSearch)
          .addGroup(layout.createSequentialGroup()
            .addGap(1, 1, 1)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(ComboBoxInward)
              .addComponent(TextField))))
        .addGap(9, 9, 9)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(ButtonEliminar)
          .addComponent(ButtonAdd))
        .addContainerGap())
    );
  }// </editor-fold>//GEN-END:initComponents

  private void ButtonSearchActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonSearchActionPerformed
  {//GEN-HEADEREND:event_ButtonSearchActionPerformed
    controller.search(TextField.getText(), ComboBoxPlanes.getSelectedItem(), ComboBoxOutward.getSelectedItem()
      , ComboBoxInward.getSelectedItem(), ComboBoxTypes.getSelectedIndex());
  }//GEN-LAST:event_ButtonSearchActionPerformed

  private void ButtonAddActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonAddActionPerformed
  {//GEN-HEADEREND:event_ButtonAddActionPerformed
    JDialog dialog = new JDialog(this.model.getWindowController().getView(), "Añadir viaje", true);
    dialog.setResizable(false);
    
    airline.presentation.admin.trip.addmodify.Model addmodifyModel = 
            new airline.presentation.admin.trip.addmodify.Model(null, dialog, controller);
    airline.presentation.admin.trip.addmodify.View addmodifyView = 
            new airline.presentation.admin.trip.addmodify.View();
    airline.presentation.admin.trip.addmodify.Controller addmodifyController =
            new airline.presentation.admin.trip.addmodify.Controller(addmodifyModel, addmodifyView);
    
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
      JDialog dialog = new JDialog(this.model.getWindowController().getView(), "Modificar viaje", true);
      dialog.setResizable(false);

      airline.presentation.admin.trip.addmodify.Model addmodifyModel = 
              new airline.presentation.admin.trip.addmodify.Model(model.getElement(Table.convertRowIndexToModel(row)), dialog, controller);
      airline.presentation.admin.trip.addmodify.View addmodifyView = 
              new airline.presentation.admin.trip.addmodify.View();
      airline.presentation.admin.trip.addmodify.Controller addmodifyController =
              new airline.presentation.admin.trip.addmodify.Controller(addmodifyModel, addmodifyView);
    
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
      JLabel label = new JLabel("<html><center>No se puede ya que objetos quedarían huerfanos.</center></html>");
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

  private void ButtonReturnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonReturnActionPerformed
  {//GEN-HEADEREND:event_ButtonReturnActionPerformed
    model.getWindowController().swapWindow("admin");
  }//GEN-LAST:event_ButtonReturnActionPerformed

  @Override
  public void update(Observable o, Object arg)
  {
    Table.setModel(model.getTableModel());
    setColumnWidths(Table, 70, 150, 150, 70, 150, 70);
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
  
  public void initialize()
  {
    ComboBoxOutward.setModel(new DefaultComboBoxModel<>(Controller.getFlights()));
    ComboBoxPlanes.setModel(new DefaultComboBoxModel<>(Controller.getPlanes()));
    ComboBoxInward.setModel(new DefaultComboBoxModel<>(Controller.getFlightsWithNone()));
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
  private javax.swing.JButton ButtonReturn;
  private javax.swing.JButton ButtonSearch;
  private javax.swing.JComboBox<Object> ComboBoxInward;
  private javax.swing.JComboBox<Object> ComboBoxOutward;
  private javax.swing.JComboBox<Object> ComboBoxPlanes;
  private javax.swing.JComboBox<String> ComboBoxTypes;
  private javax.swing.JLabel LabelTitle;
  private javax.swing.JTable Table;
  private javax.swing.JTextField TextField;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JScrollPane jScrollPane1;
  // End of variables declaration//GEN-END:variables
}
