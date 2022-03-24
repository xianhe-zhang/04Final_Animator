package cs5004.animator.view;

import cs5004.animator.model.EasyAnimatorModel;

/**
 * This represents Visual View.
 */
public class VisualView implements ViewInterface {

  Frame frame;
  EasyAnimatorModel model;

  /**
   * This method constructs a visual view object.
   *
   * @param model The model from our builder.
   */
  public VisualView(EasyAnimatorModel model) {
    if (model == null) {
      throw new IllegalArgumentException("The model you passed in is null");
    }
    this.model = model;
    this.frame =
        new Frame(
            model.getX(),
            model.getY(),
            model.getCanvasWidth(),
            model.getCanvasHeight(),
            model.getShapes());
  }

  @Override
  public String showView() {
    throw new UnsupportedOperationException("Cannot show the view in text format");
  }

  @Override
  public Frame getFrame() {
    return this.frame;
  }

  @Override
  public String getViewType() {
    return "visual";
  }

  @Override
  public String getOutputFile() {
    throw new UnsupportedOperationException("This operation is not supported by this view");
  }

  @Override
  public EasyAnimatorModel getModel() {
    return this.model;
  }
}
