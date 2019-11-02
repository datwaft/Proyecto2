package airline.presentation.user.selectseats;

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
    ButtonCancel = new javax.swing.JButton();

    setMaximumSize(new java.awt.Dimension(800, 500));
    setMinimumSize(new java.awt.Dimension(800, 500));
    setPreferredSize(new java.awt.Dimension(800, 500));
    setRequestFocusEnabled(false);
    setVerifyInputWhenFocusTarget(false);

    LabelTitle.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
    LabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    LabelTitle.setText("Seleccione los asientos");

    ButtonCancel.setText("Cancelar");
    ButtonCancel.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ButtonCancelActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(ButtonCancel))
          .addGroup(layout.createSequentialGroup()
            .addGap(278, 278, 278)
            .addComponent(LabelTitle)
            .addGap(0, 268, Short.MAX_VALUE)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(LabelTitle)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 429, Short.MAX_VALUE)
        .addComponent(ButtonCancel)
        .addContainerGap())
    );
  }// </editor-fold>//GEN-END:initComponents

  private void ButtonCancelActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonCancelActionPerformed
  {//GEN-HEADEREND:event_ButtonCancelActionPerformed
    Model.clean();
    model.getUserController().changeWindow("trips");
  }//GEN-LAST:event_ButtonCancelActionPerformed

  @Override
  public void update(Observable o, Object arg)
  {
    
  }
  
  public void initialize()
  {
    
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
  private javax.swing.JLabel LabelTitle;
  // End of variables declaration//GEN-END:variables
}
