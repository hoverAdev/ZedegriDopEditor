package com.ambiencetown.zedegridop.gui;

import com.ambiencetown.zedegridop.model.EnemyType;
import com.ambiencetown.zedegridop.model.EtherAttack;
import com.ambiencetown.zedegridop.model.EtherAttackType;
import com.ambiencetown.zedegridop.model.Player;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
 * JPanel for editing the details of the Ether attacks array.
 *
 * @author Serenity Montgomery
 */
public class EthersPanel extends JPanel {
  private final List<EtherAttack> ethers;
  private final List<Player> players;
  private final ObjectMapper mapper;

  private File savedFile;
  private File loadedFile;

  // Components
  private JFileChooser saveFileDialog;
  private JFileChooser openFileDialog;

  private JPanel listPanel;
  private DefaultListModel<String> listModel;
  private JScrollPane ethersListContainer;
  private JList<String> ethersList;

  private JButton addEtherButton;
  private JButton removeEtherButton;

  private JPanel formPanel;

  private JLabel userLabel;
  private JComboBox<String> userInput;

  private JLabel titleLabel;
  private JTextField titleInput;

  private JLabel descriptionLabel;
  private JTextField descriptionInput;

  private JLabel epLabel;
  private JSpinner epInput;

  private JLabel hitsLabel;
  private JSpinner hitsInput;

  private JLabel aoeLabel;
  private JCheckBox aoeInput;

  private JLabel accuracyLabel;
  private JSpinner accuracyInput;

  private JLabel multiplierLabel;
  private JSpinner multiplierInput;

  private JScrollPane dazeTargetContainer;
  private JPanel dazeTargetPanel;

  private JLabel dazeChanceLabel;
  private JSpinner dazeChanceInput;

  private JLabel healLabel;
  private JCheckBox healInput;

  private JLabel purgeLabel;
  private JCheckBox purgeInput;

  private JLabel leechLabel;
  private JCheckBox leechInput;

  private JLabel typeLabel;
  private JComboBox<EtherAttackType> typeInput;

  private JLabel burnTimeLabel;
  private JSpinner burnTimeInput;

  private JLabel poisonTimeLabel;
  private JSpinner poisonTimeInput;

  private JLabel physicalDefenseUpLabel;
  private JSpinner physicalDefenseUpInput;

  private JLabel physicalAttackUpLabel;
  private JSpinner physicalAttackUpInput;

  private JLabel etherDefenseUpLabel;
  private JSpinner etherDefenseUpInput;

  private JLabel potentialUpLabel;
  private JSpinner potentialUpInput;

  private JLabel speedUpLabel;
  private JSpinner speedUpInput;

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
   * Creates a new EthersPanel.
   *
   * @param ethers The list of ether attacks to work on and modify.
   * @param mapper The ObjectMapper used for reading and writing JSON data.
   */
  protected EthersPanel(
      @NotNull List<EtherAttack> ethers,
      @NotNull List<Player> players,
      @NotNull ObjectMapper mapper) {
    this.ethers = ethers;
    if (ethers.isEmpty()) {
      ethers.add(new EtherAttack());
      System.err.println(
          "Empty ether attacks list provided to EthersPanel. A new ether attack will be added.");
    }
    this.players = players;
    this.mapper = mapper;

    GridBagLayout layout = new GridBagLayout();
    setLayout(layout);

    initializeComponents();
    initializeLayout();
    initializeEventHandlers();
  }

  /**
   * Updates the components that depend on other panels' models.
   */
  public void update() {
    buildUserInput(ethers.get(ethersList.getSelectedIndex()).getUser());
  }

