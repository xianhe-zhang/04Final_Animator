package cs5004.animator.model;

import java.awt.Color;

/**
 * This class represents oval shapes.
 */
public class Oval extends AbstractShape {

  /**
   * This constructor initializes the Oval object.
   *
   * @param name          The name.
   * @param x             The x-coordinate.
   * @param y             The y-coordinate.
   * @param xRadius       The length.
   * @param yRadius       The width.
   * @param color         The color r,g,b.
   * @param timeAppear    The time at which the shape appears.
   * @param timeDisappear The time at which the shape lasts till.
   */
  public Oval(
      String name,
      double x,
      double y,
      double xRadius,
      double yRadius,
      Color color,
      double timeAppear,
      double timeDisappear) {
    super(name, x, y, xRadius, yRadius, color, timeAppear, timeDisappear);
    this.type = ShapeType.OVAL;
  }

  /**
   * This is a second constructor that just takes in the shape's name.
   *
   * @param name The name.
   */
  public Oval(String name) {
    super(name);
    this.type = ShapeType.OVAL;
  }

  /**
   * This is a copy method which copies the current shape at its current state.
   *
   * @return It returns a new instance of the Shape object.
   */
  @Override
  public Shape cloneShape() {
    return new Oval(
        this.name,
        this.pos.getX(),
        this.pos.getY(),
        this.length,
        this.width,
        this.color,
        this.timeAppear,
        this.timeDisappear);
  }

  /**
   * This method retrieves the shape type.
   *
   * @return The shape type.
   */
  @Override
  public ShapeType getShapeType() {
    return this.type;
  }

  /**
   * It gives us the calculated area for the type of shape.
   *
   * @return It returns the calculated area of the shape.
   */
  @Override
  public double getArea() {
    return Math.PI * this.length * this.width;
  }

  /**
   * This gives us the calculated perimeter.
   *
   * @return It returns the calculated area of the shape.
   */
  @Override
  public double getPerimeter() {
    double stuffInSquareRoot = (Math.pow(this.length, 2) + Math.pow(this.length, 2)) / 2;
    double perimeter = 2 * Math.PI * Math.sqrt(stuffInSquareRoot);
    return perimeter;
  }

  /**
   * This method gives us a string representation of the Oval object.
   *
   * @return It returns a String representation of Oval.
   */
  @Override
  public String toString() {
    String shapeDescription;
    shapeDescription =
        "\nName: "
            + this.name
            + "\nType: "
            + "oval"
            + "\nMin corner: "
            + "("
            + this.pos.getX()
            + ","
            + this.pos.getY()
            + ")"
            + ", "
            + "Width: "
            + this.width
            + ", "
            + "Height: "
            + this.length
            + ", "
            + "Color: "
            + "("
            + (float) this.color.getRed()
            + ","
            + (float) this.color.getGreen()
            + ","
            + (float) this.color.getBlue()
            + ")"
            + "\nAppears at t="
            + this.timeAppear
            + "\nDisappears at t="
            + this.timeDisappear
            + "\n";

    return shapeDescription;
  }
}
