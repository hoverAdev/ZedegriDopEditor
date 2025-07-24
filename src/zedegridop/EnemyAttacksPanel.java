package zedegridop;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.net.URL;
import java.util.List;

public class EnemyAttacksPanel extends JPanel {
    private final List<EnemyAttack> enemyAttacks;
    private final ObjectMapper mapper;
    private final GridBagLayout layout;

    // Components
    private JPanel listPanel;
    private DefaultListModel<String> listModel;
    private JScrollPane enemyAttacksListContainer;
    private JList<String> enemyAttacksList;

    private JButton addEnemyAttackButton;
    private JButton removeEnemyAttackButton;

    private JPanel formPanel;

    private JLabel filler;

    public EnemyAttacksPanel(@NotNull List<EnemyAttack> enemyAttacks, @NotNull ObjectMapper mapper) {
        this.enemyAttacks = enemyAttacks;
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
        createEnemyAttacksList();
        createEnemyAttacksListContainer();

        createAddEnemyAttackButton();
        createRemoveEnemyAttackButton();

        createFormPanel();
        createFiller();
    }

    private void initializeLayout() {
        // Add components to layout
        //      List of ethers
        listPanel.add(enemyAttacksListContainer, GuiFunctions.createTallConstraints(0, 0, 2, 1));

        //      Ether list management
        listPanel.add(addEnemyAttackButton, GuiFunctions.createConstraints(0, 1));
        listPanel.add(removeEnemyAttackButton, GuiFunctions.createConstraints(1, 1));

        add(listPanel, GuiFunctions.createTallConstraints(0, 0, 1, 1));

        formPanel.add(filler);

        add(formPanel, GuiFunctions.createTallConstraints(1, 0, 1, 1));
    }

    private void createListPanel() {
        listPanel = new JPanel();
        listPanel.setLayout(new GridBagLayout());
        listPanel.setOpaque(false);
        listPanel.setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1), "Enemy Attacks"));
    }

    private void createListModel() {
        listModel = new DefaultListModel<>();
        listModel.add(0, "None");
    }
    private void createEnemyAttacksList() {
        enemyAttacksList = new JList<>(listModel);
        enemyAttacksList.setOpaque(true);
        enemyAttacksList.setBackground(Color.WHITE);
        enemyAttacksList.setSelectedIndex(0);
    }
    private void createEnemyAttacksListContainer() {
        // playersListContainer
        enemyAttacksListContainer = new JScrollPane(enemyAttacksList);
        enemyAttacksListContainer.setOpaque(true);
    }

    private void createAddEnemyAttackButton() {
        addEnemyAttackButton = new JButton("Add");
    }
    private void createRemoveEnemyAttackButton() {
        removeEnemyAttackButton = new JButton("Remove");
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
        URL iconSrc = this.getClass().getResource("res/attacks.png");
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
