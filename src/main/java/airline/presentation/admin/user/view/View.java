package airline.presentation.admin.user.view;

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
    ButtonOk = new javax.swing.JButton();
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

    ButtonOk.setText("Aceptar");
    ButtonOk.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ButtonOkActionPerformed(evt);
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
    AreaAddress.setFont(new java.awt.Font("Monospaced", 0, 10)); // NOI18N
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
          .addGroup(layout.createSequentialGroup()
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ButtonOk)
            .addGap(0, 0, Short.MAX_VALUE)))
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
        .addComponent(ButtonOk)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void ButtonOkActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonOkActionPerformed
  {//GEN-HEADEREND:event_ButtonOkActionPerformed
    model.getParent().dispose();
    model.getParent().setVisible(false);
  }//GEN-LAST:event_ButtonOkActionPerformed

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
    
    LabelTitle.setText("Ver información del usuario");
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
  private javax.swing.JButton ButtonOk;
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
