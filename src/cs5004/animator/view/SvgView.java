package cs5004.animator.view;

import cs5004.animator.model.AnimationMotion;
import cs5004.animator.model.EasyAnimatorModel;
import cs5004.animator.model.Shape;
import cs5004.animator.model.ShapeType;
import cs5004.animator.model.Transformations;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.util.List;

/**
 * This class represents SVG View.
 */
public class SvgView implements ViewInterface {

  private EasyAnimatorModel model;
  private double speed;
  private String outputFile;

  /**
   * Constructs a new SvgView object.
   *
   * @param model The model we want an SVG Representation of.
   * @param speed The speed the model runs at.
   */
  public SvgView(EasyAnimatorModel model, double speed) {
    if (model == null) {
      throw new IllegalArgumentException("The model you passed in is null");
    }
    this.model = model;
    this.speed = speed / 100;
    this.outputFile = "";
  }

  /**
   * This is a second constructor for the SvgView.
   *
   * @param model      The model.
   * @param speed      The animation speed.
   * @param outputFile The name of the output file.
   */
  public SvgView(EasyAnimatorModel model, double speed, String outputFile) {
    if (model == null) {
      throw new IllegalArgumentException("The model you passed in is null");
    }
    this.model = model;
    this.speed = speed / 100;
    this.outputFile = outputFile;
  }

