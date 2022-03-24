package cs5004.animator.model;

import static org.junit.Assert.assertEquals;

import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationReader;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

/**
 * This class is a test class for the builder that is responsible for populating the model with our
 * Shape objects and their corresponding transformations.
 */
public class TestBuilder {

  Shape rectangle1;
  Shape square1;
  Shape circle1;
  Shape oval1;
  EasyAnimatorModel newAnimation;
  EasyAnimatorModel emptyAnimation;
  AnimationBuilder<EasyAnimatorModel> builder;

  /**
   * This is a setup method. This method gets run everytime a a test method of this class runs its
   * test. It basically "resets" everything and starts from the beginning.
   */
  @Before
  public void setUp() {
    rectangle1 = new Rectangle("R1", 0, 0, 4, 7, new Color(200, 100, 60), 10, 100);
    square1 = new Rectangle("S1", -3, -3, 4, 4, new Color(0, 100, 170), 30, 70);
    circle1 = new Oval("C1", 5, 5, 4, 4, new Color(40, 150, 60), 0, 100);
    oval1 = new Oval("O1", 2, 3, 7, 3, new Color(1, 15, 10), 50, 120);
    newAnimation = new EasyAnimatorModelImpl();
    emptyAnimation = new EasyAnimatorModelImpl();

    builder = new EasyAnimatorModelImpl.BuildTheBuilder(newAnimation);

    // Readable
    // String filePath = new File("").getAbsolutePath();
    // Readable readable = new FileReader(filePath + "/" + "toh-8-Test.txt");
    // Parse File
    // AnimationReader.parseFile(readable, builder);
  }

  /**
   * This method tests the constructor of the model.
   */
  @Test
  public void validModelConstructor() {

    assertEquals("Shapes:\n", newAnimation.toString());
    assertEquals("Shapes:\n", emptyAnimation.toString());
  }

  /**
   * This method tests the build() method of the builder.
   *
   * @throws FileNotFoundException if a file is not found.
   */
  @Test
  public void testBuild() throws FileNotFoundException {

    assertEquals("[]", newAnimation.getShapes().toString());

    String filePath = new File("").getAbsolutePath();
    Readable readable = new FileReader(filePath + "/" + "toh-8-Test.txt");
    AnimationReader.parseFile(readable, builder);

    assertEquals(
        "[\n"
            + "Name: disk1\n"
            + "Type: rectangle\n"
            + "Min corner: (190.0,161.0), Width: 20.0, Height: 11.0, Color: (113.0,87.0,151.0)\n"
            + "Appears at t=1.0\n"
            + "Disappears at t=111.0\n"
            + ", \n"
            + "Name: disk2\n"
            + "Type: rectangle\n"
            + "Min corner: (483.0,238.0), Width: 32.0, Height: 11.0, Color: (35.0,173.0,73.0)\n"
            + "Appears at t=1.0\n"
            + "Disappears at t=207.0\n"
            + ", \n"
            + "Name: disk3\n"
            + "Type: rectangle\n"
            + "Min corner: (477.0,50.0), Width: 45.0, Height: 11.0, Color: (9.0,67.0,130.0)\n"
            + "Appears at t=1.0\n"
            + "Disappears at t=409.0\n"
            + ", \n"
            + "Name: disk4\n"
            + "Type: rectangle\n"
            + "Min corner: (170.0,50.0), Width: 58.0, Height: 11.0, Color: (96.0,198.0,208.0)\n"
            + "Appears at t=1.0\n"
            + "Disappears at t=281.0\n"
            + "]",
        newAnimation.getShapes().toString());
  }

  /**
   * This method tests an invalid file name.
   *
   * @throws FileNotFoundException if a file is not found.
   */
  @Test(expected = FileNotFoundException.class)
  public void testInvalidBuild() throws FileNotFoundException {
    String filePath = new File("").getAbsolutePath();
    Readable newReadable = new FileReader(filePath + "/" + "gibberish.txt");
    AnimationReader.parseFile(newReadable, builder);
  }

