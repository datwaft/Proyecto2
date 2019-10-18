package airline.presentation.planetype.addmodify;

import airline.exceptions.PreexistingEntityException;
import airline.logic.Planetype;
import java.io.IOException;
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
    LabelIdentifier = new javax.swing.JLabel();
    LabelYear = new javax.swing.JLabel();
    LabelModel = new javax.swing.JLabel();
    LabelBrand = new javax.swing.JLabel();
    LabelRowCount = new javax.swing.JLabel();
    LabelSeatsRow = new javax.swing.JLabel();
    FieldBrand = new javax.swing.JTextField();
    FieldModel = new javax.swing.JTextField();
    FieldIdentifier = new javax.swing.JTextField();
    ButtonAccept = new javax.swing.JButton();
    ButtonCancel = new javax.swing.JButton();
    SliderRowCount = new javax.swing.JSlider();
    SliderSeatsRow = new javax.swing.JSlider();
    SpinnerYear = new javax.swing.JSpinner();

    setMaximumSize(new java.awt.Dimension(389, 283));
    setMinimumSize(new java.awt.Dimension(389, 283));
    setName("planetype_add"); // NOI18N

    LabelTitle.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
    LabelTitle.setText("Añadir tipo de avión");
    LabelTitle.setToolTipText("");

    LabelIdentifier.setText("Identificador:");

    LabelYear.setText("Año:");

    LabelModel.setText("Modelo:");

    LabelBrand.setText("Marca:");

    LabelRowCount.setText("Filas:");

    LabelSeatsRow.setText("Asientos por fila:");

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

    SliderRowCount.setMajorTickSpacing(5);
    SliderRowCount.setMaximum(30);
    SliderRowCount.setMinimum(15);
    SliderRowCount.setMinorTickSpacing(5);
    SliderRowCount.setPaintLabels(true);
    SliderRowCount.setSnapToTicks(true);
    SliderRowCount.setValue(15);

    SliderSeatsRow.setMajorTickSpacing(3);
    SliderSeatsRow.setMaximum(9);
    SliderSeatsRow.setMinimum(6);
    SliderSeatsRow.setMinorTickSpacing(3);
    SliderSeatsRow.setPaintLabels(true);
    SliderSeatsRow.setSnapToTicks(true);
    SliderSeatsRow.setToolTipText("");
    SliderSeatsRow.setValue(6);

    SpinnerYear.setModel(new javax.swing.SpinnerNumberModel(2000, 1970, 2019, 1));
    SpinnerYear.setValue(2000);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(LabelYear)
              .addComponent(LabelIdentifier)
              .addComponent(LabelSeatsRow)
              .addComponent(LabelRowCount)
              .addComponent(LabelBrand)
              .addComponent(LabelModel))
            .addGap(38, 38, 38)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(FieldIdentifier, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
              .addComponent(FieldModel)
              .addComponent(FieldBrand)
              .addComponent(SliderSeatsRow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(SliderRowCount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(SpinnerYear))
            .addContainerGap())
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(LabelTitle)
            .addGap(132, 132, 132))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(ButtonAccept)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ButtonCancel)
            .addContainerGap())))
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
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(LabelYear)
          .addComponent(SpinnerYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(LabelModel)
          .addComponent(FieldModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(LabelBrand)
          .addComponent(FieldBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(SliderRowCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(LabelRowCount, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(SliderSeatsRow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(LabelSeatsRow, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
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
      error += "El identificador está en blanco.";
    }
    else if(FieldIdentifier.getText().length() > 12)
    {
      if(!error.isBlank())
        error += "<br>";
      error += "El identificador es demasiado grande.";
    }
    
    if(FieldModel.getText().isBlank())
    {
      if(!error.isBlank())
        error += "<br>";
      error += "El modelo está en blanco.";
    }
    else if(FieldModel.getText().length() > 45)
    {
      if(!error.isBlank())
        error += "<br>";
      error += "El modelo es demasiado grande.";
    }
    
    if(FieldBrand.getText().isBlank())
    {
      if(!error.isBlank())
        error += "<br>";
      error += "La marca está en blanco.";
    }
    else if(FieldBrand.getText().length() > 45)
    {
      if(!error.isBlank())
        error += "<br>";
      error += "La marca es demasiado grande.";
    }
    
    if (error.isBlank())
    {
      try
      {
        Planetype object = new Planetype(FieldIdentifier.getText());
        object.setYear((int) SpinnerYear.getValue());
        object.setModel(FieldModel.getText());
        object.setBrand(FieldBrand.getText());
        object.setRowCount(SliderRowCount.getValue());
        object.setSeatsRow(SliderSeatsRow.getValue());
        
        if (model.getPlanetype() == null)
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
        JLabel label = new JLabel("<html><center> El identificador ya existe</center></html>");
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
    if(model.getPlanetype() != null)
    {
      FieldIdentifier.setText(model.getPlanetype().getIdentifier());
      SpinnerYear.setValue(model.getPlanetype().getYear());
      FieldModel.setText(model.getPlanetype().getModel());
      FieldBrand.setText(model.getPlanetype().getBrand());
      SliderRowCount.setValue(model.getPlanetype().getRowCount());
      SliderSeatsRow.setValue(model.getPlanetype().getSeatsRow());
    }
    
    LabelTitle.setText((model.getPlanetype() == null ? "Añadir" : "Modificar") + " tipo de avión");
    FieldIdentifier.setEditable(model.getPlanetype() == null);
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
  private javax.swing.JTextField FieldBrand;
  private javax.swing.JTextField FieldIdentifier;
  private javax.swing.JTextField FieldModel;
  private javax.swing.JLabel LabelBrand;
  private javax.swing.JLabel LabelIdentifier;
  private javax.swing.JLabel LabelModel;
  private javax.swing.JLabel LabelRowCount;
  private javax.swing.JLabel LabelSeatsRow;
  private javax.swing.JLabel LabelTitle;
  private javax.swing.JLabel LabelYear;
  private javax.swing.JSlider SliderRowCount;
  private javax.swing.JSlider SliderSeatsRow;
  private javax.swing.JSpinner SpinnerYear;
  // End of variables declaration//GEN-END:variables
}
