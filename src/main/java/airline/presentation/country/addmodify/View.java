package airline.presentation.country.addmodify;

import airline.exceptions.PreexistingEntityException;
import airline.logic.Country;
import java.util.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
    LabelCode = new javax.swing.JLabel();
    FieldCode = new javax.swing.JTextField();
    ButtonAccept = new javax.swing.JButton();
    ButtonCancel = new javax.swing.JButton();
    LabelName = new javax.swing.JLabel();
    FieldName = new javax.swing.JTextField();

    setMaximumSize(new java.awt.Dimension(265, 143));
    setMinimumSize(new java.awt.Dimension(265, 143));

    LabelTitle.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
    LabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    LabelTitle.setText("Añadir país");
    LabelTitle.setToolTipText("");

    LabelCode.setText("Código");

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

    LabelName.setText("Nombre:");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(LabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(ButtonAccept)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
            .addComponent(ButtonCancel)
            .addContainerGap())
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(LabelCode)
              .addComponent(LabelName))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(FieldName)
              .addComponent(FieldCode))
            .addGap(10, 10, 10))))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(LabelTitle)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(LabelCode)
          .addComponent(FieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(LabelName)
          .addComponent(FieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    
    if(FieldCode.getText().isBlank())
    {
      if(!error.isBlank())
        error += "<br>";
      error += "El código está en blanco.";
    }
    else if(FieldCode.getText().length() > 2)
    {
      if(!error.isBlank())
        error += "<br>";
      error += "El código es demasiado grande.";
    }
    
    if(FieldName.getText().isBlank())
    {
      if(!error.isBlank())
        error += "<br>";
      error += "El nombre está en blanco.";
    }
    else if(FieldName.getText().length() > 45)
    {
      if(!error.isBlank())
        error += "<br>";
      error += "El nombre es demasiado grande.";
    }

    if (error.isBlank())
    {
      try
      {
        Country object = new Country(FieldCode.getText());
        object.setName(FieldName.getText());
        
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
      FieldCode.setText(model.getObject().getCode());
      FieldName.setText(model.getObject().getName());
    }
    
    LabelTitle.setText((model.getObject() == null ? "Añadir" : "Modificar") + " país");
    FieldCode.setEditable(model.getObject() == null);
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
  private javax.swing.JTextField FieldCode;
  private javax.swing.JTextField FieldName;
  private javax.swing.JLabel LabelCode;
  private javax.swing.JLabel LabelName;
  private javax.swing.JLabel LabelTitle;
  // End of variables declaration//GEN-END:variables
}
