package airline;

import airline.presentation.mainwindow.*;

public class App
{
  public static Model model;
  public static View view;
  public static Controller controller;
  
  public static void main(String[] args)
  {
    model = new Model();
    view = new View();
    controller = new Controller(model, view);
    view.setVisible(true);
  }
}
