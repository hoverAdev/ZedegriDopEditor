package com.ambiencetown.zedegridop.model;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Test logic related to JSON serialization and deserialization.
 *
 * @author Serenity Montgomery
 */
public class SerializationTests {
  private static ObjectMapper mapper;

  /** Sets up the ObjectMapper used for serialization and deserialization. */
  @BeforeAll
  public static void setup() {
    mapper = new ObjectMapper();
    mapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
  }

  /** Ensures correct behavior on serializing an empty set. */
  @Test
  void testEmptyDazeTargetSerialization() {
    EtherAttack attack = new EtherAttack();
    attack.setDazeTarget(new HashSet<>());

    assertDoesNotThrow(
        attack::getDazeTargetJson,
        "getDazeTargetJson should not throw an exception for an empty set.");

    assertEquals("", attack.getDazeTargetJson());
  }

  /** Validates the deserializer against a set of known values for the Player model. */
  @Test
  public void testPlayerJsonIn() {
    URL filePath = getClass().getResource("examples/char.json");
    if (filePath == null) {
      fail("Test resources missing!");
      return;
    }

    File file = new File(filePath.getFile());
    Player actual;
    try {
      actual = mapper.readValue(file, Player[].class)[0];
    } catch (Exception e) {
      fail(e.getMessage());
      return;
    }

    assertEquals("Jacob", actual.getName(), fieldShouldMatchError("name"));
    assertEquals(250, actual.getHp(), fieldShouldMatchError("hp"));
    assertEquals(0, actual.getDefense(), fieldShouldMatchError("defense"));
    assertEquals(0, actual.getEtherDefense(), fieldShouldMatchError("ether defense"));
    assertEquals(50, actual.getSpeed(), fieldShouldMatchError("speed"));
    assertEquals(80, actual.getAttack(), fieldShouldMatchError("attack"));
    assertEquals(50, actual.getPotential(), fieldShouldMatchError("potential"));
    assertEquals(7, actual.getAp(), fieldShouldMatchError("ap"));
    assertEquals(7, actual.getEp(), fieldShouldMatchError("ep"));
  }