  @Override
  public String showView() {
    StringBuilder str = new StringBuilder();
    // Add Canvas Width and Height.
    str.append(
        "<svg width=\""
            + model.getCanvasWidth()
            + "\" height=\""
            + model.getCanvasHeight()
            + "\" viewBox=\""
            + model.getX()
            + " "
            + model.getY()
            + " "
            + model.getCanvasWidth()
            + " "
            + model.getCanvasHeight()
            + "\" version=\"1.1\"\n\txmlns=\"http://www.w3.org/2000/svg\">\n");

    // Iterate through ArrayList shapes.
    for (Shape each : model.getShapes()) {
      // Get Bucket
      List<AnimationMotion> bucket = model.getAnimations().get(each.getName());
      if (bucket == null) {
        throw new IllegalArgumentException("Bucket should not be null.");
      }
      // Add initial Shape dimensions for Rectangle.
      if (each.getShapeType() == ShapeType.RECTANGLE) {
        str.append(
            "<rect id=\""
                + each.getName()
                + "\" x=\""
                + each.getX()
                + "\" y=\""
                + each.getY()
                + "\" width=\""
                + each.getWidth()
                + "\" height=\""
                + each.getLength()
                + "\" fill=\"rgb("
                + each.getColor().getRed()
                + ","
                + each.getColor().getGreen()
                + ","
                + each.getColor().getBlue()
                + ")\" visibility=\"visible\" >\n");

        // Iterate through Bucket
        for (AnimationMotion change : bucket) {
          if (change.getTransformation() == Transformations.MOVE_SHAPE) {
            Point2D old = (Point2D) change.getOld();
            Point2D neww = (Point2D) change.getNew();
            str.append(
                "<animate attributeType=\"xml\" begin=\""
                    + change.getStart() / speed
                    + "ms\" dur=\""
                    + (change.getEnd() - change.getStart()) / speed
                    + "ms\" attributeName=\"x\" from=\""
                    + old.getX()
                    + "\" to=\""
                    + neww.getX()
                    + "\" fill=\"freeze\" />\n");
            str.append(
                "<animate attributeType=\"xml\" begin=\""
                    + change.getStart() / speed
                    + "ms\" dur=\""
                    + (change.getEnd() - change.getStart()) / speed
                    + "ms\" attributeName=\"y\" from=\""
                    + old.getY()
                    + "\" to=\""
                    + neww.getY()
                    + "\" fill=\"freeze\" />\n");
          } else if (change.getTransformation() == Transformations.CHANGE_COLOR) {
            Color old = (Color) change.getOld();
            Color neww = (Color) change.getNew();
            str.append(
                "<animate attributeType=\"xml\" begin=\""
                    + change.getStart() / speed
                    + "ms\" dur=\""
                    + (change.getEnd() - change.getStart()) / speed
                    + "ms\" attributeName=\"fill\" from=\"rgb("
                    + +old.getRed()
                    + ","
                    + old.getGreen()
                    + ","
                    + old.getBlue()
                    + ")\" to=\"rgb("
                    + +neww.getRed()
                    + ","
                    + neww.getGreen()
                    + ","
                    + neww.getBlue()
                    + ")\" fill=\"freeze\" />\n");
          } else if (change.getTransformation() == Transformations.SCALE_SHAPE) {
            Point2D old = (Point2D) change.getOld();
            Point2D neww = (Point2D) change.getNew();
            str.append(
                "<animate attributeType=\"xml\" begin=\""
                    + change.getStart() / speed
                    + "ms\" dur=\""
                    + (change.getEnd() - change.getStart()) / speed
                    + "ms\" attributeName=\"height\" from=\""
                    + old.getX()
                    + "\" to=\""
                    + neww.getX()
                    + "\" fill=\"freeze\" />\n");
            str.append(
                "<animate attributeType=\"xml\" begin=\""
                    + change.getStart() / speed
                    + "ms\" dur=\""
                    + (change.getEnd() - change.getStart()) / speed
                    + "ms\" attributeName=\"width\" from=\""
                    + old.getY()
                    + "\" to=\""
                    + neww.getY()
                    + "\" fill=\"freeze\" />\n");
          }
        }
        str.append("</rect>\n");
      }
      // Add initial Shape dimensions for Oval.
      else if (each.getShapeType() == ShapeType.OVAL) {
        str.append(
            "<ellipse id=\""
                + each.getName()
                + "\" cx=\""
                + each.getX()
                + "\" cy=\""
                + each.getY()
                + "\" rx=\""
                + each.getWidth()
                + "\" ry=\""
                + each.getLength()
                + "\" fill=\"rgb("
                + each.getColor().getRed()
                + ","
                + each.getColor().getGreen()
                + ","
                + each.getColor().getBlue()
                + ")\" visibility=\"visible\" >\n");
        // Iterate through Bucket
        for (AnimationMotion change : bucket) {
          if (change.getTransformation() == Transformations.MOVE_SHAPE) {
            Point2D old = (Point2D) change.getOld();
            Point2D neww = (Point2D) change.getNew();
            str.append(
                "<animate attributeType=\"xml\" begin=\""
                    + change.getStart() / speed
                    + "ms\" dur=\""
                    + (change.getEnd() - change.getStart()) / speed
                    + "ms\" attributeName=\"cx\" from=\""
                    + old.getX()
                    + "\" to=\""
                    + neww.getX()
                    + "\" fill=\"freeze\" />\n");
            str.append(
                "<animate attributeType=\"xml\" begin=\""
                    + change.getStart() / speed
                    + "ms\" dur=\""
                    + (change.getEnd() - change.getStart()) / speed
                    + "ms\" attributeName=\"cy\" from=\""
                    + old.getY()
                    + "\" to=\""
                    + neww.getY()
                    + "\" fill=\"freeze\" />\n");
          } else if (change.getTransformation() == Transformations.CHANGE_COLOR) {
            Color old = (Color) change.getOld();
            Color neww = (Color) change.getNew();
            str.append(
                "<animate attributeType=\"xml\" begin=\""
                    + change.getStart() / speed
                    + "ms\" dur=\""
                    + (change.getEnd() - change.getStart()) / speed
                    + "ms\" attributeName=\"fill\" from=\"rgb("
                    + old.getRed()
                    + ","
                    + old.getGreen()
                    + ","
                    + old.getBlue()
                    + ")\" to=\"rgb("
                    + neww.getRed()
                    + ","
                    + neww.getGreen()
                    + ","
                    + neww.getBlue()
                    + ")\" fill=\"freeze\" />\n");
          } else if (change.getTransformation() == Transformations.SCALE_SHAPE) {
            Point2D old = (Point2D) change.getOld();
            Point2D neww = (Point2D) change.getNew();
            str.append(
                "<animate attributeType=\"xml\" begin=\""
                    + change.getStart() / speed
                    + "ms\" dur=\""
                    + (change.getEnd() - change.getStart()) / speed
                    + "ms\" attributeName=\"ry\" from=\""
                    + old.getX()
                    + "\" to=\""
                    + neww.getX()
                    + "\" fill=\"freeze\" />\n");
            str.append(
                "<animate attributeType=\"xml\" begin=\""
                    + change.getStart() / speed
                    + "ms\" dur=\""
                    + (change.getEnd() - change.getStart()) / speed
                    + "ms\" attributeName=\"rx\" from=\""
                    + old.getY()
                    + "\" to=\""
                    + neww.getY()
                    + "\" fill=\"freeze\" />\n");
          }
        }
        str.append("</ellipse>\n");
      }
    }
    str.append("</svg>");
    return str.toString();
  }

  @Override
  public Frame getFrame() {
    return null;
  }

  @Override
  public String getViewType() {
    return "svg";
  }

  @Override
  public String getOutputFile() {
    return this.outputFile;
  }

  @Override
  public EasyAnimatorModel getModel() {
    return model;
  }

}
