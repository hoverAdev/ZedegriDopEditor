package com.ambiencetown.zedegridop.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.jetbrains.annotations.Contract;

/**
 * Represents a combatant in the Zedegri DOP Engine, such as {@link Player}s and {@link Enemy}s.
 *
 * @author Fiora Satou
 * @author Serenity Montgomery
 */
public abstract class Combatant {
  /** The name of the combatant. */
  private String name;

  /** The health points of the combatant. */
  private int hp;

  /** The defense of the combatant. */
  private int defense;

  /** The ether defense of the combatant. */
  private int etherDefense;

  /** The speed of the combatant. TODO: Add detail about how to interpret the value */
  private int speed;

  /** The attack of the combatant. */
  private int attack;

  /** The potential of the combatant. */
  private int potential;

  /** Constructs a Combatant with the default values. */
  protected Combatant() {
    this.name = "None";
    this.hp = 0;
    this.defense = 0;
    this.etherDefense = 0;
    this.speed = 255;
    this.attack = 0;
    this.potential = 0;
  }

  /** {@return the name of the combatant.} */
  @JsonProperty("Name")
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the combatant.
   *
   * @param name the name of the combatant.
   */
  @JsonProperty("Name")
  public void setName(String name) {
    this.name = name;
  }

  /** {@return the health points of the combatant.} */
  @JsonProperty("HP")
  public int getHp() {
    return hp;
  }

  /**
   * Sets the health points of the combatant.
   *
   * @param hp the health points of the combatant.
   */
  @JsonProperty("HP")
  public void setHp(int hp) {
    this.hp = hp;
  }

  /** {@return the defense of the combatant.} */
  @JsonProperty("DEF")
  public int getDefense() {
    return defense;
  }

  /**
   * Sets the defense of the combatant.
   *
   * @param defense the defense of the combatant.
   */
  @JsonProperty("DEF")
  public void setDefense(int defense) {
    this.defense = defense;
  }

  /** {@return the ether defense of the combatant.} */
  @JsonProperty("EthDEF")
  public int getEtherDefense() {
    return etherDefense;
  }

  /**
   * Sets the ether defense of the combatant.
   *
   * @param etherDefense the ether defense of the combatant.
   */
  @JsonProperty("EthDEF")
  public void setEtherDefense(int etherDefense) {
    this.etherDefense = etherDefense;
  }

  /** {@return the speed of the combatant.} */
  @JsonProperty("Speed")
  public int getSpeed() {
    return speed;
  }

  /**
   * Sets the speed of the combatant.
   *
   * @param speed the speed of the combatant.
   */
  @JsonProperty("Speed")
  public void setSpeed(int speed) {
    this.speed = speed;
  }

  /** {@return the attack of the combatant.} */
  @JsonProperty("Attack")
  public int getAttack() {
    return attack;
  }

  /**
   * Sets the attack of the combatant.
   *
   * @param attack the attack of the combatant.
   */
  @JsonProperty("Attack")
  public void setAttack(int attack) {
    this.attack = attack;
  }

  /** {@return the potential of the combatant.} */
  @JsonProperty("Potent")
  public int getPotential() {
    return potential;
  }

  /**
   * Sets the potential of the combatant.
   *
   * @param potential the potential of the combatant.
   */
  @JsonProperty("Potent")
  public void setPotential(int potential) {
    this.potential = potential;
  }

  @Contract(value = "null -> false", pure = true)
  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Combatant combatant)) return false;
    return hp == combatant.hp
        && defense == combatant.defense
        && etherDefense == combatant.etherDefense
        && speed == combatant.speed
        && attack == combatant.attack
        && potential == combatant.potential
        && Objects.equals(name, combatant.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, hp, defense, etherDefense, speed, attack, potential);
  }

  @Override
  public String toString() {
    return "Combatant{"
        + "name='"
        + name
        + '\''
        + ", hp="
        + hp
        + ", defense="
        + defense
        + ", etherDefense="
        + etherDefense
        + ", speed="
        + speed
        + ", attack="
        + attack
        + ", potential="
        + potential
        + '}';
  }
}
