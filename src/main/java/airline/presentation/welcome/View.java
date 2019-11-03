package airline.presentation.welcome;

import airline.logic.City;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import javax.swing.table.TableColumnModel;

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
    ButtonAdmin = new javax.swing.JButton();
    ButtonUser = new javax.swing.JButton();
    LabelMessage = new javax.swing.JLabel();
    TabbedPane = new javax.swing.JTabbedPane();
    PanelTrip = new javax.swing.JPanel();
    jScrollPane2 = new javax.swing.JScrollPane();
    TableTrip = new javax.swing.JTable();
    ButtonSearchTrip = new javax.swing.JButton();
    ComboBoxInward = new javax.swing.JComboBox<>();
    TextFieldTrip = new javax.swing.JTextField();
    ComboBoxPlanes = new javax.swing.JComboBox<>();
    ComboBoxOutward = new javax.swing.JComboBox<>();
    LabelOutward = new javax.swing.JLabel();
    LabelPlane = new javax.swing.JLabel();
    ComboBoxTypesTrip = new javax.swing.JComboBox<>();
    LabelInward = new javax.swing.JLabel();
    PanelFlight = new javax.swing.JPanel();
    jScrollPane1 = new javax.swing.JScrollPane();
    TableFlight = new javax.swing.JTable();
    ButtonSearchFlight = new javax.swing.JButton();
    ComboBoxDestination = new javax.swing.JComboBox<>();
    LabelDestination = new javax.swing.JLabel();
    TextFieldFlight = new javax.swing.JTextField();
    ComboBoxTypesFlight = new javax.swing.JComboBox<>();
    ComboBoxWeekdays = new javax.swing.JComboBox<>();
    ComboBoxOrigin = new javax.swing.JComboBox<>();
    LabelOrigin = new javax.swing.JLabel();

    setMaximumSize(new java.awt.Dimension(800, 500));
    setMinimumSize(new java.awt.Dimension(800, 500));
    setPreferredSize(new java.awt.Dimension(800, 500));
    setRequestFocusEnabled(false);
    setVerifyInputWhenFocusTarget(false);

    LabelTitle.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
    LabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    LabelTitle.setText("Bienvenido");

    ButtonAdmin.setText("Menú de administrador");
    ButtonAdmin.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ButtonAdminActionPerformed(evt);
      }
    });

    ButtonUser.setText("Menú de usuario");
    ButtonUser.setMaximumSize(new java.awt.Dimension(131, 21));
    ButtonUser.setMinimumSize(new java.awt.Dimension(131, 21));
    ButtonUser.setPreferredSize(new java.awt.Dimension(131, 21));
    ButtonUser.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ButtonUserActionPerformed(evt);
      }
    });

    LabelMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    LabelMessage.setText("Si desea comprar tiquetes, proceda al menú de usuario");

    TableTrip.setAutoCreateRowSorter(true);
    TableTrip.setModel(new TableModelTrip());
    TableTrip.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
    jScrollPane2.setViewportView(TableTrip);

    ButtonSearchTrip.setText("Buscar");
    ButtonSearchTrip.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ButtonSearchTripActionPerformed(evt);
      }
    });

    ComboBoxInward.setModel(new DefaultComboBoxModel<>(Controller.getFlightsWithNone()));

    TextFieldTrip.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        TextFieldTripActionPerformed(evt);
      }
    });

    ComboBoxPlanes.setModel(new DefaultComboBoxModel<>(Controller.getPlanes()));

    ComboBoxOutward.setModel(new DefaultComboBoxModel<>(Controller.getFlights()));

    LabelOutward.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    LabelOutward.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    LabelOutward.setText("Vuelo de ida");
    LabelOutward.setToolTipText("");
    LabelOutward.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

    LabelPlane.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    LabelPlane.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    LabelPlane.setText("Avión");
    LabelPlane.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

    ComboBoxTypesTrip.setModel(new DefaultComboBoxModel<>(Model.getSearchTypesTrip()));

    LabelInward.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    LabelInward.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    LabelInward.setText("Vuelo de vuelta");
    LabelInward.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

    javax.swing.GroupLayout PanelTripLayout = new javax.swing.GroupLayout(PanelTrip);
    PanelTrip.setLayout(PanelTripLayout);
    PanelTripLayout.setHorizontalGroup(
      PanelTripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(PanelTripLayout.createSequentialGroup()
        .addGroup(PanelTripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(PanelTripLayout.createSequentialGroup()
            .addGap(35, 35, 35)
            .addGroup(PanelTripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(ComboBoxOutward, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(LabelOutward, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(PanelTripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(PanelTripLayout.createSequentialGroup()
                .addComponent(LabelPlane, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ComboBoxTypesTrip, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(PanelTripLayout.createSequentialGroup()
                .addComponent(ComboBoxPlanes, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TextFieldTrip, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(18, 18, 18)
            .addGroup(PanelTripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(LabelInward, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGroup(PanelTripLayout.createSequentialGroup()
                .addComponent(ComboBoxInward, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ButtonSearchTrip))))
          .addGroup(PanelTripLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane2)))
        .addContainerGap())
    );
    PanelTripLayout.setVerticalGroup(
      PanelTripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTripLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(PanelTripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(LabelPlane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(LabelInward, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(PanelTripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(ComboBoxTypesTrip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(LabelOutward, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(PanelTripLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(ComboBoxOutward, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(ComboBoxPlanes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(TextFieldTrip, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(ComboBoxInward, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(ButtonSearchTrip))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
        .addContainerGap())
    );

    TabbedPane.addTab("Listado de viajes", PanelTrip);

    TableFlight.setAutoCreateRowSorter(true);
    TableFlight.setModel(new TableModelFlight());
    TableFlight.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
    jScrollPane1.setViewportView(TableFlight);

    ButtonSearchFlight.setText("Buscar");
    ButtonSearchFlight.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ButtonSearchFlightActionPerformed(evt);
      }
    });

    ComboBoxDestination.setModel(new DefaultComboBoxModel<>(Controller.getCities()));

    LabelDestination.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    LabelDestination.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    LabelDestination.setText("País de destino");
    LabelDestination.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

    TextFieldFlight.setEnabled(false);
    TextFieldFlight.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        TextFieldFlightActionPerformed(evt);
      }
    });

    ComboBoxTypesFlight.setModel(new DefaultComboBoxModel<>(Model.getSearchTypesFlight()));
    ComboBoxTypesFlight.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ComboBoxTypesFlightActionPerformed(evt);
      }
    });

    ComboBoxWeekdays.setModel(new DefaultComboBoxModel<>(Model.getWeekdays()));
    ComboBoxWeekdays.setEnabled(false);

    ComboBoxOrigin.setModel(new DefaultComboBoxModel<>(Controller.getCities()));

    LabelOrigin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    LabelOrigin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    LabelOrigin.setText("País de origen");
    LabelOrigin.setToolTipText("");
    LabelOrigin.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

    javax.swing.GroupLayout PanelFlightLayout = new javax.swing.GroupLayout(PanelFlight);
    PanelFlight.setLayout(PanelFlightLayout);
    PanelFlightLayout.setHorizontalGroup(
      PanelFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(PanelFlightLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(PanelFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane1)
          .addGroup(PanelFlightLayout.createSequentialGroup()
            .addGroup(PanelFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(ComboBoxOrigin, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(LabelOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(PanelFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(ComboBoxTypesFlight, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGroup(PanelFlightLayout.createSequentialGroup()
                .addComponent(ComboBoxWeekdays, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TextFieldFlight, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(PanelFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(ComboBoxDestination, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(LabelDestination, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(ButtonSearchFlight)
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
    );
    PanelFlightLayout.setVerticalGroup(
      PanelFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(PanelFlightLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(PanelFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(LabelDestination)
          .addComponent(ComboBoxTypesFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(LabelOrigin))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(PanelFlightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(ComboBoxDestination, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(ComboBoxOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(ComboBoxWeekdays, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(TextFieldFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(ButtonSearchFlight, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(10, 10, 10)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
        .addContainerGap())
    );

    TabbedPane.addTab("Vuelos en descuento", PanelFlight);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(TabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 780, Short.MAX_VALUE)
          .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
            .addComponent(ButtonUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(LabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(ButtonAdmin))
          .addComponent(LabelMessage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(LabelTitle)
          .addComponent(ButtonAdmin)
          .addComponent(ButtonUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(TabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(LabelMessage)
        .addContainerGap())
    );
  }// </editor-fold>//GEN-END:initComponents

  private void ButtonSearchFlightActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonSearchFlightActionPerformed
  {//GEN-HEADEREND:event_ButtonSearchFlightActionPerformed
    if (ComboBoxTypesFlight.getSelectedIndex() == 2)
    {
      controller.searchFlight((String)ComboBoxWeekdays.getSelectedItem(), (City)ComboBoxOrigin.getSelectedItem()
        , (City)ComboBoxDestination.getSelectedItem(), ComboBoxTypesFlight.getSelectedIndex());
    }
    else
    {
      controller.searchFlight(TextFieldFlight.getText(), (City)ComboBoxOrigin.getSelectedItem()
        , (City)ComboBoxDestination.getSelectedItem(), ComboBoxTypesFlight.getSelectedIndex());
    }
  }//GEN-LAST:event_ButtonSearchFlightActionPerformed

  private void TextFieldFlightActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_TextFieldFlightActionPerformed
  {//GEN-HEADEREND:event_TextFieldFlightActionPerformed
    ButtonSearchFlightActionPerformed(evt);
  }//GEN-LAST:event_TextFieldFlightActionPerformed

  private void ComboBoxTypesFlightActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ComboBoxTypesFlightActionPerformed
  {//GEN-HEADEREND:event_ComboBoxTypesFlightActionPerformed
    switch (ComboBoxTypesFlight.getSelectedIndex())
    {
      case 0:
      TextFieldFlight.setEnabled(false);
      ComboBoxWeekdays.setEnabled(false);
      break;
      case 2:
      TextFieldFlight.setEnabled(false);
      ComboBoxWeekdays.setEnabled(true);
      break;
      default:
      TextFieldFlight.setEnabled(true);
      ComboBoxWeekdays.setEnabled(false);
      break;
    }
  }//GEN-LAST:event_ComboBoxTypesFlightActionPerformed

  private void ButtonSearchTripActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonSearchTripActionPerformed
  {//GEN-HEADEREND:event_ButtonSearchTripActionPerformed
    controller.searchTrip(TextFieldTrip.getText(), ComboBoxPlanes.getSelectedItem(), ComboBoxOutward.getSelectedItem()
      , ComboBoxInward.getSelectedItem(), ComboBoxTypesTrip.getSelectedIndex());
  }//GEN-LAST:event_ButtonSearchTripActionPerformed

  private void TextFieldTripActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_TextFieldTripActionPerformed
  {//GEN-HEADEREND:event_TextFieldTripActionPerformed
    ButtonSearchTripActionPerformed(evt);
  }//GEN-LAST:event_TextFieldTripActionPerformed

  private void ButtonAdminActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonAdminActionPerformed
  {//GEN-HEADEREND:event_ButtonAdminActionPerformed
    if (airline.presentation.admin.Model.getLoggedUser() != null)
    {
      controller.changeWindow("admin");
    }
    else
    {
      JDialog dialog = new JDialog(this.model.getWindowController().getView(), "Iniciar sesión", true);
      dialog.setResizable(false);

      airline.presentation.login.Model loginModel = 
              new airline.presentation.login.Model(true, dialog, controller, model.getWindowController());
      airline.presentation.login.View loginView = 
              new airline.presentation.login.View();
      airline.presentation.login.Controller loginController =
              new airline.presentation.login.Controller(loginModel, loginView);

      dialog.getContentPane().add(loginView);
      dialog.pack();
      dialog.setLocationRelativeTo(this.model.getWindowController().getView());
      dialog.setVisible(true);
    }
  }//GEN-LAST:event_ButtonAdminActionPerformed

  private void ButtonUserActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonUserActionPerformed
  {//GEN-HEADEREND:event_ButtonUserActionPerformed
    if (airline.presentation.user.Model.getLoggedUser() != null)
    {
      controller.changeWindow("user");
    }
    else
    {
      JDialog dialog = new JDialog(this.model.getWindowController().getView(), "Iniciar sesión", true);
      dialog.setResizable(false);

      airline.presentation.login.Model loginModel = 
              new airline.presentation.login.Model(false, dialog, controller, model.getWindowController());
      airline.presentation.login.View loginView = 
              new airline.presentation.login.View();
      airline.presentation.login.Controller loginController =
              new airline.presentation.login.Controller(loginModel, loginView);

      dialog.getContentPane().add(loginView);
      dialog.pack();
      dialog.setLocationRelativeTo(this.model.getWindowController().getView());
      dialog.setVisible(true);
    }
  }//GEN-LAST:event_ButtonUserActionPerformed

  @Override
  public void update(Observable o, Object arg)
  {
    TableFlight.setModel(model.getTableModelFlight());
    TableTrip.setModel(model.getTableModelTrip());
    setColumnWidths(TableFlight, 70, 140, 140, 60, 60, 60, 60, 60);
    setColumnWidths(TableTrip, 70, 150, 150, 70, 150, 70);
  }
  
  public void initialize()
  {
    ComboBoxOutward.setModel(new DefaultComboBoxModel<>(Controller.getFlights()));
    ComboBoxPlanes.setModel(new DefaultComboBoxModel<>(Controller.getPlanes()));
    ComboBoxInward.setModel(new DefaultComboBoxModel<>(Controller.getFlightsWithNone()));
    ComboBoxOrigin.setModel(new DefaultComboBoxModel<>(Controller.getCities()));
    ComboBoxWeekdays.setModel(new DefaultComboBoxModel<>(Model.getWeekdays()));
    ComboBoxDestination.setModel(new DefaultComboBoxModel<>(Controller.getCities()));
  }
  
  public static void setColumnWidths(JTable table, int... widths) 
  {
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    TableColumnModel columnModel = table.getColumnModel();
    for (int i = 0; i < widths.length; i++) 
    {
      if (i < columnModel.getColumnCount())
      {
        columnModel.getColumn(i).setMinWidth(widths[i]);
        columnModel.getColumn(i).setPreferredWidth(widths[i]);
        columnModel.getColumn(i).setMaxWidth(widths[i]);
      }
      else 
        break;
    }
    table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
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
  private javax.swing.JButton ButtonAdmin;
  private javax.swing.JButton ButtonSearchFlight;
  private javax.swing.JButton ButtonSearchTrip;
  private javax.swing.JButton ButtonUser;
  private javax.swing.JComboBox<Object> ComboBoxDestination;
  private javax.swing.JComboBox<Object> ComboBoxInward;
  private javax.swing.JComboBox<Object> ComboBoxOrigin;
  private javax.swing.JComboBox<Object> ComboBoxOutward;
  private javax.swing.JComboBox<Object> ComboBoxPlanes;
  private javax.swing.JComboBox<String> ComboBoxTypesFlight;
  private javax.swing.JComboBox<String> ComboBoxTypesTrip;
  private javax.swing.JComboBox<String> ComboBoxWeekdays;
  private javax.swing.JLabel LabelDestination;
  private javax.swing.JLabel LabelInward;
  private javax.swing.JLabel LabelMessage;
  private javax.swing.JLabel LabelOrigin;
  private javax.swing.JLabel LabelOutward;
  private javax.swing.JLabel LabelPlane;
  private javax.swing.JLabel LabelTitle;
  private javax.swing.JPanel PanelFlight;
  private javax.swing.JPanel PanelTrip;
  private javax.swing.JTabbedPane TabbedPane;
  private javax.swing.JTable TableFlight;
  private javax.swing.JTable TableTrip;
  private javax.swing.JTextField TextFieldFlight;
  private javax.swing.JTextField TextFieldTrip;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  // End of variables declaration//GEN-END:variables
}
