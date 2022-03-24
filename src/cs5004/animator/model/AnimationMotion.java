package cs5004.animator.model;

/**
 * This interface defines all the method which changes class should implement.
 *
 * @param <T> A few types of transformation class can implement this interface.
 */
public interface AnimationMotion<T> {

  /**
   * This method decides when to execute the change.
   *
   * @param time The time at which we want to execute the change.
   * @return the changed shape.
   */
  Shape executeChange(double time);

  /**
   * This method shows the change in a string form.
   *
   * @param key shape name.
   * @return the change in a string form.
   */
  String stringForm(String key);

  /**
   * This gets the time when the animation should start.
   *
   * @return the start time.
   */
  double getStart();

  /**
   * This gets the time when the animation should stop.
   *
   * @return the stop time.
   */
  double getEnd();


  /**
   * To get the type of transformation.
   *
   * @return the type of transformation.
   */
  Transformations getTransformation();

  /**
   * This method helps us to determine when and where the shape should begin to change.
   *
   * @param time time when the change happens.
   */
  void tweening(double time);

  /**
   * To get the old position.
   *
   * @return old position.
   */
  T getOld();

  /**
   * To get the new position.
   *
   * @return new position.
   */
  T getNew();
}
