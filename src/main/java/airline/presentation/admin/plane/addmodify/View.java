package airline.presentation.admin.plane.addmodify;

import airline.exceptions.PreexistingEntityException;
import airline.logic.Plane;
import airline.logic.Planetype;
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
    LabelIdentifier = new javax.swing.JLabel();
    FieldIdentifier = new javax.swing.JTextField();
    ButtonAccept = new javax.swing.JButton();
    ButtonCancel = new javax.swing.JButton();
    LabelPlaneType = new javax.swing.JLabel();
    ComboBoxParent = new javax.swing.JComboBox<>();

    setMaximumSize(new java.awt.Dimension(265, 143));
    setMinimumSize(new java.awt.Dimension(265, 143));

    LabelTitle.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
    LabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    LabelTitle.setText("Añadir avión");
    LabelTitle.setToolTipText("");

    LabelIdentifier.setText("Identificador:");

    ButtonAccept.setText("Aceptar");
    ButtonAccept.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ButtonAcceptActionPerformed(evt);
      }
    });

    ButtonCancel.setText("Cancelar");
    ButtonCancel.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ButtonCancelActionPerformed(evt);
      }
    });

    LabelPlaneType.setText("Tipo de avión:");

    ComboBoxParent.setModel(new DefaultComboBoxModel<>(Controller.getParents()));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(LabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(LabelPlaneType)
              .addComponent(LabelIdentifier))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(ComboBoxParent, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(FieldIdentifier, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(0, 0, Short.MAX_VALUE))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(ButtonAccept)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ButtonCancel)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(LabelTitle)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(LabelIdentifier)
          .addComponent(FieldIdentifier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(21, 21, 21)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(ComboBoxParent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(LabelPlaneType))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(ButtonCancel)
          .addComponent(ButtonAccept))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void ButtonAcceptActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonAcceptActionPerformed
  {//GEN-HEADEREND:event_ButtonAcceptActionPerformed
    String error = "";
    
    if(FieldIdentifier.getText().isBlank())
    {
      if(!error.isBlank())
        error += "<br>";
      error += "El código está en blanco.";
    }
    else if(FieldIdentifier.getText().length() > 12)
    {
      if(!error.isBlank())
        error += "<br>";
      error += "El código es demasiado grande.";
    }

    if (error.isBlank())
    {
      try
      {
        Plane object = new Plane(FieldIdentifier.getText());
        object.setType((Planetype) ComboBoxParent.getSelectedItem());
        
        if (model.getObject() == null)
        {
          controller.Add(object);
        }
        else
        {
          controller.Modify(object);
        }
        
        model.getParent().dispose();
        model.getParent().setVisible(false);
      }
      catch(PreexistingEntityException ex)
      {
        JLabel label = new JLabel("<html><center>El código ya existe</center></html>");
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
  }//GEN-LAST:event_ButtonAcceptActionPerformed

  private void ButtonCancelActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonCancelActionPerformed
  {//GEN-HEADEREND:event_ButtonCancelActionPerformed
    model.getParent().dispose();
    model.getParent().setVisible(false);
  }//GEN-LAST:event_ButtonCancelActionPerformed

  @Override
  public void update(Observable o, Object arg)
  {
    if(model.getObject() != null)
    {
      FieldIdentifier.setText(model.getObject().getIdentifier());
      ComboBoxParent.setSelectedItem(model.getObject().getType());
    }
    
    LabelTitle.setText((model.getObject() == null ? "Añadir" : "Modificar") + " avión");
    FieldIdentifier.setEditable(model.getObject() == null);
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
  private javax.swing.JButton ButtonAccept;
  private javax.swing.JButton ButtonCancel;
  private javax.swing.JComboBox<Object> ComboBoxParent;
  private javax.swing.JTextField FieldIdentifier;
  private javax.swing.JLabel LabelIdentifier;
  private javax.swing.JLabel LabelPlaneType;
  private javax.swing.JLabel LabelTitle;
  // End of variables declaration//GEN-END:variables
}
