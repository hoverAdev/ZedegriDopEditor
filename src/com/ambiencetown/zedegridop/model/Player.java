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

  /** Constructs a Player with default values. */
  public Player() {
    super();
    this.ap = 4;
    this.ep = 0;
  }

  /**
   * Constructs a Player with parameterized values.
   *
   * @param name the name of the player combatant.
   * @param hp the health points of the player combatant.
   * @param defense the defense of the player combatant.
   * @param etherDefense the ether defense of the player combatant.
   * @param speed the speed of the player combatant.
   * @param attack the attack of the player combatant.
   * @param potential the potential of the player combatant.
   * @param ap the amount of Attack Points the player has.
   * @param ep the amount of Ether Points the player has.
   */
  public Player(String name, long hp, int defense, int etherDefense, int speed, int attack, int potential, int ap, int ep) {
    super(name, hp, defense, etherDefense, speed, attack, potential);
    setAp(ap);
    setEp(ep);
  }

  /**
   * Constructs a Player with values copied from another Player.
   *
   * @param player The player to copy.
   */
  public Player(Player player) {
    super(player);
    setAp(player.getAp());
    setEp(player.getEp());
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
    this.ep = Math.max(0, Math.min(ep, 32));
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
