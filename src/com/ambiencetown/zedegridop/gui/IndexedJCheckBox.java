package com.ambiencetown.zedegridop.gui;

import javax.swing.JCheckBox;

/**
 * JCheckBox with an added index. Can be used to map a checkbox to a corresponding value.
 *
 * @param <T> The index's type.
 */
public class IndexedJCheckBox<T> extends JCheckBox {
  /**
   * The index of the indexed checkbox.
   */
  private final T index;

  /**
   * Constructs a new IndexedJCheckBox.
   *
   * @param index The index of the indexed checkbox.
   * @param text The label of the checkbox.
   */
  public IndexedJCheckBox(T index, String text) {
    super(text, false);
    this.index = index;
  }

  /**
   * {@return the index of the indexed checkbox.}
   */
  public T getIndex() {
    return index;
  }
}
