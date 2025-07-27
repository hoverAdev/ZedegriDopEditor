package com.ambiencetown.zedegridop.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
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
   * The attacks of the enemy. Stored as a list of attack numbers.
   *
   * @see EnemyAttack
   */
  private List<Integer> attacks;

  /** Constructs an Enemy with the default values. */
  public Enemy() {
    super();
    this.type = EnemyType.ANIMAL;
    this.attacks = new ArrayList<>();
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
  public List<Integer> getAttacks() {
    return attacks;
  }

  /**
   * Sets the list of attacks of the enemy. <br>
   * Note: This is of the reference type {@code List}. Instead of using this method, consider using
   * {@link List#clear()} and/or {@link List#addAll(Collection)}.
   *
   * @param attacks The new list of attacks of the enemy.
   */
  @JsonProperty("Attacks")
  public void setAttacks(@NotNull List<Integer> attacks) {
    this.attacks = attacks;
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
