package airline.presentation.admin;

import airline.presentation.admin.city.*;
import airline.exceptions.IllegalOrphanException;
import airline.logic.Country;
import java.util.Observable;
import java.util.Observer;
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
    LabelModifiable = new javax.swing.JLabel();
    LabelReadOnly = new javax.swing.JLabel();
    ButtonPayment = new javax.swing.JButton();
    ButtonCountry = new javax.swing.JButton();
    ButtonCity = new javax.swing.JButton();
    ButtonPlanetype = new javax.swing.JButton();
    ButtonPlane = new javax.swing.JButton();
    ButtonFlight = new javax.swing.JButton();
    ButtonTrip = new javax.swing.JButton();
    ButtonUser = new javax.swing.JButton();
    ButtonReservation = new javax.swing.JButton();
    ButtonTicket = new javax.swing.JButton();
    ButtonReturn = new javax.swing.JButton();
    LabelReports = new javax.swing.JLabel();
    ButtonFacturedByMonth = new javax.swing.JButton();
    ButtonRevenueByYear = new javax.swing.JButton();
    ButtonClientByPlane = new javax.swing.JButton();
    ButtonTopFlights = new javax.swing.JButton();
    ButtonLogout = new javax.swing.JButton();

    setMaximumSize(new java.awt.Dimension(800, 500));
    setMinimumSize(new java.awt.Dimension(800, 500));
    setPreferredSize(new java.awt.Dimension(800, 500));
    setRequestFocusEnabled(false);
    setVerifyInputWhenFocusTarget(false);

    LabelTitle.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
    LabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    LabelTitle.setText("Menú de administración");

    LabelModifiable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    LabelModifiable.setText("Administración de elementos modificables");

    LabelReadOnly.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    LabelReadOnly.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    LabelReadOnly.setText("Administración de elementos de solo lectura");

    ButtonPayment.setText("Tipo de pago");
    ButtonPayment.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ButtonPaymentActionPerformed(evt);
      }
    });

    ButtonCountry.setText("País");
    ButtonCountry.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ButtonCountryActionPerformed(evt);
      }
    });

    ButtonCity.setText("Ciudad");
    ButtonCity.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ButtonCityActionPerformed(evt);
      }
    });

    ButtonPlanetype.setText("Tipo de avión");
    ButtonPlanetype.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ButtonPlanetypeActionPerformed(evt);
      }
    });

    ButtonPlane.setText("Avión");
    ButtonPlane.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ButtonPlaneActionPerformed(evt);
      }
    });

    ButtonFlight.setText("Vuelo");
    ButtonFlight.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ButtonFlightActionPerformed(evt);
      }
    });

    ButtonTrip.setText("Viaje");
    ButtonTrip.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ButtonTripActionPerformed(evt);
      }
    });

    ButtonUser.setText("Usuario");
    ButtonUser.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ButtonUserActionPerformed(evt);
      }
    });

    ButtonReservation.setText("Reservación");

    ButtonTicket.setText("Tiquetes");
    ButtonTicket.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ButtonTicketActionPerformed(evt);
      }
    });

    ButtonReturn.setText("Regresar");
    ButtonReturn.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ButtonReturnActionPerformed(evt);
      }
    });

    LabelReports.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    LabelReports.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    LabelReports.setText("Reportes");

    ButtonFacturedByMonth.setText("Gráfico de cantidad facturado por mes (los últimos 12 meses)");

    ButtonRevenueByYear.setText("Gráfico de cantidad de Ingresos por año (el año actual)");

    ButtonClientByPlane.setText("Listado de clientes por avión");
    ButtonClientByPlane.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ButtonClientByPlaneActionPerformed(evt);
      }
    });

    ButtonTopFlights.setText("Los 5 vuelos con más reservaciones");

    ButtonLogout.setText("Cerrar Sesión");
    ButtonLogout.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ButtonLogoutActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addGap(65, 65, 65)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(LabelModifiable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(ButtonCity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(ButtonFlight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(ButtonTrip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(ButtonPlane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(ButtonPlanetype, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(ButtonCountry, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(ButtonPayment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGap(65, 65, 65)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(ButtonFacturedByMonth, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
          .addComponent(ButtonUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(LabelReadOnly, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(LabelReports, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(ButtonRevenueByYear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(ButtonClientByPlane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(ButtonTopFlights, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(ButtonReservation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(ButtonTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGap(65, 65, 65))
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(ButtonReturn)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(LabelTitle)
        .addGap(271, 271, 271))
      .addGroup(layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(ButtonLogout)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(LabelTitle)
          .addComponent(ButtonReturn))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(LabelModifiable)
              .addComponent(LabelReadOnly))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(ButtonPayment)
              .addComponent(ButtonUser))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(ButtonCountry)
              .addComponent(ButtonReservation))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(ButtonCity)
              .addComponent(ButtonTicket))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(ButtonPlanetype))
          .addComponent(LabelReports))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(ButtonPlane, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(ButtonFacturedByMonth))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(ButtonFlight)
          .addComponent(ButtonRevenueByYear))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(ButtonTrip)
          .addComponent(ButtonClientByPlane))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(ButtonTopFlights)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
        .addComponent(ButtonLogout)
        .addContainerGap())
    );
  }// </editor-fold>//GEN-END:initComponents

  private void ButtonUserActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonUserActionPerformed
  {//GEN-HEADEREND:event_ButtonUserActionPerformed
    controller.changeWindow("userview");
  }//GEN-LAST:event_ButtonUserActionPerformed

  private void ButtonCityActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonCityActionPerformed
  {//GEN-HEADEREND:event_ButtonCityActionPerformed
    controller.changeWindow("city");
  }//GEN-LAST:event_ButtonCityActionPerformed

  private void ButtonPlaneActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonPlaneActionPerformed
  {//GEN-HEADEREND:event_ButtonPlaneActionPerformed
    controller.changeWindow("plane");
  }//GEN-LAST:event_ButtonPlaneActionPerformed

  private void ButtonFlightActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonFlightActionPerformed
  {//GEN-HEADEREND:event_ButtonFlightActionPerformed
    controller.changeWindow("flight");
  }//GEN-LAST:event_ButtonFlightActionPerformed

  private void ButtonTicketActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonTicketActionPerformed
  {//GEN-HEADEREND:event_ButtonTicketActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_ButtonTicketActionPerformed

  private void ButtonClientByPlaneActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonClientByPlaneActionPerformed
  {//GEN-HEADEREND:event_ButtonClientByPlaneActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_ButtonClientByPlaneActionPerformed

  private void ButtonPaymentActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonPaymentActionPerformed
  {//GEN-HEADEREND:event_ButtonPaymentActionPerformed
    controller.changeWindow("payment");
  }//GEN-LAST:event_ButtonPaymentActionPerformed

  private void ButtonCountryActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonCountryActionPerformed
  {//GEN-HEADEREND:event_ButtonCountryActionPerformed
    controller.changeWindow("country");
  }//GEN-LAST:event_ButtonCountryActionPerformed

  private void ButtonPlanetypeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonPlanetypeActionPerformed
  {//GEN-HEADEREND:event_ButtonPlanetypeActionPerformed
    controller.changeWindow("planetype");
  }//GEN-LAST:event_ButtonPlanetypeActionPerformed

  private void ButtonTripActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonTripActionPerformed
  {//GEN-HEADEREND:event_ButtonTripActionPerformed
    controller.changeWindow("trip");
  }//GEN-LAST:event_ButtonTripActionPerformed

  private void ButtonReturnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonReturnActionPerformed
  {//GEN-HEADEREND:event_ButtonReturnActionPerformed
    model.getWindowController().changeWindow("welcome");
  }//GEN-LAST:event_ButtonReturnActionPerformed

  private void ButtonLogoutActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonLogoutActionPerformed
  {//GEN-HEADEREND:event_ButtonLogoutActionPerformed
    Model.setLoggedUser(null);
    model.getWindowController().changeWindow("welcome");
  }//GEN-LAST:event_ButtonLogoutActionPerformed

  @Override
  public void update(Observable o, Object arg)
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
  private javax.swing.JButton ButtonCity;
  private javax.swing.JButton ButtonClientByPlane;
  private javax.swing.JButton ButtonCountry;
  private javax.swing.JButton ButtonFacturedByMonth;
  private javax.swing.JButton ButtonFlight;
  private javax.swing.JButton ButtonLogout;
  private javax.swing.JButton ButtonPayment;
  private javax.swing.JButton ButtonPlane;
  private javax.swing.JButton ButtonPlanetype;
  private javax.swing.JButton ButtonReservation;
  private javax.swing.JButton ButtonReturn;
  private javax.swing.JButton ButtonRevenueByYear;
  private javax.swing.JButton ButtonTicket;
  private javax.swing.JButton ButtonTopFlights;
  private javax.swing.JButton ButtonTrip;
  private javax.swing.JButton ButtonUser;
  private javax.swing.JLabel LabelModifiable;
  private javax.swing.JLabel LabelReadOnly;
  private javax.swing.JLabel LabelReports;
  private javax.swing.JLabel LabelTitle;
  // End of variables declaration//GEN-END:variables
}
