package cs5004.animator.model;

import java.awt.Color;
import java.awt.geom.Point2D;

/**
 * This class implements the Shape interface.
 */
public abstract class AbstractShape implements Shape {

  protected String name;
  protected Point2D pos;
  protected double length;
  protected double width;
  protected Color color;
  protected double timeAppear;
  protected double timeDisappear;
  protected ShapeType type;
  protected boolean flagDeclared;

  /**
   * This constructor initializes the Oval object.
   *
   * @param name          The name.
   * @param x             The x-coordinate.
   * @param y             The y-coordinate.
   * @param length        The length.
   * @param width         The width.
   * @param color         The color r,g,b.
   * @param timeAppear    The time at which the shape appears.
   * @param timeDisappear The time at which the shape lasts till.
   * @throws IllegalArgumentException if something is wrong with args, will throw exceptions.
   */
  public AbstractShape(String name,
      double x,
      double y,
      double length,
      double width,
      Color color,
      double timeAppear,
      double timeDisappear)
      throws IllegalArgumentException {

    if (name == null) {
      throw new IllegalArgumentException("Name is null");
    }

    if (length < 0 || width < 0) {
      throw new IllegalArgumentException("Length or width is negative.");
    }

    if (timeAppear < 0 || timeDisappear < 0) {
      throw new IllegalArgumentException(
          "timeAppear or timeDisappear is negative. They both need to be positive.");
    }

    if (timeAppear > timeDisappear) {
      throw new IllegalArgumentException(
          "Time appear > Time disappear. Has to be the other way around.");
    }

    if (color == null) {
      throw new IllegalArgumentException("Can't have a null.");
    }

    this.name = name;
    this.pos = new Point2D.Double(x, y);
    this.length = length;
    this.width = width;
    this.color = color;
    this.timeAppear = timeAppear;
    this.timeDisappear = timeDisappear;

    // The flag field let us determine the initial state of the Shape object.
    this.flagDeclared = false;
  }


  /**
   * This is a second constructor for the AbstractShape. It only takes in the name of the object.
   *
   * @param name the name of the shape.
   */
  public AbstractShape(String name) {
    this.name = name;
    // The flag field let us determine the initial state of the Shape object.
    this.flagDeclared = false;
  }


  /**
   * This will get the x-coordinate of our shape.
   *
   * @returnv x-coordinate.
   */
  @Override

  public double getX() {
    return pos.getX();
  }

  /**
   * This will get the y-coordinate of our shape.
   *
   * @returnv y-coordinate.
   */
  @Override
  public double getY() {
    return pos.getY();
  }

  /**
   * This is a getter method. It will give us the length of our shape.
   *
   * @return the corresponding length or x-radius.
   */
  @Override
  public double getLength() {
    return this.length;
  }

  /**
   * This is a getter method. It will give us the width of our shape.
   *
   * @return the corresponding width or y-radius.
   */
  @Override
  public double getWidth() {
    return this.width;
  }

  /**
   * This is a getter method. It will give us the color of our shape.
   *
   * @return the color of the shape but in the form of r, g, b values.
   */
  @Override
  public Color getColor() {
    return this.color;
  }

  /**
   * This method gives us the time at which our shape first appears in our animation.
   *
   * @return It returns a unit-less time at which our shape first appears.
   */
  @Override
  public double getTimeAppear() {
    return this.timeAppear;
  }

  /**
   * This method gives us the time at which our shape disappears in our animation.
   *
   * @return It returns a unit-less time at which our shape first appears.
   */
  @Override
  public double getTimeDisappear() {
    return this.timeDisappear;
  }

  /**
   * This returns the name associated with each shape.
   *
   * @return shape name.
   */
  @Override
  public String getName() {
    if (name == null) {
      throw new IllegalArgumentException("Name is null");
    }
    return this.name;
  }

  /**
   * it mutates the fields, x and y, which are the x and y coordinates of each shape.
   *
   * @param x It's the new x-coordinate of the shape object.
   * @param y It's the new y-coordinate of the shape object.
   */
  @Override
  public void setNewXY(double x, double y) {
    pos.setLocation(x, y);
  }

  /**
   * it mutates the r, g, b value of each shape.
   *
   * @param color It's the new Color(r,g,b) of the shape object.
   */
  @Override
  public void setNewColor(Color color) {
    this.color = color;
  }

  /**
   * it mutates the size of our Shape object by the factor passed into the method.
   *
   * @param scaleFactor The factor by which we increase or decrease the size of our shape.
   */
  @Override
  public void setScale(double scaleFactor) {
    if (scaleFactor < 0) {
      throw new IllegalArgumentException("Can't take a negative number");
    }
    this.length *= scaleFactor;
    this.width *= scaleFactor;
  }


  /**
   * This is a copy method which copies the current shape at its current state.
   *
   * @return It returns a new instance of the Shape object.
   */
  @Override
  public abstract Shape cloneShape();

  /**
   * This method changes the current length and width to the new length and the width.
   *
   * @param newLength The new length.
   * @param newWidth  The new width.
   */
  @Override
  public void setDimensions(double newLength, double newWidth) {
    if (newLength < 0 || newWidth < 0) {
      throw new IllegalArgumentException(
          "new length and new width must be positive.");
    }
    this.length = newLength;
    this.width = newWidth;
  }

  /**
   * This sets the time disappear of the shape.
   *
   * @param timeDisappear The new time we want the shape to disappear at.
   */
  @Override
  public void setTimeDisappear(double timeDisappear) {
    this.timeDisappear = timeDisappear;
  }

  /**
   * This tells us if the shape has already been declared as part of the animation.
   *
   * @return Returns the boolean flag.
   */
  @Override
  public boolean getFlag() {
    return this.flagDeclared;
  }

  /**
   * This tells us if the shape has already been declared as part of the animation.
   */
  @Override
  public void setFlag() {
    this.flagDeclared = !this.flagDeclared;
  }

  /**
   * It gives us the calculated area for the type of shape that implements this method.
   *
   * @return It returns the calculated area.
   */
  @Override
  public abstract double getArea();

  /**
   * This gives us the calculated perimeter for type of shape.
   *
   * @return It returns the calculated area of the shape.
   */
  @Override
  public abstract double getPerimeter();

  /**
   * This method will return a string representation of each shape.
   *
   * @return a string representation of each shape.
   */
  public abstract String toString();

}
