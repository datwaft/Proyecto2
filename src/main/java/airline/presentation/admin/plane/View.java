package airline.presentation.admin.plane;

import airline.exceptions.IllegalOrphanException;
import airline.logic.Planetype;
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
    jScrollPane1 = new javax.swing.JScrollPane();
    Table = new javax.swing.JTable();
    ButtonAdd = new javax.swing.JButton();
    ButtonSearch = new javax.swing.JButton();
    TextField = new javax.swing.JTextField();
    LabelType = new javax.swing.JLabel();
    ComboBoxTypes = new javax.swing.JComboBox<>();
    ButtonEliminar = new javax.swing.JButton();
    ComboBoxCountries = new javax.swing.JComboBox<>();

    setMaximumSize(new java.awt.Dimension(800, 500));
    setMinimumSize(new java.awt.Dimension(800, 500));

    LabelTitle.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
    LabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    LabelTitle.setText("Gestión de aviones");

    Table.setAutoCreateRowSorter(true);
    Table.setModel(new TableModel());
    Table.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseClicked(java.awt.event.MouseEvent evt)
      {
        TableMouseClicked(evt);
      }
    });
    jScrollPane1.setViewportView(Table);

    ButtonAdd.setText("Añadir");
    ButtonAdd.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ButtonAddActionPerformed(evt);
      }
    });

    ButtonSearch.setText("Buscar");
    ButtonSearch.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ButtonSearchActionPerformed(evt);
      }
    });

    TextField.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        TextFieldActionPerformed(evt);
      }
    });

    LabelType.setText("Tipo de busqueda:");

    ComboBoxTypes.setModel(new DefaultComboBoxModel<>(Model.getSearchTypes()));
    ComboBoxTypes.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ComboBoxTypesActionPerformed(evt);
      }
    });

    ButtonEliminar.setText("Eliminar");
    ButtonEliminar.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ButtonEliminarActionPerformed(evt);
      }
    });

    ComboBoxCountries.setModel(new DefaultComboBoxModel<>(Controller.getParents()));
    ComboBoxCountries.setEnabled(false);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(LabelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addComponent(ButtonAdd)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ButtonEliminar))
          .addComponent(jScrollPane1)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(LabelType)
            .addGap(18, 18, 18)
            .addComponent(ComboBoxTypes, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
            .addComponent(ComboBoxCountries, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(ButtonSearch)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(LabelTitle)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(LabelType)
          .addComponent(ComboBoxTypes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(ButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(ComboBoxCountries, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(19, 19, 19)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(ButtonAdd)
          .addComponent(ButtonEliminar))
        .addContainerGap())
    );
  }// </editor-fold>//GEN-END:initComponents

  private void ButtonSearchActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonSearchActionPerformed
  {//GEN-HEADEREND:event_ButtonSearchActionPerformed
    if (ComboBoxTypes.getSelectedIndex() == 1)
    {
      if(ComboBoxCountries.getSelectedItem().getClass() == Planetype.class)
        controller.searchByParent((Planetype) ComboBoxCountries.getSelectedItem());
      else
        controller.searchAll();
    }
    else
    {
      controller.search(TextField.getText(), ComboBoxTypes.getSelectedIndex());
    }
  }//GEN-LAST:event_ButtonSearchActionPerformed

  private void ButtonAddActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonAddActionPerformed
  {//GEN-HEADEREND:event_ButtonAddActionPerformed
    JDialog dialog = new JDialog(this.model.getWindowController().getView(), "Añadir ciudad", true);
    dialog.setResizable(false);

    airline.presentation.admin.plane.addmodify.Model addmodifyModel
      = new airline.presentation.admin.plane.addmodify.Model(null, dialog, controller);
    airline.presentation.admin.plane.addmodify.View addmodifyView
      = new airline.presentation.admin.plane.addmodify.View();
    airline.presentation.admin.plane.addmodify.Controller addmodifyController
      = new airline.presentation.admin.plane.addmodify.Controller(addmodifyModel, addmodifyView);

    dialog.getContentPane().add(addmodifyView);
    dialog.pack();
    dialog.setLocationRelativeTo(this.model.getWindowController().getView());
    dialog.setVisible(true);
  }//GEN-LAST:event_ButtonAddActionPerformed

  private void TableMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_TableMouseClicked
  {//GEN-HEADEREND:event_TableMouseClicked
    if (evt.getClickCount() == 2)
    {
      int row = this.Table.getSelectedRow();
      JDialog dialog = new JDialog(this.model.getWindowController().getView(), "Modificar ciudad", true);
      dialog.setResizable(false);

      airline.presentation.admin.plane.addmodify.Model addmodifyModel
        = new airline.presentation.admin.plane.addmodify.Model(model.getElement(Table.convertRowIndexToModel(row)), dialog, controller);
      airline.presentation.admin.plane.addmodify.View addmodifyView
        = new airline.presentation.admin.plane.addmodify.View();
      airline.presentation.admin.plane.addmodify.Controller addmodifyController
        = new airline.presentation.admin.plane.addmodify.Controller(addmodifyModel, addmodifyView);

      dialog.getContentPane().add(addmodifyView);
      dialog.pack();
      dialog.setLocationRelativeTo(this.model.getWindowController().getView());
      dialog.setVisible(true);
    }
  }//GEN-LAST:event_TableMouseClicked

  private void ButtonEliminarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonEliminarActionPerformed
  {//GEN-HEADEREND:event_ButtonEliminarActionPerformed
    int[] selectedRows = this.Table.getSelectedRows();
    if (selectedRows.length == 0)
    {
      JLabel label = new JLabel("<html><center> No hay ninguna entrada seleccionada</center></html>");
      Object[] options =
      {
        "Aceptar"
      };
      JOptionPane dialog = new JOptionPane();
      JOptionPane.showOptionDialog(this,
         label,
         "Ha ocurrido un error",
         JOptionPane.DEFAULT_OPTION,
         JOptionPane.ERROR_MESSAGE,
         null,
         options,
         options[0]);
      return;
    }
    {
      Object[] options =
      {
        "Confimar", "Cancelar"
      };
      JOptionPane dialog = new JOptionPane();
      Object selection = JOptionPane.showOptionDialog(this,
         "¿Está seguro de que desea eliminar "
        + (selectedRows.length == 1 ? "la entrada" : (selectedRows.length + " entradas"))
        + "? Esta acción no se puede deshacer",
         "Confirmación de eliminación",
         JOptionPane.OK_CANCEL_OPTION,
         JOptionPane.WARNING_MESSAGE,
         null,
         options,
         options[1]);
      if (selection.equals(1))
      {
        return;
      }
    }
    try
    {
      for (int i = 0; i < selectedRows.length; i++)
      {
        selectedRows[i] = Table.convertRowIndexToModel(selectedRows[i]);
      }
      controller.delete(selectedRows);
    }
    catch (IllegalOrphanException ex)
    {
      JLabel label = new JLabel("<html><center>No se puede ya que objetos quedarían huerfanos.</center></html>");
      Object[] options =
      {
        "Aceptar"
      };
      JOptionPane dialog = new JOptionPane();
      JOptionPane.showOptionDialog(this,
         label,
         "Ha ocurrido un error",
         JOptionPane.DEFAULT_OPTION,
         JOptionPane.ERROR_MESSAGE,
         null,
         options,
         options[0]);
    }
    catch (Exception ex)
    {
      JLabel label = new JLabel("<html><center>" + ex.getMessage() + "</center></html>");
      Object[] options =
      {
        "Aceptar"
      };
      JOptionPane dialog = new JOptionPane();
      JOptionPane.showOptionDialog(this,
         label,
         "Ha ocurrido un error",
         JOptionPane.DEFAULT_OPTION,
         JOptionPane.ERROR_MESSAGE,
         null,
         options,
         options[0]);
    }
  }//GEN-LAST:event_ButtonEliminarActionPerformed

  private void TextFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_TextFieldActionPerformed
  {//GEN-HEADEREND:event_TextFieldActionPerformed
    ButtonSearchActionPerformed(evt);
  }//GEN-LAST:event_TextFieldActionPerformed

  private void ComboBoxTypesActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ComboBoxTypesActionPerformed
  {//GEN-HEADEREND:event_ComboBoxTypesActionPerformed
    if (ComboBoxTypes.getSelectedIndex() == 1)
    {
      ComboBoxCountries.setEnabled(true);
      TextField.setEnabled(false);
    }
    else
    {
      ComboBoxCountries.setEnabled(false);
      TextField.setEnabled(true);
    }
  }//GEN-LAST:event_ComboBoxTypesActionPerformed

  @Override
  public void update(Observable o, Object arg)
  {
    Table.setModel(model.getTableModel());
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
  private javax.swing.JButton ButtonAdd;
  private javax.swing.JButton ButtonEliminar;
  private javax.swing.JButton ButtonSearch;
  private javax.swing.JComboBox<Object> ComboBoxCountries;
  private javax.swing.JComboBox<String> ComboBoxTypes;
  private javax.swing.JLabel LabelTitle;
  private javax.swing.JLabel LabelType;
  private javax.swing.JTable Table;
  private javax.swing.JTextField TextField;
  private javax.swing.JScrollPane jScrollPane1;
  // End of variables declaration//GEN-END:variables
}
