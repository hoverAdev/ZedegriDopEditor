package zedegridop;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;

public class GuiFunctions {
    /**
     * Creates a new default GridBagConstraints object.
     *
     * @param gridX The x position of the object.
     * @param gridY The y position of the object.
     * @param gridWidth The number of columns to span.
     * @param gridHeight The number of rows to span.
     * @return A new default GridBagConstraints in the specified position, spanning the specified width and height.
     */
    @Contract(value = "_, _, _, _ -> new", pure = true)
    public static @NotNull GridBagConstraints createConstraints(int gridX, int gridY, int gridWidth, int gridHeight) {
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
    @Contract(value="_, _ -> new", pure = true)
    public static @NotNull GridBagConstraints createConstraints(int gridX, int gridY) {
        return createConstraints(gridX, gridY, 1, 1);
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
    public static @NotNull GridBagConstraints createTallConstraints(int gridX, int gridY, int gridWidth, int gridHeight) {
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
     * Creates a new numeric Spinner Model for positive integers.
     *
     * @param value The default value of the spinner.
     * @return A new SpinnerNumberModel with the specified value.
     */
    @Contract(value = "_ -> new", pure = true)
    public static @NotNull SpinnerNumberModel getNewNumberModel(int value) {
        return new SpinnerNumberModel(value, 0, Integer.MAX_VALUE, 1);
    }
}
