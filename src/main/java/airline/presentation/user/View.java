package airline.presentation.user;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JDialog;

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
    ButtonReturn = new javax.swing.JButton();
    LabelUser = new javax.swing.JLabel();
    ButtonLogout = new javax.swing.JButton();
    ButtonPurchases = new javax.swing.JButton();
    ButtonChangeInformation = new javax.swing.JButton();
    ButtonReservation = new javax.swing.JButton();

    setMaximumSize(new java.awt.Dimension(800, 500));
    setMinimumSize(new java.awt.Dimension(800, 500));
    setPreferredSize(new java.awt.Dimension(800, 500));
    setRequestFocusEnabled(false);
    setVerifyInputWhenFocusTarget(false);

    LabelTitle.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
    LabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    LabelTitle.setText("Menú de usuario");

    ButtonReturn.setText("Regresar");
    ButtonReturn.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ButtonReturnActionPerformed(evt);
      }
    });

    LabelUser.setText("Inició sesión como: ---------------------------");

    ButtonLogout.setText("Cerrar sesión");
    ButtonLogout.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ButtonLogoutActionPerformed(evt);
      }
    });

    ButtonPurchases.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    ButtonPurchases.setText("Ver historial de compras");

    ButtonChangeInformation.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    ButtonChangeInformation.setText("Cambiar información del usuario");
    ButtonChangeInformation.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ButtonChangeInformationActionPerformed(evt);
      }
    });

    ButtonReservation.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
    ButtonReservation.setText("Hacer una reservación");
    ButtonReservation.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ButtonReservationActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addComponent(ButtonReturn)
                .addGap(226, 226, 226)
                .addComponent(LabelTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 101, Short.MAX_VALUE)
                .addComponent(LabelUser))
              .addGroup(layout.createSequentialGroup()
                .addGap(291, 291, 291)
                .addComponent(ButtonReservation)
                .addGap(0, 0, Short.MAX_VALUE))))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addComponent(ButtonPurchases))
              .addGroup(layout.createSequentialGroup()
                .addGap(279, 279, 279)
                .addComponent(ButtonChangeInformation)))
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addGap(352, 352, 352)
        .addComponent(ButtonLogout)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(LabelTitle)
          .addComponent(ButtonReturn)
          .addComponent(LabelUser))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(ButtonReservation)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(ButtonPurchases)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(ButtonChangeInformation)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(ButtonLogout)
        .addContainerGap())
    );
  }// </editor-fold>//GEN-END:initComponents

  private void ButtonReturnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonReturnActionPerformed
  {//GEN-HEADEREND:event_ButtonReturnActionPerformed
    model.getWindowController().changeWindow("welcome");
  }//GEN-LAST:event_ButtonReturnActionPerformed

  private void ButtonLogoutActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonLogoutActionPerformed
  {//GEN-HEADEREND:event_ButtonLogoutActionPerformed
    Model.setLoggedUser(null);
    model.getWindowController().changeWindow("welcome");
  }//GEN-LAST:event_ButtonLogoutActionPerformed

  private void ButtonChangeInformationActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonChangeInformationActionPerformed
  {//GEN-HEADEREND:event_ButtonChangeInformationActionPerformed
    JDialog dialog = new JDialog(this.model.getWindowController().getView(), "Cambiar información del usuario", true);
    dialog.setResizable(false);
    
    airline.presentation.register.Model registerModel = 
            new airline.presentation.register.Model(Model.getLoggedUser(), dialog);
    airline.presentation.register.View registerView = 
            new airline.presentation.register.View();
    airline.presentation.register.Controller registerController =
            new airline.presentation.register.Controller(registerModel, registerView);
    
    dialog.getContentPane().add(registerView);
    dialog.pack();
    dialog.setLocationRelativeTo(this.model.getWindowController().getView());
    dialog.setVisible(true);
    Model.setLoggedUser(controller.findUser(Model.getLoggedUser().getUsername()));
  }//GEN-LAST:event_ButtonChangeInformationActionPerformed

  private void ButtonReservationActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonReservationActionPerformed
  {//GEN-HEADEREND:event_ButtonReservationActionPerformed
    controller.changeWindow("trips");
  }//GEN-LAST:event_ButtonReservationActionPerformed

  @Override
  public void update(Observable o, Object arg)
  {
    
  }
  
  public void initialize()
  {
    LabelUser.setText("Inició sesión como: " + Model.getLoggedUser().getUsername());
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
  private javax.swing.JButton ButtonChangeInformation;
  private javax.swing.JButton ButtonLogout;
  private javax.swing.JButton ButtonPurchases;
  private javax.swing.JButton ButtonReservation;
  private javax.swing.JButton ButtonReturn;
  private javax.swing.JLabel LabelTitle;
  private javax.swing.JLabel LabelUser;
  // End of variables declaration//GEN-END:variables
}
