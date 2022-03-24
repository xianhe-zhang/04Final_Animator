package cs5004.animator.model;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import org.junit.Before;
import org.junit.Test;

/**
 * This class tests the EasyAnimatorModel class.
 */
public class TestEasyAnimatorModel {

  Shape rectangle1;
  Shape oval1;
  EasyAnimatorModel newAnimation;

  @Before
  public void setUp() {
    rectangle1 = new Rectangle("R1", 0, 0, 4, 7, new Color(200, 100, 60), 10, 100);
    oval1 = new Oval("O1", 2, 3, 7, 3, new Color(1, 15, 10), 50, 120);
    newAnimation = new EasyAnimatorModelImpl();
  }

  /**
   * Test Constructor.
   */
  @Test
  public void testConstructor() {
    assertEquals(-1, newAnimation.getEndTime(), 0.0);
    assertEquals(0, newAnimation.getCanvasHeight());
    assertEquals(0, newAnimation.getCanvasWidth());
    assertEquals(0, newAnimation.getX());
    assertEquals(0, newAnimation.getY());
    assertEquals(0, newAnimation.getAnimations().size());
    assertEquals(0, newAnimation.getShapes().size());
  }

  /**
   * Testing the case in which the shape added is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalAddShape() {
    newAnimation.addShape(null);
  }

  /**
   * Testing a valid addShape method.
   */
  @Test
  public void testAddShape() {
    newAnimation.addShape(rectangle1);
    newAnimation.addShape(oval1);
    assertEquals(
        "Shapes:\n"
            + "Name: R1\n"
            + "Type: rectangle\n"
            + "Min corner: (0.0,0.0), Width: 7.0, Height: 4.0, Color: (200.0,100.0,60.0)\n"
            + "Appears at t=10.0\n"
            + "Disappears at t=100.0\n"
            + "\n"
            + "Name: O1\n"
            + "Type: oval\n"
            + "Min corner: (2.0,3.0), Width: 3.0, Height: 7.0, Color: (1.0,15.0,10.0)\n"
            + "Appears at t=50.0\n"
            + "Disappears at t=120.0\n\n",
        newAnimation.toString());
  }

  /**
   * Testing the case in which we try to remove a null shape.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalRemoveShape() {
    newAnimation.removeShape(null);
  }

  /**
   * Testing a valid remove shape.
   */
  @Test
  public void testLegalRemoveShape() {
    newAnimation.addShape(rectangle1);
    newAnimation.addShape(oval1);
    newAnimation.removeShape(rectangle1.getName());
    assertEquals(
        "Shapes:\n"
            + "Name: O1\n"
            + "Type: oval\n"
            + "Min corner: (2.0,3.0), Width: 3.0, Height: 7.0, Color: (1.0,15.0,10.0)\n"
            + "Appears at t=50.0\n"
            + "Disappears at t=120.0\n"
            + "\n",
        newAnimation.toString());
  }

  /**
   * Testing the case in which the shape passed in is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalMoveShape() {
    newAnimation.moveShape(null, 0, 0, 4, 5);
  }

  /**
   * Testing a legal moveShape.
   */
  @Test
  public void testLegalMoveShape() {
    newAnimation.addShape(rectangle1);
    newAnimation.addShape(oval1);

    assertEquals(0, newAnimation.getAnimations().get(rectangle1.getName()).size());
    newAnimation.moveShape(rectangle1, 4, 8, 30, 60);
    assertEquals(1, newAnimation.getAnimations().get(rectangle1.getName()).size());

    assertEquals(0, newAnimation.getAnimations().get(oval1.getName()).size());
    newAnimation.moveShape(oval1, 2, 2, 51, 100);
    assertEquals(1, newAnimation.getAnimations().get(oval1.getName()).size());
  }


  /**
   * Testing an illegal ColorChange where the shape passed in is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalrecolorShape1() {
    newAnimation.recolorShape(null, 0, 1, 2, 30, 50);
  }

  /**
   * Testing a valid recolorShape.
   */
  @Test
  public void testLegalrecolorShape() {
    newAnimation.addShape(rectangle1);
    newAnimation.addShape(oval1);

    assertEquals(0, newAnimation.getAnimations().get(rectangle1.getName()).size());
    newAnimation.recolorShape(rectangle1, 155, 155, 155, 30, 32);
    assertEquals(1, newAnimation.getAnimations().get(rectangle1.getName()).size());

    assertEquals(0, newAnimation.getAnimations().get(oval1.getName()).size());
    newAnimation.recolorShape(oval1, 2, 10, 15, 70, 90);
    assertEquals(1, newAnimation.getAnimations().get(oval1.getName()).size());
  }