  private void initializeComponents() {
    createSaveFileDialog();
    createOpenFileDialog();

    createListPanel();
    createListModel();
    createEthersList();
    createEthersListContainer();

    createAddEtherButton();
    createRemoveEtherButton();

    createFormPanel();

    createTitleLabel();
    createTitleInput();

    createUserLabel();
    createUserInput();

    createDescriptionLabel();
    createDescriptionInput();

    createEpLabel();
    createEpInput();

    createHitsLabel();
    createHitsInput();

    createAoeLabel();
    createAoeInput();

    createAccuracyLabel();
    createAccuracyInput();

    createMultiplierLabel();
    createMultiplierInput();

    createDazeTargetContainer();
    createDazeTargetPanel();

    createDazeChanceLabel();
    createDazeChanceInput();

    createHealLabel();
    createHealInput();

    createPurgeLabel();
    createPurgeInput();

    createLeechLabel();
    createLeechInput();

    createTypeLabel();
    createTypeInput();

    createBurnTimeLabel();
    createBurnTimeInput();

    createPoisonTimeLabel();
    createPoisonTimeInput();

    createPhysicalDefenseEffectInput();
    createPhysicalAttackEffectInput();
    createEtherDefenseEffectInput();
    createPotentialEffectInput();

    createPhysicalDefenseUpLabel();
    createPhysicalDefenseUpInput();

    createPhysicalAttackUpLabel();
    createPhysicalAttackUpInput();

    createEtherDefenseUpLabel();
    createEtherDefenseUpInput();

    createPotentialUpLabel();
    createPotentialUpInput();

    createSpeedUpLabel();
    createSpeedUpInput();

    createFiller();

    createSaveAsButton();
    createSaveFileButton();
    createLoadFileButton();
    createReloadFileButton();
  }

  private void initializeLayout() {
    // Add components to layout
    //      List of ethers
    listPanel.add(ethersListContainer, GuiFunctions.createTallConstraints(0, 0, 2, 1));

    //      Ether list management
    listPanel.add(addEtherButton, GuiFunctions.createConstraints(0, 1));
    listPanel.add(removeEtherButton, GuiFunctions.createConstraints(1, 1));

    add(listPanel, GuiFunctions.createTallConstraints(0, 0, 1, 1));

    formPanel.add(titleLabel, GuiFunctions.createConstraints(0, 0));
    formPanel.add(titleInput, GuiFunctions.createConstraints(1, 0, 3, 1));
    
    formPanel.add(descriptionLabel, GuiFunctions.createConstraints(0, 1));
    formPanel.add(descriptionInput, GuiFunctions.createConstraints(1, 1, 3, 1));

    formPanel.add(userLabel, GuiFunctions.createConstraints(0, 2));
    formPanel.add(userInput, GuiFunctions.createConstraints(1, 2));

    formPanel.add(epLabel, GuiFunctions.createConstraints(0, 3));
    formPanel.add(epInput, GuiFunctions.createConstraints(1, 3));

    formPanel.add(hitsLabel, GuiFunctions.createConstraints(0, 4));
    formPanel.add(hitsInput, GuiFunctions.createConstraints(1, 4));

    formPanel.add(aoeLabel, GuiFunctions.createConstraints(0, 5));
    formPanel.add(aoeInput, GuiFunctions.createConstraints(1, 5));

    formPanel.add(accuracyLabel, GuiFunctions.createConstraints(0, 6));
    formPanel.add(accuracyInput, GuiFunctions.createConstraints(1, 6));

    formPanel.add(multiplierLabel, GuiFunctions.createConstraints(0, 7));
    formPanel.add(multiplierInput, GuiFunctions.createConstraints(1, 7));

    formPanel.add(dazeChanceLabel, GuiFunctions.createConstraints(0, 8));
    formPanel.add(dazeChanceInput, GuiFunctions.createConstraints(1, 8));

    formPanel.add(healLabel, GuiFunctions.createConstraints(0, 9));
    formPanel.add(healInput, GuiFunctions.createConstraints(1, 9));

    formPanel.add(purgeLabel, GuiFunctions.createConstraints(0, 10));
    formPanel.add(purgeInput, GuiFunctions.createConstraints(1, 10));

    formPanel.add(leechLabel, GuiFunctions.createConstraints(2, 2));
    formPanel.add(leechInput, GuiFunctions.createConstraints(3, 2));

    formPanel.add(typeLabel, GuiFunctions.createConstraints(2, 3));
    formPanel.add(typeInput, GuiFunctions.createConstraints(3, 3));

    formPanel.add(burnTimeLabel, GuiFunctions.createConstraints(2, 4));
    formPanel.add(burnTimeInput, GuiFunctions.createConstraints(3, 4));

    formPanel.add(poisonTimeLabel, GuiFunctions.createConstraints(2, 5));
    formPanel.add(poisonTimeInput, GuiFunctions.createConstraints(3, 5));
    
    formPanel.add(speedUpLabel, GuiFunctions.createConstraints(2, 6));
    formPanel.add(speedUpInput, GuiFunctions.createConstraints(3, 6));

    formPanel.add(physicalDefenseUpLabel, GuiFunctions.createConstraints(2, 7));
    formPanel.add(physicalDefenseUpInput, GuiFunctions.createConstraints(3, 7));

    formPanel.add(physicalAttackUpLabel, GuiFunctions.createConstraints(2, 8));
    formPanel.add(physicalAttackUpInput, GuiFunctions.createConstraints(3, 8));

    formPanel.add(etherDefenseUpLabel, GuiFunctions.createConstraints(2, 9));
    formPanel.add(etherDefenseUpInput, GuiFunctions.createConstraints(3, 9));

    formPanel.add(potentialUpLabel, GuiFunctions.createConstraints(2, 10));
    formPanel.add(potentialUpInput, GuiFunctions.createConstraints(3, 10));

    formPanel.add(dazeTargetContainer, GuiFunctions.createTallConstraints(2, 19, 2, 3));

    formPanel.add(physicalDefenseEffectInput, GuiFunctions.createConstraints(0, 19));
    formPanel.add(physicalAttackEffectInput, GuiFunctions.createConstraints(1, 19));

    formPanel.add(etherDefenseEffectInput, GuiFunctions.createConstraints(0, 20));
    formPanel.add(potentialEffectInput, GuiFunctions.createConstraints(1, 20));

    formPanel.add(filler, GuiFunctions.createTallConstraints(0, 21, 2, 1));

    formPanel.add(saveAsButton, GuiFunctions.createConstraints(0, 22));
    formPanel.add(saveFileButton, GuiFunctions.createConstraints(1, 22));
    formPanel.add(loadFileButton, GuiFunctions.createConstraints(2, 22));
    formPanel.add(reloadFileButton, GuiFunctions.createConstraints(3, 22));

    add(formPanel, GuiFunctions.createTallConstraints(1, 0, 1, 1));
  }

