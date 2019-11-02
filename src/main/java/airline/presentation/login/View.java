package airline.presentation.login;

import airline.logic.User;
import airline.logic.UserModel;
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
    LabelUsername = new javax.swing.JLabel();
    LabelPassword = new javax.swing.JLabel();
    FieldUsername = new javax.swing.JTextField();
    FieldPassword = new javax.swing.JPasswordField();
    ButtonLogin = new javax.swing.JButton();
    ButtonCancel = new javax.swing.JButton();
    ButtonRegister = new javax.swing.JButton();

    LabelTitle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    LabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    LabelTitle.setText("Porfavor, Inicia sesión");

    LabelUsername.setText("Nombre usuario:");

    LabelPassword.setText("Contraseña:");

    FieldUsername.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        FieldUsernameActionPerformed(evt);
      }
    });

    FieldPassword.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        FieldPasswordActionPerformed(evt);
      }
    });

    ButtonLogin.setText("Iniciar sesión");
    ButtonLogin.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ButtonLoginActionPerformed(evt);
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

    ButtonRegister.setText("Registrarse");
    ButtonRegister.setEnabled(false);
    ButtonRegister.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ButtonRegisterActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(LabelTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addComponent(ButtonLogin)
            .addGap(18, 18, 18)
            .addComponent(ButtonRegister)
            .addGap(18, 18, 18)
            .addComponent(ButtonCancel))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(LabelUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(LabelPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(FieldPassword)
              .addComponent(FieldUsername))))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(LabelTitle)
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(FieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(layout.createSequentialGroup()
            .addGap(3, 3, 3)
            .addComponent(LabelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(FieldPassword)
          .addComponent(LabelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(ButtonLogin)
          .addComponent(ButtonCancel)
          .addComponent(ButtonRegister))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void ButtonCancelActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonCancelActionPerformed
  {//GEN-HEADEREND:event_ButtonCancelActionPerformed
    model.getParent().dispose();
    model.getParent().setVisible(false);
  }//GEN-LAST:event_ButtonCancelActionPerformed

  private void ButtonLoginActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonLoginActionPerformed
  {//GEN-HEADEREND:event_ButtonLoginActionPerformed
    List<User> users;
    if(model.isAdminMode())
      users = controller.findAdminUsers();
    else
      users = controller.findNormalUsers();
    
    User user = new User();
    user.setUsername(FieldUsername.getText());
    user.setPassword(String.valueOf(FieldPassword.getPassword()));
    
    if(users.contains(user) && controller.findUser(user.getUsername()).getPassword().equals(user.getPassword()))
    {
      if(model.isAdminMode())
      {
        airline.presentation.admin.Model.setLoggedUser(UserModel.getInstance().findUser(user.getUsername()));
        model.getParentController().changeWindow("admin");
      }
      else
      {
        airline.presentation.user.Model.setLoggedUser(UserModel.getInstance().findUser(user.getUsername()));
        model.getParentController().changeWindow("user");
      }
      model.getParent().dispose();
      model.getParent().setVisible(false); 
    }
    else
    {
      JLabel label = new JLabel("<html><center>Los datos de inicio se sesión son incorrectos.</center></html>");
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
  }//GEN-LAST:event_ButtonLoginActionPerformed

  private void ButtonRegisterActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonRegisterActionPerformed
  {//GEN-HEADEREND:event_ButtonRegisterActionPerformed
    JDialog dialog = new JDialog(this.model.getWindowController().getView(), "Registrarse", true);
    dialog.setResizable(false);
    
    airline.presentation.register.Model registerModel = 
            new airline.presentation.register.Model(null, dialog);
    airline.presentation.register.View registerView = 
            new airline.presentation.register.View();
    airline.presentation.register.Controller registerController =
            new airline.presentation.register.Controller(registerModel, registerView);
    
    dialog.getContentPane().add(registerView);
    dialog.pack();
    dialog.setLocationRelativeTo(this.model.getWindowController().getView());
    dialog.setVisible(true);
  }//GEN-LAST:event_ButtonRegisterActionPerformed

  private void FieldPasswordActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_FieldPasswordActionPerformed
  {//GEN-HEADEREND:event_FieldPasswordActionPerformed
    ButtonLoginActionPerformed(evt);
  }//GEN-LAST:event_FieldPasswordActionPerformed

  private void FieldUsernameActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_FieldUsernameActionPerformed
  {//GEN-HEADEREND:event_FieldUsernameActionPerformed
    ButtonLoginActionPerformed(evt);
  }//GEN-LAST:event_FieldUsernameActionPerformed

  @Override
  public void update(Observable o, Object arg)
  {
    ButtonRegister.setEnabled(!model.isAdminMode());
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
  private javax.swing.JButton ButtonLogin;
  private javax.swing.JButton ButtonRegister;
  private javax.swing.JPasswordField FieldPassword;
  private javax.swing.JTextField FieldUsername;
  private javax.swing.JLabel LabelPassword;
  private javax.swing.JLabel LabelTitle;
  private javax.swing.JLabel LabelUsername;
  // End of variables declaration//GEN-END:variables
}
