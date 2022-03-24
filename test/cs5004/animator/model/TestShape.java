package cs5004.animator.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.awt.Color;
import org.junit.Before;
import org.junit.Test;


/**
 * This class tests the Shape Interface.
 */
public class TestShape {

  final double Delta = 0.001;
  Shape r1;
  Shape o1;
  Shape o2;

  /**
   * This to set up the shape we need to test.
   */
  @Before
  public void setUp() {

    r1 = new Rectangle("rectangle", 0, 0, 5.5, 4.4, new Color(100, 200, 60), 10, 59.1);
    o1 = new Oval("circle", 2, -2, 3.3, 3.1, new Color(110, 100, 180), 20, 60);
    o2 = new Oval("oval", -5, -5, 3.3, 7.3, new Color(150, 30, 190), 5, 60);
  }

  /**
   * Here we are testing the getArea() method defined in the Shape interface.
   */
  @Test
  public void testGetArea() {

    assertEquals(24.200, r1.getArea(), Delta);
    assertEquals(32.138, o1.getArea(), Delta);
    assertEquals(75.681, o2.getArea(), Delta);
  }

  /**
   * Here we are testing the getPerimeter() method defined in the Shape interface.
   */
  @Test
  public void testGetPerimeter() {

    assertEquals(19.8, r1.getPerimeter(), Delta);
    assertEquals(20.734, o1.getPerimeter(), Delta);
    assertEquals(20.734, o2.getPerimeter(), Delta);
  }

  /**
   * Here we are testing the getX() method defined in the Shape interface.
   */
  @Test
  public void testGetX() {
    assertEquals(0, r1.getX(), Delta);
    assertEquals(2, o1.getX(), Delta);
    assertEquals(-5, o2.getX(), Delta);
  }

  /**
   * Here we are testing the getY() method defined in the Shape interface.
   */
  @Test
  public void testGetY() {
    assertEquals(0, r1.getY(), Delta);
    assertEquals(-2, o1.getY(), Delta);
    assertEquals(-5, o2.getY(), Delta);
  }

  /**
   * Here we are testing the getLength() method defined in the Shape interface.
   */
  @Test
  public void testGetLength() {
    assertEquals(5.5, r1.getLength(), Delta);
    assertEquals(3.3, o1.getLength(), Delta);
    assertEquals(3.3, o2.getLength(), Delta);
  }

  /**
   * Here we are testing the getWidth() method defined in the Shape interface.
   */
  @Test
  public void testGetWidth() {
    assertEquals(4.4, r1.getWidth(), Delta);
    assertEquals(3.1, o1.getWidth(), Delta);
    assertEquals(7.3, o2.getWidth(), Delta);
  }

  /**
   * Here we are testing the getColor() method defined in the Shape interface.
   */
  @Test
  public void testGetColor() {

    assertEquals(100.0, r1.getColor().getRed(), Delta);
    assertEquals(200.0, r1.getColor().getGreen(), Delta);
    assertEquals(60.0, r1.getColor().getBlue(), Delta);

    assertEquals(110, o1.getColor().getRed(), Delta);
    assertEquals(100, o1.getColor().getGreen(), Delta);
    assertEquals(180, o1.getColor().getBlue(), Delta);

    assertEquals(150, o2.getColor().getRed(), Delta);
    assertEquals(30, o2.getColor().getGreen(), Delta);
    assertEquals(190, o2.getColor().getBlue(), Delta);
  }

  /**
   * Here we are testing the getTimeAppear() method defined in the Shape interface.
   */
  @Test
  public void testGetTimeAppear() {
    assertEquals(10, r1.getTimeAppear(), Delta);
    assertEquals(20, o1.getTimeAppear(), Delta);
    assertEquals(5, o2.getTimeAppear(), Delta);
  }

  /**
   * Here we are testing the getTimeDisappear() method defined in the Shape interface.
   */
  @Test
  public void testGetTimeDisappear() {
    assertEquals(10, r1.getTimeAppear(), Delta);
    assertEquals(20, o1.getTimeAppear(), Delta);
    assertEquals(5, o2.getTimeAppear(), Delta);
  }