  /**
   * This method tests the setBounds() method of the builder.
   *
   * @throws FileNotFoundException if a file is not found.
   */
  @Test
  public void testSetBounds() throws FileNotFoundException {
    String filePath = new File("").getAbsolutePath();
    Readable newReadable = new FileReader(filePath + "/" + "buildingsTest.txt");
    AnimationReader.parseFile(newReadable, builder);

    assertEquals(800, newAnimation.getCanvasHeight());
    assertEquals(800, newAnimation.getCanvasWidth());
    assertEquals(0, newAnimation.getX());
    assertEquals(0, newAnimation.getY());

    builder.setBounds(25, 25, 25, 25);

    assertEquals(25, newAnimation.getCanvasHeight());
    assertEquals(25, newAnimation.getCanvasWidth());
    assertEquals(25, newAnimation.getX());
    assertEquals(25, newAnimation.getY());
  }

  /**
   * This method tests the declareShape() method of the builder.
   *
   * @throws FileNotFoundException if a file is not found.
   */
  @Test
  public void testDeclareShape() {

    assertEquals("[]", newAnimation.getShapes().toString());
    builder.declareShape("FirstRectangle", "Rectangle");
    builder.declareShape("SecondOval", "ellipse");

    Shape newRect = newAnimation.getShapes().get(0);
    Shape newOval = newAnimation.getShapes().get(1);
    assertEquals(ShapeType.RECTANGLE, newRect.getShapeType());
    assertEquals(ShapeType.OVAL, newOval.getShapeType());
  }

  /**
   * To test add motion method.
   */
  @Test
  public void testAddMotion() {

    builder.declareShape("FirstRectangle", "Rectangle");
    builder.declareShape("SecondOval", "ellipse");

    builder.addMotion("FirstRectangle", 1, 2, 3, 4, 5, 6, 7, 8, 9, 20, 25, 19, 34, 11, 78, 100);
    List<AnimationMotion> shapes = newAnimation.getAnimations().get("FirstRectangle");

    AnimationMotion moveShape = shapes.get(0);

    assertEquals(
        "Shape FirstRectangle moves from (2.0,3.0) to (20.0,25.0) from time t=1 to t=9\n",
        moveShape.stringForm("FirstRectangle"));
  }

  /**
   * Testing a valid addShape method.
   */
  @Test
  public void testAddShape() {
    newAnimation.addShape(rectangle1);
    newAnimation.addShape(square1);
    newAnimation.addShape(circle1);
    newAnimation.addShape(oval1);
    assertEquals(
        "Shapes:\n"
            + "Name: R1\n"
            + "Type: rectangle\n"
            + "Min corner: (0.0,0.0), Width: 7.0, Height: 4.0, Color: (200.0,100.0,60.0)\n"
            + "Appears at t=10.0\n"
            + "Disappears at t=100.0\n"
            + "\n"
            + "Name: S1\n"
            + "Type: rectangle\n"
            + "Min corner: (-3.0,-3.0), Width: 4.0, Height: 4.0, Color: (0.0,100.0,170.0)\n"
            + "Appears at t=30.0\n"
            + "Disappears at t=70.0\n"
            + "\n"
            + "Name: C1\n"
            + "Type: oval\n"
            + "Min corner: (5.0,5.0), Width: 4.0, Height: 4.0, Color: (40.0,150.0,60.0)\n"
            + "Appears at t=0.0\n"
            + "Disappears at t=100.0\n"
            + "\n"
            + "Name: O1\n"
            + "Type: oval\n"
            + "Min corner: (2.0,3.0), Width: 3.0, Height: 7.0, Color: (1.0,15.0,10.0)\n"
            + "Appears at t=50.0\n"
            + "Disappears at t=120.0\n\n",
        newAnimation.toString());
  }
}
