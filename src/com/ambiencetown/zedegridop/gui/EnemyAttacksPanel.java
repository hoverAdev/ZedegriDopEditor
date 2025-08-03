package com.ambiencetown.zedegridop.gui;

import com.ambiencetown.zedegridop.model.EnemyAttack;
import com.ambiencetown.zedegridop.model.EnemyAttackType;
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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jetbrains.annotations.NotNull;

/**
 * JPanel for editing the details of the Enemy Attacks array.
 *
 * @author Serenity Montgomery
 */
public class EnemyAttacksPanel extends JPanel {
  private final List<EnemyAttack> enemyAttacks;
  private final EnemiesPanel enemiesPanel;
  private final ObjectMapper mapper;

  private File savedFile;
  private File loadedFile;

  // Components
  private JFileChooser saveFileDialog;
  private JFileChooser openFileDialog;

  private JPanel listPanel;
  private DefaultListModel<String> listModel;
  private JScrollPane enemyAttacksListContainer;
  private JList<String> enemyAttacksList;

  private JButton addEnemyAttackButton;
  private JButton removeEnemyAttackButton;

  private JPanel formPanel;

  private JLabel numberLabel;
  private JSpinner numberInput;

  private JLabel titleLabel;
  private JTextField titleInput;

  private JLabel descriptionLabel;
  private JTextField descriptionInput;

  private JLabel hitsLabel;
  private JSpinner hitsInput;

  private JLabel aoeLabel;
  private JCheckBox aoeInput;

  private JLabel accuracyLabel;
  private JSpinner accuracyInput;

  private JLabel multiplierLabel;
  private JSpinner multiplierInput;

  private JLabel dazeChanceLabel;
  private JSpinner dazeChanceInput;

  private JLabel healLabel;
  private JCheckBox healInput;

  private JLabel leechLabel;
  private JCheckBox leechInput;

  private JLabel typeLabel;
  private JComboBox<EnemyAttackType> typeInput;

  private JLabel targetLabel;
  private JTextField targetInput;

  private JLabel usePotentialLabel;
  private JCheckBox usePotentialInput;

  private JLabel flickerLabel;
  private JSpinner flickerInput;

  private JLabel pointsLabel;
  private JSpinner pointsInput;

  private JLabel burnTimeLabel;
  private JSpinner burnTimeInput;

  private JLabel poisonTimeLabel;
  private JSpinner poisonTimeInput;

  private EffectPanel physicalDefenseEffectInput;
  private EffectPanel physicalAttackEffectInput;
  private EffectPanel etherDefenseEffectInput;
  private EffectPanel potentialEffectInput;

  private JPanel filler;

  private JButton saveAsButton;
  private JButton saveFileButton;
  private JButton loadFileButton;
  private JButton reloadFileButton;

  /**
   * Creates a new EnemyAttacksPanel.
   *
   * @param enemyAttacks The list of enemy attacks to work on and modify.
   * @param mapper The ObjectMapper used for reading and writing JSON data.
   */
  /* package-private */ EnemyAttacksPanel(
      @NotNull List<EnemyAttack> enemyAttacks,
      @NotNull EnemiesPanel enemiesPanel,
      @NotNull ObjectMapper mapper) {
    this.enemyAttacks = enemyAttacks;
    this.enemiesPanel = enemiesPanel;
    this.mapper = mapper;

    GridBagLayout layout = new GridBagLayout();
    setLayout(layout);

    initializeComponents();
    initializeLayout();
    initializeEventHandlers();
  }

