package zedegridop;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Editor extends JFrame {
    /**
     * Starts the editor.
     *
     * @param args Ignored. Required part of method signature.
     */
    public static void main(String[] args) {
        File file = new File(".");
        System.out.println(file.getAbsolutePath());

        //setLookAndFeel();
        EventQueue.invokeLater(EditorGui::new);
    }

    private static void setLookAndFeel() {
        String crossPlatformLookAndFeelClassName = UIManager.getCrossPlatformLookAndFeelClassName();
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