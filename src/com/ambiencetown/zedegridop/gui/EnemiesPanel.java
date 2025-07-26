package com.ambiencetown.zedegridop.gui;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import com.ambiencetown.zedegridop.model.Enemy;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.net.URL;
import java.util.List;

public class EnemiesPanel extends JPanel {
    private final List<Enemy> enemies;
    private final ObjectMapper mapper;
    private final GridBagLayout layout;

    // Components
    private JPanel listPanel;
    private DefaultListModel<String> listModel;
    private JScrollPane enemiesListContainer;
    private JList<String> enemiesList;

    private JButton addEnemyButton;
    private JButton removeEnemyButton;

    private JPanel formPanel;

    private JLabel filler;

    public EnemiesPanel(@NotNull List<Enemy> enemies, @NotNull ObjectMapper mapper) {
        this.enemies = enemies;
        this.mapper = mapper;

        this.layout = new GridBagLayout();
        setLayout(layout);

        initializeComponents();
        initializeLayout();
    }

    private void initializeComponents() {
        // Create components
        createListPanel();
        createListModel();
        createEnemiesList();
        createEnemiesListContainer();

        createAddEnemyButton();
        createRemoveEnemyButton();

        createFormPanel();
        createFiller();
    }

    private void initializeLayout() {
        // Add components to layout
        //      List of enemies
        listPanel.add(enemiesListContainer, GuiFunctions.createTallConstraints(0, 0, 2, 1));

        //      Enemy list management
        listPanel.add(addEnemyButton, GuiFunctions.createConstraints(0, 1));
        listPanel.add(removeEnemyButton, GuiFunctions.createConstraints(1, 1));

        add(listPanel, GuiFunctions.createTallConstraints(0, 0, 1, 1));

        formPanel.add(filler);

        add(formPanel, GuiFunctions.createTallConstraints(1, 0, 1, 1));
    }

    private void createListPanel() {
        listPanel = new JPanel();
        listPanel.setLayout(new GridBagLayout());
        listPanel.setOpaque(false);
        listPanel.setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1), "Enemies"));
    }

    private void createListModel() {
        listModel = new DefaultListModel<>();
        listModel.add(0, "None");
    }
    private void createEnemiesList() {
        enemiesList = new JList<>(listModel);
        enemiesList.setOpaque(true);
        enemiesList.setBackground(Color.WHITE);
        enemiesList.setSelectedIndex(0);
    }
    private void createEnemiesListContainer() {
        // playersListContainer
        enemiesListContainer = new JScrollPane(enemiesList);
        enemiesListContainer.setOpaque(true);
    }

    private void createAddEnemyButton() {
        addEnemyButton = new JButton("Add");
    }
    private void createRemoveEnemyButton() {
        removeEnemyButton = new JButton("Remove");
    }

    private void createFormPanel() {
        formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        formPanel.setOpaque(false);
        formPanel.setBorder(new EmptyBorder(3, 3, 5, 3));
    }

    /**
     * Creates an image icon to fill the empty space.
     */
    private void createFiller() {
        URL iconSrc = this.getClass().getResource("res/enemies.png");
        if (iconSrc != null) {
            filler = new JLabel(new ImageIcon(iconSrc));
        }
        else {
            filler = new JLabel("Filler");
        }
        filler.setHorizontalAlignment(JLabel.CENTER);
        filler.setVerticalAlignment(JLabel.CENTER);
    }

}