  /**
   * This tests the case in which the shape passed into the second scaleShape method is null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalScaleShape1() {
    newAnimation.resizeShape(null, 1, 3, 30, 40);
  }

  /**
   * Testing legal scale shapes.
   */
  @Test
  public void testLegalScaleShape() {
    newAnimation.addShape(rectangle1);
    newAnimation.addShape(oval1);
    // Scaling a rectangle to another rectangle
    assertEquals(0, newAnimation.getAnimations().get(rectangle1.getName()).size());
    newAnimation.resizeShape(rectangle1, 2, 1, 12, 23);
    assertEquals(1, newAnimation.getAnimations().get(rectangle1.getName()).size());

    // Scaling a rectangle to a square
    newAnimation.resizeShape(rectangle1, 3, 3, 23, 24);
    assertEquals(2, newAnimation.getAnimations().get(rectangle1.getName()).size());

    // Scaling an oval to a circle
    assertEquals(0, newAnimation.getAnimations().get(oval1.getName()).size());
    newAnimation.resizeShape(oval1, 3, 3, 55, 60);
    assertEquals(1, newAnimation.getAnimations().get(oval1.getName()).size());

    // Scaling an oval to another oval
    newAnimation.resizeShape(oval1, 2, 1, 60, 65);
    assertEquals(2, newAnimation.getAnimations().get(oval1.getName()).size());
  }

  /**
   * Testing the toString method.
   */
  @Test
  public void testToString() {
    newAnimation.addShape(rectangle1);
    newAnimation.addShape(oval1);
    assertEquals(
        "Shapes:\n"
            + "Name: R1\n"
            + "Type: rectangle\n"
            + "Min corner: (0.0,0.0), Width: 7.0, Height: 4.0, Color: (200.0,100.0,60.0)\n"
            + "Appears at t=10.0\n"
            + "Disappears at t=100.0\n"
            + "\n"
            + "Name: O1\n"
            + "Type: oval\n"
            + "Min corner: (2.0,3.0), Width: 3.0, Height: 7.0, Color: (1.0,15.0,10.0)\n"
            + "Appears at t=50.0\n"
            + "Disappears at t=120.0\n\n",
        newAnimation.toString());
  }

  /**
   * This tests setting canvas dimensions.
   */
  @Test
  public void testSetCanvasDimensions() {
    newAnimation.setCanvasDimensions(5, 10, 34, 432);
    assertEquals(34, newAnimation.getCanvasHeight());
    assertEquals(432, newAnimation.getCanvasWidth());
    assertEquals(5, newAnimation.getX());
    assertEquals(10, newAnimation.getY());
  }

  /**
   * This tests setting time disappear.
   */
  @Test
  public void testSetTimeDisappear() {
    newAnimation.setEndTime(5);
    assertEquals(5, newAnimation.getEndTime(), 0.01);
  }

  /**
   * This tests getter method for Hashmap.
   */
  @Test
  public void testGetAnimations() {
    newAnimation.addShape(rectangle1);
    newAnimation.addShape(oval1);
    assertEquals(2, newAnimation.getAnimations().size(), 0.0);
  }

  /**
   * This tests getter method for ArrayList.
   */
  @Test
  public void testGetShapes() {
    newAnimation.addShape(rectangle1);
    newAnimation.addShape(oval1);
    assertEquals(2, newAnimation.getShapes().size(), 0.0);
  }

  /**
   * Tests getShapesAtTick(double time) method. Shapes have been declared and mutations are
   * present.
   */
  @Test
  public void testgetShapesAtTick() {
    newAnimation.addShape(rectangle1);
    newAnimation.moveShape(rectangle1, 4, 4, 10, 11);
    newAnimation.moveShape(rectangle1, 4, 4, 15, 19);
    newAnimation.addShape(oval1);
    newAnimation.resizeShape(oval1, 4, 4, 62, 120);
    newAnimation.recolorShape(oval1, 5, 4, 5, 119, 120);
    assertEquals(1, newAnimation.getShapesAtTick(11).size());
    assertEquals("R1", newAnimation.getShapesAtTick(11).get(0).getName());
    assertEquals(1, newAnimation.getShapesAtTick(16).size());
    assertEquals("R1", newAnimation.getShapesAtTick(16).get(0).getName());
    assertEquals(2, newAnimation.getShapesAtTick(119).size());
    assertEquals("O1", newAnimation.getShapesAtTick(119).get(0).getName());
    assertEquals("O1", newAnimation.getShapesAtTick(119).get(1).getName());
  }
}
