package cs5004.animator.model;

import java.awt.Color;

/**
 * This class represents the "recolor" animation change.
 */
public class RecolorShape implements AnimationMotion<Color> {

  private Color newColor;
  private Color oldColor;
  private double start;
  private double end;
  private Transformations transformation;
  private Color colorAtTime;
  private Shape shape;

  /**
   * This constructor initializes the ChangeColor object.
   *
   * @param newColor The new Color (r,g,b).
   * @param shape    The Shape object.
   * @param start    The start time at which we want the change in color to start.
   * @param end      The end time at which we want the change in color to end.
   * @throws IllegalArgumentException If the Color passed into the constructor is null.
   */
  public RecolorShape(Color newColor, Shape shape, double start, double end)
      throws IllegalArgumentException {

    if (newColor == null) {
      throw new IllegalArgumentException("Can't pass null.");
    }

    this.newColor = newColor;
    this.oldColor = shape.getColor();
    this.start = start;
    this.end = end;
    this.transformation = Transformations.CHANGE_COLOR;
    this.shape = shape;
  }

  @Override
  public Shape executeChange(double time) {
    tweening(time);
    shape.setNewColor(colorAtTime);
    return shape;
  }

  @Override
  public String stringForm(String key) {
    String str;
    str =
        "Shape "
            + key
            + " changes color from ("
            + (float) oldColor.getRed()
            + ","
            + (float) oldColor.getGreen()
            + ","
            + (float) oldColor.getBlue()
            + ") to ("
            + (float) newColor.getRed()
            + ","
            + (float) newColor.getGreen()
            + ","
            + (float) newColor.getBlue()
            + ") from t="
            + String.format("%.0f", start)
            + " to t="
            + String.format("%.0f\n", end);
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
    int r =
        (int)
            (oldColor.getRed() * ((end - time) / (end - start))
                + newColor.getRed() * ((time - start) / (end - start)));
    int g =
        (int)
            (oldColor.getGreen() * ((end - time) / (end - start))
                + newColor.getGreen() * ((time - start) / (end - start)));
    int b =
        (int)
            (oldColor.getBlue() * ((end - time) / (end - start))
                + newColor.getBlue() * ((time - start) / (end - start)));
    colorAtTime = new Color(r, g, b);
  }

  @Override
  public Color getOld() {
    return this.oldColor;
  }

  @Override
  public Color getNew() {
    return this.newColor;
  }
}
