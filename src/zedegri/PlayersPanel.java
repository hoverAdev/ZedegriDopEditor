package zedegri;

import javax.swing.*;
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
    private DefaultListModel<Player> listModel;
    private JScrollPane playersListContainer;
    private JList<Player> playersList;

    private GridBagLayout formLayout;
    private JPanel formPanel;

    private JLabel nameLabel;
    private JTextField nameInput;

    private JLabel hpLabel;
    private JSpinner hpInput;

    private JLabel filler;


    /**
     * Instantiate the Players Panel.
     */
    public PlayersPanel() {
        players = new ArrayList<>();
        players.add(new Player());

        layout = new GridBagLayout();
        setLayout(layout);

        initializeComponent();
    }

    /**
     * Create the components of the JPanel.
     */
    private void initializeComponent() {
        // Create components
        createListModel();
        createPlayersList();
        createPlayersListContainer();

        createFormLayout();
        createFormPanel();

        createNameLabel();
        createNameInput();

        createHpLabel();
        createHpInput();
        createFiller();

        // Add components to layout
        add(playersListContainer);

        formPanel.add(nameLabel, createFillConstraints(0, 0));
        formPanel.add(nameInput, createFillConstraints(1, 0));

        formPanel.add(hpLabel, createFillConstraints(0, 1));
        formPanel.add(hpInput, createFillConstraints(1, 1));

        add(formPanel);

        formPanel.add(filler, createFillConstraints(0, 100));
    }

    private void createListModel() {
        listModel = new DefaultListModel<>();
        listModel.addAll(players);
    }
    private void createPlayersList() {
        // playersList
        playersList = new JList<>(listModel);
        playersList.setOpaque(true);
        playersList.setBackground(Color.WHITE);
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
        constraints.weightx = 0.3;
        constraints.weighty = 1.0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;

        layout.setConstraints(playersListContainer, constraints);
    }

    private void createFormLayout() {
        formLayout = new GridBagLayout();
    }
    private void createFormPanel() {
        formPanel = new JPanel();
        formPanel.setLayout(formLayout);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 0.7;
        constraints.weighty = 1.0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;

        layout.setConstraints(formPanel, constraints);
    }

    private void createNameLabel() {
        nameLabel = new JLabel("Name:");
        nameLabel.setHorizontalAlignment(JLabel.RIGHT);
    }
    private void createNameInput() {
        nameInput = new JTextField(32);
    }

    private void createHpLabel() {
        hpLabel = new JLabel("HP:");
        hpLabel.setHorizontalAlignment(JLabel.RIGHT);
    }
    private void createHpInput() {
        SpinnerNumberModel spinnerModel = new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1);
        hpInput = new JSpinner(spinnerModel);
    }

    private void createFiller() {
        java.net.URL iconSrc = this.getClass().getResource("/res/filler.png");
        if (iconSrc == null) {
            filler = new JLabel();
        } else {
            filler = new JLabel(new ImageIcon(iconSrc));
        }
    }

    private GridBagConstraints createFillConstraints(int gridx, int gridy) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridx = gridx;
        constraints.gridy = gridy;
        constraints.weightx = 1.0;
        constraints.weighty = 0.0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;

        return constraints;
    }
}
