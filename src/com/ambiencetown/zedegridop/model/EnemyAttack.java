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

  /** TODO: Ask Fiora */
  private int flicker;

  /** TODO: Ask Fiora */
  private int points;

  /** Constructs a new EnemyAttack with default values. */
  public EnemyAttack() {
    this.number = 0;
    this.type = EnemyAttackType.PHYSICAL_ATTACK;
    this.target = "Enemy";
    this.usePotential = false;
    this.flicker = 0;
    this.points = 0;
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
    this.number = number;
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

  /** TODO */
  @JsonProperty("Flicker")
  public int getFlicker() {
    return flicker;
  }

  /** TODO */
  @JsonProperty("Flicker")
  public void setFlicker(int flicker) {
    this.flicker = flicker;
  }

  /** TODO */
  @JsonProperty("Points")
  public int getPoints() {
    return points;
  }

  /** TODO */
  @JsonProperty("Points")
  public void setPoints(int points) {
    this.points = points;
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
    return Integer.compare(this.getNumber(), o.getNumber());
  }
}