  /** Validates the deserializer against a set of known values for the Ether Attack model. */
  @Test
  public void testEtherJsonIn() {
    URL filePath = getClass().getResource("examples/ether.json");
    if (filePath == null) {
      fail("Test resources missing!");
      return;
    }

    File file = new File(filePath.getFile());
    EtherAttack actual;
    try {
      actual = mapper.readValue(file, EtherAttack[].class)[0];
    } catch (Exception e) {
      fail(e.getMessage());
      return;
    }

    assertEquals("Jacob", actual.getUser(), fieldShouldMatchError("user"));
    assertEquals("Power Driver", actual.getTitle(), fieldShouldMatchError("title"));
    assertEquals(
        "A strong hit charged with mystical force",
        actual.getDescription(),
        fieldShouldMatchError("description"));
    assertEquals(1, actual.getEp(), fieldShouldMatchError("ep"));
    assertEquals(1, actual.getHits(), fieldShouldMatchError("hits"));
    assertFalse(actual.isAoe(), fieldShouldMatchError("aoe"));
    assertEquals(90, actual.getAccuracy(), fieldShouldMatchError("accuracy"));
    assertEquals(2.5, actual.getMultiplier(), fieldShouldMatchError("multiplier"));
    assertEquals(
        new HashSet<EnemyType>(), actual.getDazeTarget(), fieldShouldMatchError("daze target"));
    assertEquals(0, actual.getDazeChance(), fieldShouldMatchError("daze chance"));
    assertFalse(actual.isHeal(), fieldShouldMatchError("heal"));
    assertFalse(actual.isPurge(), fieldShouldMatchError("purge"));
    assertFalse(actual.isLeech(), fieldShouldMatchError("leech"));
    assertEquals(EtherAttackType.ATTACK, actual.getType(), fieldShouldMatchError("type"));
    assertEquals(0, actual.getBurnTime(), fieldShouldMatchError("burn time"));
    assertEquals(0, actual.getPoisonTime(), fieldShouldMatchError("poison time"));

    assertEquals(
        EffectMultiplier.TIMES_05,
        actual.getPhysicalDefenseEffect(),
        fieldShouldMatchError("physical defense effect"));
    assertEquals(
        0,
        actual.getPhysicalDefenseEffectTime(),
        fieldShouldMatchError("physical defense effect time"));
    assertEquals(
        0,
        actual.getPhysicalDefenseEffectChance(),
        fieldShouldMatchError("physical defense effect chance"));

    assertEquals(
        EffectMultiplier.TIMES_05,
        actual.getPhysicalAttackEffect(),
        fieldShouldMatchError("physical attack effect"));
    assertEquals(
        2,
        actual.getPhysicalAttackEffectTime(),
        fieldShouldMatchError("physical attack effect time"));
    assertEquals(
        10,
        actual.getPhysicalAttackEffectChance(),
        fieldShouldMatchError("physical attack effect chance"));

    assertEquals(
        EffectMultiplier.TIMES_05,
        actual.getEtherDefenseEffect(),
        fieldShouldMatchError("ether defense effect"));
    assertEquals(
        0, actual.getEtherDefenseEffectTime(), fieldShouldMatchError("ether defense effect time"));
    assertEquals(
        0,
        actual.getEtherDefenseEffectChance(),
        fieldShouldMatchError("ether defense effect chance"));

    assertEquals(
        EffectMultiplier.TIMES_05,
        actual.getPotentialEffect(),
        fieldShouldMatchError("potential effect"));
    assertEquals(
        0, actual.getPotentialEffectTime(), fieldShouldMatchError("potential effect time"));
    assertEquals(
        0, actual.getPotentialEffectChance(), fieldShouldMatchError("potential effect chance"));

    assertEquals(0, actual.getPhysicalDefenseUp(), fieldShouldMatchError("physical defense up"));
    assertEquals(0, actual.getPhysicalAttackUp(), fieldShouldMatchError("physical attack up"));

    assertEquals(0, actual.getEtherDefenseUp(), fieldShouldMatchError("ether defense up"));
    assertEquals(0, actual.getEtherAttackUp(), fieldShouldMatchError("ether attack up"));

    assertEquals(0, actual.getSpeedUp(), fieldShouldMatchError("speed up"));
  }

  /** Validates the deserializer against a set of known values for the Enemy model. */
  @Test
  public void testEnemyJsonIn() {
    URL filePath = getClass().getResource("examples/enemies.json");
    if (filePath == null) {
      fail("Test resources missing!");
      return;
    }

    File file = new File(filePath.getFile());
    Enemy actual;
    try {
      actual = mapper.readValue(file, Enemy[].class)[0];
    } catch (Exception e) {
      fail(e.getMessage());
      return;
    }

    assertEquals("No Enemy", actual.getName(), fieldShouldMatchError("name"));
    assertEquals(EnemyType.ANIMAL, actual.getType(), fieldShouldMatchError("type"));
    assertEquals(0, actual.getHp(), fieldShouldMatchError("hp"));
    assertEquals(0, actual.getDefense(), fieldShouldMatchError("defense"));
    assertEquals(0, actual.getEtherDefense(), fieldShouldMatchError("ether defense"));
    assertEquals(255, actual.getSpeed(), fieldShouldMatchError("speed"));
    assertEquals(0, actual.getAttack(), fieldShouldMatchError("attack"));
    assertEquals(0, actual.getPotential(), fieldShouldMatchError("potential"));
    assertEquals(
        new ArrayList<>(List.of(0)), actual.getAttacks(), fieldShouldMatchError("attacks"));
  }

