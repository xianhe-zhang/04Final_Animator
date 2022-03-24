package cs5004.animator.model;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.awt.geom.Point2D;
import org.junit.Before;
import org.junit.Test;


/**
 * This class tests the AnimationChanges Interface.
 */
public class TestAnimationMotion {

  Shape shape1;
  Shape shape2;

  /**
   * This set up shapes we are going to test.
   */
  @Before
  public void init() {
    shape1 = new Rectangle("Rect", 3.483, 2.223, 15, 25, new Color(110, 210, 22), 20, 100);
    shape2 = new Oval("Oval", 3, 4, 5, 6, new Color(170, 8, 99), 0, 50);
  }

  /**
   * To test when the new position is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMoveShape_NullNewPos() {
    new MoveShape(null, shape1, 5, 10);
  }

  /**
   * To test the move shape constructor.
   */
  @Test
  public void testValidMoveShapeConstructor() {
    AnimationMotion move = new MoveShape(new Point2D.Double(6, 8), shape1, 10, 25);
    assertEquals(
        "Shape "
            + "Rect"
            + " moves from "
            + "("
            + 3.483
            + ","
            + 2.223
            + ")"
            + " to "
            + "("
            + 6.0
            + ","
            + 8.0
            + ")"
            + " from time t="
            + 10
            + " to t="
            + 25
            + "\n",
        move.stringForm(shape1.getName()));
  }

  /**
   * To test the Execute-Change method.
   */
  @Test
  public void testMoveExecuteChange() {
    AnimationMotion move = new MoveShape(new Point2D.Double(3, 4), shape1, 5, 30);
    move.executeChange(10);
    assertEquals(3.386, shape1.getX(), 0.01);
    assertEquals(2.578, shape1.getY(), 0.01);
    assertEquals(
        "Shape "
            + "Rect"
            + " moves from "
            + "("
            + 3.483
            + ","
            + 2.223
            + ")"
            + " to "
            + "("
            + 3.0
            + ","
            + 4.0
            + ")"
            + " from time t="
            + 5
            + " to t="
            + 30
            + "\n",
        move.stringForm(shape1.getName()));
  }

  /**
   * To test the getStart method.
   */
  @Test
  public void testGetStart() {
    assertEquals(2, new MoveShape(new Point2D.Double(0, 0), shape2, 2, 10).getStart(), 0.01);
  }

  /**
   * To test the getEnd method.
   */
  @Test
  public void testGetEnd() {
    assertEquals(20, new MoveShape(new Point2D.Double(0, 0), shape2, 2, 20).getEnd(), 0.01);
  }

  /**
   * To test the getTransformation method.
   */
  @Test
  public void testGetTransformation() {
    assertEquals(
        Transformations.MOVE_SHAPE,
        new MoveShape(new Point2D.Double(0, 0), shape2, 2, 10).getTransformation());
  }

  /**
   * To test the getOld method.
   */
  @Test
  public void testGetOld() {
    MoveShape obj = new MoveShape(new Point2D.Double(0, 0), shape2, 5, 10);
    assertEquals(3, obj.getOld().getX(), 0.01);
    assertEquals(4.0, obj.getOld().getY(), 0.01);
  }

  /**
   * To test the getNew method.
   */
  @Test
  public void testGetNew_a() {
    MoveShape obj = new MoveShape(new Point2D.Double(0, 1), shape1, 5, 10);
    assertEquals(0, obj.getNew().getX(), 0.01);
    assertEquals(1, obj.getNew().getY(), 0.01);
  }

  /**
   * To test when the new color is null. A thrown exception is expected here.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRecolorShapeConstructor_NullColor() {
    new RecolorShape(null, shape1, 5, 10);
  }

  /**
   * To test the constructor when input color is valid.
   */
  @Test
  public void testValidRecolorShapeConstructor() {
    AnimationMotion recolorShape = new RecolorShape(new Color(10, 20, 30), shape1, 5, 10);
    assertEquals(
        "Shape "
            + "Rect"
            + " changes color from ("
            + 110.0
            + ","
            + 210.0
            + ","
            + 22.0
            + ") to ("
            + 10.0
            + ","
            + 20.0
            + ","
            + 30.0
            + ") from t="
            + 5
            + " to t="
            + 10
            + "\n",
        recolorShape.stringForm(shape1.getName()));
  }

  /**
   * Test Recolor ExecuteChange method.
   */
  @Test
  public void testRecolorShapeExecuteChange() {
    AnimationMotion recolorShape = new RecolorShape(new Color(10, 20, 30), shape1, 5, 10);
    recolorShape.executeChange(8);
    assertEquals(50.0, shape1.getColor().getRed(), 0.01);
    assertEquals(96.0, shape1.getColor().getGreen(), 0.01);
    assertEquals(26, shape1.getColor().getBlue(), 0.01);
    assertEquals(
        "Shape "
            + "Rect"
            + " changes color from ("
            + 110.0
            + ","
            + 210.0
            + ","
            + 22.0
            + ") to ("
            + 10.0
            + ","
            + 20.0
            + ","
            + 30.0
            + ") from t="
            + 5
            + " to t="
            + 10
            + "\n",
        recolorShape.stringForm(shape1.getName()));
  }

  /**
   * To test Resize constructor.
   */
  @Test
  public void testValidResizeShapeConstructor() {
    AnimationMotion resizeShape = new ResizeShape(1.32, 0.001, shape1, 3, 99);
    assertEquals(
        "Shape "
            + "Rect"
            + " scales from Width: "
            + 15.0
            + ", Height: "
            + 25.0
            + " to Width: "
            + 1.32
            + ", Height: "
            + 0.001
            + " from t="
            + 3
            + " to t="
            + 99
            + "\n",
        resizeShape.stringForm(shape1.getName()));
  }

  /**
   * To test Resize ExecuteChange method.
   */
  @Test
  public void testResizeShapeExecuteChange() {
    AnimationMotion resizeShape = new ResizeShape(1.32, 0.001, shape1, 3, 99);

    assertEquals(15.0, shape1.getLength(), 0.01);
    assertEquals(25, shape1.getWidth(), 0.001);
    resizeShape.executeChange(10);
    assertEquals(23.17, shape1.getLength(), 0.01);
    assertEquals(14.00, shape1.getWidth(), 0.01);
    assertEquals(
        "Shape "
            + "Rect"
            + " scales from Width: "
            + 15.0
            + ", Height: "
            + 25.0
            + " to Width: "
            + 1.32
            + ", Height: "
            + 0.001
            + " from t="
            + 3
            + " to t="
            + 99
            + "\n",
        resizeShape.stringForm(shape1.getName()));
  }

}