  /**
   * Here we are testing the getName() method defined in the Shape interface.
   */
  @Test
  public void testGetName() {
    assertEquals("rectangle", r1.getName());
    assertEquals("circle", o1.getName());
    assertEquals("oval", o2.getName());
  }

  /**
   * Here we are testing the setNewXY() method defined in the Shape interface.
   */
  @Test
  public void testSetNewXY() {

    r1.setNewXY(5, 5);
    assertEquals(5, r1.getX(), Delta);
    assertEquals(5, r1.getY(), Delta);

    o1.setNewXY(-7, -23);
    assertEquals(-7, o1.getX(), Delta);
    assertEquals(-23, o1.getY(), Delta);

    o2.setNewXY(9, 12);
    assertEquals(9, o2.getX(), Delta);
    assertEquals(12, o2.getY(), Delta);
  }

  /**
   * Here we are testing the setNewColor() method defined in the Shape interface.
   */
  @Test
  public void testSetNewColor() {
    Color newColor = new Color(50, 100, 50);

    r1.setNewColor(newColor);
    o1.setNewColor(newColor);
    o2.setNewColor(newColor);

    assertEquals(50.0, r1.getColor().getRed(), Delta);
    assertEquals(100.0, r1.getColor().getGreen(), Delta);
    assertEquals(50.0, r1.getColor().getBlue(), Delta);

    assertEquals(50.0, o1.getColor().getRed(), Delta);
    assertEquals(100.0, o1.getColor().getGreen(), Delta);
    assertEquals(50.0, o1.getColor().getBlue(), Delta);

    assertEquals(50.0, o2.getColor().getRed(), Delta);
    assertEquals(100.0, o2.getColor().getGreen(), Delta);
    assertEquals(50.0, o2.getColor().getBlue(), Delta);
  }

  /**
   * Here we are testing the setScale() method defined in the Shape interface.
   */
  @Test
  public void testSetScale() {
    double sameSize = 1.0;
    r1.setScale(sameSize);
    o1.setScale(sameSize);
    o2.setScale(sameSize);

    assertEquals(5.5, r1.getLength(), Delta);
    assertEquals(3.3, o1.getLength(), Delta);
    assertEquals(3.3, o2.getLength(), Delta);

    assertEquals(4.4, r1.getWidth(), Delta);
    assertEquals(3.1, o1.getWidth(), Delta);
    assertEquals(7.3, o2.getWidth(), Delta);

    double doubleScale = 2.0;
    r1.setScale(doubleScale);
    o1.setScale(doubleScale);

    assertEquals(11.0, r1.getLength(), Delta);
    assertEquals(8.8, r1.getWidth(), Delta);

    double halfScale = 0.5;
    o2.setScale(halfScale);

    assertEquals(1.65, o2.getLength(), Delta);
    assertEquals(3.65, o2.getWidth(), Delta);

    // scaled to 0---------------
    double zeroScale = 0.0;
    r1.setScale(zeroScale);
    o1.setScale(zeroScale);
    o2.setScale(zeroScale);

    assertEquals(0, r1.getLength(), Delta);
    assertEquals(0, o1.getLength(), Delta);
    assertEquals(0, o2.getLength(), Delta);

    assertEquals(0, r1.getWidth(), Delta);
    assertEquals(0, o1.getWidth(), Delta);
    assertEquals(0, o2.getWidth(), Delta);
  }

  /**
   * Here we are testing the setDimensions() method defined in the Shape interface.
   */
  @Test
  public void testSetDimensions() {

    assertEquals(5.5, r1.getLength(), Delta);
    assertEquals(3.3, o1.getLength(), Delta);
    assertEquals(3.3, o2.getLength(), Delta);

    assertEquals(4.4, r1.getWidth(), Delta);
    assertEquals(3.1, o1.getWidth(), Delta);
    assertEquals(7.3, o2.getWidth(), Delta);

    r1.setDimensions(13, 7);
    o1.setDimensions(4.20, 6.9);
    o2.setDimensions(3.14, 3.14);

    assertEquals(13, r1.getLength(), Delta);
    assertEquals(4.20, o1.getLength(), Delta);
    assertEquals(3.14, o2.getLength(), Delta);

    assertEquals(7, r1.getWidth(), Delta);
    assertEquals(6.9, o1.getWidth(), Delta);
    assertEquals(3.14, o2.getWidth(), Delta);
  }

