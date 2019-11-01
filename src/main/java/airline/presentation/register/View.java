package airline.presentation.register;

import airline.exceptions.PreexistingEntityException;
import airline.logic.User;
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
    ButtonAccept = new javax.swing.JButton();
    ButtonCancel = new javax.swing.JButton();
    LabelUsername = new javax.swing.JLabel();
    FieldUsername = new javax.swing.JTextField();
    LabelPassword = new javax.swing.JLabel();
    FieldPassword = new javax.swing.JPasswordField();
    LabelName = new javax.swing.JLabel();
    FieldName = new javax.swing.JTextField();
    LabelLastname = new javax.swing.JLabel();
    FieldLastname = new javax.swing.JTextField();
    LabelEmail = new javax.swing.JLabel();
    FieldEmail = new javax.swing.JTextField();
    LabelBirthday = new javax.swing.JLabel();
    SpinnerBirthday = new javax.swing.JSpinner()
    {
      @Override
      public void setEditor(JComponent editor)
      {
        super.setEditor(editor);
        this.fireStateChanged();
      }
    };
    LabelAddress = new javax.swing.JLabel();
    ScrollPaneAddress = new javax.swing.JScrollPane();
    AreaAddress = new javax.swing.JTextArea();
    LabelWorkphone = new javax.swing.JLabel();
    FieldWorkphone = new javax.swing.JTextField();
    LabelCellphone = new javax.swing.JLabel();
    FieldCellphone = new javax.swing.JTextField();

    setMaximumSize(new java.awt.Dimension(389, 283));
    setMinimumSize(new java.awt.Dimension(389, 283));
    setName("planetype_add"); // NOI18N

    LabelTitle.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
    LabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    LabelTitle.setText("Registrarse");
    LabelTitle.setToolTipText("");

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

    LabelUsername.setText("Nombre de usuario:");

    LabelPassword.setText("Contraseña:");

    LabelName.setText("Nombre:");

    LabelLastname.setText("Apellido:");

    LabelEmail.setText("Correo electrónico:");

    LabelBirthday.setText("Fecha de nacimiento:");

    SpinnerBirthday.setModel(new javax.swing.SpinnerDateModel());
    JSpinner.DateEditor editor = new JSpinner.DateEditor(SpinnerBirthday, "yyyy-MM-dd");
    editor.getFormat().setTimeZone(TimeZone.getTimeZone("UTC"));
    SpinnerBirthday.setEditor(editor);

    LabelAddress.setText("Dirección:");

    AreaAddress.setColumns(20);
    AreaAddress.setRows(5);
    ScrollPaneAddress.setViewportView(AreaAddress);

    LabelWorkphone.setText("Teléfono de trabajo:");

    LabelCellphone.setText("Teléfono personal:");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(LabelTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(LabelAddress, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelUsername, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelBirthday, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelLastname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelWorkphone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
              .addComponent(LabelCellphone))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(FieldUsername)
              .addComponent(FieldPassword)
              .addComponent(FieldName)
              .addComponent(FieldLastname)
              .addComponent(FieldEmail, javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(SpinnerBirthday, javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(FieldWorkphone)
              .addComponent(ScrollPaneAddress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
              .addComponent(FieldCellphone)))
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
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(LabelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(FieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(LabelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(FieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(FieldName)
          .addComponent(LabelName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(FieldLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(layout.createSequentialGroup()
            .addGap(3, 3, 3)
            .addComponent(LabelLastname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(FieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(layout.createSequentialGroup()
            .addGap(3, 3, 3)
            .addComponent(LabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(LabelBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(SpinnerBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(ScrollPaneAddress)
          .addComponent(LabelAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(FieldWorkphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(LabelWorkphone, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(LabelCellphone)
          .addComponent(FieldCellphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(ButtonCancel)
          .addComponent(ButtonAccept))
        .addContainerGap(9, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void ButtonAcceptActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonAcceptActionPerformed
  {//GEN-HEADEREND:event_ButtonAcceptActionPerformed
    String error = "";
    
    if(FieldUsername.getText().isBlank())
    {
      if(!error.isBlank())
        error += "<br>";
      error += "El nombre de usuario está en blanco.";
    }
    else if(FieldUsername .getText().length() > 15)
    {
      if(!error.isBlank())
        error += "<br>";
      error += "El nombre de usuario es demasiado grande.";
    }
    
    if(String.valueOf(FieldPassword.getPassword()).isBlank())
    {
      if(!error.isBlank())
        error += "<br>";
      error += "La contraseña está en blanco.";
    }
    else if(String.valueOf(FieldPassword.getPassword()).length() > 45)
    {
      if(!error.isBlank())
        error += "<br>";
      error += "La contraseña es demasiado grande.";
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
    
    if(FieldLastname.getText().isBlank())
    {
      if(!error.isBlank())
        error += "<br>";
      error += "El apellido está en blanco.";
    }
    else if(FieldLastname.getText().length() > 45)
    {
      if(!error.isBlank())
        error += "<br>";
      error += "El apellido es demasiado grande.";
    }
    
    if(FieldEmail.getText().isBlank())
    {
      if(!error.isBlank())
        error += "<br>";
      error += "El correo electrónico está en blanco.";
    }
    else if(FieldEmail.getText().length() > 45)
    {
      if(!error.isBlank())
        error += "<br>";
      error += "El correo electrónico es demasiado grande.";
    }
    
    if(AreaAddress.getText().isBlank())
    {
      if(!error.isBlank())
        error += "<br>";
      error += "La dirección está en blanco.";
    }
    else if(AreaAddress.getText().length() > 200)
    {
      if(!error.isBlank())
        error += "<br>";
      error += "La dirección es demasiado grande.";
    }
    
    if(FieldWorkphone.getText().isBlank())
    {
      if(!error.isBlank())
        error += "<br>";
      error += "El teléfono del trabajo está en blanco.";
    }
    else if(FieldWorkphone.getText().length() > 45)
    {
      if(!error.isBlank())
        error += "<br>";
      error += "El teléfono del trabajo es demasiado grande.";
    }
    
    if(FieldCellphone.getText().isBlank())
    {
      if(!error.isBlank())
        error += "<br>";
      error += "El teléfono celular está en blanco.";
    }
    else if(FieldCellphone.getText().length() > 45)
    {
      if(!error.isBlank())
        error += "<br>";
      error += "El teléfono celular es demasiado grande.";
    }
    
    if (error.isBlank())
    {
      try
      {
        User object = new User(FieldUsername.getText());
        object.setAdmin(false);
        object.setPassword(String.valueOf(FieldPassword.getPassword()));
        object.setName(FieldName.getText());
        object.setLastname(FieldLastname.getText());
        object.setEmail(FieldEmail.getText());
        object.setBirthday((Date) SpinnerBirthday.getValue());
        object.setAddress(AreaAddress.getText());
        object.setWorkphone(FieldWorkphone.getText());
        object.setCellphone(FieldCellphone.getText());
        
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
        JLabel label = new JLabel("<html><center>El identificador ya existe</center></html>");
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
      FieldUsername.setText(model.getObject().getUsername());
      FieldPassword.setText(model.getObject().getPassword());
      FieldName.setText(model.getObject().getName());
      FieldLastname.setText(model.getObject().getLastname());
      FieldEmail.setText(model.getObject().getEmail());
      SpinnerBirthday.setValue(model.getObject().getBirthday());
      AreaAddress.setText(model.getObject().getAddress());
      FieldWorkphone.setText(model.getObject().getWorkphone());
      FieldCellphone.setText(model.getObject().getCellphone());
    }
    
    LabelTitle.setText((model.getObject() == null ? "Registrarse" : "Modificar información del usuario"));
    FieldUsername.setEditable(model.getObject() == null);
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
  private javax.swing.JTextArea AreaAddress;
  private javax.swing.JButton ButtonAccept;
  private javax.swing.JButton ButtonCancel;
  private javax.swing.JTextField FieldCellphone;
  private javax.swing.JTextField FieldEmail;
  private javax.swing.JTextField FieldLastname;
  private javax.swing.JTextField FieldName;
  private javax.swing.JPasswordField FieldPassword;
  private javax.swing.JTextField FieldUsername;
  private javax.swing.JTextField FieldWorkphone;
  private javax.swing.JLabel LabelAddress;
  private javax.swing.JLabel LabelBirthday;
  private javax.swing.JLabel LabelCellphone;
  private javax.swing.JLabel LabelEmail;
  private javax.swing.JLabel LabelLastname;
  private javax.swing.JLabel LabelName;
  private javax.swing.JLabel LabelPassword;
  private javax.swing.JLabel LabelTitle;
  private javax.swing.JLabel LabelUsername;
  private javax.swing.JLabel LabelWorkphone;
  private javax.swing.JScrollPane ScrollPaneAddress;
  private javax.swing.JSpinner SpinnerBirthday;
  // End of variables declaration//GEN-END:variables
}
