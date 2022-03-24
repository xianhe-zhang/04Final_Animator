package cs5004.animator.model;

import java.awt.Color;

/**
 * This interface defines the methods which be implemented on different shapes.
 */
public interface Shape {

  /**
   * This will get the x-coordinate of our shape.
   *
   * @returnv x-coordinate.
   */
  double getX();

  /**
   * This will get the y-coordinate of our shape.
   *
   * @returnv y-coordinate.
   */
  double getY();

  /**
   * This return the corresponding length or x-radius.
   *
   * @return the corresponding length or x-radius.
   */
  double getLength();

  /**
   * This will return the corresponding width or y-radius.
   *
   * @return the corresponding width or y-radius.
   */
  double getWidth();

  /**
   * This will give us the color of our shape.
   *
   * @return the color of the shape but in the form of r, g, b values.
   */
  Color getColor();

  /**
   * This method gives us the time at which our shape first appears in our animation.
   *
   * @return It returns a unit-less time at which our shape first appears.
   */
  double getTimeAppear();

  /**
   * This method gives us the time at which our shape disappears in our animation.
   *
   * @return It returns a unit-less time at which our shape first appears.
   */
  double getTimeDisappear();

  /**
   * This returns the name associated with each shape.
   *
   * @return shape name.
   */
  String getName();

  /**
   * it mutates the fields, x and y, which are the x and y coordinates of each shape.
   *
   * @param x It's the new x-coordinate of the shape object.
   * @param y It's the new y-coordinate of the shape object.
   */
  void setNewXY(double x, double y);

  /**
   * it mutates the r, g, b value of each shape.
   *
   * @param color It's the new Color(r,g,b) of the shape object.
   */
  void setNewColor(Color color);

  /**
   * it mutates the size of our Shape object by the factor passed into the method.
   *
   * @param scaleFactor The factor by which we increase or decrease the size of our shape.
   */
  void setScale(double scaleFactor);

  /**
   * This is a copy method which copies the current shape at its current state. It gives us a new
   * object with the same fields used to initialize the original object.
   *
   * @return It returns a new instance of the Shape object.
   */
  Shape cloneShape();


  /**
   * This method changes the current length and width to the new length and the width. This method
   * mutates the original shape.
   *
   * @param newLength The new length of the shape.
   * @param newWidth  The new width of the shape.
   */
  void setDimensions(double newLength, double newWidth);

  /**
   * This method retrieves the shape type.
   *
   * @return The shape type.
   */
  ShapeType getShapeType();

  /**
   * This method sets the time disappear of the shape.
   *
   * @param timeDisappear The new time we want the shape to disappear at.
   */
  void setTimeDisappear(double timeDisappear);

  /**
   * This method helps us to define if the shape has already been declared as part of the
   * animation.
   *
   * @return Returns the boolean flag.
   */
  boolean getFlag();

  /**
   * This method lets us set the status of the flag.
   */
  void setFlag();

  /**
   * It gives us the calculated area for the type of shape.
   *
   * @return It returns the calculated area of the shape.
   */
  double getArea();

  /**
   * It gives us the calculated perimeter for type of shape that implements this method.
   *
   * @return It returns the calculated area of the shape.
   */

  double getPerimeter();
}
