package com.ambiencetown.zedegridop.gui;

import com.ambiencetown.zedegridop.model.Enemy;
import com.ambiencetown.zedegridop.model.EnemyAttack;
import com.ambiencetown.zedegridop.model.EtherAttack;
import com.ambiencetown.zedegridop.model.Player;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class EditorGui extends JFrame {
  private final List<Player> players;
  private final List<EtherAttack> ethers;
  private final List<Enemy> enemies;
  private final List<EnemyAttack> enemyAttacks;

  private final ObjectMapper mapper;

  protected EditorGui() {
    // Create lists
    players = new ArrayList<>();
    players.add(new Player());

    ethers = new ArrayList<>();
    ethers.add(new EtherAttack());

    enemies = new ArrayList<>();
    enemies.add(new Enemy());

    enemyAttacks = new ArrayList<>();
    enemyAttacks.add(new EnemyAttack());


    // Create mapper
    mapper = new ObjectMapper();
    mapper.enable(JsonParser.Feature.ALLOW_COMMENTS);
    mapper.enable(SerializationFeature.INDENT_OUTPUT);

    // Set up window
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 1080, 720);
    setTitle("Zedegri DOP Editor");

    // Add components
    initializeComponents();

    // Show the window
    setVisible(true);
  }

  private void initializeComponents() {
    JPanel contentPane = new JPanel();
    contentPane.setLayout(new BorderLayout());
    setContentPane(contentPane);

    JTabbedPane tabbedPane = new JTabbedPane();

    EthersPanel etherPanel = new EthersPanel(ethers, players, mapper);
    PlayersPanel playersPanel = new PlayersPanel(players, etherPanel, mapper);
    EnemiesPanel enemiesPanel = new EnemiesPanel(enemies, enemyAttacks, mapper);
    EnemyAttacksPanel enemyAttacksPanel = new EnemyAttacksPanel(enemyAttacks, enemiesPanel, mapper);

    tabbedPane.addTab("Players", playersPanel);
    tabbedPane.addTab("Ether Arts", etherPanel);
    tabbedPane.addTab("Enemies", enemiesPanel);
    tabbedPane.addTab("Enemy Attacks", enemyAttacksPanel);
    contentPane.add(tabbedPane, BorderLayout.CENTER);
  }
}
