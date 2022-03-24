package cs5004.animator.model;

import java.awt.geom.Point2D;

/**
 * This class represents resize change to the shape.
 */
public class ResizeShape implements AnimationMotion<Point2D> {

  private double oldLength;
  private double oldWidth;
  private double newLength;
  private double newWidth;
  private double widthAtTime;
  private double heightAtTime;
  private double start;
  private double end;
  private final Transformations transformation;
  Shape shape;

  /**
   * This constructor initializes the ScaleShape object.
   *
   * @param newLength new Length.
   * @param newWidth  new Width.
   * @param shape     The Shape object that we want to change the size of
   * @param start     The start time at which we want the movement to start.
   * @param end       The end time at which we want the movement to end.
   */
  public ResizeShape(double newLength, double newWidth, Shape shape, double start, double end) {

    this.oldLength = shape.getLength();
    this.oldWidth = shape.getWidth();
    this.newLength = newLength;
    this.newWidth = newWidth;
    this.start = start;
    this.end = end;
    this.transformation = Transformations.SCALE_SHAPE;
    this.shape = shape;
  }

  @Override
  public Shape executeChange(double time) {
    tweening(time);
    shape.setDimensions(heightAtTime, widthAtTime);
    return shape;
  }

  @Override
  public String stringForm(String key) {
    String str;
    str =
        "Shape "
            + key
            + " scales from Width: "
            + oldLength
            + ", Height: "
            + oldWidth
            + " to Width: ";
    str += newLength + ", Height: " + newWidth;
    str += " from t=" + String.format("%.0f", start) + " to t=" + String.format("%.0f\n", end);

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
    this.widthAtTime =
        oldLength * ((end - time) / (end - start)) + newLength * ((time - start) / (end - start));
    this.heightAtTime =
        oldWidth * ((end - time) / (end - start)) + newWidth * ((time - start) / (end - start));
  }

  @Override
  public Point2D getOld() {
    return new Point2D.Double(oldLength, oldWidth);
  }

  @Override
  public Point2D getNew() {
    return new Point2D.Double(newLength, newWidth);
  }
}
