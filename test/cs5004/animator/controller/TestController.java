package cs5004.animator.controller;

import static org.junit.Assert.assertEquals;

import cs5004.animator.model.EasyAnimatorModel;
import cs5004.animator.model.EasyAnimatorModelImpl;
import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.ViewInterface;
import cs5004.animator.view.ViewSelector;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;


/**
 * This class tests the controller.
 */
public class TestController {

  EasyAnimatorModel model;
  AnimationBuilder<EasyAnimatorModel> builder;
  String filePath;

  /**
   * This sets up the model, the builder, and the filepath that are used to test.
   */
  @Before
  public void init() {
    model = new EasyAnimatorModelImpl();
    builder = new EasyAnimatorModelImpl.BuildTheBuilder(model);
    filePath = new File("").getAbsolutePath();
  }

  /**
   * To test our constructor.
   *
   * @throws IOException when reading is something wrong.
   */
  @Test
  public void testConstructor() throws IOException {
    Readable readable = new FileReader(filePath + "//buildings.txt");
    AnimationReader.parseFile(readable, builder);
    model.setAnimationSpeed(1);
    ViewInterface ourView = ViewSelector.getView(model, "text", "", 1);
    ControllerImpl controller = new ControllerImpl(ourView, model);
    assertEquals(model, controller.getModel());
    assertEquals(1, controller.getModel().getAnimationSpeed(), 0.01);
    assertEquals(0, controller.getTick(), 0.01);
  }

