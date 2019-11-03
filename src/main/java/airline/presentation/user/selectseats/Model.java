package airline.presentation.user.selectseats;

import airline.logic.*;
import com.sun.tools.javac.util.Pair;
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

  private final List<Pair<Integer, Character>> selected;
  
  private ArrayList<ArrayList<Seat>> seats;
  
  public Model()
  {
    selected = new ArrayList<>();
    seats = new ArrayList<>();
  }

  public ArrayList<ArrayList<Seat>> getSeats()
  {
    return seats;
  }
  
  public void setSeats(ArrayList<ArrayList<Seat>> list)
  {
    seats = list;
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

  public List<Pair<Integer, Character>> getSelected()
  {
    return selected;
  }
  
  public void addSelected(Pair<Integer, Character> pair)
  {
    selected.add(pair);
    this.setChanged();
    this.notifyObservers();  
  }
  
  public void deleteSelected(Pair<Integer, Character> pair)
  {
    selected.remove(pair);
    this.setChanged();
    this.notifyObservers();  
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