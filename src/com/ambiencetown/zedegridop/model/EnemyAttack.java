package com.ambiencetown.zedegridop.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/**
 * Represents an enemy attack in the Zedegri DOP Engine.
 *
 * @author Fiora Satou
 * @author Serenity Montgomery
 */
public class EnemyAttack extends Attack implements Comparable<EnemyAttack> {
  /** The numeric identifier of the attack. */
  private int number;

  /** The type of the attack. */
  private EnemyAttackType type;

  /** The target of the attack. */
  private String target;

  /** Whether to calculate damage based on attack or potential. */
  private boolean usePotential;

  /** The number of turns Flicker lasts. */
  private int flicker;

  /** The number of times the attack may be used. */
  private int points;

  /** Constructs a new Enemy Attack with default values. */
  public EnemyAttack() {
    this(0);
  }

  /**
   * Constructs a default Enemy with a given number.
   *
   * @param number The number to assign the new attack.
   */
  public EnemyAttack(int number) {
    super();
    setNumber(number);
    this.type = EnemyAttackType.PHYSICAL_ATTACK;
    this.target = "Enemy";
    this.usePotential = false;
    this.flicker = 0;
    this.points = 0;
  }

  /**
   * Constructs a new Enemy Attack with parameterized values.
   *
   * @param number the numeric identifier of the attack.
   * @param title the title of the attack.
   * @param description the description of the attack.
   * @param hits the number of hits the attack deals.
   * @param aoe whether the attack hits multiple enemies.
   * @param accuracy the accuracy of the attack as an integer percentage.
   * @param multiplier modifies the attack damage by a float multiplier.
   * @param dazeChance the chance that the attack will inflict Daze as an integer percentage.
   * @param heal whether the attack is a healing attack.
   * @param leech whether the attack leeches health from enemies.
   * @param type the type of the attack.
   * @param target the target of the attack.
   * @param usePotential whether to calculate damage based on attack or potential.
   * @param flicker the number of turns Flicker lasts.
   * @param points the number of times the attack may be used.
   * @param burnTime the number of turns to inflict Burn.
   * @param poisonTime the number of turns to inflict Poison.
   * @param physicalDefenseEffect the physical defense buff or debuff applied by the attack.
   * @param physicalDefenseEffectTime the number of turns the physical defense buff or debuff lasts.
   * @param physicalDefenseEffectChance the chance to inflict the physical defense buff or debuff as
   *     an integer percentage.
   * @param physicalAttackEffect the physical attack buff or debuff applied by the attack.
   * @param physicalAttackEffectTime the number of turns the physical attack buff or debuff lasts.
   * @param physicalAttackEffectChance the chance to inflict the physical attack buff or debuff as
   *     an integer percentage.
   * @param etherDefenseEffect the ether defense buff or debuff applied by the attack.
   * @param etherDefenseEffectTime the number of turns the ether defense buff or debuff lasts.
   * @param etherDefenseEffectChance the chance to inflict the ether defense buff or debuff as an
   *     integer percentage.
   * @param potentialEffect the potential buff or debuff applied by the attack.
   * @param potentialEffectTime the number of turns the potential buff or debuff lasts.
   * @param potentialEffectChance the chance to inflict the potential buff or debuff as an integer percentage.
   */
  public EnemyAttack(
      int number,
      String title,
      String description,
      int hits,
      boolean aoe,
      int accuracy,
      double multiplier,
      int dazeChance,
      boolean heal,
      boolean leech,
      EnemyAttackType type,
      String target,
      boolean usePotential,
      int flicker,
      int points,
      int burnTime,
      int poisonTime,
      EffectMultiplier physicalDefenseEffect,
      int physicalDefenseEffectTime,
      int physicalDefenseEffectChance,
      EffectMultiplier physicalAttackEffect,
      int physicalAttackEffectTime,
      int physicalAttackEffectChance,
      EffectMultiplier etherDefenseEffect,
      int etherDefenseEffectTime,
      int etherDefenseEffectChance,
      EffectMultiplier potentialEffect,
      int potentialEffectTime,
      int potentialEffectChance) {
    super(
        title,
        description,
        hits,
        aoe,
        accuracy,
        multiplier,
        dazeChance,
        heal,
        leech,
        burnTime,
        poisonTime,
        physicalDefenseEffect,
        physicalDefenseEffectTime,
        physicalDefenseEffectChance,
        physicalAttackEffect,
        physicalAttackEffectTime,
        physicalAttackEffectChance,
        etherDefenseEffect,
        etherDefenseEffectTime,
        etherDefenseEffectChance,
        potentialEffect,
        potentialEffectTime,
        potentialEffectChance);
    setNumber(number);
    setType(type);
    setTarget(target);
    setUsePotential(usePotential);
    setFlicker(flicker);
    setPoints(points);
  }

