package cs5004.animator.controller;

import cs5004.animator.model.EasyAnimatorModel;
import cs5004.animator.view.ViewInterface;

import java.io.IOException;

/**
 * This interface represents the behaviors that the controller should be capable of.
 */
public interface Controller {

  /**
   * This method relinquishes control to the controller and produces the correct view based on the
   * input from the EasyAnimator class.
   *
   * @throws IOException throws a checked exception if we have a compile-time error.
   */
  void playAnimation() throws IOException;

  /**
   * To get the view.
   *
   * @return the view.
   */
  ViewInterface getView();

  /**
   * To get the model.
   *
   * @return the model.
   */
  EasyAnimatorModel getModel();

  /**
   * To get the current tick.
   *
   * @return the current tick.
   */
  double getTick();
}