  /** Validates the deserializer against a set of known values for the Enemy Attack model. */
  @Test
  public void testEnemyAttackJsonIn() {
    URL filePath = getClass().getResource("examples/enemy_attacks.json");
    if (filePath == null) {
      fail("Test resources missing!");
      return;
    }

    File file = new File(filePath.getFile());
    EnemyAttack actual;
    try {
      actual = mapper.readValue(file, EnemyAttack[].class)[0];
    } catch (Exception e) {
      fail(e.getMessage());
      return;
    }

    assertEquals(1, actual.getNumber(), fieldShouldMatchError("number"));
    assertEquals("Bite", actual.getTitle(), fieldShouldMatchError("title"));
    assertEquals(
        "A single regular bite", actual.getDescription(), fieldShouldMatchError("description"));
    assertEquals(1, actual.getHits(), fieldShouldMatchError("hits"));
    assertFalse(actual.isAoe(), fieldShouldMatchError("aoe"));
    assertEquals(70, actual.getAccuracy(), fieldShouldMatchError("accuracy"));
    assertEquals(1, actual.getMultiplier(), fieldShouldMatchError("multiplier"));
    assertEquals(80, actual.getDazeChance(), fieldShouldMatchError("daze chance"));
    assertFalse(actual.isHeal(), fieldShouldMatchError("heal"));
    assertFalse(actual.isLeech(), fieldShouldMatchError("leech"));
    assertEquals(EnemyAttackType.PHYSICAL_ATTACK, actual.getType(), fieldShouldMatchError("type"));
    assertEquals("Enemy", actual.getTarget(), fieldShouldMatchError("target"));
    assertFalse(actual.isUsePotential(), fieldShouldMatchError("use potential"));
    assertEquals(0, actual.getFlicker(), fieldShouldMatchError("flicker"));
    assertEquals(20, actual.getPoints(), fieldShouldMatchError("points"));
    assertEquals(0, actual.getBurnTime(), fieldShouldMatchError("burn time"));
    assertEquals(0, actual.getPoisonTime(), fieldShouldMatchError("poison time"));

    assertEquals(
        EffectMultiplier.TIMES_05,
        actual.getPhysicalDefenseEffect(),
        fieldShouldMatchError("physical defense effect"));
    assertEquals(
        0,
        actual.getPhysicalDefenseEffectTime(),
        fieldShouldMatchError("physical defense effect time"));
    assertEquals(
        0,
        actual.getPhysicalDefenseEffectChance(),
        fieldShouldMatchError("physical defense effect chance"));

    assertEquals(
        EffectMultiplier.TIMES_05,
        actual.getPhysicalAttackEffect(),
        fieldShouldMatchError("physical attack effect"));
    assertEquals(
        0,
        actual.getPhysicalAttackEffectTime(),
        fieldShouldMatchError("physical attack effect time"));
    assertEquals(
        0,
        actual.getPhysicalAttackEffectChance(),
        fieldShouldMatchError("physical attack effect chance"));

    assertEquals(
        EffectMultiplier.TIMES_05,
        actual.getEtherDefenseEffect(),
        fieldShouldMatchError("ether defense effect"));
    assertEquals(
        0, actual.getEtherDefenseEffectTime(), fieldShouldMatchError("ether defense effect time"));
    assertEquals(
        0,
        actual.getEtherDefenseEffectChance(),
        fieldShouldMatchError("ether defense effect chance"));

    assertEquals(
        EffectMultiplier.TIMES_05,
        actual.getPotentialEffect(),
        fieldShouldMatchError("potential effect"));
    assertEquals(
        0, actual.getPotentialEffectTime(), fieldShouldMatchError("potential effect time"));
    assertEquals(
        0, actual.getPotentialEffectChance(), fieldShouldMatchError("potential effect chance"));
  }

  /**
   * Returns a generic error message for field mismatch.
   *
   * @param field The name of the mismatched field.
   * @return a generic error message for field mismatch.
   */
  public static String fieldShouldMatchError(String field) {
    return "Field " + field + " should match " + field + " in file";
  }
}
