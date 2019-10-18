package airline;

import airline.presentation.mainwindow.*;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class App
{
  public static Model model;
  public static View view;
  public static Controller controller;
  
  public static void main(String[] args)
  {
    try
    {
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
    } 
    catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) 
    {
      System.err.println("error: invalid look and feel.");
    }
    
    model = new Model();
    view = new View();
    controller = new Controller(model, view);
    
    controller.swapWindow("country");
    
    view.setVisible(true);
  }
}
