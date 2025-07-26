package com.ambiencetown.zedegridop.gui;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ambiencetown.zedegridop.model.Enemy;
import com.ambiencetown.zedegridop.model.EnemyAttack;
import com.ambiencetown.zedegridop.model.EtherAttack;
import com.ambiencetown.zedegridop.model.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EditorGui extends JFrame {
    private final List<Player> players;
    private final List<EtherAttack> ethers;
    private final List<Enemy> enemies;
    private final List<EnemyAttack> enemyAttacks;
    private final ObjectMapper mapper;

    public EditorGui() {
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

        PlayersPanel playersPanel = new PlayersPanel(players, mapper);
        JPanel etherPanel = new EthersPanel(ethers, mapper);
        JPanel enemiesPanel = new EnemiesPanel(enemies, mapper);
        JPanel enemyAttacksPanel = new EnemyAttacksPanel(enemyAttacks, mapper);

        tabbedPane.addTab("Players", playersPanel);
        tabbedPane.addTab("Ether Arts", etherPanel);
        tabbedPane.addTab("Enemies", enemiesPanel);
        tabbedPane.addTab("Enemy Attacks", enemyAttacksPanel);
        contentPane.add(tabbedPane, BorderLayout.CENTER);
    }
}
