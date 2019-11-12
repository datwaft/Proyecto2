package airline.presentation.user.selectseats;

import airline.logic.*;
import com.sun.tools.javac.util.Pair;
import java.awt.*;
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
    ButtonCancel = new javax.swing.JButton();
    LabelRemainder = new javax.swing.JLabel();
    FieldRemainder = new javax.swing.JTextField();
    PanelDraw = new javax.swing.JPanel()
    {
      @Override
      public void paintComponent(Graphics g)
      {
        super.paintComponent(g);
        renderModel(g);
      }
    };
    ButtonFinish = new javax.swing.JButton();

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

    LabelRemainder.setText("Asientos restantes:");

    FieldRemainder.setEditable(false);
    FieldRemainder.setBackground(new java.awt.Color(255, 255, 255));
    FieldRemainder.setText("0");

    PanelDraw.setBackground(new java.awt.Color(255, 255, 255));
    PanelDraw.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
    PanelDraw.addMouseListener(new java.awt.event.MouseAdapter()
    {
      public void mouseClicked(java.awt.event.MouseEvent evt)
      {
        PanelDrawMouseClicked(evt);
      }
    });

    javax.swing.GroupLayout PanelDrawLayout = new javax.swing.GroupLayout(PanelDraw);
    PanelDraw.setLayout(PanelDrawLayout);
    PanelDrawLayout.setHorizontalGroup(
      PanelDrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 0, Short.MAX_VALUE)
    );
    PanelDrawLayout.setVerticalGroup(
      PanelDrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 377, Short.MAX_VALUE)
    );

    ButtonFinish.setText("Finalizar");
    ButtonFinish.addActionListener(new java.awt.event.ActionListener()
    {
      public void actionPerformed(java.awt.event.ActionEvent evt)
      {
        ButtonFinishActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addGap(278, 278, 278)
                .addComponent(LabelTitle))
              .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelRemainder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(FieldRemainder, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(0, 268, Short.MAX_VALUE))
          .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addComponent(ButtonFinish)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonCancel))
              .addComponent(PanelDraw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(LabelTitle)
        .addGap(1, 1, 1)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(LabelRemainder)
          .addComponent(FieldRemainder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addComponent(PanelDraw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(ButtonCancel)
          .addComponent(ButtonFinish))
        .addContainerGap())
    );
  }// </editor-fold>//GEN-END:initComponents

  private void ButtonCancelActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonCancelActionPerformed
  {//GEN-HEADEREND:event_ButtonCancelActionPerformed
    Model.clean();
    model.getUserController().changeWindow("trips");
  }//GEN-LAST:event_ButtonCancelActionPerformed

  private void ButtonFinishActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ButtonFinishActionPerformed
  {//GEN-HEADEREND:event_ButtonFinishActionPerformed
     String error = "";
    
    if(Model.getNames().size() > model.getSelected().size())
    {
      if(!error.isBlank())
        error += "<br>";
      error += "No se han seleccionado todos los asientos.";
    }
    
    if (error.isBlank())
    {
      {
        ImageIcon icon = new ImageIcon(getClass().getResource("/icons/plane.png"));
        JLabel label = new JLabel("<html><center>Gracias por su compra.</center></html>");
        Object[] options = {"Aceptar"};
        JOptionPane dialog = new JOptionPane();
        JOptionPane.showOptionDialog(this
          , label
          , "Gracias por su compra"
          , JOptionPane.DEFAULT_OPTION
          , JOptionPane.INFORMATION_MESSAGE
          , null
          , options
          , options[0]);
      }
      
      try
      {
        controller.processPurchase();
      }
      catch(Exception ex)
      {
        JLabel label = new JLabel("<html><center>"+ ex.getLocalizedMessage() +"</center></html>");
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
      model.getUserController().changeWindow("trips");
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
  }//GEN-LAST:event_ButtonFinishActionPerformed

  private void PanelDrawMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_PanelDrawMouseClicked
  {//GEN-HEADEREND:event_PanelDrawMouseClicked
    Seat seat;
    for(int i = 0; i < Model.getSelectedTrip().getPlane().getType().getRownumber(); ++i)
    {
      for(int j = 0; j <  Model.getSelectedTrip().getPlane().getType().getRowseats(); ++j)
      {
        seat = model.getSeats().get(i).get(j);
        if(seat.contains(evt.getX(), evt.getY()))
        {
          if(seat.getColor() == Color.white)
          {
            if(Model.getNames().size() > model.getSelected().size())
            {
              model.addSelected(new Pair<>(seat.getRow(), seat.getSeat()));
              seat.setColor(Color.cyan);
            }
          }
          else if(seat.getColor() == Color.cyan)
          {
            model.deleteSelected(new Pair<>(seat.getRow(), seat.getSeat()));
            seat.setColor(Color.white);
          }
          PanelDraw.validate();
          PanelDraw.repaint();
        }
      }
    }
  }//GEN-LAST:event_PanelDrawMouseClicked

  @Override
  public void update(Observable o, Object arg)
  {
    if(Model.getNames() != null)
      FieldRemainder.setText(Integer.toString(Model.getNames().size() - model.getSelected().size()));
  }
  
  public void initialize()
  {
     FieldRemainder.setText(Integer.toString(Model.getNames().size() - model.getSelected().size()));
     this.generateSeats();
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
  
  private void renderModel(Graphics g)
  {
    Graphics2D media = (Graphics2D) g;
    
    RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

    media.setRenderingHints(rh);
    
    renderSeats(media);
  }
  
  private void generateSeats()
  {
    int seatWidth = 20;
    int seatHeight = 20;
    int width = (PanelDraw.getWidth() - Model.getSelectedTrip().getPlane().getType().getRownumber() * seatWidth)/2;
    int height;
    
    if(Model.getSelectedTrip().getPlane().getType().getRowseats() == 6)
      height = (PanelDraw.getHeight() - (Model.getSelectedTrip().getPlane().getType().getRowseats() + 1) * seatHeight)/2;
    else
      height = (PanelDraw.getHeight() - (Model.getSelectedTrip().getPlane().getType().getRowseats() + 2) * seatHeight)/2;
    
    ArrayList<ArrayList<Seat>> seats = new ArrayList<>();
    
    for(int i = 0; i < Model.getSelectedTrip().getPlane().getType().getRownumber(); ++i)
    {
      seats.add(new ArrayList<>());
    }
    
    for(int i = 0; i < Model.getSelectedTrip().getPlane().getType().getRownumber(); ++i)
    {
      for(int j = 0; j < Model.getSelectedTrip().getPlane().getType().getRowseats(); ++j)
      {
        Seat seat;
        
        if(Model.getSelectedTrip().getPlane().getType().getRowseats() == 6)
        {
          if(j < 3)
            seat = new Seat(i * seatWidth + width,j * seatHeight + height,seatWidth - 5, seatHeight - 5);
          else
            seat = new Seat(i * seatWidth + width,(j+1) * seatHeight + height,seatWidth - 5, seatHeight - 5);
        }
        else
        {
          if(j < 3)
            seat = new Seat(i * seatWidth + width,j * seatHeight + height,seatWidth - 5, seatHeight - 5);
          else if(j < 6)
            seat = new Seat(i * seatWidth + width,(j+1) * seatHeight + height,seatWidth - 5, seatHeight - 5);
          else
            seat = new Seat(i * seatWidth + width,(j+2) * seatHeight + height,seatWidth - 5, seatHeight - 5);
        }
        
        seat.setRow(i+1);
        seat.setSeat((char)(65 + j));
        seat.setColor(Color.white);
        seats.get(i).add(seat);
      }
    }
    checkSeats(seats);
    model.setSeats(seats);
  }
  
  private void checkSeats(ArrayList<ArrayList<Seat>> seats)
  {
    java.util.List<Ticket> occupied = controller.getTripSeats();
    for(int i = 0; i < occupied.size(); ++i)
    {
      try
      {
        int row = occupied.get(i).getRownumber();
        int seat = occupied.get(i).getSeatletter().codePointAt(0) - 65;
        seats.get(row - 1).get(seat).setColor(Color.pink);
      }
      catch(Exception ex)
      {

      }
    }
  }
  
  private void renderSeats(Graphics2D media)
  {
    int seatWidth = 20;
    int seatHeight = 20;
    int width = (PanelDraw.getWidth() - Model.getSelectedTrip().getPlane().getType().getRownumber() * seatWidth)/2;
    int widthlimit = width + Model.getSelectedTrip().getPlane().getType().getRownumber() * seatWidth;
    int height;
    int heightlimit;
    
    if(Model.getSelectedTrip().getPlane().getType().getRowseats() == 6)
    {
      height = (PanelDraw.getHeight() - (Model.getSelectedTrip().getPlane().getType().getRowseats() + 1) * seatHeight)/2;
      heightlimit = height + (Model.getSelectedTrip().getPlane().getType().getRowseats() + 1) * seatHeight;
    }
    else
    {
      height = (PanelDraw.getHeight() - (Model.getSelectedTrip().getPlane().getType().getRowseats() + 2) * seatHeight)/2;
      heightlimit = height + (Model.getSelectedTrip().getPlane().getType().getRowseats() + 2) * seatHeight;
    }
    
    for(int i = 0; i < Model.getSelectedTrip().getPlane().getType().getRownumber(); ++i)
    {
      renderCenteredString(Integer.toString(i + 1), new Rectangle(i * seatWidth + width, height - seatHeight, seatWidth, seatHeight), media);
      renderCenteredString(Integer.toString(i + 1), new Rectangle(i * seatWidth + width, heightlimit, seatWidth, seatHeight), media);
    }
    
    for(int j = 0; j < Model.getSelectedTrip().getPlane().getType().getRowseats(); ++j)
    {
      if(Model.getSelectedTrip().getPlane().getType().getRowseats() == 6)
      {
        if(j < 3)
        {
          renderCenteredString(Character.toString(j + 65), new Rectangle(width - seatWidth, (j+0) * seatHeight + height, seatWidth, seatHeight), media);
          renderCenteredString(Character.toString(j + 65), new Rectangle(widthlimit, (j+0) * seatHeight + height, seatWidth, seatHeight), media);
        }
        else
        {
          renderCenteredString(Character.toString(j + 65), new Rectangle(width - seatWidth, (j+1) * seatHeight + height, seatWidth, seatHeight), media);
          renderCenteredString(Character.toString(j + 65), new Rectangle(widthlimit, (j+1) * seatHeight + height, seatWidth, seatHeight), media);
        }
      }
      else
      {
        if(j < 3)
        {
          renderCenteredString(Character.toString(j + 65), new Rectangle(width - seatWidth, (j+0) * seatHeight + height, seatWidth, seatHeight), media);
          renderCenteredString(Character.toString(j + 65), new Rectangle(widthlimit, (j+0) * seatHeight + height, seatWidth, seatHeight), media);
        }
        else if(j < 6)
        {
          renderCenteredString(Character.toString(j + 65), new Rectangle(width - seatWidth, (j+1) * seatHeight + height, seatWidth, seatHeight), media);
          renderCenteredString(Character.toString(j + 65), new Rectangle(widthlimit, (j+1) * seatHeight + height, seatWidth, seatHeight), media);
        }
        else
        {
          renderCenteredString(Character.toString(j + 65), new Rectangle(width - seatWidth, (j+2) * seatHeight + height, seatWidth, seatHeight), media);
          renderCenteredString(Character.toString(j + 65), new Rectangle(widthlimit, (j+2) * seatHeight + height, seatWidth, seatHeight), media);
        }
      }
    }
    
    for(int i = 0; i < Model.getSelectedTrip().getPlane().getType().getRownumber(); ++i)
    {
      for(int j = 0; j < Model.getSelectedTrip().getPlane().getType().getRowseats(); ++j)
      {
        renderRectangle(model.getSeats().get(i).get(j), media);
      }
    }
  }
  
  private void renderRectangle(Seat rect, Graphics2D media)
  {
    media.setColor(rect.getColor());
    media.fill(rect);
    media.setColor(Color.black);
    media.draw(rect);
  }
  
  private void renderCenteredString(String string, Rectangle rect, Graphics2D media)
  {
    rect.height -= 5;
    rect.width -= 5;
    
    Font font = new Font("Monospaced", Font.BOLD, 10);
    FontMetrics metrics = media.getFontMetrics(font);
    int x = rect.x + (rect.width - metrics.stringWidth(string)) / 2;
    int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
    media.setFont(font);
    media.drawString(string, x, y);
  }
  
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton ButtonCancel;
  private javax.swing.JButton ButtonFinish;
  private javax.swing.JTextField FieldRemainder;
  private javax.swing.JLabel LabelRemainder;
  private javax.swing.JLabel LabelTitle;
  private javax.swing.JPanel PanelDraw;
  // End of variables declaration//GEN-END:variables
}
