package cs5004.animator.model;

import java.awt.geom.Point2D;

/**
 * This class represents moving shape changes.
 */
public class MoveShape implements AnimationMotion<Point2D> {

  private Point2D newPos;
  private Point2D oldPos;
  private double start;
  private double end;
  private final Transformations transformation;
  private Point2D posAtTime;
  Shape shape;

  /**
   * This constructor initializes the MoveShape object.
   *
   * @param newPos The new position
   * @param shape  The Shape object。
   * @param start  The start time at which we want the movement to start.
   * @param end    The end time at which we want the movement to end.
   * @throws IllegalArgumentException We throw this exception, when null is passed.
   */
  public MoveShape(Point2D newPos, Shape shape, double start, double end) {

    if (newPos == null) {
      throw new IllegalArgumentException("Can't pass in null for the positions");
    }

    this.newPos = newPos;
    this.oldPos = new Point2D.Double(shape.getX(), shape.getY());
    this.start = start;
    this.end = end;
    this.transformation = Transformations.MOVE_SHAPE;
    this.shape = shape;
  }


  /**
   * This method implements the mutation to the positions.
   *
   * @param time The time at which we want to execute the change.
   */
  @Override
  public Shape executeChange(double time) {
    tweening(time);
    shape.setNewXY(posAtTime.getX(), posAtTime.getY());
    return shape;
  }

  @Override
  public String stringForm(String key) {
    String str;
    str =
        "Shape "
            + key
            + " moves from "
            + "("
            + this.oldPos.getX()
            + ","
            + this.oldPos.getY()
            + ")"
            + " to "
            + "("
            + this.newPos.getX()
            + ","
            + this.newPos.getY()
            + ")"
            + " from time t="
            + String.format("%.0f", this.start)
            + " to t="
            + String.format("%.0f\n", this.end);
    return str;
  }

  @Override
  public double getStart() {
    return this.start;
  }

  @Override
  public double getEnd() {
    return this.end;
  }

  @Override
  public Transformations getTransformation() {
    return this.transformation;
  }

  @Override
  public void tweening(double time) {
    double x =
        oldPos.getX() * ((end - time) / (end - start))
            + newPos.getX() * ((time - start) / (end - start));
    double y =
        oldPos.getY() * ((end - time) / (end - start))
            + newPos.getY() * ((time - start) / (end - start));
    this.posAtTime = new Point2D.Double(x, y);
  }

  @Override
  public Point2D getOld() {
    return this.oldPos;
  }

  @Override
  public Point2D getNew() {
    return this.newPos;
  }
}
