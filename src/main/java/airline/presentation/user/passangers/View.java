package airline.presentation.user.passangers;

import airline.logic.Payment;
import java.util.*;
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
    ButtonCancel = new javax.swing.JButton();
    LabelTrip = new javax.swing.JLabel();
    FieldTrip = new javax.swing.JTextField();
    LabelPayment = new javax.swing.JLabel();
    ComboBoxPayment = new javax.swing.JComboBox<>();
    SpinnerSeats = new javax.swing.JSpinner();
    LabelSeats = new javax.swing.JLabel();
    LabelPrice = new javax.swing.JLabel();
    FieldPrice = new javax.swing.JTextField();
    LabelNames = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    Table = new javax.swing.JTable();
    ButtonContinue = new javax.swing.JButton();

    setMaximumSize(new java.awt.Dimension(389, 283));
    setMinimumSize(new java.awt.Dimension(389, 283));
    setName("planetype_add"); // NOI18N

    LabelTitle.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
    LabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    LabelTitle.setText("Ingrese los datos para la reservación");
    LabelTitle.setToolTipText("");

    ButtonCancel.setText("Cancelar");
    ButtonCancel.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ButtonCancelActionPerformed(evt);
      }
    });

    LabelTrip.setText("Viaje seleccionado:");

    FieldTrip.setEditable(false);

    LabelPayment.setText("Tipo de pago:");

    ComboBoxPayment.setModel(new DefaultComboBoxModel<>(Controller.getPayment()));

    SpinnerSeats.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
    SpinnerSeats.addChangeListener(new javax.swing.event.ChangeListener()
    {
      public void stateChanged(javax.swing.event.ChangeEvent evt)
      {
        SpinnerSeatsStateChanged(evt);
      }
    });

    LabelSeats.setText("Cantidad de asientos:");

    LabelPrice.setText("Precio a pagar:");

    FieldPrice.setEditable(false);
    FieldPrice.setBackground(new java.awt.Color(255, 255, 255));

    LabelNames.setText("Ingrese los nombres:");

    Table.setModel(new TableModel(1));
    jScrollPane1.setViewportView(Table);

    ButtonContinue.setText("Continuar");
    ButtonContinue.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ButtonContinueActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(LabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
              .addComponent(LabelPrice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(LabelSeats, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
              .addComponent(LabelTrip, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(LabelPayment, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(LabelNames, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(FieldPrice)
              .addComponent(SpinnerSeats)
              .addComponent(ComboBoxPayment, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(FieldTrip)
              .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(ButtonContinue)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ButtonCancel)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(LabelTitle)
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(LabelTrip, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(FieldTrip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(7, 7, 7)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(LabelPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(ComboBoxPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(SpinnerSeats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(LabelSeats, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(LabelPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(FieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addGroup(layout.createSequentialGroup()
            .addGap(1, 1, 1)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
          .addComponent(LabelNames, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(ButtonCancel)
          .addComponent(ButtonContinue))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void ButtonCancelActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonCancelActionPerformed
  {//GEN-HEADEREND:event_ButtonCancelActionPerformed
    model.getParent().dispose();
    model.getParent().setVisible(false);
  }//GEN-LAST:event_ButtonCancelActionPerformed

  private void SpinnerSeatsStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_SpinnerSeatsStateChanged
  {//GEN-HEADEREND:event_SpinnerSeatsStateChanged
    FieldPrice.setText("$" + Double.toString(
        ((model.getTrip().getOutward().getPrice() * (1 - model.getTrip().getOutward().getDiscount().doubleValue()))
      + (model.getTrip().getInward() != null ? (model.getTrip().getInward().getPrice() *  (1 - model.getTrip().getInward().getDiscount().doubleValue())) : 0))
      * ((int)SpinnerSeats.getValue())));
    ((TableModel)Table.getModel()).changeList((int)SpinnerSeats.getValue());
  }//GEN-LAST:event_SpinnerSeatsStateChanged

  private void ButtonContinueActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonContinueActionPerformed
  {//GEN-HEADEREND:event_ButtonContinueActionPerformed
    String error = "";
    
    List<String> list = ((TableModel)Table.getModel()).getList();
    for(int i = 0; i < list.size(); ++i)
    {
      if(list.get(i).isBlank())
      {
        if(!error.isBlank())
          error += "<br>";
        error += "El nombre No." + (i+1) + " está en blanco";
      }
    }
    
    if (error.isBlank())
    {
      airline.presentation.user.selectseats.Model.clean();
      airline.presentation.user.selectseats.Model.setLoggedUser(airline.presentation.user.Model.getLoggedUser());
      airline.presentation.user.selectseats.Model.setNames(list);
      airline.presentation.user.selectseats.Model.setPaymentType((Payment)ComboBoxPayment.getSelectedItem());
      airline.presentation.user.selectseats.Model.setPrice(
        ((model.getTrip().getOutward().getPrice() * (1 - model.getTrip().getOutward().getDiscount().doubleValue()))
      + (model.getTrip().getInward() != null ? (model.getTrip().getInward().getPrice() *  (1 - model.getTrip().getInward().getDiscount().doubleValue())) : 0))
      * ((int)SpinnerSeats.getValue()));
      airline.presentation.user.selectseats.Model.setSelectedTrip(model.getTrip());
      
      model.getUserController().changeWindow("seats");
      
      model.getParent().dispose();
      model.getParent().setVisible(false);
    }
    else
    {
      JLabel label = new JLabel("<html><center>"+ error +"</center></html>");
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
  }//GEN-LAST:event_ButtonContinueActionPerformed

  @Override
  public void update(Observable o, Object arg)
  {
    FieldTrip.setText(model.getTrip().toString());
    FieldPrice.setText("$" + Double.toString(
        ((model.getTrip().getOutward().getPrice() * (1 - model.getTrip().getOutward().getDiscount().doubleValue()))
      + (model.getTrip().getInward() != null ? (model.getTrip().getInward().getPrice() *  (1 - model.getTrip().getInward().getDiscount().doubleValue())) : 0))
      * ((int)SpinnerSeats.getValue())));
    ((TableModel)Table.getModel()).changeList((int)SpinnerSeats.getValue());
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
  private javax.swing.JButton ButtonCancel;
  private javax.swing.JButton ButtonContinue;
  private javax.swing.JComboBox<Object> ComboBoxPayment;
  private javax.swing.JTextField FieldPrice;
  private javax.swing.JTextField FieldTrip;
  private javax.swing.JLabel LabelNames;
  private javax.swing.JLabel LabelPayment;
  private javax.swing.JLabel LabelPrice;
  private javax.swing.JLabel LabelSeats;
  private javax.swing.JLabel LabelTitle;
  private javax.swing.JLabel LabelTrip;
  private javax.swing.JSpinner SpinnerSeats;
  private javax.swing.JTable Table;
  private javax.swing.JScrollPane jScrollPane1;
  // End of variables declaration//GEN-END:variables
}
