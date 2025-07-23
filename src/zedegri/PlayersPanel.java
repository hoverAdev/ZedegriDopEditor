package zedegri;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Panel for editing the details of the Player array.
 */
public class PlayersPanel extends JPanel {
    private final List<Player> players;
    private final GridBagLayout layout;

    // Components
    private DefaultListModel<String> listModel;
    private JScrollPane playersListContainer;
    private JList<String> playersList;

    private JButton addPlayerButton;
    private JButton removePlayerButton;

    private JPanel formPanel;

    private JLabel nameLabel;
    private JTextField nameInput;

    private JLabel hpLabel;
    private JSpinner hpInput;

    private JLabel defenseLabel;
    private JSpinner defenseInput;

    private JLabel etherDefenseLabel;
    private JSpinner etherDefenseInput;

    private JLabel speedLabel;
    private JSpinner speedInput;

    private JLabel attackLabel;
    private JSpinner attackInput;

    private JLabel potentialLabel;
    private JSpinner potentialInput;
    
    private JLabel apLabel;
    private JSpinner apInput;

    private JLabel epLabel;
    private JSpinner epInput;

    private JLabel filler;


    /**
     * Instantiate the Players Panel.
     */
    public PlayersPanel() {
        players = new ArrayList<>();
        players.add(new Player());

        layout = new GridBagLayout();
        setLayout(layout);

        initializeComponents();
        initializeLayout();
        initializeEventHandlers();
    }

    /**
     * Create the components of the JPanel.
     */
    private void initializeComponents() {
        // Create components
        createListModel();
        createPlayersList();
        createPlayersListContainer();

        createAddPlayerButton();
        createRemovePlayerButton();

        createFormPanel();

        createNameLabel();
        createNameInput();

        createHpLabel();
        createHpInput();

        createDefenseLabel();
        createDefenseInput();

        createEtherDefenseLabel();
        createEtherDefenseInput();

        createSpeedLabel();
        createSpeedInput();

        createAttackLabel();
        createAttackInput();

        createPotentialLabel();
        createPotentialInput();

        createApLabel();
        createApInput();

        createEpLabel();
        createEpInput();
        
        createFiller();
    }

    private void initializeLayout() {
        // Add components to layout
        add(playersListContainer, createTallConstraints(0, 0, 2, 1));

        add(addPlayerButton, createConstraints(0, 1));
        add(removePlayerButton, createConstraints(1, 1));

        formPanel.add(nameLabel, createConstraints(0, 0));
        formPanel.add(nameInput, createConstraints(1, 0, 3, 1));

        formPanel.add(hpLabel, createConstraints(0, 1));
        formPanel.add(hpInput, createConstraints(1, 1));

        formPanel.add(defenseLabel, createConstraints(0, 2));
        formPanel.add(defenseInput, createConstraints(1, 2));

        formPanel.add(etherDefenseLabel, createConstraints(0, 3));
        formPanel.add(etherDefenseInput, createConstraints(1, 3));

        formPanel.add(speedLabel, createConstraints(0, 4));
        formPanel.add(speedInput, createConstraints(1, 4));

        formPanel.add(attackLabel, createConstraints(2, 1));
        formPanel.add(attackInput, createConstraints(3, 1));

        formPanel.add(potentialLabel, createConstraints(2, 2));
        formPanel.add(potentialInput, createConstraints(3, 2));

        formPanel.add(apLabel, createConstraints(2, 3));
        formPanel.add(apInput, createConstraints(3, 3));

        formPanel.add(epLabel, createConstraints(2, 4));
        formPanel.add(epInput, createConstraints(3, 4));

        GridBagConstraints fillerConstraints = createFillerConstraints();
        formPanel.add(filler, createTallConstraints(0, 5, 4, 1));

        add(formPanel, createTallConstraints(2, 0, 1, 2));
    }

