package airline.presentation.admin.flight.addmodify;

import airline.exceptions.PreexistingEntityException;
import airline.logic.City;
import airline.logic.Flight;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.*;
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

    jScrollPane1 = new javax.swing.JScrollPane();
    jEditorPane1 = new javax.swing.JEditorPane();
    LabelTitle = new javax.swing.JLabel();
    LabelIdentifier = new javax.swing.JLabel();
    FieldIdentifier = new javax.swing.JTextField();
    ButtonAccept = new javax.swing.JButton();
    ButtonCancel = new javax.swing.JButton();
    LabelOrigin = new javax.swing.JLabel();
    LabelDestination = new javax.swing.JLabel();
    ComboBoxOrigin = new javax.swing.JComboBox<>();
    ComboBoxDestination = new javax.swing.JComboBox<>();
    LabelWeekday = new javax.swing.JLabel();
    ComboBoxWeekday = new javax.swing.JComboBox<>();
    LabelDeparture = new javax.swing.JLabel();
    SpinnerDepartureHour = new javax.swing.JSpinner();
    SpinnerDepartureMinute = new javax.swing.JSpinner();
    SpinnerDepartureSecond = new javax.swing.JSpinner();
    SpinnerDurationSecond = new javax.swing.JSpinner();
    SpinnerDurationMinute = new javax.swing.JSpinner();
    SpinnerDurationHour = new javax.swing.JSpinner();
    LabelDuration = new javax.swing.JLabel();
    LabelPrice = new javax.swing.JLabel();
    SpinnerPrice = new javax.swing.JSpinner();
    LabelDiscount = new javax.swing.JLabel();
    SpinnerDiscount = new javax.swing.JSpinner();

    jScrollPane1.setViewportView(jEditorPane1);

    setMaximumSize(new java.awt.Dimension(389, 326));
    setMinimumSize(new java.awt.Dimension(389, 326));
    setName("planetype_add"); // NOI18N

    LabelTitle.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
    LabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    LabelTitle.setText("Añadir vuelo");
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

    LabelOrigin.setText("Ciudad de origen:");

    LabelDestination.setText("Ciudad de destino:");

    ComboBoxOrigin.setModel(new DefaultComboBoxModel<>(Controller.getCities()));

    ComboBoxDestination.setModel(new DefaultComboBoxModel<>(Controller.getCities()));

    LabelWeekday.setText("Día de la semana:");

    ComboBoxWeekday.setModel(new DefaultComboBoxModel<>(Controller.getWeekdays()));

    LabelDeparture.setText("Hora de salida:");

    SpinnerDepartureHour.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));

    SpinnerDepartureMinute.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));

    SpinnerDepartureSecond.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));

    SpinnerDurationSecond.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));

    SpinnerDurationMinute.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));

    SpinnerDurationHour.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));

    LabelDuration.setText("Duración:");

    LabelPrice.setText("Precio:");

    SpinnerPrice.setModel(new javax.swing.SpinnerNumberModel(500.0d, 0.0d, null, 10.0d));

    LabelDiscount.setText("Descuento:");

    SpinnerDiscount.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(LabelTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(ButtonAccept)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ButtonCancel))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
              .addComponent(LabelPrice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(LabelDuration, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(LabelOrigin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(LabelDestination, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
              .addComponent(LabelIdentifier, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(LabelDeparture, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(LabelWeekday, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(LabelDiscount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(FieldIdentifier)
              .addComponent(ComboBoxOrigin, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(ComboBoxDestination, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(ComboBoxWeekday, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(SpinnerPrice)
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                    .addComponent(SpinnerDurationHour, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(SpinnerDurationMinute, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(SpinnerDurationSecond, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGroup(layout.createSequentialGroup()
                    .addComponent(SpinnerDepartureHour, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(SpinnerDepartureMinute, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(SpinnerDepartureSecond, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 61, Short.MAX_VALUE))
              .addComponent(SpinnerDiscount))))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(LabelTitle)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(FieldIdentifier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(layout.createSequentialGroup()
            .addGap(3, 3, 3)
            .addComponent(LabelIdentifier, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(ComboBoxOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(layout.createSequentialGroup()
            .addGap(3, 3, 3)
            .addComponent(LabelOrigin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(LabelDestination, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(ComboBoxDestination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(ComboBoxWeekday)
          .addComponent(LabelWeekday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(LabelDeparture, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(SpinnerDepartureHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(SpinnerDepartureMinute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(SpinnerDepartureSecond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(LabelDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(SpinnerDurationHour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(SpinnerDurationMinute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(SpinnerDurationSecond, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(SpinnerPrice)
          .addComponent(LabelPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(LabelDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(SpinnerDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(ButtonAccept)
          .addComponent(ButtonCancel))
        .addContainerGap())
    );
  }// </editor-fold>//GEN-END:initComponents

  private void ButtonAcceptActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonAcceptActionPerformed
  {//GEN-HEADEREND:event_ButtonAcceptActionPerformed
    try
    {
      Flight object;
      if (model.getObject() == null)
        object = new Flight();
      else
        object = new Flight(model.getObject().getIdentifier());
      object.setOrigin((City)ComboBoxOrigin.getSelectedItem());
      object.setDestination((City)ComboBoxDestination.getSelectedItem());
      object.setWeekday(ComboBoxWeekday.getSelectedIndex() + 1);
      LocalTime departure = LocalTime.parse(((int)SpinnerDepartureHour.getValue() < 10 ? "0" : "")+Integer.toString((int)SpinnerDepartureHour.getValue())+
        ":"+((int)SpinnerDepartureMinute.getValue() < 10 ? "0" : "")+Integer.toString((int)SpinnerDepartureMinute.getValue())+
        ":"+((int)SpinnerDepartureSecond.getValue() < 10 ? "0" : "")+Integer.toString((int)SpinnerDepartureSecond.getValue()));
      object.setDeparture(Date.from(departure.atDate(LocalDate.of(2000, 10, 10)).
        atZone(ZoneId.of("UTC")).toInstant()));
      LocalTime duration = LocalTime.parse(((int)SpinnerDurationHour.getValue() < 10 ? "0" : "")+Integer.toString((int)SpinnerDurationHour.getValue())+
        ":"+((int)SpinnerDurationMinute.getValue() < 10 ? "0" : "")+Integer.toString((int)SpinnerDurationMinute.getValue())+
        ":"+((int)SpinnerDurationSecond.getValue() < 10 ? "0" : "")+Integer.toString((int)SpinnerDurationSecond.getValue()));
      object.setDuration(Date.from(duration.atDate(LocalDate.of(2000, 10, 10)).
        atZone(ZoneId.of("UTC")).toInstant()));
      object.setArrival(new Date());
      object.setPrice((Double)SpinnerPrice.getValue());
      object.setDiscount(BigDecimal.valueOf(((Integer)SpinnerDiscount.getValue()).doubleValue()).divide(BigDecimal.valueOf(100d)));

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
      FieldIdentifier.setText(model.getObject().getIdentifier().toString());
      ComboBoxOrigin.setSelectedItem(model.getObject().getOrigin());
      ComboBoxDestination.setSelectedItem(model.getObject().getDestination());
      ComboBoxWeekday.setSelectedItem(Controller.parseWeekday(model.getObject().getWeekday()));
      
      SimpleDateFormat departureF = new SimpleDateFormat("HH:mm:ss");
      departureF.setTimeZone(TimeZone.getTimeZone("UTC"));
      String departure = departureF.format(model.getObject().getDeparture());
      
      SpinnerDepartureHour.setValue(Integer.valueOf(departure.substring(0, 2)));
      SpinnerDepartureMinute.setValue(Integer.valueOf(departure.substring(3, 5)));
      SpinnerDepartureSecond.setValue(Integer.valueOf(departure.substring(6)));
      
      SimpleDateFormat durationF = new SimpleDateFormat("HH:mm:ss");
      durationF.setTimeZone(TimeZone.getTimeZone("UTC"));
      String duration = durationF.format(model.getObject().getDuration());
      
      SpinnerDurationHour.setValue(Integer.valueOf(duration.substring(0, 2)));
      SpinnerDurationMinute.setValue(Integer.valueOf(duration.substring(3, 5)));
      SpinnerDurationSecond.setValue(Integer.valueOf(duration.substring(6)));
      SpinnerPrice.setValue(model.getObject().getPrice());
      SpinnerDiscount.setValue(model.getObject().getDiscount().multiply(BigDecimal.valueOf(100d)).intValueExact());
    }
    else
    {
      FieldIdentifier.setText("Generado automáticamente");
    }
    
    LabelTitle.setText((model.getObject() == null ? "Añadir" : "Modificar") + " vuelo");
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
  private javax.swing.JComboBox<Object> ComboBoxDestination;
  private javax.swing.JComboBox<Object> ComboBoxOrigin;
  private javax.swing.JComboBox<String> ComboBoxWeekday;
  private javax.swing.JTextField FieldIdentifier;
  private javax.swing.JLabel LabelDeparture;
  private javax.swing.JLabel LabelDestination;
  private javax.swing.JLabel LabelDiscount;
  private javax.swing.JLabel LabelDuration;
  private javax.swing.JLabel LabelIdentifier;
  private javax.swing.JLabel LabelOrigin;
  private javax.swing.JLabel LabelPrice;
  private javax.swing.JLabel LabelTitle;
  private javax.swing.JLabel LabelWeekday;
  private javax.swing.JSpinner SpinnerDepartureHour;
  private javax.swing.JSpinner SpinnerDepartureMinute;
  private javax.swing.JSpinner SpinnerDepartureSecond;
  private javax.swing.JSpinner SpinnerDiscount;
  private javax.swing.JSpinner SpinnerDurationHour;
  private javax.swing.JSpinner SpinnerDurationMinute;
  private javax.swing.JSpinner SpinnerDurationSecond;
  private javax.swing.JSpinner SpinnerPrice;
  private javax.swing.JEditorPane jEditorPane1;
  private javax.swing.JScrollPane jScrollPane1;
  // End of variables declaration//GEN-END:variables
}
