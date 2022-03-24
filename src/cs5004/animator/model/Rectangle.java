package cs5004.animator.model;

import java.awt.Color;

/**
 * This class represents rectangle shapes.
 */
public class Rectangle extends AbstractShape {

  /**
   * This constructor initializes the Rectangle object.
   *
   * @param name          The name of each shape.
   * @param x             The x-coordinate.
   * @param y             The y-coordinate.
   * @param length        The length.
   * @param width         The width.
   * @param color         The color r,g,b.
   * @param timeAppear    The time at which the shape appears.
   * @param timeDisappear The time at which the shape lasts till.
   */
  public Rectangle(
      String name,
      double x,
      double y,
      double length,
      double width,
      Color color,
      double timeAppear,
      double timeDisappear) {
    super(name, x, y, length, width, color, timeAppear, timeDisappear);
    this.type = ShapeType.RECTANGLE;
  }

  /**
   * This is a second constructor that just takes in the shape's name.
   *
   * @param name The name.
   */
  public Rectangle(String name) {
    super(name);
    this.type = ShapeType.RECTANGLE;
  }


  /**
   * This is a copy method which copies the current shape at its current state.
   *
   * @return It returns a new instance of the Shape object.
   */
  @Override
  public Shape cloneShape() {
    return new Rectangle(
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
   * It gives us the calculated area.
   *
   * @return It returns the calculated area of the shape.
   */
  @Override
  public double getArea() {
    return this.length * this.width;
  }

  /**
   * This gives us the calculated perimeter.
   *
   * @return It returns the calculated area of the shape.
   */
  @Override
  public double getPerimeter() {
    return 2 * this.length + 2 * this.width;
  }

  /**
   * This method gives us a string representation of the Rectangle object.
   *
   * @return It returns a String representation of Rectangle.
   */
  @Override
  public String toString() {
    String shapeDescription;
    shapeDescription =
        "\nName: "
            + this.name
            + "\nType: "
            + "rectangle"
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
