package com.ambiencetown.zedegridop.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * Represents a player {@link Combatant} in the Zedegri DOP Engine.
 *
 * @author Fiora Satou
 * @author Serenity Montgomery
 */
public class Player extends Combatant {
  /** The amount of Attack Points the player has. Must be between 4 and 7 inclusive. */
  private int ap;

  /** The amount of Ether Points the player has. */
  private int ep;

  /** Constructs a new Player with default values. */
  public Player() {
    super();
    this.ap = 0;
    this.ep = 0;
  }

  /** {@return the amount of Attack Points the player has.} */
  @JsonProperty("AP")
  public int getAp() {
    return ap;
  }

  /**
   * Sets the amount of Attack Points the player has. Must be between 4 and 7 inclusive.
   *
   * @param ap the amount of Attack Points the player has.
   */
  @JsonProperty("AP")
  public void setAp(int ap) {
    this.ap = Math.max(4, Math.min(ap, 7));
  }

  /** {@return the amount of Ether Points the player has.} */
  @JsonProperty("EP")
  public int getEp() {
    return ep;
  }

  /**
   * Sets the amount of Ether Points the player has.
   *
   * @param ep the amount of Ether Points the player has.
   */
  @JsonProperty("EP")
  public void setEp(int ep) {
    this.ep = ep;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Player player)) return false;
    if (!super.equals(o)) return false;
    return ap == player.ap && ep == player.ep;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), ap, ep);
  }

  @Override
  public String toString() {
    return "Player{" + "ap=" + ap + ", ep=" + ep + "} " + super.toString();
  }
}
