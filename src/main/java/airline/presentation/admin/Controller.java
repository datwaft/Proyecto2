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
      case "city": model.cityController.update();
      case "country": model.countryController.update();
      case "flight": model.flightController.update();
      case "payment": model.paymentController.update();
      case "plane": model.planeController.update();
      case "planetype": model.planetypeController.update();
      case "trip": model.tripController.update();
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
