package zedegridop;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.net.URL;
import java.util.List;

/**
 * Panel for editing the details of the Player array.
 */
public class PlayersPanel extends JPanel {
    private final List<Player> players;
    private final ObjectMapper mapper;
    private final GridBagLayout layout;

    // Components
    private JPanel listPanel;
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

    private JButton loadFileButton;
    private JButton reloadFileButton;
    private JButton saveAsButton;
    private JButton saveFileButton;


    /**
     * Creates a new PlayerPanel.
     *
     * @param players The list of players to work on and modify.
     */
    public PlayersPanel(@NotNull List<Player> players, @NotNull ObjectMapper mapper) {
        this.players = players;
        this.mapper = mapper;

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
        createListPanel();

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

        createLoadFileButton();
        createReloadFileButton();
        createSaveAsButton();
        createSaveFileButton();
    }

    /**
     * Add the components to the layout.
     */
    private void initializeLayout() {
        // Add components to layout
        //      List of players
        listPanel.add(playersListContainer, GuiFunctions.createTallConstraints(0, 0, 2, 1));

        //      Player list management
        listPanel.add(addPlayerButton, GuiFunctions.createConstraints(0, 1));
        listPanel.add(removePlayerButton, GuiFunctions.createConstraints(1, 1));

        add(listPanel, GuiFunctions.createTallConstraints(0, 0, 1, 1));

        //      Name field
        formPanel.add(nameLabel, GuiFunctions.createConstraints(0, 0));
        formPanel.add(nameInput, GuiFunctions.createConstraints(1, 0, 3, 1));

        //      HP field
        formPanel.add(hpLabel, GuiFunctions.createConstraints(0, 1));
        formPanel.add(hpInput, GuiFunctions.createConstraints(1, 1));

        //      Defense field
        formPanel.add(defenseLabel, GuiFunctions.createConstraints(0, 2));
        formPanel.add(defenseInput, GuiFunctions.createConstraints(1, 2));

        //      Ether defense field
        formPanel.add(etherDefenseLabel, GuiFunctions.createConstraints(0, 3));
        formPanel.add(etherDefenseInput, GuiFunctions.createConstraints(1, 3));

        //      Speed field
        formPanel.add(speedLabel, GuiFunctions.createConstraints(0, 4));
        formPanel.add(speedInput, GuiFunctions.createConstraints(1, 4));

        //      Attack field
        formPanel.add(attackLabel, GuiFunctions.createConstraints(2, 1));
        formPanel.add(attackInput, GuiFunctions.createConstraints(3, 1));

        //      Potential field
        formPanel.add(potentialLabel, GuiFunctions.createConstraints(2, 2));
        formPanel.add(potentialInput, GuiFunctions.createConstraints(3, 2));

        //      AP field
        formPanel.add(apLabel, GuiFunctions.createConstraints(2, 3));
        formPanel.add(apInput, GuiFunctions.createConstraints(3, 3));

        //      EP field
        formPanel.add(epLabel, GuiFunctions.createConstraints(2, 4));
        formPanel.add(epInput, GuiFunctions.createConstraints(3, 4));

        formPanel.add(filler, GuiFunctions.createTallConstraints(0, 5, 4, 1));

        formPanel.add(loadFileButton, GuiFunctions.createConstraints(0, 6, 1, 1));
        formPanel.add(reloadFileButton, GuiFunctions.createConstraints(1, 6, 1, 1));
        formPanel.add(saveAsButton, GuiFunctions.createConstraints(2, 6, 1, 1));
        formPanel.add(saveFileButton, GuiFunctions.createConstraints(3, 6, 1, 1));

        add(formPanel, GuiFunctions.createTallConstraints(1, 0, 1, 1));
    }

    /**
     * Add the scripts for each element.
     */
    private void initializeEventHandlers() {
        playersList.addListSelectionListener(_ -> {
            int index = playersList.getSelectedIndex();
            if (index >= 0) {
                nameInput.setText(players.get(index).getName());
                hpInput.setValue(players.get(index).getHp());
                defenseInput.setValue(players.get(index).getDef());
                etherDefenseInput.setValue(players.get(index).getEtherDefense());
                speedInput.setValue(players.get(index).getSpeed());
                attackInput.setValue(players.get(index).getAttack());
                potentialInput.setValue(players.get(index).getPotential());
                apInput.setValue(players.get(index).getAp());
                epInput.setValue(players.get(index).getEp());
            }
        });

        addPlayerButton.addActionListener(_ -> {
            players.add(new Player());
            listModel.addElement(players.getLast().getName());
            playersList.setSelectedIndex(listModel.getSize() - 1);
        });

        removePlayerButton.addActionListener(
        _ -> {
          int index = playersList.getSelectedIndex();
          if (index >= 0 && players.size() > 1) { // Don't allow user to remove the last element
              listModel.remove(index);
              players.remove(index);
          }
          if(index < listModel.size()){
            playersList.setSelectedIndex(index);
          }
          else {
              playersList.setSelectedIndex(listModel.size() - 1);
          }
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

                    /**
                     * Update the name of the currently selected player according to user input in the players list
                     * as well as in the JList of players.
                     */
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
                players.get(index).setDef((int) defenseInput.getValue());
            }
        });

