package airline.presentation.login;

import java.util.Observable;
import java.util.Observer;

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
    FieldPasseword = new javax.swing.JPasswordField();
    ButtonLogin = new javax.swing.JButton();
    ButtonCancel = new javax.swing.JButton();
    ButtonRegister = new javax.swing.JButton();

    LabelTitle.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    LabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    LabelTitle.setText("Porfavor, Inicia sesión");

    LabelUsername.setText("Nombre usuario:");

    LabelPassword.setText("Contraseña:");

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
              .addComponent(FieldPasseword)
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
          .addComponent(FieldPasseword)
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
    model.getParentController().changeWindow("admin");
    model.getParent().dispose();
    model.getParent().setVisible(false);
  }//GEN-LAST:event_ButtonLoginActionPerformed

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
  private javax.swing.JPasswordField FieldPasseword;
  private javax.swing.JTextField FieldUsername;
  private javax.swing.JLabel LabelPassword;
  private javax.swing.JLabel LabelTitle;
  private javax.swing.JLabel LabelUsername;
  // End of variables declaration//GEN-END:variables
}
