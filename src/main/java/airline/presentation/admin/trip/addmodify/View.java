package airline.presentation.admin.trip.addmodify;

import airline.exceptions.PreexistingEntityException;
import airline.logic.*;
import java.text.SimpleDateFormat;
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
    ComboBoxPlane = new javax.swing.JComboBox<>();
    LabelPlane = new javax.swing.JLabel();
    ComboBoxOutward = new javax.swing.JComboBox<>();
    LabelOutward = new javax.swing.JLabel();
    LabelDeparture = new javax.swing.JLabel();
    SpinnerDeparture = new javax.swing.JSpinner()
    {
      @Override
      public void setEditor(JComponent editor)
      {
        super.setEditor(editor);
        this.fireStateChanged();
      }
    };
    LabelInward = new javax.swing.JLabel();
    ComboBoxInward = new javax.swing.JComboBox<>();
    LabelArrival = new javax.swing.JLabel();
    SpinnerArrival = new javax.swing.JSpinner()
    {
      @Override
      public void setEditor(JComponent editor)
      {
        super.setEditor(editor);
        this.fireStateChanged();
      }
    };

    setName("planetype_add"); // NOI18N

    LabelTitle.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
    LabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    LabelTitle.setText("Añadir viaje");
    LabelTitle.setToolTipText("");

    LabelIdentifier.setText("Identificador:");

    FieldIdentifier.setEditable(false);

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

    ComboBoxPlane.setModel(new DefaultComboBoxModel<>(Controller.getPlanes()));

    LabelPlane.setText("Avión:");

    ComboBoxOutward.setModel(new DefaultComboBoxModel<>(Controller.getFlights()));
    ComboBoxOutward.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ComboBoxOutwardActionPerformed(evt);
      }
    });

    LabelOutward.setText("Viaje de ida:");

    LabelDeparture.setText("Fecha de salida:");

    SpinnerDeparture.setModel(new javax.swing.SpinnerDateModel());
    JSpinner.DateEditor departureEditor = new JSpinner.DateEditor(SpinnerDeparture, "EEEE yyyy-MM-dd");
    departureEditor.getFormat().setTimeZone(TimeZone.getTimeZone("UTC"));
    SpinnerDeparture.setEditor(departureEditor);

    LabelInward.setText("Viaje de vuelta:");

    ComboBoxInward.setModel(new DefaultComboBoxModel<>(Controller.getFlightsWithNone((Flight)ComboBoxOutward.getSelectedItem())));
    ComboBoxInward.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ComboBoxInwardActionPerformed(evt);
      }
    });

    LabelArrival.setText("Fecha de llegada:");

    SpinnerArrival.setModel(new javax.swing.SpinnerDateModel());
    SpinnerArrival.setEnabled(false);
    JSpinner.DateEditor arrivalEditor = new JSpinner.DateEditor(SpinnerArrival, "EEEE yyyy-MM-dd");
    arrivalEditor.getFormat().setTimeZone(TimeZone.getTimeZone("UTC"));
    SpinnerArrival.setEditor(arrivalEditor);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(ButtonAccept)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 229, Short.MAX_VALUE)
            .addComponent(ButtonCancel))
          .addComponent(LabelTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
              .addComponent(LabelArrival, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
              .addComponent(LabelOutward, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(LabelIdentifier, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(LabelPlane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(LabelDeparture, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(LabelInward, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(FieldIdentifier, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
              .addComponent(ComboBoxPlane, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(ComboBoxOutward, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(SpinnerDeparture)
              .addComponent(ComboBoxInward, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(SpinnerArrival, javax.swing.GroupLayout.Alignment.TRAILING))))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(LabelTitle)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(LabelIdentifier, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(FieldIdentifier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(ComboBoxPlane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(LabelPlane, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(ComboBoxOutward, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(LabelOutward, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(LabelDeparture, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(SpinnerDeparture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(LabelInward, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(ComboBoxInward, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(LabelArrival, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(SpinnerArrival, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    
    SimpleDateFormat formatter = new SimpleDateFormat("u");
    formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
    
    if(!formatter.format(SpinnerDeparture.getValue()).equals(Integer.toString(((Flight)ComboBoxOutward.getSelectedItem()).getWeekday())))
    {
      if(!error.isBlank())
        error += "<br>";
      error += "La fecha de salida tiene que ser un "+controller.parseWeekday(((Flight)ComboBoxOutward.getSelectedItem()).getWeekday())+".";
    }
    
    if(ComboBoxInward.getSelectedIndex() != 0)
    {
      if(!formatter.format(SpinnerArrival.getValue()).equals(Integer.toString(((Flight)ComboBoxInward.getSelectedItem()).getWeekday())))
      {
        if(!error.isBlank())
          error += "<br>";
        error += "La fecha de regreso tiene que ser un "+controller.parseWeekday(((Flight)ComboBoxInward.getSelectedItem()).getWeekday())+".";
      }
      if(!((Date) SpinnerArrival.getValue()).after((Date) SpinnerDeparture.getValue()))
      {
        if(!error.isBlank())
          error += "<br>";
        error += "La fecha de regreso deber ser mayor a la de salida.";
      }
    }
    
    if (error.isBlank())
    {
      try
      {
        Trip object;
        if(model.getTrip() == null)
          object = new Trip();
        else
          object = new Trip(Integer.valueOf(FieldIdentifier.getText()));
        object.setPlane((Plane)ComboBoxPlane.getSelectedItem());
        object.setOutward((Flight)ComboBoxOutward.getSelectedItem());
        object.setDeparture((Date)SpinnerDeparture.getValue());
        if(ComboBoxInward.getSelectedIndex() != 0)
        {
          object.setInward((Flight)ComboBoxInward.getSelectedItem());
          object.setArrival((Date)SpinnerArrival.getValue());
        }
        
        if (model.getTrip() == null)
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

  private void ComboBoxOutwardActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ComboBoxOutwardActionPerformed
  {//GEN-HEADEREND:event_ComboBoxOutwardActionPerformed
    ComboBoxInward.setModel(new DefaultComboBoxModel<>(Controller.getFlightsWithNone((Flight)ComboBoxOutward.getSelectedItem())));
  }//GEN-LAST:event_ComboBoxOutwardActionPerformed

  private void ComboBoxInwardActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ComboBoxInwardActionPerformed
  {//GEN-HEADEREND:event_ComboBoxInwardActionPerformed
    if(ComboBoxInward.getSelectedIndex() == 0)
      SpinnerArrival.setEnabled(false);
    else
      SpinnerArrival.setEnabled(true);
  }//GEN-LAST:event_ComboBoxInwardActionPerformed

  @Override
  public void update(Observable o, Object arg)
  {
    if(model.getTrip() != null)
    {
      FieldIdentifier.setText(model.getTrip().getIdentifier().toString());
      ComboBoxPlane.setSelectedItem(model.getTrip().getPlane());
      ComboBoxOutward.setSelectedItem(model.getTrip().getOutward());
      SpinnerDeparture.setValue(model.getTrip().getDeparture());
      ComboBoxInward.setModel(new DefaultComboBoxModel<>(Controller.getFlightsWithNone((Flight)ComboBoxOutward.getSelectedItem())));
      if(model.getTrip().getInward() != null)
        ComboBoxInward.setSelectedItem(model.getTrip().getInward());
      if(model.getTrip().getArrival() != null)
      {
        SpinnerArrival.setValue(model.getTrip().getArrival());
        SpinnerArrival.setEnabled(true);
      }
      else
      {
        SpinnerArrival.setEnabled(false);
      }
    }
    else
    {
      FieldIdentifier.setText("Generado automáticamente");
      SpinnerArrival.setEnabled(false);
    }
    
    LabelTitle.setText((model.getTrip() == null ? "Añadir" : "Modificar") + " viaje");
    FieldIdentifier.setEditable(false);
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
  private javax.swing.JComboBox<Object> ComboBoxInward;
  private javax.swing.JComboBox<Object> ComboBoxOutward;
  private javax.swing.JComboBox<Object> ComboBoxPlane;
  private javax.swing.JTextField FieldIdentifier;
  private javax.swing.JLabel LabelArrival;
  private javax.swing.JLabel LabelDeparture;
  private javax.swing.JLabel LabelIdentifier;
  private javax.swing.JLabel LabelInward;
  private javax.swing.JLabel LabelOutward;
  private javax.swing.JLabel LabelPlane;
  private javax.swing.JLabel LabelTitle;
  private javax.swing.JSpinner SpinnerArrival;
  private javax.swing.JSpinner SpinnerDeparture;
  // End of variables declaration//GEN-END:variables
}
