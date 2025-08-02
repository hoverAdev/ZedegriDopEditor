package com.ambiencetown.zedegridop.gui;

import com.ambiencetown.zedegridop.model.EffectMultiplier;

import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.event.ChangeListener;
import org.jetbrains.annotations.NotNull;

/**
 * Creates a panel for managing data related to an attack's four effect options.
 */
public class EffectPanel extends JPanel {
  private JLabel multiplierLabel;
  private JComboBox<EffectMultiplier> multiplierInput;

  private JLabel timeLabel;
  private JSpinner timeInput;

  private JLabel chanceLabel;
  private JSpinner chanceInput;

  protected EffectPanel(EffectMultiplier effect, int time, int chance) {
    super();
    setLayout(new GridBagLayout());

    initializeComponents();
    initializeLayout();

    multiplierInput.setSelectedItem(effect);
    timeInput.setValue(time);
    chanceInput.setValue(Math.max(0, Math.min(chance, 100)));
  }

  /**
   * Default constructor with default values
   */
  protected EffectPanel() {
    this(EffectMultiplier.TIMES_05, 0, 0);
  }

  private void initializeComponents() {
    multiplierLabel = GuiFunctions.getRightAlignedLabel("Effect:");
    multiplierInput = new JComboBox<>(EffectMultiplier.values());

    timeLabel = GuiFunctions.getRightAlignedLabel("Time:");
    timeInput = new JSpinner(GuiFunctions.getNewNumberModel(32));

    chanceLabel = GuiFunctions.getRightAlignedLabel("Chance:");
    chanceInput = new JSpinner(GuiFunctions.getNewNumberModel(100));
  }

  private void initializeLayout() {
    add(multiplierLabel, GuiFunctions.createConstraints(0, 0));
    add(multiplierInput, GuiFunctions.createConstraints(1, 0));

    add(timeLabel, GuiFunctions.createConstraints(0, 1));
    add(timeInput, GuiFunctions.createConstraints(1, 1));

    add(chanceLabel, GuiFunctions.createConstraints(0, 2));
    add(chanceInput, GuiFunctions.createConstraints(1, 2));
  }

  /**
   * Sets the effect's multiplier.
   *
   * @param effect The multiplier of the effect.
   */
  protected void setEffect(@NotNull EffectMultiplier effect) {
    multiplierInput.setSelectedItem(effect);
  }

  /** {@return the multiplier of effect} */
  protected EffectMultiplier getEffect() {
    return (EffectMultiplier) multiplierInput.getSelectedItem();
  }

  /**
   * Sets the duration of the effect.
   *
   * @param time the duration of the effect.
   */
  protected void setTime(int time) {
    timeInput.setValue(time);
  }

  /** {@return the duration of the effect} */
  protected int getTime() {
    return (int) timeInput.getValue();
  }

  /**
   * Sets the chance of the effect being inflicted as an integer percentage.
   *
   * @param chance the chance of the effect being inflicted as an integer percentage.
   */
  protected void setChance(int chance) {
    int chanceParsed = Math.max(0, Math.min(chance, 100));
    if (chance != chanceParsed) {
      GuiFunctions.printSwingError("Invalid chance value, clamping to " + chanceParsed + ".", this);
    }
    chanceInput.setValue(chanceParsed);
  }

  /** {@return the chance of the effect being inflicted as an integer percentage.} */
  protected int getChance() {
    return (int) chanceInput.getValue();
  }

  /**
   * Adds an ActionListener to the multiplier input.
   *
   * @param listener The ActionListener to add to the multiplier input.
   * @see JComboBox#addActionListener(ActionListener)
   */
  protected void addMultiplierInputActionListener(ActionListener listener) {
    multiplierInput.addActionListener(listener);
  }

  /**
   * Adds a ChangeListener to the time input.
   *
   * @param listener the ChangeListener to add to the time input.
   * @see JSpinner#addChangeListener(ChangeListener)
   */
  protected void addTimeInputChangeListener(ChangeListener listener) {
    timeInput.addChangeListener(listener);
  }

  protected void addChanceInputChangeListener(ChangeListener listener) {
    chanceInput.addChangeListener(listener);
  }
}