  /**
   * Here we are testing the cloneShape() method defined in the Shape interface.
   */
  @Test
  public void testCloneShape() {

    Shape r1Clone = r1.cloneShape();
    Shape o1Clone = o1.cloneShape();
    Shape o2Clone = o2.cloneShape();

    assertNotEquals(r1, r1Clone);
    assertNotEquals(o1, o1Clone);
    assertNotEquals(o2, o2Clone);
  }

  /**
   * Here we are testing the toString() method defined in the Shape interface.
   */
  @Test
  public void testToString() {
    assertEquals(
        "\n"
            + "Name: rectangle\n"
            + "Type: rectangle\n"
            + "Min corner: (0.0,0.0), Width: 4.4, Height: 5.5, Color: (100.0,200.0,60.0)\n"
            + "Appears at t=10.0\n"
            + "Disappears at t=59.1\n",
        r1.toString());

    assertEquals(
        "\n"
            + "Name: circle\n"
            + "Type: oval\n"
            + "Min corner: (2.0,-2.0), Width: 3.1, Height: 3.3, Color: (110.0,100.0,180.0)\n"
            + "Appears at t=20.0\n"
            + "Disappears at t=60.0\n",
        o1.toString());
    assertEquals(
        "\n"
            + "Name: oval\n"
            + "Type: oval\n"
            + "Min corner: (-5.0,-5.0), Width: 7.3, Height: 3.3, Color: (150.0,30.0,190.0)\n"
            + "Appears at t=5.0\n"
            + "Disappears at t=60.0\n",
        o2.toString());
  }

  /**
   * Here we are testing an invalid input to the constructor. We are inputting null for the color.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorNullColor() {
    Shape invalidShape = new Rectangle("rectangle", 0, 0, 5.5, 4.4, null, 10, 60.2);
  }

  /**
   * Here we are testing an invalid input to the constructor. We are passing in a negative radius to
   * the initialization of an Oval object.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorNegRadius() {
    Shape invalidShape = new Oval("circle", 7, -10, -4.1, 4.1, new Color(100, 100, 100), 10, 60);
  }

  /**
   * Here we are testing an invalid input to the constructor. We are passing in a negative length to
   * the initialization of a Rectangle object.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorNegLength() {
    Shape invalidShape =
        new Rectangle("rectangle", 0, 0, -5.5, 4.4, new Color(150, 200, 60), 10, 60.2);
  }

  /**
   * Here we are testing an invalid input to the constructor. We are passing in a negative width to
   * the initialization of a Rectangle object.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorNegWidth() {

    Shape invalidShape =
        new Rectangle("rectangle", 0, 0, 5.5, -4.4, new Color(150, 200, 60), 10, 60.2);
  }

  /**
   * Here we are testing an invalid input to the constructor. We are passing in a negative time to
   * appear to the initialization of a Rectangle object.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorNegAppear() {
    Shape invalidShape =
        new Rectangle("rectangle", 0, 0, 5.5, 4.4, new Color(150, 200, 60), -10, 60.2);
  }

  /**
   * Here we are testing an invalid input to the constructor. We are passing in a negative time to
   * disappear to the initialization of a Rectangle object.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructorNegDisappear() {
    Shape invalidShape =
        new Rectangle("rectangle", 0, 0, 5.5, 4.4, new Color(150, 200, 60), 10, -60.2);
  }

  /**
   * Here we are testing an invalid input to the constructor. We are passing in a time to disappear
   * less than time to appear
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor2() {

    // when timeDisappear is less than time appear
    Shape invalidShape =
        new Rectangle("rectangle", 0, 0, 5.5, 4.4, new Color(150, 200, 60), 10, 9.9);
  }

  /**
   * Here we are testing an invalid input to the setScale() method. We are passing negative value to
   * scale down our Shape object.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeSetScale() {
    r1.setScale(-1);
  }

  /**
   * Here we are testing an invalid input to the setDimensions() method. We are passing negative
   * value to newLength argument.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNegativeSetDimensions() {
    r1.setDimensions(-1, 5);
  }
}