    private void initializeEventHandlers() {
        addPlayerButton.addActionListener(_ -> {
            players.add(new Player());
            listModel.addElement(players.getLast().getName());
        });

        removePlayerButton.addActionListener(
        _ -> {
          int index = playersList.getSelectedIndex();
          if (index >= 0 && players.size() > 1) { // Don't allow user to remove the last element
              listModel.remove(index);
              players.remove(index);
          }
          playersList.setSelectedIndex(0);
        });

        nameInput.getDocument().addDocumentListener(
                new DocumentListener() {
                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        updateName();
                    }

                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        updateName();
                    }

                    @Override
                    public void changedUpdate(DocumentEvent e) {
                        updateName();
                    }

                    private void updateName() {
                        int index = playersList.getSelectedIndex();
                        if(index >= 0) {
                            String name = nameInput.getText().isEmpty() ? " " : nameInput.getText();
                            players.get(index).setName(name);
                            listModel.setElementAt(name, index);
                        }
                    }
                }
        );

        hpInput.addChangeListener(_ -> {
                int index = playersList.getSelectedIndex();
                if(index >= 0) {
                    players.get(index).setHp((int) hpInput.getValue());
                }
        });

        defenseInput.addChangeListener(_ -> {
            int index = playersList.getSelectedIndex();
            if (index >= 0) {
                players.get(index).setHp((int) hpInput.getValue());
            }
        });
    }

    private static GridBagConstraints createFillerConstraints() {
        GridBagConstraints fillerConstraints = new GridBagConstraints();
        fillerConstraints.gridx = 2;
        fillerConstraints.gridy = 100;
        fillerConstraints.weightx = 1.0;
        fillerConstraints.weighty = 1.0;
        fillerConstraints.gridwidth = 4;
        fillerConstraints.gridheight = 1;
        return fillerConstraints;
    }

    private void createListModel() {
        listModel = new DefaultListModel<>();
        listModel.add(0, "None");
    }
    private void createPlayersList() {
        // playersList
        playersList = new JList<>(listModel);
        playersList.setOpaque(true);
        playersList.setBackground(Color.WHITE);
        playersList.setSelectedIndex(0);
    }
    private void createPlayersListContainer() {
        // playersListContainer
        playersListContainer = new JScrollPane(playersList);
        playersListContainer.setOpaque(true);
        playersListContainer.setBackground(Color.BLUE);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;

        layout.setConstraints(playersListContainer, constraints);
    }

    private void createAddPlayerButton() {
        addPlayerButton = new JButton("Add");
    }
    private void createRemovePlayerButton() {
        removePlayerButton = new JButton("Remove");
    }

    private void createFormPanel() {
        formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
    }

    private void createNameLabel() {
        nameLabel = new JLabel("Name:");
        nameLabel.setHorizontalAlignment(JLabel.RIGHT);
    }
    private void createNameInput() {
        nameInput = new JTextField();
        nameInput.setText("None");
    }

    private void createHpLabel() {
        hpLabel = new JLabel("HP:");
        hpLabel.setHorizontalAlignment(JLabel.RIGHT);
    }
    private void createHpInput() {
        hpInput = new JSpinner(getNewNumberModel());
    }

    private void createDefenseLabel() {
        defenseLabel = new JLabel("Defense:");
        defenseLabel.setHorizontalAlignment(JLabel.RIGHT);
    }
    private void createDefenseInput() {
        defenseInput = new JSpinner(getNewNumberModel());
    }

    private void createEtherDefenseLabel() {
        etherDefenseLabel = new JLabel("Ether Defense:");
        etherDefenseLabel.setHorizontalAlignment(JLabel.RIGHT);
    };
    private void createEtherDefenseInput() {
        etherDefenseInput = new JSpinner(getNewNumberModel());
    }

    private void createSpeedLabel() {
        speedLabel = new JLabel("Speed:");
        speedLabel.setHorizontalAlignment(JLabel.RIGHT);
    }
    private void createSpeedInput() {
        speedInput = new JSpinner(getNewNumberModel());
    }

    private void createAttackLabel() {
        attackLabel = new JLabel("Attack:");
        attackLabel.setHorizontalAlignment(JLabel.RIGHT);
    }
    private void createAttackInput() {
        attackInput = new JSpinner(getNewNumberModel());
    }

    private void createPotentialLabel() {
        potentialLabel = new JLabel("Potential:");
        potentialLabel.setHorizontalAlignment(JLabel.RIGHT);
    }
    private void createPotentialInput() {
        potentialInput = new JSpinner(getNewNumberModel());
    }

    private void createApLabel() {
        apLabel = new JLabel("AP:");
        apLabel.setHorizontalAlignment(JLabel.RIGHT);
    }
    private void createApInput() {
        apInput = new JSpinner(getNewNumberModel());
    }

    private void createEpLabel() {
        epLabel = new JLabel("EP:");
        epLabel.setHorizontalAlignment(JLabel.RIGHT);
    }
    private void createEpInput() {
        epInput = new JSpinner(getNewNumberModel());
    }

    private void createFiller() {
        java.net.URL iconSrc = this.getClass().getResource("res/filler.png");
        filler = new JLabel(new ImageIcon(iconSrc));
    }

    private GridBagConstraints createConstraints(int gridX, int gridY, int gridWidth, int gridHeight) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = gridX;
        constraints.gridy = gridY;
        constraints.weightx = 1.0;
        constraints.weighty = 0.0;
        constraints.gridwidth = gridWidth;
        constraints.gridheight = gridHeight;

        return constraints;
    }
    private GridBagConstraints createConstraints(int gridX, int gridY) {
        return createConstraints(gridX, gridY, 1, 1);
    }
    private GridBagConstraints createTallConstraints(int gridX, int gridY, int gridWidth, int gridHeight) {
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

    private SpinnerNumberModel getNewNumberModel() {
        return new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
    }
}
