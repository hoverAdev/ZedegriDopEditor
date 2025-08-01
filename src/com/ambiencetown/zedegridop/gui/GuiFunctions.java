package com.ambiencetown.zedegridop.gui;

import java.awt.*;
import javax.swing.*;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Utility class for common Swing functions.
 *
 * @author Serenity Montgomery
 */
public class GuiFunctions {
  /**
   * Creates a new default GridBagConstraints object.
   *
   * @param gridX The x position of the object.
   * @param gridY The y position of the object.
   * @param gridWidth The number of columns to span.
   * @param gridHeight The number of rows to span.
   * @return A new default GridBagConstraints in the specified position, spanning the specified
   *     width and height.
   */
  @Contract(value = "_, _, _, _ -> new", pure = true)
  public static @NotNull GridBagConstraints createConstraints(
      int gridX, int gridY, int gridWidth, int gridHeight) {
    GridBagConstraints constraints = new GridBagConstraints();
    constraints.fill = GridBagConstraints.HORIZONTAL;
    constraints.gridx = gridX;
    constraints.gridy = gridY;
    constraints.weightx = 1.0;
    constraints.weighty = 0.0;
    constraints.gridwidth = gridWidth;
    constraints.gridheight = gridHeight;
    constraints.insets = new Insets(3, 3, 3, 3);

    return constraints;
  }

  /**
   * Creates a new default GridBagConstraints object.
   *
   * @param gridX The x position of the object.
   * @param gridY The y position of the object.
   * @return A new default GridBagConstraints in the specified position.
   */
  @Contract(value = "_, _ -> new", pure = true)
  public static @NotNull GridBagConstraints createConstraints(int gridX, int gridY) {
    return createConstraints(gridX, gridY, 1, 1);
  }

  /**
   *
   */
  public static @NotNull JLabel getRightAlignedLabel(String text) {
    JLabel label = new JLabel(text);
    label.setHorizontalAlignment(JLabel.RIGHT);
    return label;
  }
  /**
   * Creates a new GridBagConstraints that is greedy about height.
   *
   * @param gridX The x position of the object.
   * @param gridY The y position of the object.
   * @param gridWidth The number of columns to span.
   * @param gridHeight The number of rows to span.
   * @return A new height-greedy GridBagConstraints of the specified position, width, and height.
   */
  @Contract(value = "_, _, _, _ -> new", pure = true)
  public static @NotNull GridBagConstraints createTallConstraints(
      int gridX, int gridY, int gridWidth, int gridHeight) {
    GridBagConstraints constraints = new GridBagConstraints();
    constraints.fill = GridBagConstraints.BOTH;
    constraints.gridx = gridX;
    constraints.gridy = gridY;
    constraints.weightx = 1.0;
    constraints.weighty = 1.0;
    constraints.gridwidth = gridWidth;
    constraints.gridheight = gridHeight;

    return constraints;
  }

  /**
   * Creates a new numeric Spinner Model for positive integers bound by an upper limit.
   *
   * @param max The maximum value of the spinner.
   * @return A new {@code SpinnerNumberModel} with the specified maximum.
   */
  @Contract(value = "_ -> new", pure = true)
  public static @NotNull SpinnerNumberModel getNewNumberModel(int max) {
    return getNewNumberModel(max, 0);
  }

  /**
   * Creates a new numeric Spinner model for positive integers bound by an upper limit.
   *
   * @param max The upper limit of the Spinner.
   * @param value The default value of the Spinner.
   * @return A new {@code SpinnerNumberModel} with the specified maximum and value.
   */
  @Contract(value = "_, _ -> new", pure = true)
  public static @NotNull SpinnerNumberModel getNewNumberModel(int max, int value) {
    return getNewNumberModel(0, max, value);
  }

  /**
   * Creates a new numeric Spinner model for integers bound by lower and upper limits.
   *
   * @param min the lower limit of the Spinner.
   * @param max the upper limit of the Spinner.
   * @param value the default value of the Spinner.
   * @return A new {@code SpinnerNumberModel} with the specified bounds and value.
   */
  @Contract(value = "_, _, _ -> new", pure = true)
  public static @NotNull SpinnerNumberModel getNewNumberModel(int min, int max, int value) {
    return new SpinnerNumberModel(value, min, max, 1);
  }

  /**
   * Prints a new Swing warning message. Should be used instead of throwing errors when possible.
   *
   * @param message The warning message to display.
   * @param parent The parent component of the warning dialog.
   */
  public static void printSwingError(String message, JComponent parent) {
    JOptionPane.showMessageDialog(parent, message, "Warning!", JOptionPane.WARNING_MESSAGE);
  }
}