  private void initializeEventHandlers() {
    ethersList.addListSelectionListener(
        _ -> {
          int index = ethersList.getSelectedIndex();
          if (index >= 0) {
            userInput.setSelectedItem(ethers.get(index).getUser());
            titleInput.setText(ethers.get(index).getTitle());
            descriptionInput.setText(ethers.get(index).getDescription());
            epInput.setValue(ethers.get(index).getEp());
            hitsInput.setValue(ethers.get(index).getHits());
            aoeInput.setSelected(ethers.get(index).isAoe());
            accuracyInput.setValue(ethers.get(index).getAccuracy());
            multiplierInput.setValue(ethers.get(index).getMultiplier());
            dazeChanceInput.setValue(ethers.get(index).getDazeChance());
            healInput.setSelected(ethers.get(index).isHeal());
            purgeInput.setSelected(ethers.get(index).isPurge());
            leechInput.setSelected(ethers.get(index).isLeech());
            typeInput.setSelectedItem(ethers.get(index).getType());
            burnTimeInput.setValue(ethers.get(index).getBurnTime());
            poisonTimeInput.setValue(ethers.get(index).getPoisonTime());
            speedUpInput.setValue(ethers.get(index).getSpeedUp());
            physicalDefenseUpInput.setValue(ethers.get(index).getPhysicalDefenseUp());
            physicalAttackUpInput.setValue(ethers.get(index).getPhysicalAttackUp());
            etherDefenseUpInput.setValue(ethers.get(index).getEtherDefenseUp());
            potentialUpInput.setValue(ethers.get(index).getPotentialUp());
            physicalDefenseEffectInput.setEffect(ethers.get(index).getPhysicalDefenseEffect());
            physicalDefenseEffectInput.setTime(ethers.get(index).getPhysicalDefenseEffectTime());
            physicalDefenseEffectInput.setChance(ethers.get(index).getPhysicalDefenseEffectChance());
            physicalAttackEffectInput.setEffect(ethers.get(index).getPhysicalAttackEffect());
            physicalAttackEffectInput.setTime(ethers.get(index).getPhysicalAttackEffectTime());
            physicalAttackEffectInput.setChance(ethers.get(index).getPhysicalAttackEffectChance());
            etherDefenseEffectInput.setEffect(ethers.get(index).getEtherDefenseEffect());
            etherDefenseEffectInput.setTime(ethers.get(index).getEtherDefenseEffectTime());
            etherDefenseEffectInput.setChance(ethers.get(index).getEtherDefenseEffectChance());
            potentialEffectInput.setEffect(ethers.get(index).getPotentialEffect());
            potentialEffectInput.setTime(ethers.get(index).getPotentialEffectTime());
            potentialEffectInput.setChance(ethers.get(index).getPotentialEffectChance());

            updateDazeTarget(ethers.get(index).getDazeTarget());
          }
        });

    addEtherButton.addActionListener(
        _ -> {
          ethers.add(new EtherAttack());
          listModel.addElement(ethers.getLast().getTitle());
          ethersList.setSelectedIndex(listModel.getSize() - 1);
        });

    removeEtherButton.addActionListener(
        _ -> {
          int index = ethersList.getSelectedIndex();
          if (index >= 0 && ethers.size() > 1) { // Don't allow user to remove the last element
            listModel.remove(index);
            ethers.remove(index);
          }
          if (index < listModel.size()) {
            ethersList.setSelectedIndex(index);
          } else {
            ethersList.setSelectedIndex(listModel.size() - 1);
          }
        });

    userInput.addActionListener(
        _ -> {
          int index = ethersList.getSelectedIndex();
          if (index >= 0) {
            String user = (String) userInput.getSelectedItem();
            if (user == null) user = "";
            ethers.get(index).setUser(user);
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
                int index = ethersList.getSelectedIndex();
                if (index >= 0) {
                  ethers.get(index).setTitle(titleInput.getText());
                  listModel.setElementAt(
                      titleInput.getText().isEmpty() ? " " : titleInput.getText(), index);
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
                int index = ethersList.getSelectedIndex();
                if (index >= 0) {
                  ethers.get(index).setDescription(descriptionInput.getText());
                }
              }
            });

    epInput.addChangeListener(
        _ -> {
          int index = ethersList.getSelectedIndex();
          if (index >= 0) {
            ethers.get(index).setEp(((int) epInput.getValue()));
          }
        });

    hitsInput.addChangeListener(
        _ -> {
          int index = ethersList.getSelectedIndex();
          if (index >= 0) {
            ethers.get(index).setHits(((int) hitsInput.getValue()));
          }
        });

    aoeInput.addChangeListener(
        _ -> {
          int index = ethersList.getSelectedIndex();
          if (index >= 0) {
            ethers.get(index).setAoe(aoeInput.isSelected());
          }
        });

    accuracyInput.addChangeListener(
        _ -> {
          int index = ethersList.getSelectedIndex();
          if (index >= 0) {
            ethers.get(index).setAccuracy(((int) accuracyInput.getValue()));
          }
        });

    multiplierInput.addChangeListener(
        _ -> {
          int index = ethersList.getSelectedIndex();
          if (index >= 0) {
            ethers.get(index).setMultiplier((double) multiplierInput.getValue());
          }
        });

    dazeChanceInput.addChangeListener(
        _ -> {
          int index = ethersList.getSelectedIndex();
          if (index >= 0) {
            ethers.get(index).setDazeChance(((int) dazeChanceInput.getValue()));
          }
        });

    healInput.addChangeListener(
        _ -> {
          int index = ethersList.getSelectedIndex();
          if (index >= 0) {
            ethers.get(index).setHeal(healInput.isSelected());
          }
        });

    purgeInput.addChangeListener(
        _ -> {
          int index = ethersList.getSelectedIndex();
          if (index >= 0) {
            ethers.get(index).setPurge(purgeInput.isSelected());
          }
        });

    leechInput.addChangeListener(
        _ -> {
          int index = ethersList.getSelectedIndex();
          if (index >= 0) {
            ethers.get(index).setLeech(leechInput.isSelected());
          }
        });

    typeInput.addActionListener(
        _ -> {
          int index = ethersList.getSelectedIndex();
          if (index >= 0) {
            ethers.get(index).setType(((EtherAttackType) typeInput.getSelectedItem()));
          }
        });

    burnTimeInput.addChangeListener(
        _ -> {
          int index = ethersList.getSelectedIndex();
          if (index >= 0) {
            ethers.get(index).setBurnTime(((int) burnTimeInput.getValue()));
          }
        });

    poisonTimeInput.addChangeListener(
        _ -> {
          int index = ethersList.getSelectedIndex();
          if (index >= 0) {
            ethers.get(index).setPoisonTime((int) poisonTimeInput.getValue());
          }
        });
    
    physicalDefenseUpInput.addChangeListener(_ -> {
      int index = ethersList.getSelectedIndex();
      if (index >= 0) {
        ethers.get(index).setPhysicalDefenseUp((int) physicalDefenseUpInput.getValue());
      }
    });
    
    physicalAttackUpInput.addChangeListener(_ -> {
      int index = ethersList.getSelectedIndex();
      if (index >= 0) {
        ethers.get(index).setPhysicalAttackUp(((int)physicalAttackUpInput.getValue()));
      }
    });
    
    etherDefenseUpInput.addChangeListener(_ -> {
      int index = ethersList.getSelectedIndex();
      if (index >= 0) {
        ethers.get(index).setEtherDefenseUp(((int)etherDefenseUpInput.getValue()));
      }
    });
    potentialUpInput.addChangeListener(_ -> {
      int index = ethersList.getSelectedIndex();
      if (index >= 0) {
        ethers.get(index).setPotentialUp(((int)potentialUpInput.getValue()));
      }
    });
    
    speedUpInput.addChangeListener(_ -> {
      int index = ethersList.getSelectedIndex();
      if (index >= 0) {
        ethers.get(index).setSpeedUp(((int)speedUpInput.getValue()));
      }
    });

    physicalDefenseEffectInput.addMultiplierInputActionListener(
        _ -> {
          int index = ethersList.getSelectedIndex();
          if (index >= 0) {
            ethers.get(index).setPhysicalDefenseEffect(physicalDefenseEffectInput.getEffect());
          }
        });
    physicalDefenseEffectInput.addChanceInputChangeListener(
        _ -> {
          int index = ethersList.getSelectedIndex();
          if (index >= 0) {
            ethers
                .get(index)
                .setPhysicalDefenseEffectChance(physicalDefenseEffectInput.getChance());
          }
        });
    physicalDefenseEffectInput.addTimeInputChangeListener(
        _ -> {
          int index = ethersList.getSelectedIndex();
          if (index >= 0) {
            ethers.get(index).setPhysicalDefenseEffectTime(physicalDefenseEffectInput.getTime());
          }
        });

    physicalAttackEffectInput.addMultiplierInputActionListener(
        _ -> {
          int index = ethersList.getSelectedIndex();
          if (index >= 0) {
            ethers.get(index).setPhysicalAttackEffect(physicalAttackEffectInput.getEffect());
          }
        });
    physicalAttackEffectInput.addChanceInputChangeListener(
        _ -> {
          int index = ethersList.getSelectedIndex();
          if (index >= 0) {
            ethers
                .get(index)
                .setPhysicalAttackEffectChance(physicalAttackEffectInput.getChance());
          }
        });
    physicalAttackEffectInput.addTimeInputChangeListener(
        _ -> {
          int index = ethersList.getSelectedIndex();
          if (index >= 0) {
            ethers.get(index).setPhysicalAttackEffectTime(physicalAttackEffectInput.getTime());
          }
        });

    etherDefenseEffectInput.addMultiplierInputActionListener(
        _ -> {
          int index = ethersList.getSelectedIndex();
          if (index >= 0) {
            ethers.get(index).setEtherDefenseEffect(etherDefenseEffectInput.getEffect());
          }
        });
    etherDefenseEffectInput.addChanceInputChangeListener(
        _ -> {
          int index = ethersList.getSelectedIndex();
          if (index >= 0) {
            ethers.get(index).setEtherDefenseEffectChance(etherDefenseEffectInput.getChance());
          }
        });
    etherDefenseEffectInput.addTimeInputChangeListener(
        _ -> {
          int index = ethersList.getSelectedIndex();
          if (index >= 0) {
            ethers.get(index).setEtherDefenseEffectTime(etherDefenseEffectInput.getTime());
          }
        });

    potentialEffectInput.addMultiplierInputActionListener(
        _ -> {
          int index = ethersList.getSelectedIndex();
          if (index >= 0) {
            ethers.get(index).setPotentialEffect(potentialEffectInput.getEffect());
          }
        });
    potentialEffectInput.addChanceInputChangeListener(
        _ -> {
          int index = ethersList.getSelectedIndex();
          if (index >= 0) {
            ethers.get(index).setPotentialEffectChance(potentialEffectInput.getChance());
          }
        });
    potentialEffectInput.addTimeInputChangeListener(_ -> {
      int index = ethersList.getSelectedIndex();
      if (index >= 0) {
        ethers.get(index).setPotentialEffectTime(potentialEffectInput.getTime());
      }
    });

    saveAsButton.addActionListener(_ -> {
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

  private void saveFile() {
    try {
      mapper.writeValue(savedFile, ethers);
      saveFileButton.setEnabled(true);
      saveFileButton.setText("Save " + savedFile.getName());
    } catch (IOException e) {
      GuiFunctions.printSwingError("Could not save to file " + savedFile.getName() + "!", this);
    }
  }

  private void loadFile() {
    try {
      TypeReference<ArrayList<EtherAttack>> type = new TypeReference<>() {};
      List<EtherAttack> inEthers = mapper.readValue(loadedFile, type);

      if (!inEthers.isEmpty()) {
        ethers.clear();
        listModel.clear();

        for (EtherAttack inEther : inEthers) {
          ethers.add(inEther);
          listModel.addElement(inEther.getTitle());
        }

        ethersList.setSelectedIndex(-1);
        ethersList.setSelectedIndex(0);

        // Update the quick load button
        reloadFileButton.setEnabled(true);
        reloadFileButton.setText(("Load " + loadedFile.getName()));
      } else GuiFunctions.printSwingError("File " + loadedFile.getName() + " is empty!", this);
    } catch (DatabindException | StreamReadException e) {
      GuiFunctions.printSwingError(
              "File " + loadedFile.getName() + " is not an Ether Arts JSON!", this);
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
    listPanel.setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1), "Ether Arts"));
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

  private void createTitleLabel() {
    titleLabel = GuiFunctions.getRightAlignedLabel("Title:");
  }

  private void createTitleInput() {
    titleInput = new JTextField();
    titleInput.setText(ethers.getFirst().getTitle());
  }

  private void createUserLabel() {
    userLabel = GuiFunctions.getRightAlignedLabel("User:");
  }

  private void createUserInput() {
    userInput = new JComboBox<>();
    buildUserInput(ethers.getFirst().getUser());
  }

  private void createDescriptionLabel() {
    descriptionLabel = GuiFunctions.getRightAlignedLabel("Description:");
  }

  private void createDescriptionInput() {
    descriptionInput = new JTextField();
    descriptionInput.setText(ethers.getFirst().getDescription());
  }

  private void createEpLabel() {
    epLabel = GuiFunctions.getRightAlignedLabel("EP cost:");
  }

  private void createEpInput() {
    epInput = new JSpinner(GuiFunctions.getNewNumberModel(8));
  }

  private void createHitsLabel() {
    hitsLabel = GuiFunctions.getRightAlignedLabel("Hits:");
  }

  private void createHitsInput() {
    hitsInput =
        new JSpinner(
            GuiFunctions.getNewNumberModel(Integer.MAX_VALUE, ethers.getFirst().getHits()));
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
        new JSpinner(GuiFunctions.getNewNumberModel(100, ethers.getFirst().getAccuracy()));
  }

  private void createMultiplierLabel() {
    multiplierLabel = GuiFunctions.getRightAlignedLabel("Multiplier:");
  }

  private void createMultiplierInput() {
    SpinnerNumberModel doubleNumberModel =
        new SpinnerNumberModel(ethers.getFirst().getMultiplier(), 0.0, 1000.0, 0.25);
    multiplierInput = new JSpinner(doubleNumberModel);
  }

  private void createDazeChanceLabel() {
    dazeChanceLabel = GuiFunctions.getRightAlignedLabel("Daze Chance:");
  }

  private void createDazeChanceInput() {
    dazeChanceInput =
        new JSpinner(GuiFunctions.getNewNumberModel(100, ethers.getFirst().getDazeChance()));
  }

  private void createDazeTargetPanel() {
    dazeTargetPanel = new JPanel();
    dazeTargetPanel.setLayout(new GridBagLayout());
    dazeTargetPanel.setOpaque(true);
    dazeTargetPanel.setBackground(Color.WHITE);

    updateDazeTarget(ethers.getFirst().getDazeTarget());
  }

  private void updateDazeTarget(Set<EnemyType> dazeTarget) {
    dazeTargetPanel.removeAll();

    EnemyType[] enemyTypes = EnemyType.values();

    int i = 0;
    while (i < enemyTypes.length) {
      EnemyType enemyType = enemyTypes[i];
      IndexedJCheckBox<EnemyType> checkBox =
              new IndexedJCheckBox<>(enemyType, enemyType.toString());
      checkBox.setSelected(dazeTarget.contains(enemyType));

      dazeTargetPanel.add(checkBox, GuiFunctions.createConstraints(0, i));

      checkBox.addChangeListener(
              _ -> {
                int index = ethersList.getSelectedIndex();
                if (index >= 0) {
                  if (checkBox.isSelected()) {
                    ethers.get(index).getDazeTarget().add(checkBox.getIndex());
                  } else {
                    ethers.get(index).getDazeTarget().remove(checkBox.getIndex());
                  }
                }
              });
      i++;
    }

    JPanel panelFiller = new JPanel();
    panelFiller.setOpaque(false);
    dazeTargetPanel.add(panelFiller, GuiFunctions.createTallConstraints(0, i, 1, 1));
    if (dazeTargetContainer != null) dazeTargetContainer.setViewportView(dazeTargetPanel);
  }

  private void createDazeTargetContainer() {
    dazeTargetContainer = new JScrollPane(dazeTargetPanel);
    dazeTargetContainer.setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1), "Daze Targets"));
    dazeTargetContainer.setOpaque(false);
  }