  /**
   * To test TEXT view works well.
   *
   * @throws IOException when reading is something wrong.
   */
  @Test
  public void testGo_Text() throws IOException {
    Readable readable = new FileReader(filePath + "//buildingsTest.txt");
    AnimationReader.parseFile(readable, builder);
    model.setAnimationSpeed(1);
    ViewInterface ourView = ViewSelector.getView(model, "text", "", 1);
    ControllerImpl controller = new ControllerImpl(ourView, model);
    // Copy pasted output from the console for expected value.
    assertEquals(
        "Shapes:\n"
            + "Name: background\n"
            + "Type: rectangle\n"
            + "Min corner: (0.0,0.0), Width: 800.0, Height: 800.0, Color: (33.0,94.0,248.0)\n"
            + "Appears at t=1.0\n"
            + "Disappears at t=50.0\n"
            + "\n"
            + "Name: B0\n"
            + "Type: rectangle\n"
            + "Min corner: (80.0,424.0), Width: 100.0, Height: 326.0, Color: (0.0,0.0,0.0)\n"
            + "Appears at t=1.0\n"
            + "Disappears at t=200.0\n"
            + "\n"
            + "Name: B1\n"
            + "Type: rectangle\n"
            + "Min corner: (260.0,365.0), Width: 100.0, Height: 385.0, Color: (0.0,0.0,0.0)\n"
            + "Appears at t=1.0\n"
            + "Disappears at t=200.0\n"
            + "\n"
            + "Name: window351\n"
            + "Type: rectangle\n"
            + "Min corner: (680.0,-550.0), Width: 20.0, Height: 20.0, Color: (255.0,255.0,255.0)\n"
            + "Appears at t=1.0\n"
            + "Disappears at t=20.0\n"
            + "\n"
            + "Name: window360\n"
            + "Type: rectangle\n"
            + "Min corner: (640.0,-510.0), Width: 20.0, Height: 20.0, Color: (255.0,255.0,255.0)\n"
            + "Appears at t=1.0\n"
            + "Disappears at t=20.0\n"
            + "\n"
            + "Name: moon\n"
            + "Type: oval\n"
            + "Min corner: (200.0,200.0), Width: 100.0, Height: 100.0, Color: (229.0,229.0,255.0)\n"
            + "Appears at t=1.0\n"
            + "Disappears at t=200.0\n"
            + "\n"
            + "Name: eclipse\n"
            + "Type: oval\n"
            + "Min corner: (400.0,0.0), Width: 100.0, Height: 100.0, Color: (33.0,94.0,248.0)\n"
            + "Appears at t=1.0\n"
            + "Disappears at t=50.0\n"
            + "\n"
            + "Name: star0\n"
            + "Type: oval\n"
            + "Min corner: (223.0,66.0), Width: 6.0, Height: 6.0, Color: (255.0,255.0,255.0)\n"
            + "Appears at t=108.0\n"
            + "Disappears at t=200.0\n"
            + "\n"
            + "Name: star1\n"
            + "Type: oval\n"
            + "Min corner: (585.0,211.0), Width: 6.0, Height: 6.0, Color: (255.0,255.0,255.0)\n"
            + "Appears at t=120.0\n"
            + "Disappears at t=200.0\n"
            + "\n"
            + "Name: star2\n"
            + "Type: oval\n"
            + "Min corner: (489.0,77.0), Width: 6.0, Height: 6.0, Color: (255.0,255.0,255.0)\n"
            + "Appears at t=110.0\n"
            + "Disappears at t=200.0\n"
            + "\n"
            + "Shape moon moves from (200.0,200.0) to (200.0,200.0) from time t=1 to t=1\n"
            + "Shape moon moves from (200.0,200.0) to (200.0,200.0) from time t=1 to t=200\n"
            + "Shape background moves from (0.0,0.0) to (0.0,0.0) from time t=1 to t=1\n"
            + "Shape background moves from (0.0,0.0) to (0.0,0.0) from time t=1 to t=50\n"
            + "Shape window360 moves from (640.0,-510.0) to (640.0,-510.0) from time t=1 to t=1\n"
            + "Shape window360 moves from (640.0,-510.0) to (640.0,-510.0) from time t=1 to t=20\n"
            + "Shape B0 moves from (80.0,424.0) to (80.0,424.0) from time t=1 to t=1\n"
            + "Shape B0 moves from (80.0,424.0) to (80.0,424.0) from time t=1 to t=200\n"
            + "Shape B1 moves from (260.0,365.0) to (260.0,365.0) from time t=1 to t=1\n"
            + "Shape B1 moves from (260.0,365.0) to (260.0,365.0) from time t=1 to t=200\n"
            + "Shape window351 moves from (680.0,-550.0) to (680.0,-550.0) from time t=1 to t=1\n"
            + "Shape window351 moves from (680.0,-550.0) to (680.0,-550.0) from time t=1 to t=20\n"
            + "Shape eclipse moves from (400.0,0.0) to (400.0,0.0) from time t=1 to t=1\n"
            + "Shape eclipse moves from (400.0,0.0) to (400.0,0.0) from time t=1 to t=50\n"
            + "Shape star0 moves from (223.0,66.0) to (223.0,66.0) from time t=108 to t=108\n"
            + "Shape star0 moves from (223.0,66.0) to (223.0,66.0) from time t=108 to t=200\n"
            + "Shape star2 moves from (489.0,77.0) to (489.0,77.0) from time t=110 to t=110\n"
            + "Shape star2 moves from (489.0,77.0) to (489.0,77.0) from time t=110 to t=200\n"
            + "Shape star1 moves from (585.0,211.0) to (585.0,211.0) from time t=120 to t=120\n"
            + "Shape star1 moves from (585.0,211.0) to (585.0,211.0) from time t=120 to t=200\n",
        ourView.showView());
  }