  /**
   * Constructs a new Enemy Attack from values copied from another Enemy Attack.
   *
   * @param enemyAttack The enemy attack to copy.
   */
  public EnemyAttack(EnemyAttack enemyAttack) {
    super(enemyAttack);
    setNumber(enemyAttack.getNumber());
    setType(enemyAttack.getType());
    setTarget(enemyAttack.getTarget());
    setUsePotential(enemyAttack.isUsePotential());
    setFlicker(enemyAttack.getFlicker());
    setPoints(enemyAttack.getPoints());
  }

  /** {@return the numeric identifier of the attack.} */
  @JsonProperty("Num")
  public int getNumber() {
    return number;
  }

  /**
   * Sets the numeric identifier of the attack.
   *
   * @param number the numeric identifier of the attack.
   */
  @JsonProperty("Num")
  public void setNumber(int number) {
    this.number = Math.max(0, Math.min(number, 255));
  }

  /** {@return the type of the attack.} */
  @JsonProperty("Type")
  public EnemyAttackType getType() {
    return type;
  }

  /**
   * Sets the type of the attack.
   *
   * @param type the type of the attack.
   */
  @JsonProperty("Type")
  public void setType(EnemyAttackType type) {
    this.type = type;
  }

  /** {@return the target of the attack.} */
  @JsonProperty("Target")
  public String getTarget() {
    return target;
  }

  /**
   * Sets the target of the attack.
   *
   * @param target the target of the attack.
   */
  @JsonProperty("Target")
  public void setTarget(String target) {
    this.target = target;
  }

  /** {@return whether to calculate damage based on attack or potential.} */
  @JsonProperty("Use_Pot")
  public boolean isUsePotential() {
    return usePotential;
  }

  /**
   * Sets whether to calculate damage based on attack or potential.
   *
   * @param usePotential whether to calculate damage based on attack or potential.
   */
  @JsonProperty("Use_Pot")
  public void setUsePotential(boolean usePotential) {
    this.usePotential = usePotential;
  }

  /** {@return the number of turns Flicker lasts.} */
  @JsonProperty("Flicker")
  public int getFlicker() {
    return flicker;
  }

  /**
   * Sets the number of turns Flicker lasts.
   *
   * @param flicker the number of turns Flicker lasts.
   */
  @JsonProperty("Flicker")
  public void setFlicker(int flicker) {
    this.flicker = Math.max(0, Math.min(flicker, 128));
  }

  /** {@return the number of times the attack may be used.} */
  @JsonProperty("Points")
  public int getPoints() {
    return points;
  }

  /**
   * Sets the number of times the attack may be used.
   *
   * @param points the number of times the attack may be used.
   */
  @JsonProperty("Points")
  public void setPoints(int points) {
    this.points = Math.max(0, Math.min(points, 255));
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof EnemyAttack that)) return false;
    if (!super.equals(o)) return false;
    return number == that.number
        && usePotential == that.usePotential
        && flicker == that.flicker
        && points == that.points
        && type == that.type
        && Objects.equals(target, that.target);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), number, type, target, usePotential, flicker, points);
  }

  @Override
  public String toString() {
    return "EnemyAttack{"
        + "number="
        + number
        + ", type="
        + type
        + ", target='"
        + target
        + '\''
        + ", usePotential="
        + usePotential
        + ", flicker="
        + flicker
        + ", points="
        + points
        + "} "
        + super.toString();
  }

  @Override
  public int compareTo(@NotNull EnemyAttack o) {
    int comp = Integer.compare(this.getNumber(), o.getNumber());

    if (comp == 0) {
      comp = this.getTitle().compareTo(o.getTitle());
    }

    return comp;
  }
}
