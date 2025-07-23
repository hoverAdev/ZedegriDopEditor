package zedegri;

import javax.swing.*;
import java.awt.*;

public class Editor extends JFrame {
    public static void main(String[] args) {
        EventQueue.invokeLater(Editor::new);
    }

    public Editor() {
        String crossPlatformLookAndFeelClassName = UIManager.getCrossPlatformLookAndFeelClassName();
        try {
            UIManager.setLookAndFeel(crossPlatformLookAndFeelClassName);
        } catch (Exception e) {
            throw new RuntimeException(String.format(
                    "Unable to set Cross Platform Look And Feel: %s%n",
                    crossPlatformLookAndFeelClassName
            ), e);
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1080, 720);
        setTitle("Zedegri DOP Editor");

        InitializeComponent();
        setVisible(true);
    }

    private void InitializeComponent() {
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);

        JTabbedPane tabbedPane = new JTabbedPane();

        PlayersPanel playersPanel = new PlayersPanel();

        playersPanel.setBackground(Color.MAGENTA);

        JPanel etherPanel = new JPanel();
        JPanel enemiesPanel = new JPanel();
        JPanel enemyAttacksPanel = new JPanel();

        tabbedPane.addTab("Players", playersPanel);
        tabbedPane.addTab("Ether Arts", etherPanel);
        tabbedPane.addTab("Enemies", enemiesPanel);
        tabbedPane.addTab("Enemy Attacks", enemyAttacksPanel);
        contentPane.add(tabbedPane, BorderLayout.CENTER);
    }
}