package cs5004.animator.view;


import cs5004.animator.model.EasyAnimatorModel;

/**
 * This interface defines all the method we are going to implement in various kinds view classes.
 */
public interface ViewInterface {

  /**
   * This method shows the view to the user.
   *
   * @return A string representation of the model.
   */
  String showView();

  /**
   * This method is a getter method to return the frame for the visual view.
   *
   * @return the SwingFrame, so that the current view can be called.
   */
  Frame getFrame();

  /**
   * Get the view's type (one of 3 types - visual, textual, SVG enum).
   *
   * @return The type of view (enum)
   */
  String getViewType();

  /**
   * This is a getter method to retrieve the output file name.
   *
   * @return The output file name.
   */
  String getOutputFile();

  /**
   * Returns the model. This a getter method.
   *
   * @return the model.
   */
  EasyAnimatorModel getModel();
}
