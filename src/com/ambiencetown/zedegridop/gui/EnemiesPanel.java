package com.ambiencetown.zedegridop.gui;

import com.ambiencetown.zedegridop.model.Enemy;
import com.ambiencetown.zedegridop.model.EnemyAttack;
import com.ambiencetown.zedegridop.model.EnemyType;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jetbrains.annotations.NotNull;

/**
 * JPanel for editing the details of the Enemies array.
 *
 * @author Serenity Montgomery
 */
public class EnemiesPanel extends JPanel {
  private final List<Enemy> enemies;
  private final ObjectMapper mapper;

  private File loadedFile;
  private File savedFile;

  /* Swing components. Stored as fields in order to make access possible within private methods. */
  private JFileChooser saveFileDialog;
  private JFileChooser openFileDialog;

  private JPanel listPanel;
  private DefaultListModel<String> listModel;
  private JScrollPane enemiesListContainer;
  private JList<String> enemiesList;

  private JButton addEnemyButton;
  private JButton removeEnemyButton;

  private JPanel formPanel;

  private JLabel nameLabel;
  private JTextField nameInput;

  private JLabel typeLabel;
  private JComboBox<EnemyType> typeInput;

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

  private final List<EnemyAttack> enemyAttacks;
  private JScrollPane attacksListContainer;
  private JPanel attacksListPanel;

  private JPanel filler;

  private JButton saveAsButton;
  private JButton saveFileButton;
  private JButton loadFileButton;
  private JButton reloadFileButton;

  /**
   * Creates a new EnemiesPanel.
   *
   * @param enemies The list of enemies to work on and modify.
   * @param enemyAttacks the list of attacks. Required to update the list of shown attacks.
   * @param mapper The ObjectMapper used for reading and writing JSON data.
   */
  protected EnemiesPanel(
      @NotNull List<Enemy> enemies,
      @NotNull List<EnemyAttack> enemyAttacks,
      @NotNull ObjectMapper mapper) {
    this.enemies = enemies;
    if (enemies.isEmpty()) {
      System.err.println("Empty enemies list provided to EnemiesPanel. A new enemy will be added.");
      enemies.add(new Enemy());
    }

    this.enemyAttacks = enemyAttacks;

    this.mapper = mapper;

    setLayout(new BorderLayout());

    initializeComponents();
    initializeLayout();
    initializeEventHandlers();

    enemiesList.setSelectedIndex(0);
  }

  private void initializeComponents() {
    createSaveFileDialog();
    createOpenFileDialog();

    // Create components
    createListPanel();
    createListModel();
    createEnemiesList();
    createEnemiesListContainer();

    createAddEnemyButton();
    createRemoveEnemyButton();

    createFormPanel();

    createNameLabel();
    createNameInput();

    createTypeLabel();
    createTypeInput();

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

    createAttacksListPanel();
    createAttacksListContainer();

    createFiller();

    createSaveAsButton();
    createSaveFileButton();
    createLoadFileButton();
    createReloadFileButton();
  }

  private void initializeLayout() {
    // Add components to layout
    //      List of enemies
    listPanel.add(enemiesListContainer, GuiFunctions.createTallConstraints(0, 0, 2, 1));

    //      Enemy list management
    listPanel.add(addEnemyButton, GuiFunctions.createConstraints(0, 1));
    listPanel.add(removeEnemyButton, GuiFunctions.createConstraints(1, 1));

    add(listPanel, BorderLayout.WEST);

    //      Form inputs
    formPanel.add(nameLabel, GuiFunctions.createConstraints(0, 0));
    formPanel.add(nameInput, GuiFunctions.createConstraints(1, 0, 3, 1));

    formPanel.add(typeLabel, GuiFunctions.createConstraints(0, 1));
    formPanel.add(typeInput, GuiFunctions.createConstraints(1, 1));

    formPanel.add(hpLabel, GuiFunctions.createConstraints(0, 2));
    formPanel.add(hpInput, GuiFunctions.createConstraints(1, 2));

    formPanel.add(defenseLabel, GuiFunctions.createConstraints(0, 3));
    formPanel.add(defenseInput, GuiFunctions.createConstraints(1, 3));

    formPanel.add(etherDefenseLabel, GuiFunctions.createConstraints(0, 4));
    formPanel.add(etherDefenseInput, GuiFunctions.createConstraints(1, 4));

    formPanel.add(speedLabel, GuiFunctions.createConstraints(0, 5));
    formPanel.add(speedInput, GuiFunctions.createConstraints(1, 5));

    formPanel.add(attackLabel, GuiFunctions.createConstraints(0, 6));
    formPanel.add(attackInput, GuiFunctions.createConstraints(1, 6));

    formPanel.add(potentialLabel, GuiFunctions.createConstraints(0, 7));
    formPanel.add(potentialInput, GuiFunctions.createConstraints(1, 7));

    formPanel.add(attacksListContainer, GuiFunctions.createTallConstraints(2, 1, 2, 8));

    formPanel.add(filler, GuiFunctions.createTallConstraints(0, 8, 2, 1));

    formPanel.add(saveAsButton, GuiFunctions.createConstraints(0, 9, 1, 1));
    formPanel.add(saveFileButton, GuiFunctions.createConstraints(1, 9, 1, 1));
    formPanel.add(loadFileButton, GuiFunctions.createConstraints(2, 9, 1, 1));
    formPanel.add(reloadFileButton, GuiFunctions.createConstraints(3, 9, 1, 1));

    add(formPanel, BorderLayout.CENTER);
  }

