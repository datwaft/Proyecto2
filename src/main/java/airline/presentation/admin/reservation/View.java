package airline.presentation.admin.reservation;

import airline.logic.Trip;
import airline.logic.Payment;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

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
    ButtonSearch = new javax.swing.JButton();
    TextField = new javax.swing.JTextField();
    LabelType = new javax.swing.JLabel();
    ComboBoxTypes = new javax.swing.JComboBox<>();
    ComboBoxObjects = new javax.swing.JComboBox<>();
    ButtonReturn = new javax.swing.JButton();
    ComboBoxUser = new javax.swing.JComboBox<>();
    LabelUser = new javax.swing.JLabel();

    setMaximumSize(new java.awt.Dimension(800, 500));
    setMinimumSize(new java.awt.Dimension(800, 500));
    setPreferredSize(new java.awt.Dimension(800, 500));
    setRequestFocusEnabled(false);
    setVerifyInputWhenFocusTarget(false);

    LabelTitle.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
    LabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    LabelTitle.setText("Ver reservas");

    Table.setAutoCreateRowSorter(true);
    Table.setModel(new TableModel());
    Table.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseClicked(java.awt.event.MouseEvent evt)
      {
        TableMouseClicked(evt);
      }
    });
    jScrollPane1.setViewportView(Table);

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

    LabelType.setText("Tipo de busqueda:");

    ComboBoxTypes.setModel(new DefaultComboBoxModel<>(Model.getSearchTypes()));
    ComboBoxTypes.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ComboBoxTypesActionPerformed(evt);
      }
    });

    ComboBoxObjects.setModel(new DefaultComboBoxModel<>(Controller.getTrips()));
    ComboBoxObjects.setEnabled(false);

    ButtonReturn.setText("Regresar");
    ButtonReturn.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ButtonReturnActionPerformed(evt);
      }
    });

    ComboBoxUser.setModel(new DefaultComboBoxModel(Controller.getUsers()));
    ComboBoxUser.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ComboBoxUserActionPerformed(evt);
      }
    });

    LabelUser.setText("Usuario:");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jScrollPane1)
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(LabelUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboBoxUser, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelType)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboBoxTypes, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboBoxObjects, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonSearch)))
            .addContainerGap())
          .addGroup(layout.createSequentialGroup()
            .addComponent(ButtonReturn)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 250, Short.MAX_VALUE)
            .addComponent(LabelTitle)
            .addGap(335, 335, 335))))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(LabelTitle)
          .addComponent(ButtonReturn))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(LabelType)
          .addComponent(ComboBoxTypes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(ButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(ComboBoxObjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(ComboBoxUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(LabelUser))
        .addGap(19, 19, 19)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(12, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void ButtonSearchActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonSearchActionPerformed
  {//GEN-HEADEREND:event_ButtonSearchActionPerformed
    switch (ComboBoxTypes.getSelectedIndex())
    {
      case 1:
        if(ComboBoxObjects.getSelectedItem().getClass() == Trip.class)
          controller.searchByTrip((Trip) ComboBoxObjects.getSelectedItem());
        else
          controller.searchAll();
        break;
      case 2:
        if(ComboBoxObjects.getSelectedItem().getClass() == Payment.class)
          controller.searchByPayment((Payment) ComboBoxObjects.getSelectedItem());
        else
          controller.searchAll();
        break;
      default:
        controller.search(TextField.getText(), ComboBoxTypes.getSelectedIndex());
        break;
    }
  }//GEN-LAST:event_ButtonSearchActionPerformed

  private void TableMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_TableMouseClicked
  {//GEN-HEADEREND:event_TableMouseClicked
    if(evt.getClickCount() == 2)
    {
      int row = this.Table.getSelectedRow();
      JDialog dialog = new JDialog(this.model.getWindowController().getView(), "Ver tiquetes", true);
      dialog.setResizable(false);

      airline.presentation.admin.reservation.ticket.Model viewModel = 
              new airline.presentation.admin.reservation.ticket.Model(model.getElement(Table.convertRowIndexToModel(row)), dialog, controller);
      airline.presentation.admin.reservation.ticket.View viewView = 
              new airline.presentation.admin.reservation.ticket.View();
      airline.presentation.admin.reservation.ticket.Controller viewController =
              new airline.presentation.admin.reservation.ticket.Controller(viewModel, viewView);

      dialog.getContentPane().add(viewView);
      dialog.pack();
      dialog.setLocationRelativeTo(this.model.getWindowController().getView());
      dialog.setVisible(true);
    }
  }//GEN-LAST:event_TableMouseClicked

  private void TextFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_TextFieldActionPerformed
  {//GEN-HEADEREND:event_TextFieldActionPerformed
    ButtonSearchActionPerformed(evt);
  }//GEN-LAST:event_TextFieldActionPerformed

  private void ComboBoxTypesActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ComboBoxTypesActionPerformed
  {//GEN-HEADEREND:event_ComboBoxTypesActionPerformed
    switch (ComboBoxTypes.getSelectedIndex())
    {
      case 1:
        ComboBoxObjects.setModel(new DefaultComboBoxModel<>(Controller.getTrips()));
        ComboBoxObjects.setEnabled(true);
        TextField.setEnabled(false);
        break;
      case 2:
        ComboBoxObjects.setModel(new DefaultComboBoxModel<>(Controller.getPayments()));
        ComboBoxObjects.setEnabled(true);
        TextField.setEnabled(false);
        break;
      default:
        ComboBoxObjects.setEnabled(false);
        TextField.setEnabled(true);
        break;
    }
  }//GEN-LAST:event_ComboBoxTypesActionPerformed

  private void ButtonReturnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonReturnActionPerformed
  {//GEN-HEADEREND:event_ButtonReturnActionPerformed
    model.getWindowController().swapWindow("admin");
  }//GEN-LAST:event_ButtonReturnActionPerformed

  private void ComboBoxUserActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ComboBoxUserActionPerformed
  {//GEN-HEADEREND:event_ComboBoxUserActionPerformed
    controller.setUser(ComboBoxUser.getSelectedItem());
  }//GEN-LAST:event_ComboBoxUserActionPerformed

  @Override
  public void update(Observable o, Object arg)
  {
    Table.setModel(model.getTableModel());
  }
  
  public void initialize()
  {
    ComboBoxUser.setModel(new DefaultComboBoxModel<>(Controller.getUsers()));
    controller.setUser(ComboBoxUser.getSelectedItem());
    ComboBoxTypes.setModel(new DefaultComboBoxModel<>(Model.getSearchTypes()));
    ComboBoxObjects.setModel(new DefaultComboBoxModel<>(Controller.getTrips()));
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
  private javax.swing.JButton ButtonReturn;
  private javax.swing.JButton ButtonSearch;
  private javax.swing.JComboBox<Object> ComboBoxObjects;
  private javax.swing.JComboBox<String> ComboBoxTypes;
  private javax.swing.JComboBox<Object> ComboBoxUser;
  private javax.swing.JLabel LabelTitle;
  private javax.swing.JLabel LabelType;
  private javax.swing.JLabel LabelUser;
  private javax.swing.JTable Table;
  private javax.swing.JTextField TextField;
  private javax.swing.JScrollPane jScrollPane1;
  // End of variables declaration//GEN-END:variables
}
