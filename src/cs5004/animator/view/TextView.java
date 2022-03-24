package cs5004.animator.view;

import cs5004.animator.model.EasyAnimatorModel;

/**
 * This class represent one of the views we need.
 */
public class TextView implements ViewInterface {

  EasyAnimatorModel model;

  /**
   * Constructs a TextView object, by taking in a model.
   *
   * @param model The model we want to take in.
   */
  public TextView(EasyAnimatorModel model) {
    if (model == null) {
      throw new IllegalArgumentException("The model you passed in is null");
    }
    this.model = model;
  }

  @Override
  public String showView() {
    return this.model.toString();
  }

  @Override
  public Frame getFrame() {
    throw new UnsupportedOperationException("TextView has no field of type SwingFrame");
  }

  @Override
  public String getViewType() {
    return "text";
  }

  @Override
  public String getOutputFile() {
    throw new UnsupportedOperationException("This operation is not supported by this view");
  }

  @Override
  public EasyAnimatorModel getModel() {
    return model;
  }
}
