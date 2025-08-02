package com.ambiencetown.zedegridop.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/**
 * Represents an enemy {@link Combatant} in the Zedegri DOP Engine.
 *
 * @author Fiora Satou
 * @author Serenity Montgomery
 */
public class Enemy extends Combatant {
  /** The type of the enemy. */
  private EnemyType type;

  /**
   * The attacks of the enemy. Stored as a set of attack numbers.
   *
   * @see EnemyAttack
   */
  private final Set<Integer> attacks;

  /** Constructs a new Enemy with the default values. */
  public Enemy() {
    super();
    this.type = EnemyType.ANIMAL;
    this.attacks = new HashSet<>();
  }

  /**
   * Constructs a new Enemy with parameterized values.
   *
   * @param name the name of the enemy combatant.
   * @param type the type of the enemy.
   * @param hp the health points of the enemy combatant.
   * @param defense the defense of the enemy combatant.
   * @param etherDefense the ether defense of the enemy combatant.
   * @param speed the speed of the enemy combatant.
   * @param attack the attack of the enemy combatant.
   * @param potential the potential of the enemy combatant.
   * @param attacks the list of attacks of the enemy.
   */
  public Enemy(String name, EnemyType type, long hp, int defense, int etherDefense, int speed, int attack, int potential, Set<Integer> attacks) {
    // Use setters for input validation
    super(name, hp, defense, etherDefense, speed, attack, potential);
    setType(type);
    this.attacks = new HashSet<>(attacks);
  }

  /**
   * Constructs a new Enemy with values copied from another Enemy.
   *
   * @param enemy The Enemy to copy.
   */
  public Enemy(Enemy enemy) {
    super(enemy);
    setType(enemy.getType());
    attacks = new HashSet<>(enemy.getAttacks());
  }

  /** {@return the type of the enemy.} */
  @JsonProperty("Type")
  public EnemyType getType() {
    return type;
  }

  /**
   * Sets the type of the enemy.
   *
   * @param type the type of the enemy.
   */
  @JsonProperty("Type")
  public void setType(@NotNull EnemyType type) {
    this.type = type;
  }

  /** {@return the attacks of the enemy.} */
  @JsonProperty("Attacks")
  public Set<Integer> getAttacks() {
    return attacks;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Enemy enemy)) return false;
    if (!super.equals(o)) return false;
    return Objects.equals(type, enemy.type) && Objects.equals(attacks, enemy.attacks);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), type, attacks);
  }

  @Override
  public String toString() {
    return "Enemy{" + "type='" + type + '\'' + ", attacks=" + attacks + "} " + super.toString();
  }
}