        etherDefenseInput.addChangeListener(_ -> {
            int index = playersList.getSelectedIndex();
            if (index >= 0) {
                players.get(index).setEtherDefense((int) etherDefenseInput.getValue());
            }
        });

        speedInput.addChangeListener(_ -> {
            int index = playersList.getSelectedIndex();
            if (index >= 0) {
                players.get(index).setSpeed((int) speedInput.getValue());
            }
        });

        attackInput.addChangeListener(_ -> {
            int index = playersList.getSelectedIndex();
            if (index >= 0) {
                players.get(index).setAttack(((int) attackInput.getValue()));
            }
        });

        potentialInput.addChangeListener(_ -> {
            int index = playersList.getSelectedIndex();
            if (index >= 0) {
                players.get(index).setPotential((int) potentialInput.getValue());
            }
        });

        apInput.addChangeListener(_ -> {
            int index = playersList.getSelectedIndex();
            if (index >= 0) {
                players.get(index).setAp(((int) apInput.getValue()));
            }
        });

        epInput.addChangeListener(_ -> {
            int index = playersList.getSelectedIndex();
            if (index >= 0) {
                players.get(index).setEp(((int) epInput.getValue()));
            }
        });
    }

    private void createListPanel() {
        listPanel = new JPanel();
        listPanel.setLayout(new GridBagLayout());
        listPanel.setOpaque(false);
        listPanel.setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1), "Players"));
    }

    private void createListModel() {
        listModel = new DefaultListModel<>();
        listModel.add(0, "None");
    }
    private void createPlayersList() {
        playersList = new JList<>(listModel);
        playersList.setOpaque(true);
        playersList.setBackground(Color.WHITE);
        playersList.setSelectedIndex(0);
    }
    private void createPlayersListContainer() {
        // playersListContainer
        playersListContainer = new JScrollPane(playersList);
        playersListContainer.setOpaque(true);
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
        formPanel.setOpaque(false);
        formPanel.setBorder(new EmptyBorder(3, 3, 5, 3));
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
        hpInput = new JSpinner(GuiFunctions.getNewNumberModel(0));
        hpInput.setOpaque(false);
    }

    private void createDefenseLabel() {
        defenseLabel = new JLabel("Defense:");
        defenseLabel.setHorizontalAlignment(JLabel.RIGHT);
    }
    private void createDefenseInput() {
        defenseInput = new JSpinner(GuiFunctions.getNewNumberModel(0));
        defenseInput.setOpaque(false);
    }

    private void createEtherDefenseLabel() {
        etherDefenseLabel = new JLabel("Ether Defense:");
        etherDefenseLabel.setHorizontalAlignment(JLabel.RIGHT);
    }
    private void createEtherDefenseInput() {
        etherDefenseInput = new JSpinner(GuiFunctions.getNewNumberModel(0));
        etherDefenseInput.setOpaque(false);
    }

    private void createSpeedLabel() {
        speedLabel = new JLabel("Speed:");
        speedLabel.setHorizontalAlignment(JLabel.RIGHT);
    }
    private void createSpeedInput() {
        speedInput = new JSpinner(GuiFunctions.getNewNumberModel(255));
        speedInput.setOpaque(false);
    }

    private void createAttackLabel() {
        attackLabel = new JLabel("Attack:");
        attackLabel.setHorizontalAlignment(JLabel.RIGHT);
    }
    private void createAttackInput() {
        attackInput = new JSpinner(GuiFunctions.getNewNumberModel(0));
        attackInput.setOpaque(false);
    }

    private void createPotentialLabel() {
        potentialLabel = new JLabel("Potential:");
        potentialLabel.setHorizontalAlignment(JLabel.RIGHT);
    }
    private void createPotentialInput() {
        potentialInput = new JSpinner(GuiFunctions.getNewNumberModel(0));
        potentialInput.setOpaque(false);
    }

    private void createApLabel() {
        apLabel = new JLabel("AP:");
        apLabel.setHorizontalAlignment(JLabel.RIGHT);
    }
    private void createApInput() {
        apInput = new JSpinner(GuiFunctions.getNewNumberModel(0));
        apInput.setOpaque(false);
    }

    private void createEpLabel() {
        epLabel = new JLabel("EP:");
        epLabel.setHorizontalAlignment(JLabel.RIGHT);
    }
    private void createEpInput() {
        epInput = new JSpinner(GuiFunctions.getNewNumberModel(0));
        epInput.setOpaque(false);
    }

    /**
     * Creates an image icon to fill the empty space.
     */
    private void createFiller() {
        URL iconSrc = this.getClass().getResource("res/players.png");
        if (iconSrc != null) {
            filler = new JLabel(new ImageIcon(iconSrc));
        }
        else {
            filler = new JLabel("Filler");
        }
        filler.setHorizontalAlignment(JLabel.CENTER);
        filler.setVerticalAlignment(JLabel.CENTER);
    }

    private void createLoadFileButton() {
        loadFileButton = new JButton("Load file...");
    }
    private void createReloadFileButton() {
        reloadFileButton = new JButton("Load file");
        reloadFileButton.setEnabled(false);
    }
    private void createSaveAsButton() {
        saveAsButton = new JButton("Save as...");
    }
    private void createSaveFileButton() {
        saveFileButton = new JButton("Save file");
        saveFileButton.setEnabled(false);
    }


}