  private void createHealLabel() {
    healLabel = GuiFunctions.getRightAlignedLabel("Is Heal:");
  }

  private void createHealInput() {
    healInput = new JCheckBox();
  }

  private void createPurgeLabel() {
    purgeLabel = GuiFunctions.getRightAlignedLabel("Is Purge:");
  }

  private void createPurgeInput() {
    purgeInput = new JCheckBox();
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
    typeInput = new JComboBox<>(EtherAttackType.values());
    typeInput.setSelectedItem(ethers.getFirst().getType());
  }

  private void createBurnTimeLabel() {
    burnTimeLabel = GuiFunctions.getRightAlignedLabel("Burn Time:");
  }

  private void createBurnTimeInput() {
    burnTimeInput =
        new JSpinner(
            GuiFunctions.getNewNumberModel(Integer.MAX_VALUE, ethers.getFirst().getBurnTime()));
  }

  private void createPoisonTimeLabel() {
    poisonTimeLabel = GuiFunctions.getRightAlignedLabel("Poison Time:");
  }

  private void createPoisonTimeInput() {
    poisonTimeInput =
        new JSpinner(
            GuiFunctions.getNewNumberModel(Integer.MAX_VALUE, ethers.getFirst().getPoisonTime()));
  }

  private void createPhysicalDefenseEffectInput() {
    EtherAttack first = ethers.getFirst();

    physicalDefenseEffectInput =
        new EffectPanel(
            first.getPhysicalDefenseEffect(),
            first.getPhysicalDefenseEffectTime(),
            first.getPhysicalDefenseEffectChance());
    physicalDefenseEffectInput.setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1), "Physical Defense Effect"));
  }

  private void createPhysicalAttackEffectInput() {
    EtherAttack first = ethers.getFirst();

    physicalAttackEffectInput =
        new EffectPanel(
            first.getPhysicalAttackEffect(),
            first.getPhysicalAttackEffectTime(),
            first.getPhysicalAttackEffectChance());
    physicalAttackEffectInput.setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1), "Physical Attack Effect"));
  }

  private void createEtherDefenseEffectInput() {
    EtherAttack first = ethers.getFirst();

    etherDefenseEffectInput =
        new EffectPanel(
            first.getEtherDefenseEffect(),
            first.getEtherDefenseEffectTime(),
            first.getEtherDefenseEffectChance());
    etherDefenseEffectInput.setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1), "Ether Defense Effect"));
  }

  private void createPotentialEffectInput() {
    EtherAttack first = ethers.getFirst();

    potentialEffectInput =
        new EffectPanel(
            first.getPotentialEffect(),
            first.getPotentialEffectTime(),
            first.getPotentialEffectChance());
    potentialEffectInput.setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1), "Potential Effect"));
  }

  private void createPhysicalDefenseUpLabel() {
    physicalDefenseUpLabel = GuiFunctions.getRightAlignedLabel("Physical Defense Up:");
  }
  private void createPhysicalDefenseUpInput() {
    physicalDefenseUpInput = new JSpinner(GuiFunctions.getNewNumberModel(8));
  }

  private void createPhysicalAttackUpLabel() {
    physicalAttackUpLabel = GuiFunctions.getRightAlignedLabel("Physical Attack Up:");
  }
  private void createPhysicalAttackUpInput() {
    physicalAttackUpInput = new JSpinner(GuiFunctions.getNewNumberModel(8));
  }

  private void createEtherDefenseUpLabel() {
    etherDefenseUpLabel = GuiFunctions.getRightAlignedLabel("Ether Defense Up:");
  }
  private void createEtherDefenseUpInput() {
    etherDefenseUpInput = new JSpinner(GuiFunctions.getNewNumberModel(8));
  }

  private void createPotentialUpLabel() {
    potentialUpLabel = GuiFunctions.getRightAlignedLabel("Potential Up:");
  }
  private void createPotentialUpInput() {
    potentialUpInput = new JSpinner(GuiFunctions.getNewNumberModel(8));
  }

  private void createSpeedUpLabel() {
    speedUpLabel = GuiFunctions.getRightAlignedLabel("Speed Up:");
  }
  private void createSpeedUpInput() {
    speedUpInput = new JSpinner(GuiFunctions.getNewNumberModel(8));
  }

  /** Creates an image icon to fill the empty space. */
  private void createFiller() {
    filler = new JPanel(new BorderLayout());

    URL iconSrc = this.getClass().getResource("res/ethers.png");
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

  private void buildUserInput(String user) {
    userInput.removeAllItems();

    Set<String> playerNames = new HashSet<>();
    players.forEach(player -> playerNames.add(player.getName()));

    for (String playerName : playerNames) {
      userInput.addItem(playerName);
    }
    userInput.setSelectedItem(user);
  }
}
