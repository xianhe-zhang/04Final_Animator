package cs5004.animator.controller;

import cs5004.animator.model.EasyAnimatorModel;
import cs5004.animator.model.Shape;
import cs5004.animator.view.ViewInterface;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * This class represents the controller, which will take user input and generate the correct view.
 */
public class ControllerImpl implements Controller {

  private ViewInterface view;
  private EasyAnimatorModel model;
  private double speed;
  private double tick;

  /**
   * This is the constructor for our controller. It takes in a view and a model, and depending on
   * the type of view, we create the necessary output.
   *
   * @param view  The view that has been generated using the EasyAnimator.
   * @param model The model that has been built using the builder in EasyAnimator.
   */
  public ControllerImpl(ViewInterface view, EasyAnimatorModel model) {
    this.view = view;
    this.model = model;
    this.speed = model.getAnimationSpeed();
    this.tick = 0;
  }

  @Override
  public void playAnimation() throws IOException {
    if (view.getViewType().equalsIgnoreCase("text")) {
      playTextView();
    } else if (view.getViewType().equalsIgnoreCase("svg")) {
      playSvgView();
    } else if (view.getViewType().equalsIgnoreCase("visual")) {
      playVisualView();
    }
  }

  /**
   * This is a helper method that gets called upon by the go() method above in order to execute if
   * the user enters "visual" as a command line argument.
   */
  private void playVisualView() {
    while (tick <= model.getEndTime()) {
      List<Shape> preShapes = model.getShapesAtTick(tick);
      this.view.getFrame().currentView(preShapes);
      tick++;
      try {
        Thread.sleep((long) (100 / speed));
      } catch (InterruptedException ex) {
        Thread.currentThread().interrupt();
      }
    }
  }

  /**
   * This is a helper method that gets called upon by the go() method above in order to execute if
   * the user enters "SVG" as a command line argument.
   *
   * @throws IOException If the user doesn't enter a correct command line argument.
   */
  private void playSvgView() throws IOException {
    if (this.view.getOutputFile().toLowerCase().equals("")) {
      System.out.println(this.view.showView());
    } else {
      BufferedWriter input = new BufferedWriter(new FileWriter(this.view.getOutputFile()));
      input.write(this.view.showView());
      input.close();
    }
  }


  /**
   * This is a helper method that gets called upon by the go() method above in order to execute if
   * the user enters "text" as a command line argument.
   */
  private void playTextView() {
    System.out.println(view.showView());
  }

  @Override
  public ViewInterface getView() {
    return this.view;
  }

  @Override
  public EasyAnimatorModel getModel() {
    return this.model;
  }

  @Override
  public double getTick() {
    return tick;
  }
}
