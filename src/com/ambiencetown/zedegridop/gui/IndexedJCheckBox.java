package com.ambiencetown.zedegridop.gui;

import javax.swing.*;

public class IndexedJCheckBox extends JCheckBox {
  private int index;
  private boolean checked;

  public IndexedJCheckBox(int index, String text) {
    super(text, false);
    this.index = index;
  }

  public int getIndex() {
    return index;
  }
}
