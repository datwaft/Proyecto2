package airline.presentation.mainwindow;

import java.io.IOException;
import java.util.*;
import javax.swing.*;

public final class View extends javax.swing.JFrame implements Observer
{
  Model model;
  Controller controller;
  
  public View()
  {
    initComponents();
    
    ImageIcon icon = new ImageIcon(getClass().getResource("/plane.png"));
    this.setIconImage(icon.getImage());
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents()
  {

    MenuBar = new javax.swing.JMenuBar();
    MenuFile = new javax.swing.JMenu();
    ItemExit = new javax.swing.JMenuItem();
    MenuAbout = new javax.swing.JMenu();
    ItemInstitutionalReference = new javax.swing.JMenuItem();
    ItemHistory = new javax.swing.JMenuItem();
    ItemContact = new javax.swing.JMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("Proyecto #2: Aerolínea");
    setMinimumSize(new java.awt.Dimension(800, 500));
    setName("mainwindow"); // NOI18N
    setResizable(false);

    MenuFile.setText("Programa");

    ItemExit.setText("Salir del programa");
    ItemExit.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ItemExitActionPerformed(evt);
      }
    });
    MenuFile.add(ItemExit);

    MenuBar.add(MenuFile);

    MenuAbout.setText("Información");

    ItemInstitutionalReference.setText("Referente institucional");
    ItemInstitutionalReference.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ItemInstitutionalReferenceActionPerformed(evt);
      }
    });
    MenuAbout.add(ItemInstitutionalReference);

    ItemHistory.setText("Historia de la empresa");
    ItemHistory.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ItemHistoryActionPerformed(evt);
      }
    });
    MenuAbout.add(ItemHistory);

    ItemContact.setText("Contactenos");
    ItemContact.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ItemContactActionPerformed(evt);
      }
    });
    MenuAbout.add(ItemContact);

    MenuBar.add(MenuAbout);

    setJMenuBar(MenuBar);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 800, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 478, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void ItemExitActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ItemExitActionPerformed
  {//GEN-HEADEREND:event_ItemExitActionPerformed
    Object[] options = {"Aceptar", "Cancelar"};
    int exit = JOptionPane.showOptionDialog(this
      , "¿Está usted seguro de que desea salir?"
      , "¿Seguro que desea salir?"
      , JOptionPane.OK_CANCEL_OPTION
      , JOptionPane.WARNING_MESSAGE
      , null
      , options
      , options[0]);

    if (exit == JOptionPane.YES_OPTION)
    {
      java.lang.System.exit(0);
    }
  }//GEN-LAST:event_ItemExitActionPerformed

  private void ItemInstitutionalReferenceActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ItemInstitutionalReferenceActionPerformed
  {//GEN-HEADEREND:event_ItemInstitutionalReferenceActionPerformed
    try
    {
      String path = "/institutional_reference.html";
      String data = new Scanner(getClass().getResource(path).openStream(), "UTF-8").useDelimiter("\\A").next();
      JLabel label = new JLabel(data);
      
      Object[] options = {"Aceptar"};
      
      JOptionPane dialog = new JOptionPane();
      JOptionPane.showOptionDialog(this
        , label
        , "Referente institucional"
        , JOptionPane.DEFAULT_OPTION
        , JOptionPane.PLAIN_MESSAGE
        , null
        , options
        , options[0]);
    }
    catch (IOException ex)
    {
      System.err.println(ex.getMessage());
    }
  }//GEN-LAST:event_ItemInstitutionalReferenceActionPerformed

  private void ItemHistoryActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ItemHistoryActionPerformed
  {//GEN-HEADEREND:event_ItemHistoryActionPerformed
    try
    {
      String path = "/history.html";
      String data = new Scanner(getClass().getResource(path).openStream(), "UTF-8").useDelimiter("\\A").next();
      JLabel label = new JLabel(data);
      
      Object[] options = {"Aceptar"};
      
      JOptionPane dialog = new JOptionPane();
      JOptionPane.showOptionDialog(this
        , label
        , "Nuestra historia"
        , JOptionPane.DEFAULT_OPTION
        , JOptionPane.PLAIN_MESSAGE
        , null
        , options
        , options[0]);
    }
    catch (IOException ex)
    {
      System.err.println(ex.getMessage());
    }
  }//GEN-LAST:event_ItemHistoryActionPerformed

  private void ItemContactActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ItemContactActionPerformed
  {//GEN-HEADEREND:event_ItemContactActionPerformed
    try
    {
      String path = "/contact.html";
      String data = new Scanner(getClass().getResource(path).openStream(), "UTF-8").useDelimiter("\\A").next();
      JLabel label = new JLabel(data);
      
      Object[] options = {"Aceptar"};
      
      JOptionPane dialog = new JOptionPane();
      JOptionPane.showOptionDialog(this
        , label
        , "Contactenos"
        , JOptionPane.DEFAULT_OPTION
        , JOptionPane.PLAIN_MESSAGE
        , null
        , options
        , options[0]);
    }
    catch (IOException ex)
    {
      System.err.println(ex.getMessage());
    }
  }//GEN-LAST:event_ItemContactActionPerformed

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
  private javax.swing.JMenuItem ItemContact;
  private javax.swing.JMenuItem ItemExit;
  private javax.swing.JMenuItem ItemHistory;
  private javax.swing.JMenuItem ItemInstitutionalReference;
  private javax.swing.JMenu MenuAbout;
  private javax.swing.JMenuBar MenuBar;
  private javax.swing.JMenu MenuFile;
  // End of variables declaration//GEN-END:variables
}
