package cs5004.animator.view;

import cs5004.animator.model.EasyAnimatorModel;

/**
 * This class will decide which view we are going to offer users.
 */
public class ViewSelector {

  /**
   * This method gets the view and generates the required view based on that.
   *
   * @param model      The model.
   * @param viewType   The view type.
   * @param outputFile The name.
   * @param speed      The speed.
   */
  public static ViewInterface getView(
      EasyAnimatorModel model, String viewType, String outputFile, double speed) {

    ViewInterface view = null;
    try {
      if (viewType.equalsIgnoreCase("svg") && (outputFile.isEmpty())) {
        view = new SvgView(model, speed);
      } else if (viewType.equalsIgnoreCase("svg")) {
        view = new SvgView(model, speed, outputFile);
      } else if (viewType.equalsIgnoreCase("text")) {
        view = new TextView(model);
      } else if (viewType.equalsIgnoreCase("visual")) {
        view = new VisualView(model);
      }
    } catch (Exception e) {
      System.out.println("Error happens when trying getView(method)");
    }
    return view;
  }
}