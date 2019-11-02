package airline.presentation.user.selectseats;

import airline.logic.*;
import java.util.*;

public class Model extends Observable
{
  private Controller controller;
  private airline.presentation.mainwindow.Controller windowController;
  private airline.presentation.user.Controller userController;
  
  private static User loggedUser = null;
  private static Trip selectedTrip = null;
  private static Payment paymentType = null;
  private static Double price = null;
  private static List<String> names = null;


  public Model()
  {
    
  }
  
  
  public static void clean()
  {
    Model.loggedUser = null;
    Model.selectedTrip = null;
    Model.paymentType = null;
    Model.price = null;
    Model.names = null;
  }
  
  public static Trip getSelectedTrip()
  {
    return selectedTrip;
  }

  public static void setSelectedTrip(Trip selectedTrip)
  {
    Model.selectedTrip = selectedTrip;
  }

  public static Payment getPaymentType()
  {
    return paymentType;
  }

  public static void setPaymentType(Payment paymentType)
  {
    Model.paymentType = paymentType;
  }

  public static Double getPrice()
  {
    return price;
  }

  public static void setPrice(Double price)
  {
    Model.price = price;
  }

  public static List<String> getNames()
  {
    return names;
  }

  public static void setNames(List<String> names)
  {
    Model.names = names;
  }
  
  public static User getLoggedUser()
  {
    return loggedUser;
  }

  public static void setLoggedUser(User loggedUser)
  {
    Model.loggedUser = loggedUser;
  }
  
  public Controller getController()
  {
    return controller;
  }

  public void setController(Controller controller)
  {
    this.controller = controller;
    this.setChanged();
    this.notifyObservers();  
  }
  
  public airline.presentation.mainwindow.Controller getWindowController()
  {
    return windowController;
  }

  public airline.presentation.user.Controller getUserController()
  {
    return userController;
  }

  public void setUserController(airline.presentation.user.Controller userController)
  {
    this.userController = userController;
  }

  public void setWindowController(airline.presentation.mainwindow.Controller windowController)
  {
    this.windowController = windowController;
  }
  
  @Override
  public void addObserver(Observer o)
  {
    super.addObserver(o);
    this.setChanged();
    this.notifyObservers();   
  }
}