package com.ambiencetown.zedegridop.gui;

import java.awt.EventQueue;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/** Functional starting point for the Zedegri DOP graphical editor. */
public class Editor {

  /**
   * Initializes the LookAndFeel and starts the editor.
   *
   * @param args Ignored. Required part of method signature.
   */
  public static void main(String[] args) {
    setLookAndFeel();

    EventQueue.invokeLater(EditorGui::new);
  }

  /** Sets the look and feel for the editor. */
  private static void setLookAndFeel() {
    // LookAndFeel reference
    //    [Metal javax.swing.plaf.metal.MetalLookAndFeel]
    //    [Nimbus javax.swing.plaf.nimbus.NimbusLookAndFeel]
    //    [CDE/Motif com.sun.java.swing.plaf.motif.MotifLookAndFeel]
    //    [Mac OS X com.apple.laf.AquaLookAndFeel]
    //    [Windows com.sun.java.swing.plaf.windows.WindowsLookAndFeel]
    //    [Windows Classic com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel]

    String[] lookAndFeels = {
      "com.apple.laf.AquaLookAndFeel",
      "com.sun.java.swing.plaf.windows.WindowsLookAndFeel",
      "javax.swing.plaf.metal.MetalLookAndFeel",
      "javax.swing.plaf.nimbus.NimbusLookAndFeel",
      "com.sun.java.swing.plaf.motif.MotifLookAndFeel",
    };

    // Set the look and feel
    Exception exception = null;
    for (String lookAndFeel : lookAndFeels) {
      try {
        UIManager.setLookAndFeel(lookAndFeel);
        return;
      } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
               UnsupportedLookAndFeelException e) {
        exception = e;
      }
    }
    throw new RuntimeException("No available LookAndFeels found!", exception);
  }
}