  private void initializeComponents() {
    createSaveFileDialog();
    createOpenFileDialog();

    createListPanel();
    createListModel();
    createEnemyAttacksList();
    createEnemyAttacksListContainer();

    createAddEnemyAttackButton();
    createRemoveEnemyAttackButton();

    createFormPanel();

    createNumberLabel();
    createNumberInput();

    createTitleLabel();
    createTitleInput();

    createDescriptionLabel();
    createDescriptionInput();

    createHitsLabel();
    createHitsInput();

    createAoeLabel();
    createAoeInput();

    createAccuracyLabel();
    createAccuracyInput();

    createMultiplierLabel();
    createMultiplierInput();

    createDazeChanceLabel();
    createDazeChanceInput();

    createHealLabel();
    createHealInput();

    createLeechLabel();
    createLeechInput();

    createTypeLabel();
    createTypeInput();

    createTargetLabel();
    createTargetInput();

    createUsePotentialLabel();
    createUsePotentialInput();

    createFlickerLabel();
    createFlickerInput();

    createPointsLabel();
    createPointsInput();

    createBurnTimeLabel();
    createBurnTimeInput();

    createPoisonTimeLabel();
    createPoisonTimeInput();

    createPhysicalDefenseEffectInput();
    createPhysicalAttackEffectInput();
    createEtherDefenseEffectInput();
    createPotentialEffectInput();

    createFiller();

    createSaveAsButton();
    createSaveFileButton();
    createLoadFileButton();
    createReloadFileButton();
  }

  private void initializeLayout() {
    // Add components to layout
    //      List of enemy attacks
    listPanel.add(enemyAttacksListContainer, GuiFunctions.createTallConstraints(0, 0, 2, 1));

    //      Enemy attack list management
    listPanel.add(addEnemyAttackButton, GuiFunctions.createConstraints(0, 1));
    listPanel.add(removeEnemyAttackButton, GuiFunctions.createConstraints(1, 1));

    add(listPanel, GuiFunctions.createTallConstraints(0, 0, 1, 1));

    formPanel.add(numberLabel, GuiFunctions.createConstraints(0, 0));
    formPanel.add(numberInput, GuiFunctions.createConstraints(1, 0));

    formPanel.add(titleLabel, GuiFunctions.createConstraints(2, 0));
    formPanel.add(titleInput, GuiFunctions.createConstraints(3, 0));

    formPanel.add(descriptionLabel, GuiFunctions.createConstraints(0, 1));
    formPanel.add(descriptionInput, GuiFunctions.createConstraints(1, 1, 3, 1));

    formPanel.add(hitsLabel, GuiFunctions.createConstraints(0, 2));
    formPanel.add(hitsInput, GuiFunctions.createConstraints(1, 2));

    formPanel.add(aoeLabel, GuiFunctions.createConstraints(0, 3));
    formPanel.add(aoeInput, GuiFunctions.createConstraints(1, 3));

    formPanel.add(accuracyLabel, GuiFunctions.createConstraints(0, 4));
    formPanel.add(accuracyInput, GuiFunctions.createConstraints(1, 4));

    formPanel.add(multiplierLabel, GuiFunctions.createConstraints(0, 5));
    formPanel.add(multiplierInput, GuiFunctions.createConstraints(1, 5));

    formPanel.add(dazeChanceLabel, GuiFunctions.createConstraints(0, 6));
    formPanel.add(dazeChanceInput, GuiFunctions.createConstraints(1, 6));

    formPanel.add(healLabel, GuiFunctions.createConstraints(0, 7));
    formPanel.add(healInput, GuiFunctions.createConstraints(1, 7));

    formPanel.add(leechLabel, GuiFunctions.createConstraints(0, 8));
    formPanel.add(leechInput, GuiFunctions.createConstraints(1, 8));

    formPanel.add(typeLabel, GuiFunctions.createConstraints(2, 2));
    formPanel.add(typeInput, GuiFunctions.createConstraints(3, 2));

    formPanel.add(targetLabel, GuiFunctions.createConstraints(2, 3));
    formPanel.add(targetInput, GuiFunctions.createConstraints(3, 3));

    formPanel.add(usePotentialLabel, GuiFunctions.createConstraints(2, 4));
    formPanel.add(usePotentialInput, GuiFunctions.createConstraints(3, 4));

    formPanel.add(flickerLabel, GuiFunctions.createConstraints(2, 5));
    formPanel.add(flickerInput, GuiFunctions.createConstraints(3, 5));

    formPanel.add(pointsLabel, GuiFunctions.createConstraints(2, 6));
    formPanel.add(pointsInput, GuiFunctions.createConstraints(3, 6));

    formPanel.add(burnTimeLabel, GuiFunctions.createConstraints(2, 7));
    formPanel.add(burnTimeInput, GuiFunctions.createConstraints(3, 7));

    formPanel.add(poisonTimeLabel, GuiFunctions.createConstraints(2, 8));
    formPanel.add(poisonTimeInput, GuiFunctions.createConstraints(3, 8));

    formPanel.add(physicalDefenseEffectInput, GuiFunctions.createConstraints(0, 9));
    formPanel.add(physicalAttackEffectInput, GuiFunctions.createConstraints(1, 9));
    formPanel.add(etherDefenseEffectInput, GuiFunctions.createConstraints(2, 9));
    formPanel.add(potentialEffectInput, GuiFunctions.createConstraints(3, 9));

    formPanel.add(filler, GuiFunctions.createTallConstraints(0, 10, 4, 1));

    formPanel.add(saveAsButton, GuiFunctions.createConstraints(0, 11));
    formPanel.add(saveFileButton, GuiFunctions.createConstraints(1, 11));
    formPanel.add(loadFileButton, GuiFunctions.createConstraints(2, 11));
    formPanel.add(reloadFileButton, GuiFunctions.createConstraints(3, 11));

    add(formPanel, GuiFunctions.createTallConstraints(1, 0, 1, 1));
  }

