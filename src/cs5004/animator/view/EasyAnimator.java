package cs5004.animator.view;

import cs5004.animator.controller.ControllerImpl;
import cs5004.animator.model.EasyAnimatorModel;
import cs5004.animator.model.EasyAnimatorModelImpl;
import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * This is the main Entry for the whole project.
 */
public final class EasyAnimator {

  /**
   * This is the main method for the animation that takes in the command line arguments and creates
   * the appropriate model and view. [Details] The main method mainly could be seperated into 3
   * parts.
   *
   * @param args The command line arguments.
   * @throws IOException if there is a compilation error.
   */
  public static void main(String[] args) throws IOException {
    // our model
    EasyAnimatorModel myModel = new EasyAnimatorModelImpl();

    // variables for our command line arguments
    String inputFile = "";
    String outputFile = "";
    double speed = 0;
    String viewType = "";

    try {
      for (int i = 0; i < args.length; i += 2) {
        if (args[i].toLowerCase().equals("-in")) {
          inputFile = args[i + 1];
        } else if (args[i].toLowerCase().equals("-out")) {
          outputFile = args[i + 1];
        } else if (args[i].toLowerCase().equals("-view")) {
          viewType = args[i + 1];
        } else if (args[i].toLowerCase().equals("-speed")) {
          speed = Integer.parseInt(args[i + 1]);
        } else {
          throw new IllegalArgumentException("Wrong with command line!");
        }
      }
    } catch (IndexOutOfBoundsException e) {
      JOptionPane.showMessageDialog(null, "argument error", "Argument Error",
          JOptionPane.ERROR_MESSAGE);

    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(
          null, "Speed err", "Speed err", JOptionPane.ERROR_MESSAGE);

    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "unknown error", "Unknown Error",
          JOptionPane.ERROR_MESSAGE);
    }

    if (inputFile.equalsIgnoreCase("") || !inputFile.contains(".txt")) {
      JOptionPane.showMessageDialog(null, "Input error", "Input Error", JOptionPane.ERROR_MESSAGE);
    }

    try {
      AnimationBuilder<EasyAnimatorModel> builder = new EasyAnimatorModelImpl.BuildTheBuilder(
          myModel);
      String filePath = new File("").getAbsolutePath();
      Readable readable = new FileReader(filePath + "/" + inputFile);
      AnimationReader.parseFile(readable, builder);

    } catch (IllegalStateException e) {
      JOptionPane.showMessageDialog(
          null, e.getMessage(), "Build Read Err", JOptionPane.ERROR_MESSAGE);
    } catch (FileNotFoundException e) {
      JOptionPane.showMessageDialog(
          null, "Build Input Err", "Build Input Err", JOptionPane.ERROR_MESSAGE);
    } catch (IllegalArgumentException e) {
      JOptionPane.showMessageDialog(
          null, e.getMessage(), "Build Args Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
      JOptionPane.showMessageDialog(
          null, e.getMessage(), "Build Unknown Error", JOptionPane.ERROR_MESSAGE);
    }
    if (speed == 0) {
      speed = 1;
    }
    myModel.setAnimationSpeed(speed);
    // Delegating to our view factory.
    ViewInterface ourView = ViewSelector.getView(myModel, viewType, outputFile, speed);
    ControllerImpl controller = new ControllerImpl(ourView, myModel);
    controller.playAnimation();
  }
}
