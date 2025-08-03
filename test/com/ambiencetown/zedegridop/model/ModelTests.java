package com.ambiencetown.zedegridop.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class ModelTests {
  @Test
  public void testIntegerPercentageClamping() {
    Attack testAttack = new EnemyAttack();

    testAttack.setDazeChance(100);
    assertEquals(100, testAttack.getDazeChance());

    testAttack.setDazeChance(101);
    assertEquals(100, testAttack.getDazeChance());

    testAttack.setDazeChance(0);
    assertEquals(0, testAttack.getDazeChance());

    testAttack.setDazeChance(-1);
    assertEquals(0, testAttack.getDazeChance());

    testAttack.setDazeChance(50);
    assertEquals(50, testAttack.getDazeChance());
  }

  @Test
  public void testAttackPointClamping() {
    Player testPlayer = new Player();

    testPlayer.setAp(3);
    assertEquals(4, testPlayer.getAp());

    testPlayer.setAp(4);
    assertEquals(4, testPlayer.getAp());

    testPlayer.setAp(5);
    assertEquals(5, testPlayer.getAp());

    testPlayer.setAp(6);
    assertEquals(6, testPlayer.getAp());

    testPlayer.setAp(7);
    assertEquals(7, testPlayer.getAp());

    testPlayer.setAp(8);
    assertEquals(7, testPlayer.getAp());
  }
}
