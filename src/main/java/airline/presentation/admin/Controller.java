package airline.presentation.admin;

public class Controller
{
  Model model;
  View view;

  public Controller(Model model, View view)
  {
    this.model = model;
    this.view = view;
    view.setModel(model);
    view.setController(this);
    model.setController(this);
  }
  
  public void changeWindow(String window)
  {
    switch(window)
    {
      case "city": model.cityController.initialize(); break;
      case "country": model.countryController.initialize();  break;
      case "flight": model.flightController.initialize();  break;
      case "payment": model.paymentController.initialize();  break;
      case "plane": model.planeController.initialize();  break;
      case "planetype": model.planetypeController.initialize();  break;
      case "trip": model.tripController.initialize(); break;
      case "userview": model.userController.initialize(); break;
      case "reservation": model.reservationController.initialize(); break;
    }
    model.getWindowController().swapWindow(window);
  }
  
  public Model getModel()
  {
    return model;
  }

  public View getView()
  {
    return view;
  }
}