  /**
   * To test SVG view works well.
   *
   * @throws IOException when reading is something wrong.
   */
  @Test
  public void testGo_Svg() throws IOException {
    Readable readable = new FileReader(filePath + "//buildingsTest.txt");
    AnimationReader.parseFile(readable, builder);
    model.setAnimationSpeed(1);
    ViewInterface ourView = ViewSelector.getView(model, "svg", "output1.svg", 1);
    ControllerImpl controller = new ControllerImpl(ourView, model);
    // Copy pasted output from the console for expected value.
    assertEquals(
        "<svg width=\"800\" height=\"800\" viewBox=\"0 0 800 800\" version=\"1.1\"\n"
            + "\txmlns=\"http://www.w3.org/2000/svg\">\n"
            + "<rect id=\"background\" x=\"0.0\" y=\"0.0\" width=\"800.0\" height=\"800.0\" "
            + "fill=\"rgb(33,94,248)\" visibility=\"visible\" >\n"
            + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" attributeName=\"x\" "
            + "from=\"0.0\" to=\"0.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" attributeName=\"y\" "
            + "from=\"0.0\" to=\"0.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"4900.0ms\" "
            + "attributeName=\"x\" from=\"0.0\" to=\"0.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"4900.0ms\" "
            + "attributeName=\"y\" from=\"0.0\" to=\"0.0\" fill=\"freeze\" />\n"
            + "</rect>\n"
            + "<rect id=\"B0\" x=\"80.0\" y=\"424.0\" width=\"100.0\" height=\"326.0\" "
            + "fill=\"rgb(0,0,0)\" visibility=\"visible\" >\n"
            + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" "
            + "attributeName=\"x\" from=\"80.0\" to=\"80.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" "
            + "attributeName=\"y\" from=\"424.0\" to=\"424.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"19900.0ms\" "
            + "attributeName=\"x\" from=\"80.0\" to=\"80.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"19900.0ms\" "
            + "attributeName=\"y\" from=\"424.0\" to=\"424.0\" fill=\"freeze\" />\n"
            + "</rect>\n"
            + "<rect id=\"B1\" x=\"260.0\" y=\"365.0\" width=\"100.0\" height=\"385.0\" "
            + "fill=\"rgb(0,0,0)\" visibility=\"visible\" >\n"
            + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" "
            + "attributeName=\"x\" from=\"260.0\" to=\"260.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" "
            + "attributeName=\"y\" from=\"365.0\" to=\"365.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"19900.0ms\" "
            + "attributeName=\"x\" from=\"260.0\" to=\"260.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"19900.0ms\" "
            + "attributeName=\"y\" from=\"365.0\" to=\"365.0\" fill=\"freeze\" />\n"
            + "</rect>\n"
            + "<rect id=\"window351\" x=\"680.0\" y=\"-550.0\" width=\"20.0\" "
            + "height=\"20.0\" fill=\"rgb(255,255,255)\" visibility=\"visible\" >\n"
            + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" "
            + "attributeName=\"x\" from=\"680.0\" to=\"680.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" "
            + "attributeName=\"y\" from=\"-550.0\" to=\"-550.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"1900.0ms\" "
            + "attributeName=\"x\" from=\"680.0\" to=\"680.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"1900.0ms\" "
            + "attributeName=\"y\" from=\"-550.0\" to=\"-550.0\" fill=\"freeze\" />\n"
            + "</rect>\n"
            + "<rect id=\"window360\" x=\"640.0\" y=\"-510.0\" width=\"20.0\" "
            + "height=\"20.0\" fill=\"rgb(255,255,255)\" visibility=\"visible\" >\n"
            + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" "
            + "attributeName=\"x\" from=\"640.0\" to=\"640.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" "
            + "attributeName=\"y\" from=\"-510.0\" to=\"-510.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"1900.0ms\" "
            + "attributeName=\"x\" from=\"640.0\" to=\"640.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"1900.0ms\" "
            + "attributeName=\"y\" from=\"-510.0\" to=\"-510.0\" fill=\"freeze\" />\n"
            + "</rect>\n"
            + "<ellipse id=\"moon\" cx=\"200.0\" cy=\"200.0\" rx=\"100.0\" ry=\"100.0\" "
            + "fill=\"rgb(229,229,255)\" visibility=\"visible\" >\n"
            + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" "
            + "attributeName=\"cx\" from=\"200.0\" to=\"200.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" "
            + "attributeName=\"cy\" from=\"200.0\" to=\"200.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"19900.0ms\" "
            + "attributeName=\"cx\" from=\"200.0\" to=\"200.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"19900.0ms\" "
            + "attributeName=\"cy\" from=\"200.0\" to=\"200.0\" fill=\"freeze\" />\n"
            + "</ellipse>\n"
            + "<ellipse id=\"eclipse\" cx=\"400.0\" cy=\"0.0\" rx=\"100.0\" ry=\"100.0\" "
            + "fill=\"rgb(33,94,248)\" visibility=\"visible\" >\n"
            + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" "
            + "attributeName=\"cx\" from=\"400.0\" to=\"400.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"0.0ms\" "
            + "attributeName=\"cy\" from=\"0.0\" to=\"0.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"4900.0ms\" "
            + "attributeName=\"cx\" from=\"400.0\" to=\"400.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"100.0ms\" dur=\"4900.0ms\" "
            + "attributeName=\"cy\" from=\"0.0\" to=\"0.0\" fill=\"freeze\" />\n"
            + "</ellipse>\n"
            + "<ellipse id=\"star0\" cx=\"223.0\" cy=\"66.0\" rx=\"6.0\" ry=\"6.0\" "
            + "fill=\"rgb(255,255,255)\" visibility=\"visible\" >\n"
            + "<animate attributeType=\"xml\" begin=\"10800.0ms\" dur=\"0.0ms\" "
            + "attributeName=\"cx\" from=\"223.0\" to=\"223.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"10800.0ms\" dur=\"0.0ms\" "
            + "attributeName=\"cy\" from=\"66.0\" to=\"66.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"10800.0ms\" dur=\"9200.0ms\" "
            + "attributeName=\"cx\" from=\"223.0\" to=\"223.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"10800.0ms\" dur=\"9200.0ms\" "
            + "attributeName=\"cy\" from=\"66.0\" to=\"66.0\" fill=\"freeze\" />\n"
            + "</ellipse>\n"
            + "<ellipse id=\"star1\" cx=\"585.0\" cy=\"211.0\" rx=\"6.0\" ry=\"6.0\" "
            + "fill=\"rgb(255,255,255)\" visibility=\"visible\" >\n"
            + "<animate attributeType=\"xml\" begin=\"12000.0ms\" dur=\"0.0ms\" "
            + "attributeName=\"cx\" from=\"585.0\" to=\"585.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"12000.0ms\" dur=\"0.0ms\" "
            + "attributeName=\"cy\" from=\"211.0\" to=\"211.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"12000.0ms\" dur=\"8000.0ms\" "
            + "attributeName=\"cx\" from=\"585.0\" to=\"585.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"12000.0ms\" dur=\"8000.0ms\" "
            + "attributeName=\"cy\" from=\"211.0\" to=\"211.0\" fill=\"freeze\" />\n"
            + "</ellipse>\n"
            + "<ellipse id=\"star2\" cx=\"489.0\" cy=\"77.0\" rx=\"6.0\" ry=\"6.0\" "
            + "fill=\"rgb(255,255,255)\" visibility=\"visible\" >\n"
            + "<animate attributeType=\"xml\" begin=\"11000.0ms\" dur=\"0.0ms\" "
            + "attributeName=\"cx\" from=\"489.0\" to=\"489.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"11000.0ms\" dur=\"0.0ms\" "
            + "attributeName=\"cy\" from=\"77.0\" to=\"77.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"11000.0ms\" dur=\"9000.0ms\" "
            + "attributeName=\"cx\" from=\"489.0\" to=\"489.0\" fill=\"freeze\" />\n"
            + "<animate attributeType=\"xml\" begin=\"11000.0ms\" dur=\"9000.0ms\" "
            + "attributeName=\"cy\" from=\"77.0\" to=\"77.0\" fill=\"freeze\" />\n"
            + "</ellipse>\n"
            + "</svg>",
        ourView.showView());
  }

}