  private void initializeEventHandlers() {
    enemiesList.addListSelectionListener(
        _ -> {
          int index = enemiesList.getSelectedIndex();
          if (index >= 0) {
            Enemy enemy = enemies.get(index);

            nameInput.setText(enemy.getName());
            typeInput.setSelectedItem(enemy.getType());
            hpInput.setValue(enemy.getHp());
            defenseInput.setValue(enemy.getDefense());
            etherDefenseInput.setValue(enemy.getEtherDefense());
            speedInput.setValue(enemy.getSpeed());
            attackInput.setValue(enemy.getAttack());
            potentialInput.setValue(enemy.getPotential());

            buildAttacksList(enemy.getAttacks());
          }
        });

    addEnemyButton.addActionListener(
        _ -> {
          enemies.add(new Enemy());
          listModel.addElement(enemies.getLast().getName());
          enemiesList.setSelectedIndex(listModel.getSize() - 1);
        });

    removeEnemyButton.addActionListener(
        _ -> {
          int index = enemiesList.getSelectedIndex();
          if (index >= 0 && enemies.size() > 1) { // Don't allow user to remove the last element
            listModel.remove(index);
            enemies.remove(index);
          }
          if (index < listModel.size()) {
            enemiesList.setSelectedIndex(index);
          } else {
            enemiesList.setSelectedIndex(listModel.size() - 1);
          }
        });

    nameInput
        .getDocument()
        .addDocumentListener(
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
                int index = enemiesList.getSelectedIndex();
                if (index >= 0) {
                  String name = nameInput.getText().isEmpty() ? " " : nameInput.getText();
                  enemies.get(index).setName(name);
                  listModel.setElementAt(name, index);
                }
              }
            });

    typeInput.addActionListener(_ -> {
      int index = enemiesList.getSelectedIndex();
      if (index >= 0) {
        EnemyType type = (EnemyType) typeInput.getSelectedItem();
        if (type != null){
        enemies.get(index).setType(type);}
      }
    });

    hpInput.addChangeListener(_ -> {
      int index = enemiesList.getSelectedIndex();
      if (index >= 0) {
        long val = (hpInput.getValue()) instanceof Double ? ((Double) hpInput.getValue()).longValue() : (long) hpInput.getValue();
        enemies.get(index).setHp(val);
      }
    });

    defenseInput.addChangeListener(_ -> {
      int index = enemiesList.getSelectedIndex();
      if (index >= 0) {
        enemies.get(index).setDefense((int) defenseInput.getValue());
      }
    });

    etherDefenseInput.addChangeListener(_ -> {
      int index = enemiesList.getSelectedIndex();
      if (index >= 0) {
        enemies.get(index).setEtherDefense((int) etherDefenseInput.getValue());
        }
    });

    speedInput.addChangeListener(_ -> {
      int index = enemiesList.getSelectedIndex();
      if (index >= 0) {
        enemies.get(index).setSpeed((int) speedInput.getValue());
      }
            });

    attackInput.addChangeListener(_ -> {
      int index = enemiesList.getSelectedIndex();
      if (index >= 0) {
        enemies.get(index).setAttack(((int) attackInput.getValue()));
      }
    });

    potentialInput.addChangeListener(_ -> {
      int index = enemiesList.getSelectedIndex();
      if (index >= 0) {
        enemies.get(index).setPotential((int) potentialInput.getValue());
      }
    });

    // see EnemiesPanel#buildAttacksList(Set) for the attacks event listener

    saveAsButton.addActionListener(
        _ -> {
          int response = saveFileDialog.showSaveDialog(new JDialog());

          if (response == JFileChooser.APPROVE_OPTION) {
            savedFile = saveFileDialog.getSelectedFile();
            if (!savedFile.getName().matches("[.]")) {
              savedFile = new File(savedFile.getParentFile(), savedFile.getName() + ".json");
            }
            saveFileDialog.setCurrentDirectory(savedFile.getParentFile());

            saveFile();
          }
        });

    saveFileButton.addActionListener(_ -> saveFile());

    loadFileButton.addActionListener(
        _ -> {
          int response = openFileDialog.showOpenDialog(new JDialog());

          if (response == JFileChooser.APPROVE_OPTION) {
            loadedFile = openFileDialog.getSelectedFile();
            openFileDialog.setCurrentDirectory(loadedFile.getParentFile());

            loadFile();
          }
        });

    reloadFileButton.addActionListener(_ -> loadFile());
  }
  
  public void update() {
    int index = enemiesList.getSelectedIndex();
    buildAttacksList(enemies.get(index).getAttacks());
  }

  private void saveFile() {
    try {
      mapper.writeValue(savedFile, enemies);
      saveFileButton.setEnabled(true);
      saveFileButton.setText("Save " + savedFile.getName());
    } catch (IOException e) {
      GuiFunctions.printSwingError("Could not save to file " + savedFile.getName() + "!", this);
    }
  }

  private void loadFile() {
    try {
      TypeReference<ArrayList<Enemy>> type = new TypeReference<>() {};
      List<Enemy> inEnemies = mapper.readValue(loadedFile, type);

      if (!inEnemies.isEmpty()) {
        enemies.clear();
        listModel.clear();
        for (Enemy inEnemy : inEnemies) {
          enemies.add(inEnemy);
          listModel.addElement(inEnemy.getName());
        }

        Enemy display = inEnemies.getFirst();

        enemiesList.setSelectedIndex(-1);

        nameInput.setText(display.getName());
        typeInput.setSelectedItem(display.getType());
        hpInput.setValue(display.getHp());
        defenseInput.setValue(display.getDefense());
        etherDefenseInput.setValue(display.getEtherDefense());
        speedInput.setValue(display.getSpeed());
        attackInput.setValue(display.getAttack());
        potentialInput.setValue(display.getPotential());

        buildAttacksList(display.getAttacks());

        enemiesList.setSelectedIndex(0);
      } else GuiFunctions.printSwingError("File " + loadedFile.getName() + " is empty!", this);
    } catch (DatabindException | StreamReadException e) {
      GuiFunctions.printSwingError(
          "File " + loadedFile.getName() + " is not an Enemies JSON!", this);
    } catch (IOException e) {
      GuiFunctions.printSwingError("Could not read from file " + loadedFile.getName() + "!", this);
    }
  }

  private void createSaveFileDialog() {
    saveFileDialog = new JFileChooser();
    saveFileDialog.setCurrentDirectory(new File("."));
    saveFileDialog.setFileFilter(new FileNameExtensionFilter("JSON files", "json"));
  }

  private void createOpenFileDialog() {
    openFileDialog = new JFileChooser();
    openFileDialog.setCurrentDirectory(new File("."));
    openFileDialog.setFileFilter(new FileNameExtensionFilter("JSON files", "json"));
  }

  private void createListPanel() {
    listPanel = new JPanel();
    listPanel.setLayout(new GridBagLayout());
    listPanel.setOpaque(false);
    listPanel.setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1), "Enemies"));
  }

  private void createListModel() {
    listModel = new DefaultListModel<>();
    enemies.forEach(t -> listModel.addElement(t.toString()));
  }

  private void createEnemiesList() {
    enemiesList = new JList<>(listModel);
    enemiesList.setOpaque(true);
    enemiesList.setBackground(Color.WHITE);
    enemiesList.setSelectedIndex(-1);
  }

  private void createEnemiesListContainer() {
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

  private void createNameLabel() {
    nameLabel = new JLabel("Name:");
    nameLabel.setHorizontalAlignment(JLabel.RIGHT);
  }

  private void createNameInput() {
    nameInput = new JTextField();
    nameInput.setText(enemies.getFirst().toString());
  }

  private void createTypeLabel() {
    typeLabel = new JLabel("Type:");
    typeLabel.setHorizontalAlignment(JLabel.RIGHT);
  }

  private void createHpLabel() {
    hpLabel = GuiFunctions.getRightAlignedLabel("HP:");
  }

  private void createHpInput() {
    hpInput =
        new JSpinner(GuiFunctions.getNewNumberModel(Long.MAX_VALUE, enemies.getFirst().getHp()));
  }

  private void createDefenseLabel() {
    defenseLabel = GuiFunctions.getRightAlignedLabel("Defense:");
  }

  private void createDefenseInput() {
    defenseInput = new JSpinner(GuiFunctions.getNewNumberModel(Integer.MAX_VALUE, enemies.getFirst().getDefense()));
  }

  private void createEtherDefenseLabel() {
    etherDefenseLabel = GuiFunctions.getRightAlignedLabel("Ether Defense:");
  }

  private void createEtherDefenseInput() {
    etherDefenseInput = new JSpinner(GuiFunctions.getNewNumberModel(Integer.MAX_VALUE, enemies.getFirst().getEtherDefense()));
  }

  private void createSpeedLabel() {
    speedLabel = GuiFunctions.getRightAlignedLabel("Speed:");
  }

  private void createSpeedInput() {
    speedInput = new JSpinner(GuiFunctions.getNewNumberModel(255, enemies.getFirst().getSpeed()));
  }

  private void createAttackLabel() {
    attackLabel = GuiFunctions.getRightAlignedLabel("Attack:");
  }

  private void createAttackInput() {
    attackInput = new JSpinner(GuiFunctions.getNewNumberModel(Integer.MAX_VALUE, enemies.getFirst().getAttack()));
  }

  private void createPotentialLabel() {
    potentialLabel = GuiFunctions.getRightAlignedLabel("Potential:");
  }

  private void createPotentialInput() {
    potentialInput = new JSpinner(GuiFunctions.getNewNumberModel(Integer.MAX_VALUE, enemies.getFirst().getPotential()));
  }

  private void createAttacksListContainer() {
    attacksListContainer = new JScrollPane(attacksListPanel);
    attacksListContainer.setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1), "Attacks"));
    attacksListContainer.setOpaque(false);
  }

  private void createAttacksListPanel() {
    buildAttacksList(enemies.getFirst().getAttacks());
  }

  private void createTypeInput() {
    typeInput = new JComboBox<>(EnemyType.values());
  }

  /** Creates an image icon to fill the empty space. */
  private void createFiller() {
    filler = new JPanel(new BorderLayout());
    JLabel icon;

    URL iconSrc = this.getClass().getResource("res/enemies.png");
    if (iconSrc != null) {
      icon = new JLabel(new ImageIcon(iconSrc));
      icon.setHorizontalAlignment(JLabel.CENTER);
      icon.setVerticalAlignment(JLabel.CENTER);
      filler.add(icon, BorderLayout.CENTER);
    }
  }

  private void createSaveAsButton() {
    saveAsButton = new JButton("Save as...");
  }

  private void createSaveFileButton() {
    saveFileButton = new JButton("Save file");
    saveFileButton.setEnabled(false);
  }

  private void createLoadFileButton() {
    loadFileButton = new JButton("Load file...");
  }

  private void createReloadFileButton() {
    reloadFileButton = new JButton("Load file");
    reloadFileButton.setEnabled(false);
  }

  private void buildAttacksList(Set<Integer> attacks) {
    attacksListPanel = new JPanel();
    attacksListPanel.setLayout(new GridBagLayout());
    attacksListPanel.setOpaque(true);
    attacksListPanel.setBackground(Color.WHITE);

    int i = 0;
    while (i < enemyAttacks.size()) {
      EnemyAttack attack = enemyAttacks.get(i);
      String text = attack.getNumber() + ": " + attack.getTitle();
      IndexedJCheckBox<Integer> checkBox = new IndexedJCheckBox<>(attack.getNumber(), text);
      checkBox.setSelected(attacks.contains(i));

      attacksListPanel.add(checkBox, GuiFunctions.createConstraints(0, i));

      checkBox.addChangeListener(
          _ -> {
            int index = enemiesList.getSelectedIndex();
            if (index >= 0) {
              if (checkBox.isSelected()) {
                enemies.get(index).getAttacks().add(checkBox.getIndex());
              } else {
                enemies.get(index).getAttacks().remove(checkBox.getIndex());
              }
            }
          });
      i++;
    }

    JPanel panelFiller = new JPanel();
    panelFiller.setOpaque(false);
    attacksListPanel.add(panelFiller, GuiFunctions.createTallConstraints(0, i, 1, 1));
    if (attacksListContainer != null) attacksListContainer.setViewportView(attacksListPanel);
  }
}
