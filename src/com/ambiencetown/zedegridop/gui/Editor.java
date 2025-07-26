package com.ambiencetown.zedegridop.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Functional starting point for the Zedegri DOP graphical editor.
 */
public class Editor extends JFrame {
    /**
     * Initializes the LookAndFeel and starts the editor.
     *
     * @param args Ignored. Required part of method signature.
     */
    public static void main(String[] args) {
        setLookAndFeel();

        EventQueue.invokeLater(EditorGui::new);
    }

    /**
     * Sets the look and feel for the editor.
     */
    private static void setLookAndFeel() {
        // LookAndFeel reference
        //      [Metal javax.swing.plaf.metal.MetalLookAndFeel]
        //      [Nimbus javax.swing.plaf.nimbus.NimbusLookAndFeel]
        //      [Mac OS X com.apple.laf.AquaLookAndFeel]

        String crossPlatformLookAndFeelClassName = UIManager.getCrossPlatformLookAndFeelClassName();
        UIManager.getSystemLookAndFeelClassName();
        try {
            UIManager.setLookAndFeel(crossPlatformLookAndFeelClassName);
        } catch (Exception e) {
            throw new RuntimeException(String.format(
                    "Unable to set Cross Platform Look And Feel: %s%n",
                    crossPlatformLookAndFeelClassName
            ), e);
        }
    }
}