package cs5004.animator.view;

/**
 * This enumerates all view types we need.
 */
public enum ViewType {
  TEXT, VISUAL, SVG, PLAYBACK;

  /**
   * Given a good string input will provide the corresponding view type. Helps with string parsing
   * for generating view of a particular type.
   *
   * @param type The type of view.
   * @return ViewType corresponding to the string.
   * @throws IllegalArgumentException If the given type is not an existing ViewType
   */
  public static ViewType getType(String type) {
    switch (type.toLowerCase()) {
      case "visual":
        return ViewType.VISUAL;
      case "text":
        return ViewType.TEXT;
      case "svg":
        return ViewType.SVG;
      case "playback":
        return ViewType.PLAYBACK;
      default:
        throw new IllegalArgumentException("given view type does not exist");
    }
  }
}
