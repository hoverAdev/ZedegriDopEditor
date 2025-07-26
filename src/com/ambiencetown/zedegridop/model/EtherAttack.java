package com.ambiencetown.zedegridop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * Represents an Ether attack in the Zedegri DOP Engine. Ether attacks are considered a type of
 * {@link Attack}.
 *
 * <p>This class includes logic for dealing with JSON serialization and deserialization using
 * Jackson (<a
 * href="https://repo.maven.apache.org/maven2/com/fasterxml/jackson/core/jackson-databind/2.19.0/">
 * Maven</a>). Some fields are treated specially:
 *
 * <ul>
 *   <li>{@link EtherAttack#getPhysicalDefenseUpJson()}
 *   <li>{@link EtherAttack#setPhysicalDefenseUpJson(Object)}
 *   <li>{@link EtherAttack#getPhysicalAttackUpJson()}
 *   <li>{@link EtherAttack#setPhysicalAttackUpJson(Object)}
 *   <li>{@link EtherAttack#getEtherDefenseUpJson()}
 *   <li>{@link EtherAttack#setEtherDefenseUpJson(Object)}
 *   <li>{@link EtherAttack#getEtherAttackUpJson()}
 *   <li>{@link EtherAttack#setEtherAttackUpJson(Object)}
 * </ul>
 *
 * @author Fiora Satou
 * @author Serenity Montgomery
 */
public class EtherAttack extends Attack {
  /** The user of the attack. */
  private String user;

  /** The EP cost of the attack. */
  private int ep;

  /** The daze target of the attack. */
  private String dazeTarget;

  /** Whether the attack inflicts Purge. */
  private boolean purge;

  /** The type of the attack. */
  private EtherAttackType type;

  /** The amount of Physical Defense Up the attack grants. */
  private int physicalDefenseUp;

  /** The amount of Physical Attack Up the attack grants. */
  private int physicalAttackUp;

  /** The amount of Ether Defense Up the attack grants. */
  private int etherDefenseUp;

  /** The amount of Ether Attack Up the attack grants. */
  private int etherAttackUp;

  /** The amount of Speed Up the attack grants. */
  private int speedUp;

  /** Creates a new EtherAttack with default parameters. */
  public EtherAttack() {
    user = "";
    ep = 0;
    dazeTarget = "";
    purge = false;
    type = EtherAttackType.ATTACK;
    physicalDefenseUp = 0;
    physicalAttackUp = 0;
    etherDefenseUp = 0;
    etherAttackUp = 0;
    speedUp = 0;
  }

  /** {@return the user of the attack.} */
  @JsonProperty("User")
  public String getUser() {
    return user;
  }

  /**
   * Sets the user of the attack.
   *
   * @param user the user of the attack.
   */
  @JsonProperty("User")
  public void setUser(String user) {
    this.user = user;
  }

  /** {@return the EP cost of the attack.} */
  @JsonProperty("EP")
  public int getEp() {
    return ep;
  }

  /**
   * Sets the EP cost of the attack.
   *
   * @param ep The EP cost of the attack.
   */
  @JsonProperty("EP")
  public void setEp(int ep) {
    this.ep = ep;
  }

  /** {@return the daze target of the attack.} */
  @JsonProperty("Daze_Target")
  public String getDazeTarget() {
    return dazeTarget;
  }

  /**
   * Sets the daze target of the attack.
   *
   * @param dazeTarget the daze target of the attack.
   */
  @JsonProperty("Daze_Target")
  public void setDazeTarget(String dazeTarget) {
    this.dazeTarget = dazeTarget;
  }

  /** {@return whether the attack inflicts Purge.} */
  @JsonProperty("Purge")
  public boolean isPurge() {
    return purge;
  }

  /**
   * Sets whether the attack inflicts Purge.
   *
   * @param purge whether the attack inflicts Purge.
   */
  @JsonProperty("Purge")
  public void setPurge(boolean purge) {
    this.purge = purge;
  }

  /** {@return the type of the attack.} */
  @JsonProperty("Type")
  public EtherAttackType getType() {
    return type;
  }

  /**
   * Sets the type of the attack.
   *
   * @param type the type of the attack.
   */
  @JsonProperty("Type")
  public void setType(EtherAttackType type) {
    this.type = type;
  }

  /** {@return the amount of Physical Defense Up the attack grants.} */
  @JsonIgnore
  public int getPhysicalDefenseUp() {
    return physicalDefenseUp;
  }

  /**
   * Special serializer to enable compatibility with existing code.
   *
   * @return {@code false} if 0, otherwise returns the integer value of {@code physicalDefenseUp}.
   * @see EtherAttack#getPhysicalDefenseUp()
   */
  @JsonProperty("PHYS_DEF_UP")
  public Object getPhysicalDefenseUpJson() {
    if (physicalDefenseUp == 0) return false;
    else return physicalDefenseUp;
  }

  /**
   * Sets the amount of Physical Defense Up the attack grants.
   *
   * @param physicalDefenseUp the amount of Physical Defense Up the attack grants.
   */
  @JsonIgnore
  public void setPhysicalDefenseUp(int physicalDefenseUp) {
    this.physicalDefenseUp = physicalDefenseUp;
  }

  /**
   * Special deserializer to enable compatibility with existing code.
   *
   * @param physDefUp The value read from the JSON file.
   * @throws IllegalArgumentException if the input is not a {@code false} or an integer.
   * @see EtherAttack#setPhysicalDefenseUp(int)
   */
  @JsonProperty("PHYS_DEF_UP")
  public void setPhysicalDefenseUpJson(Object physDefUp) {
    if (physDefUp instanceof Boolean && !((Boolean) physDefUp)) this.physicalDefenseUp = 0;
    else if (physDefUp instanceof Integer) setPhysicalDefenseUp((Integer) physDefUp);
    else
      throw new IllegalArgumentException(
          "Input " + physDefUp.toString() + " not false or an integer");
  }

  /** {@return the amount of Physical Attack Up the attack grants.} */
  @JsonIgnore
  public int getPhysicalAttackUp() {
    return physicalAttackUp;
  }

  /**
   * Special serializer to enable compatibility with existing code.
   *
   * @return {@code false} if 0, otherwise the integer value of {@code physicalAttackUp}.
   * @see EtherAttack#getPhysicalAttackUp()
   */
  @JsonProperty("PHYS_ATK_UP")
  public Object getPhysicalAttackUpJson() {
    if (physicalAttackUp == 0) return false;
    else return physicalAttackUp;
  }

  /**
   * Sets the amount of Physical Attack Up the attack grants.
   *
   * @param physicalAttackUp the amount of Physical Attack Up the attack grants.
   */
  @JsonIgnore
  public void setPhysicalAttackUp(int physicalAttackUp) {
    this.physicalAttackUp = physicalAttackUp;
  }

  /**
   * Special deserializer to enable compatibility with existing code.
   *
   * @param physAtkUp The value read from the JSON file.
   * @see EtherAttack#setPhysicalAttackUp(int)
   */
  @JsonProperty("PHYS_ATK_UP")
  public void setPhysicalAttackUpJson(Object physAtkUp) {
    if (physAtkUp instanceof Boolean && !((Boolean) physAtkUp)) this.physicalAttackUp = 0;
    else if (physAtkUp instanceof Integer) setPhysicalAttackUp((Integer) physAtkUp);
    else
      throw new IllegalArgumentException(
          "Input " + physAtkUp.toString() + " not false or an integer");
  }

  /** {@return the amount of Ether Defense Up the attack grants.} */
  @JsonIgnore
  public int getEtherDefenseUp() {
    return etherDefenseUp;
  }

  /**
   * Special serializer to enable compatibility with existing code.
   *
   * @return {@code false} if 0, otherwise returns the integer value of {@code etherDefenseUp}.
   * @see EtherAttack#getEtherDefenseUp()
   */
  @JsonProperty("ETH_DEF_UP")
  public Object getEtherDefenseUpJson() {
    if (etherDefenseUp == 0) return false;
    else return etherDefenseUp;
  }

  /**
   * Sets the amount of Ether Defense Up the attack grants.
   *
   * @param etherDefenseUp the amount of Ether Defense Up the attack grants.
   */
  @JsonIgnore
  public void setEtherDefenseUp(int etherDefenseUp) {
    this.etherDefenseUp = etherDefenseUp;
  }

  /**
   * Special deserializer to enable compatibility with existing code.
   *
   * @param ethDefUp The value read from the JSON file.
   * @see EtherAttack#setEtherDefenseUp(int)
   */
  @JsonProperty("ETH_DEF_UP")
  public void setEtherDefenseUpJson(Object ethDefUp) {
    if (ethDefUp instanceof Boolean && !((Boolean) ethDefUp)) this.etherDefenseUp = 0;
    else if (ethDefUp instanceof Integer) setEtherDefenseUp((Integer) ethDefUp);
    else
      throw new IllegalArgumentException(
          "Input " + ethDefUp.toString() + " not false or an integer");
  }

  /** {@return the amount of Ether Attack Up the attack grants.} */
  @JsonIgnore
  public int getEtherAttackUp() {
    return etherAttackUp;
  }

  /**
   * Special serializer to enable compatibility with existing code.
   *
   * @return {@code false} if 0, otherwise the integer value of {@code etherAttackUp}.
   * @see EtherAttack#getEtherAttackUp()
   */
  @JsonProperty("ETH_ATK_UP")
  public Object getEtherAttackUpJson() {
    if (etherAttackUp == 0) return false;
    else return etherAttackUp;
  }

  /**
   * Sets the amount of Ether Attack Up the attack grants.
   *
   * @param etherAttackUp the amount of Ether Attack Up the attack grants.
   */
  @JsonIgnore
  public void setEtherAttackUp(int etherAttackUp) {
    this.etherAttackUp = etherAttackUp;
  }

  /**
   * Special deserializer to enable compatibility with existing code.
   *
   * @param ethAtkUp The value read from the JSON file.
   * @see EtherAttack#setEtherAttackUp(int)
   */
  @JsonProperty("ETH_ATK_UP")
  public void setEtherAttackUpJson(Object ethAtkUp) {
    if (ethAtkUp instanceof Boolean && !((Boolean) ethAtkUp)) this.etherAttackUp = 0;
    else if (ethAtkUp instanceof Integer) setEtherAttackUp((Integer) ethAtkUp);
    else
      throw new IllegalArgumentException(
          "Input " + ethAtkUp.toString() + " not false or an integer");
  }

  /** {@return the amount of Speed Up the attack grants.} */
  @JsonProperty("SPD_UP")
  public int getSpeedUp() {
    return speedUp;
  }

  /**
   * Sets the amount of Speed Up the attack grants.
   *
   * @param speedUp the amount of Speed Up the attack grants.
   */
  @JsonProperty("SPD_UP")
  public void setSpeedUp(int speedUp) {
    this.speedUp = speedUp;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof EtherAttack that)) return false;
    if (!super.equals(o)) return false;
    return ep == that.ep
        && purge == that.purge
        && physicalDefenseUp == that.physicalDefenseUp
        && physicalAttackUp == that.physicalAttackUp
        && etherDefenseUp == that.etherDefenseUp
        && etherAttackUp == that.etherAttackUp
        && speedUp == that.speedUp
        && Objects.equals(user, that.user)
        && Objects.equals(dazeTarget, that.dazeTarget)
        && type == that.type;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        super.hashCode(),
        user,
        ep,
        dazeTarget,
        purge,
        type,
        physicalDefenseUp,
        physicalAttackUp,
        etherDefenseUp,
        etherAttackUp,
        speedUp);
  }

  @Override
  public String toString() {
    return "EtherAttack{"
        + "user='"
        + user
        + '\''
        + ", ep="
        + ep
        + ", dazeTarget='"
        + dazeTarget
        + '\''
        + ", purge="
        + purge
        + ", type="
        + type
        + ", physicalDefenseUp="
        + physicalDefenseUp
        + ", physicalAttackUp="
        + physicalAttackUp
        + ", etherDefenseUp="
        + etherDefenseUp
        + ", etherAttackUp="
        + etherAttackUp
        + ", speedUp="
        + speedUp
        + "} "
        + super.toString();
  }
}