  private void initializeEventHandlers() {
    enemyAttacksList.addListSelectionListener(
        _ -> {
          int index = enemyAttacksList.getSelectedIndex();
          if (index >= 0) {
            numberInput.setValue(enemyAttacks.get(index).getNumber());
            titleInput.setText(enemyAttacks.get(index).getTitle());
            descriptionInput.setText(enemyAttacks.get(index).getDescription());
            hitsInput.setValue(enemyAttacks.get(index).getHits());
            aoeInput.setSelected(enemyAttacks.get(index).isAoe());
            accuracyInput.setValue(enemyAttacks.get(index).getAccuracy());
            multiplierInput.setValue(enemyAttacks.get(index).getMultiplier());
            dazeChanceInput.setValue(enemyAttacks.get(index).getDazeChance());
            healInput.setSelected(enemyAttacks.get(index).isHeal());
            leechInput.setSelected(enemyAttacks.get(index).isLeech());
            typeInput.setSelectedItem(enemyAttacks.get(index).getType());
            targetInput.setText(enemyAttacks.get(index).getTarget());
            usePotentialInput.setSelected(enemyAttacks.get(index).isUsePotential());
            flickerInput.setValue(enemyAttacks.get(index).getFlicker());
            pointsInput.setValue(enemyAttacks.get(index).getPoints());
            burnTimeInput.setValue(enemyAttacks.get(index).getBurnTime());
            poisonTimeInput.setValue(enemyAttacks.get(index).getPoisonTime());

            physicalDefenseEffectInput.setEffect(
                enemyAttacks.get(index).getPhysicalDefenseEffect());
            physicalDefenseEffectInput.setTime(
                enemyAttacks.get(index).getPhysicalDefenseEffectTime());
            physicalDefenseEffectInput.setChance(
                enemyAttacks.get(index).getPhysicalDefenseEffectChance());

            physicalAttackEffectInput.setEffect(enemyAttacks.get(index).getPhysicalAttackEffect());
            physicalAttackEffectInput.setTime(
                enemyAttacks.get(index).getPhysicalAttackEffectTime());
            physicalAttackEffectInput.setChance(
                enemyAttacks.get(index).getPhysicalAttackEffectChance());

            etherDefenseEffectInput.setEffect(enemyAttacks.get(index).getEtherDefenseEffect());
            etherDefenseEffectInput.setTime(enemyAttacks.get(index).getEtherDefenseEffectTime());
            etherDefenseEffectInput.setChance(
                enemyAttacks.get(index).getEtherDefenseEffectChance());

            potentialEffectInput.setEffect(enemyAttacks.get(index).getPotentialEffect());
            potentialEffectInput.setTime(enemyAttacks.get(index).getPotentialEffectTime());
            potentialEffectInput.setChance(enemyAttacks.get(index).getPotentialEffectChance());
          }
        });

    addEnemyAttackButton.addActionListener(
        _ -> {
          enemyAttacks.add(new EnemyAttack(getLowestNewNumber()));
          listModel.addElement(getAttackName(enemyAttacks.getLast()));
          enemyAttacksList.setSelectedIndex(listModel.getSize() - 1);
          enemiesPanel.update();
        });

    removeEnemyAttackButton.addActionListener(
        _ -> {
          int index = enemyAttacksList.getSelectedIndex();
          if (index >= 0
              && enemyAttacks.size() > 1) { // Don't allow user to remove the last element
            listModel.remove(index);
            enemyAttacks.remove(index);
            enemiesPanel.update();
          }
          if (index < listModel.size()) {
            enemyAttacksList.setSelectedIndex(index);
          } else {
            enemyAttacksList.setSelectedIndex(listModel.size() - 1);
          }
        });

    numberInput.addChangeListener(
        _ -> {
          int index = enemyAttacksList.getSelectedIndex();
          if (index >= 0) {
            // Get all the currently used numbers
            Map<Integer, EnemyAttack> takenNumbers = new HashMap<>();
            for (int i = 0; i < enemyAttacks.size(); i++) {
              if (i != index) {
                takenNumbers.put(enemyAttacks.get(i).getNumber(), enemyAttacks.get(i));
              }
            }

            // Don't allow duplicate numbers
            if (takenNumbers.containsKey(((int) numberInput.getValue()))) {
              int oldValue = (int) numberInput.getValue();

              numberInput.setValue(((SpinnerNumberModel) numberInput.getModel()).getMaximum());
              numberInput.setValue(getLowestNewNumber());

              GuiFunctions.printSwingError(
                  String.format(
                      "Number %d is already taken by \"%s\". The attack number has been set to the lowest available number, %d.",
                      oldValue,
                      getAttackName(takenNumbers.get(oldValue)),
                      ((int) numberInput.getValue())),
                  this);
            }

            enemyAttacks.get(index).setNumber((int) numberInput.getValue());
            listModel.setElementAt(getAttackName(enemyAttacks.get(index)), index);
            enemiesPanel.update();
          }
        });

    titleInput
        .getDocument()
        .addDocumentListener(
            new DocumentListener() {
              @Override
              public void insertUpdate(DocumentEvent e) {
                updateTitle();
              }

              @Override
              public void removeUpdate(DocumentEvent e) {
                updateTitle();
              }

              @Override
              public void changedUpdate(DocumentEvent e) {
                updateTitle();
              }

              private void updateTitle() {
                int index = enemyAttacksList.getSelectedIndex();
                if (index >= 0) {
                  String title = titleInput.getText().isEmpty() ? " " : titleInput.getText();
                  enemyAttacks.get(index).setTitle(title);
                  listModel.setElementAt(getAttackName(enemyAttacks.get(index)), index);
                  enemiesPanel.update();
                }
              }
            });

    descriptionInput
        .getDocument()
        .addDocumentListener(
            new DocumentListener() {
              @Override
              public void insertUpdate(DocumentEvent e) {
                updateDescription();
              }

              @Override
              public void removeUpdate(DocumentEvent e) {
                updateDescription();
              }

              @Override
              public void changedUpdate(DocumentEvent e) {
                updateDescription();
              }

              private void updateDescription() {
                int index = enemyAttacksList.getSelectedIndex();
                if (index >= 0) {
                  enemyAttacks.get(index).setDescription(descriptionInput.getText());
                }
              }
            });

    hitsInput.addChangeListener(
        _ -> {
          int index = enemyAttacksList.getSelectedIndex();
          if (index >= 0) {
            enemyAttacks.get(index).setHits((int) hitsInput.getValue());
          }
        });

    aoeInput.addActionListener(
        _ -> {
          int index = enemyAttacksList.getSelectedIndex();
          if (index >= 0) {
            enemyAttacks.get(index).setAoe(aoeInput.isSelected());
          }
        });

    accuracyInput.addChangeListener(
        _ -> {
          int index = enemyAttacksList.getSelectedIndex();
          if (index >= 0) {
            enemyAttacks.get(index).setAccuracy((int) accuracyInput.getValue());
          }
        });

    multiplierInput.addChangeListener(
        _ -> {
          int index = enemyAttacksList.getSelectedIndex();
          if (index >= 0) {
            enemyAttacks.get(index).setMultiplier((double) multiplierInput.getValue());
          }
        });

    dazeChanceInput.addChangeListener(
        _ -> {
          int index = enemyAttacksList.getSelectedIndex();
          if (index >= 0) {
            enemyAttacks.get(index).setDazeChance((int) dazeChanceInput.getValue());
          }
        });

    healInput.addActionListener(
        _ -> {
          int index = enemyAttacksList.getSelectedIndex();
          if (index >= 0) {
            enemyAttacks.get(index).setHeal(healInput.isSelected());
          }
        });

    leechInput.addActionListener(
        _ -> {
          int index = enemyAttacksList.getSelectedIndex();
          if (index >= 0) {
            enemyAttacks.get(index).setLeech(leechInput.isSelected());
          }
        });

    typeInput.addActionListener(
        _ -> {
          int index = enemyAttacksList.getSelectedIndex();
          if (index >= 0) {
            enemyAttacks.get(index).setType((EnemyAttackType) typeInput.getSelectedItem());
          }
        });

    targetInput
        .getDocument()
        .addDocumentListener(
            new DocumentListener() {
              @Override
              public void insertUpdate(DocumentEvent e) {
                updateTarget();
              }

              @Override
              public void removeUpdate(DocumentEvent e) {
                updateTarget();
              }

              @Override
              public void changedUpdate(DocumentEvent e) {
                updateTarget();
              }

              private void updateTarget() {
                int index = enemyAttacksList.getSelectedIndex();
                if (index >= 0) {
                  enemyAttacks.get(index).setTarget(targetInput.getText());
                }
              }
            });

    usePotentialInput.addActionListener(
        _ -> {
          int index = enemyAttacksList.getSelectedIndex();
          if (index >= 0) {
            enemyAttacks.get(index).setUsePotential(usePotentialInput.isSelected());
          }
        });

    flickerInput.addChangeListener(
        _ -> {
          int index = enemyAttacksList.getSelectedIndex();
          if (index >= 0) {
            enemyAttacks.get(index).setFlicker((int) flickerInput.getValue());
          }
        });

    pointsInput.addChangeListener(
        _ -> {
          int index = enemyAttacksList.getSelectedIndex();
          if (index >= 0) {
            enemyAttacks.get(index).setPoints((int) pointsInput.getValue());
          }
        });

    burnTimeInput.addChangeListener(
        _ -> {
          int index = enemyAttacksList.getSelectedIndex();
          if (index >= 0) {
            enemyAttacks.get(index).setBurnTime((int) burnTimeInput.getValue());
          }
        });

    poisonTimeInput.addChangeListener(
        _ -> {
          int index = enemyAttacksList.getSelectedIndex();
          if (index >= 0) {
            enemyAttacks.get(index).setPoisonTime((int) poisonTimeInput.getValue());
          }
        });

    physicalDefenseEffectInput.addMultiplierInputActionListener(
        _ -> {
          int index = enemyAttacksList.getSelectedIndex();
          if (index >= 0) {
            enemyAttacks
                .get(index)
                .setPhysicalDefenseEffect(physicalDefenseEffectInput.getEffect());
          }
        });

    physicalDefenseEffectInput.addTimeInputChangeListener(
        _ -> {
          int index = enemyAttacksList.getSelectedIndex();
          if (index >= 0) {
            enemyAttacks
                .get(index)
                .setPhysicalDefenseEffectTime(physicalDefenseEffectInput.getTime());
          }
        });
    physicalDefenseEffectInput.addChanceInputChangeListener(
        _ -> {
          int index = enemyAttacksList.getSelectedIndex();
          if (index >= 0) {
            enemyAttacks
                .get(index)
                .setPhysicalDefenseEffectChance(physicalDefenseEffectInput.getChance());
          }
        });

    physicalAttackEffectInput.addMultiplierInputActionListener(
        _ -> {
          int index = enemyAttacksList.getSelectedIndex();
          if (index >= 0) {
            enemyAttacks.get(index).setPhysicalAttackEffect(physicalAttackEffectInput.getEffect());
          }
        });
    physicalAttackEffectInput.addTimeInputChangeListener(
        _ -> {
          int index = enemyAttacksList.getSelectedIndex();
          if (index >= 0) {
            enemyAttacks
                .get(index)
                .setPhysicalAttackEffectTime(physicalAttackEffectInput.getTime());
          }
        });
    physicalAttackEffectInput.addChanceInputChangeListener(
        _ -> {
          int index = enemyAttacksList.getSelectedIndex();
          if (index >= 0) {
            enemyAttacks
                .get(index)
                .setPhysicalAttackEffectChance(physicalAttackEffectInput.getChance());
          }
        });

    etherDefenseEffectInput.addMultiplierInputActionListener(
        _ -> {
          int index = enemyAttacksList.getSelectedIndex();
          if (index >= 0) {
            enemyAttacks.get(index).setEtherDefenseEffect(etherDefenseEffectInput.getEffect());
          }
        });
    etherDefenseEffectInput.addTimeInputChangeListener(
        _ -> {
          int index = enemyAttacksList.getSelectedIndex();
          if (index >= 0) {
            enemyAttacks.get(index).setEtherDefenseEffectTime(etherDefenseEffectInput.getTime());
          }
        });
    etherDefenseEffectInput.addChanceInputChangeListener(
        _ -> {
          int index = enemyAttacksList.getSelectedIndex();
          if (index >= 0) {
            enemyAttacks
                .get(index)
                .setEtherDefenseEffectChance(etherDefenseEffectInput.getChance());
          }
        });

    potentialEffectInput.addMultiplierInputActionListener(
        _ -> {
          int index = enemyAttacksList.getSelectedIndex();
          if (index >= 0) {
            enemyAttacks.get(index).setPotentialEffect(potentialEffectInput.getEffect());
          }
        });
    potentialEffectInput.addTimeInputChangeListener(
        _ -> {
          int index = enemyAttacksList.getSelectedIndex();
          if (index >= 0) {
            enemyAttacks.get(index).setPotentialEffectTime(potentialEffectInput.getTime());
          }
        });
    potentialEffectInput.addChanceInputChangeListener(
        _ -> {
          int index = enemyAttacksList.getSelectedIndex();
          if (index >= 0) {
            enemyAttacks.get(index).setPotentialEffectChance(potentialEffectInput.getChance());
          }
        });

    saveAsButton.addActionListener(
        _ -> {
          int response = saveFileDialog.showSaveDialog(new JDialog());

          if (response == JFileChooser.APPROVE_OPTION) {
            savedFile = saveFileDialog.getSelectedFile();
            if (!savedFile.getName().contains(".")) {
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

  private int getLowestNewNumber() {
    int number = 0;
    HashSet<Integer> nums = new HashSet<>();
    enemyAttacks.forEach(e -> nums.add(e.getNumber()));
    while (nums.contains(number)) {
      number++;
    }
    return number;
  }

  private String getAttackName(EnemyAttack attack) {
    return attack.getNumber() + ": " + attack.getTitle();
  }

  private void saveFile() {
    try {
      mapper.writeValue(savedFile, enemyAttacks);
      saveFileButton.setEnabled(true);
      saveFileButton.setText("Save " + savedFile.getName());
    } catch (IOException e) {
      GuiFunctions.printSwingError("Could not save to file " + savedFile.getName() + "!", this);
    }
  }

  private void loadFile() {
    try {
      TypeReference<ArrayList<EnemyAttack>> type = new TypeReference<>() {};
      List<EnemyAttack> inEnemyAttacks = mapper.readValue(loadedFile, type);

      if (!inEnemyAttacks.isEmpty()) {
        // Add the elements of the input file to the corresponding object in memory
        enemyAttacks.clear();
        listModel.clear();

        for (EnemyAttack inEnemyAttack : inEnemyAttacks) {
          enemyAttacks.add(inEnemyAttack);
          listModel.addElement(getAttackName(inEnemyAttack));
        }
        enemiesPanel.update();

        enemyAttacksList.setSelectedIndex(-1);
        enemyAttacksList.setSelectedIndex(0);

        // Update the quick load button
        reloadFileButton.setEnabled(true);
        reloadFileButton.setText(("Load " + loadedFile.getName()));

      } else GuiFunctions.printSwingError("File " + loadedFile.getName() + " is empty!", this);
    } catch (DatabindException | StreamReadException e) {
      GuiFunctions.printSwingError(
          "File " + loadedFile.getName() + " is not an Enemy Attacks JSON!", this);
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
    listPanel.setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1), "Enemy Attacks"));
  }

  private void createListModel() {
    listModel = new DefaultListModel<>();
    listModel.add(0, getAttackName(enemyAttacks.getFirst()));
  }

  private void createEnemyAttacksList() {
    enemyAttacksList = new JList<>(listModel);
    enemyAttacksList.setOpaque(true);
    enemyAttacksList.setBackground(Color.WHITE);
    enemyAttacksList.setSelectedIndex(0);
  }

  private void createEnemyAttacksListContainer() {
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

  private void createNumberLabel() {
    numberLabel = GuiFunctions.getRightAlignedLabel("Number:");
  }

  private void createNumberInput() {
    numberInput = new JSpinner(GuiFunctions.getNewNumberModel(255));
    numberInput.setValue(enemyAttacks.getFirst().getNumber());
  }

  private void createTitleLabel() {
    titleLabel = GuiFunctions.getRightAlignedLabel("Title:");
  }

  private void createTitleInput() {
    titleInput = new JTextField();
    titleInput.setText(enemyAttacks.getFirst().getTitle());
  }

  private void createDescriptionLabel() {
    descriptionLabel = GuiFunctions.getRightAlignedLabel("Description:");
  }

  private void createDescriptionInput() {
    descriptionInput = new JTextField();
    descriptionInput.setText(enemyAttacks.getFirst().getDescription());
  }

  private void createHitsLabel() {
    hitsLabel = GuiFunctions.getRightAlignedLabel("Hits:");
  }

  private void createHitsInput() {
    hitsInput = new JSpinner(GuiFunctions.getNewNumberModel(16, enemyAttacks.getFirst().getHits()));
  }

  private void createAoeLabel() {
    aoeLabel = GuiFunctions.getRightAlignedLabel("Is AOE:");
  }

  private void createAoeInput() {
    aoeInput = new JCheckBox();
  }

  private void createAccuracyLabel() {
    accuracyLabel = GuiFunctions.getRightAlignedLabel("Accuracy:");
  }

  private void createAccuracyInput() {
    accuracyInput =
        new JSpinner(GuiFunctions.getNewNumberModel(100, enemyAttacks.getFirst().getAccuracy()));
  }

  private void createMultiplierLabel() {
    multiplierLabel = GuiFunctions.getRightAlignedLabel("Multiplier:");
  }

  private void createMultiplierInput() {
    SpinnerNumberModel doubleNumberModel =
        new SpinnerNumberModel(enemyAttacks.getFirst().getMultiplier(), 0.0, 1000.0, 0.25);
    multiplierInput = new JSpinner(doubleNumberModel);
  }

  private void createDazeChanceLabel() {
    dazeChanceLabel = GuiFunctions.getRightAlignedLabel("Daze Chance:");
  }

  private void createDazeChanceInput() {
    dazeChanceInput =
        new JSpinner(GuiFunctions.getNewNumberModel(100, enemyAttacks.getFirst().getDazeChance()));
  }

  private void createHealLabel() {
    healLabel = GuiFunctions.getRightAlignedLabel("Is Heal:");
  }

  private void createHealInput() {
    healInput = new JCheckBox();
  }

  private void createLeechLabel() {
    leechLabel = GuiFunctions.getRightAlignedLabel("Is Leech:");
  }

  private void createLeechInput() {
    leechInput = new JCheckBox();
  }

  private void createTypeLabel() {
    typeLabel = GuiFunctions.getRightAlignedLabel("Type:");
  }

  private void createTypeInput() {
    typeInput = new JComboBox<>(EnemyAttackType.values());
    typeInput.setSelectedItem(enemyAttacks.getFirst().getType());
  }

  private void createTargetLabel() {
    targetLabel = GuiFunctions.getRightAlignedLabel("Target:");
  }

  private void createTargetInput() {
    targetInput = new JTextField();
    targetInput.setText(enemyAttacks.getFirst().getTarget());
  }

  private void createUsePotentialLabel() {
    usePotentialLabel = GuiFunctions.getRightAlignedLabel("Use Potential:");
  }

  private void createUsePotentialInput() {
    usePotentialInput = new JCheckBox();
  }

  private void createFlickerLabel() {
    flickerLabel = GuiFunctions.getRightAlignedLabel("Flicker:");
  }

  private void createFlickerInput() {
    flickerInput =
        new JSpinner(GuiFunctions.getNewNumberModel(128, enemyAttacks.getFirst().getFlicker()));
  }

  private void createPointsLabel() {
    pointsLabel = GuiFunctions.getRightAlignedLabel("Points:");
  }

  private void createPointsInput() {
    pointsInput =
        new JSpinner(GuiFunctions.getNewNumberModel(255, enemyAttacks.getFirst().getPoints()));
  }

  private void createBurnTimeLabel() {
    burnTimeLabel = GuiFunctions.getRightAlignedLabel("Burn Time:");
  }

  private void createBurnTimeInput() {
    burnTimeInput =
        new JSpinner(
            GuiFunctions.getNewNumberModel(
                Integer.MAX_VALUE, enemyAttacks.getFirst().getBurnTime()));
  }

  private void createPoisonTimeLabel() {
    poisonTimeLabel = GuiFunctions.getRightAlignedLabel("Poison Time:");
  }

  private void createPoisonTimeInput() {
    poisonTimeInput =
        new JSpinner(
            GuiFunctions.getNewNumberModel(
                Integer.MAX_VALUE, enemyAttacks.getFirst().getPoisonTime()));
  }

  private void createPhysicalDefenseEffectInput() {
    EnemyAttack first = enemyAttacks.getFirst();

    physicalDefenseEffectInput =
        new EffectPanel(
            first.getPhysicalDefenseEffect(),
            first.getPhysicalDefenseEffectTime(),
            first.getPhysicalDefenseEffectChance());
    physicalDefenseEffectInput.setBorder(
        new TitledBorder(new LineBorder(Color.GRAY, 1), "Physical Defense Effect"));
  }

  private void createPhysicalAttackEffectInput() {
    EnemyAttack first = enemyAttacks.getFirst();

    physicalAttackEffectInput =
        new EffectPanel(
            first.getPhysicalAttackEffect(),
            first.getPhysicalAttackEffectTime(),
            first.getPhysicalAttackEffectChance());
    physicalAttackEffectInput.setBorder(
        new TitledBorder(new LineBorder(Color.GRAY, 1), "Physical Attack Effect"));
  }

  private void createEtherDefenseEffectInput() {
    EnemyAttack first = enemyAttacks.getFirst();

    etherDefenseEffectInput =
        new EffectPanel(
            first.getEtherDefenseEffect(),
            first.getEtherDefenseEffectTime(),
            first.getEtherDefenseEffectChance());
    etherDefenseEffectInput.setBorder(
        new TitledBorder(new LineBorder(Color.GRAY, 1), "Ether Defense Effect"));
  }

  private void createPotentialEffectInput() {
    EnemyAttack first = enemyAttacks.getFirst();

    potentialEffectInput =
        new EffectPanel(
            first.getPotentialEffect(),
            first.getPotentialEffectTime(),
            first.getPotentialEffectChance());
    potentialEffectInput.setBorder(
        new TitledBorder(new LineBorder(Color.GRAY, 1), "Potential Effect"));
  }

  /** Creates an image icon to fill the empty space. */
  private void createFiller() {
    filler = new JPanel(new BorderLayout());

    URL iconSrc = this.getClass().getResource("res/attacks.png");
    if (iconSrc != null) {
      JLabel icon = new JLabel(new ImageIcon(iconSrc));
      icon.setHorizontalAlignment(JLabel.CENTER);
      icon.setVerticalAlignment(JLabel.CENTER);
      filler.add(icon, BorderLayout.CENTER);
    }
  }

  private void createSaveAsButton() {
    saveAsButton = new JButton("Save As...");
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
}
