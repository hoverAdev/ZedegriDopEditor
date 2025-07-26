package com.ambiencetown.zedegridop.gui;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import com.ambiencetown.zedegridop.model.EtherAttack;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.net.URL;
import java.util.List;

public class EthersPanel extends JPanel {
    private final List<EtherAttack> ethers;
    private final ObjectMapper mapper;
    private final GridBagLayout layout;

    // Components
    private JPanel listPanel;
    private DefaultListModel<String> listModel;
    private JScrollPane ethersListContainer;
    private JList<String> ethersList;

    private JButton addEtherButton;
    private JButton removeEtherButton;

    private JPanel formPanel;

    private JLabel filler;

    public EthersPanel(@NotNull List<EtherAttack> ethers, @NotNull ObjectMapper mapper) {
        this.ethers = ethers;
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
        createEthersList();
        createEthersListContainer();

        createAddEtherButton();
        createRemoveEtherButton();

        createFormPanel();
        createFiller();
    }

    private void initializeLayout() {
        // Add components to layout
        //      List of ethers
        listPanel.add(ethersListContainer, GuiFunctions.createTallConstraints(0, 0, 2, 1));

        //      Ether list management
        listPanel.add(addEtherButton, GuiFunctions.createConstraints(0, 1));
        listPanel.add(removeEtherButton, GuiFunctions.createConstraints(1, 1));

        add(listPanel, GuiFunctions.createTallConstraints(0, 0, 1, 1));

        formPanel.add(filler);

        add(formPanel, GuiFunctions.createTallConstraints(1, 0, 1, 1));
    }

    private void createListPanel() {
        listPanel = new JPanel();
        listPanel.setLayout(new GridBagLayout());
        listPanel.setOpaque(false);
        listPanel.setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1), "Ether Attacks"));
    }

    private void createListModel() {
        listModel = new DefaultListModel<>();
        listModel.add(0, "None");
    }
    private void createEthersList() {
            ethersList = new JList<>(listModel);
            ethersList.setOpaque(true);
            ethersList.setBackground(Color.WHITE);
            ethersList.setSelectedIndex(0);
    }
    private void createEthersListContainer() {
        // playersListContainer
        ethersListContainer = new JScrollPane(ethersList);
        ethersListContainer.setOpaque(true);
    }

    private void createAddEtherButton() {
        addEtherButton = new JButton("Add");
    }
    private void createRemoveEtherButton() {
        removeEtherButton = new JButton("Remove");
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
        URL iconSrc = this.getClass().getResource("res/ethers.png");
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
