package cs5004.animator.model;

import java.util.HashMap;
import java.util.List;

/**
 * This interface defines all methods we need to implement in the EasyAnimatorModel class.
 */
public interface EasyAnimatorModel {

  /**
   * This method adds a Shape object to the animation.
   *
   * @param shape The Shape object that gets added to our data structure.
   * @throws IllegalArgumentException We throw this if a Shape object is passed in with a name that
   *                                  already exists in our animation. We throw exception if null is
   *                                  passed in instead of Shape object.
   */
  void addShape(Shape shape) throws IllegalArgumentException;

  /**
   * This method removes a Shape object from the animation. Object is removed from both the HashMap
   * and the ArrayList.
   *
   * @param shapeName The name of the shape that gets removed from our data structure.
   * @throws IllegalArgumentException We throw exception if null is passed in instead of Shape
   *                                  object. We throw this if an Shape object is passed in with a
   *                                  name that already exists in our animation.
   */
  void removeShape(String shapeName) throws IllegalArgumentException;

  /**
   * This method is called upon by the EasyAnimatorModel object to move an Shape object from its
   * current (x,y) position to the new (x,y) position passed in the argument for the duration of the
   * start and end time also passed in the argument. This method delegates the changes to each
   * MoveShape object that will mutate the position of Shape object.
   *
   * @param shape The Shape object that we want to move.
   * @param newX  The new x-coordinate of the Shape object.
   * @param newY  The new y-coordinate of the Shape object.
   * @param start The start time at which we want the movement to start.
   * @param end   The end time at which we want the movement to end.
   * @throws IllegalArgumentException We throw this exception, when null is passed in instead of
   *                                  Shape object, when the start in the argument < Shape object's
   *                                  timeAppear, when the end time > Shape object's timeDisappear,
   *                                  when start > end.
   */
  void moveShape(Shape shape, int newX, int newY, double start, double end)
      throws IllegalArgumentException;

  /**
   * This method is called upon by the EasyAnimatorModel object to change the color of an Shape
   * object from its current Color (r,g,b) to the new Color (r,g,b) passed in the argument for the
   * duration of the start and end time also passed in the argument. This method delegates the
   * changes to ChangeColor class that will mutate the color of Shape object passed in as the
   * argument.
   *
   * @param shape The Shape object that we want to change the color of.
   * @param r     The new Red color of the object.
   * @param g     The new Green color of the object.
   * @param b     The new Blue color of the object.
   * @param start The start time at which we want the change in color to start.
   * @param end   The end time at which we want the change in color to end.
   * @throws IllegalArgumentException We throw this exception, when null is passed in instead of
   *                                  Shape object, when the start in the argument < Shape object's
   *                                  timeAppear, when the end time > Shape object's timeDisappear,
   *                                  when start > end.
   */
  void recolorShape(Shape shape, int r, int g, int b, double start, double end)
      throws IllegalArgumentException;

  /**
   * This method is called upon by the EasyAnimatorModel object to change the scale of an Shape
   * object from its current size to the new size passed in the argument as the newLength and the
   * newWidth for the duration of the start and end time also passed in the argument. This method
   * delegates the changes to ScaleShape class that will mutate the scale of Shape object passed in
   * as the argument.
   *
   * @param shape     The Shape object that we want to change the scale of.
   * @param newLength The new length of the shape.
   * @param newWidth  The new width of the shape.
   * @param start     The start time at which we want the scale in color to start.
   * @param end       The end time at which we want the scale in color to end.
   * @throws IllegalArgumentException We throw this exception, when null is passed in instead of
   *                                  Shape object, when the start in the argument < Shape object's
   *                                  timeAppear, when the end time > Shape object's timeDisappear,
   *                                  when start > end.
   */
  void resizeShape(Shape shape, double newLength, double newWidth, double start, double end)
      throws IllegalArgumentException;

  /**
   * Getter method for hashMap.
   *
   * @return Hashmap.
   */
  HashMap<String, List<AnimationMotion>> getAnimations();

  /**
   * This method creates a list of all the shapes present at a particular time stamp during the
   * animation. This method also calls upon the executeChange() method at a particular time stamp by
   * delegating to the specific AnimationChanges object. That object then returns the new modified
   * shape to this function call, which then adds it to a list in this method.
   *
   * @param time The time at which we want to the list of shapes.
   */
  List<Shape> getShapesAtTick(double time);

  /**
   * This method gives us a string representation of the changes happening to a particular shape.
   *
   * @param name The name of the shape.
   */
  String showShapeJourney(String name);

  /**
   * This is a getter method that gives us the list of shapes.
   *
   * @return A list of the shapes present in the animation.
   */
  List<Shape> getShapes();

  /**
   * Sets Canvas Height and Width.
   *
   * @param height height of canvas.
   * @param width  width of canvas.
   */
  void setCanvasDimensions(int x, int y, int height, int width);

  /**
   * Gets Canvas Height.
   *
   * @return Height of canvas.
   */
  int getCanvasHeight();

  /**
   * Gets Canvas Width.
   *
   * @return Width of canvas.
   */
  int getCanvasWidth();

  /**
   * Gets end time of entire animation.
   *
   * @return end time of animation.
   */
  double getEndTime();

  /**
   * Sets end time of entire animation.
   *
   * @param endTime the end time of the animation.
   */
  void setEndTime(double endTime);

  /**
   * This is a getter method to return the x position of the model.
   *
   * @return The x position.
   */
  int getX();

  /**
   * This is a getter method to return the y position of the model.
   *
   * @return The y position.
   */
  int getY();

  /**
   * This method allows us to set the speed of the animation.
   *
   * @param speed the new speed of the animation.
   */
  void setAnimationSpeed(double speed);

  /**
   * This method allows us to retrieve the current value of the speed of the animation.
   *
   * @return The current speed of the animation.
   */
  double getAnimationSpeed();

}
