package airline;

import airline.presentation.mainwindow.*;
import java.util.TimeZone;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class App
{
  public static Model model;
  public static View view;
  public static Controller controller;
  
  public static void main(String[] args)
  {
    TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    
    try
    {
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
    } 
    catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) 
    {
      System.err.println("Error with look and feel: " + e.getMessage());
    }
    
    model = new Model();
    view = new View();
    controller = new Controller(model, view);
    
    controller.changeWindow("welcome");
    
    view.setVisible(true);
  }
}
