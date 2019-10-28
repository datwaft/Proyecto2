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
      case "city": model.cityController.initialize();
      case "country": model.countryController.initialize();
      case "flight": model.flightController.initialize();
      case "payment": model.paymentController.initialize();
      case "plane": model.planeController.initialize();
      case "planetype": model.planetypeController.initialize();
      case "trip": model.tripController.initialize();
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
