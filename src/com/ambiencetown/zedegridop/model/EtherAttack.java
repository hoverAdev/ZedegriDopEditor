package com.ambiencetown.zedegridop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/**
 * Represents an Ether attack in the Zedegri DOP Engine. Ether attacks are considered a type of
 * {@link Attack}.
 *
 * <p>This class includes logic for dealing with JSON serialization and deserialization using
 * Jackson. Some fields are treated specially:
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

  /** The type of enemy the daze targets. */
  private final Set<EnemyType> dazeTarget;

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

  /** The amount of Potential Up the attack grants. */
  private int potentialUp;

  /** The amount of Speed Up the attack grants. */
  private int speedUp;

  /** Creates a new EtherAttack with default parameters. */
  public EtherAttack() {
    user = "";
    ep = 0;
    dazeTarget = new HashSet<>();
    purge = false;
    type = EtherAttackType.ATTACK;
    physicalDefenseUp = 0;
    physicalAttackUp = 0;
    etherDefenseUp = 0;
    potentialUp = 0;
    speedUp = 0;
  }

  /**
   * Constructs an Ether Attack with parameterized values.
   *
   * @param user the user of the attack.
   * @param title the title of the attack.
   * @param description the description of the attack.
   * @param ep the EP cost of the attack.
   * @param hits the number of hits the attack deals.
   * @param aoe whether the attack is an Area of Effect.
   * @param accuracy the accuracy of the attack.
   * @param multiplier the multiplier of the attack.
   * @param dazeTarget the types of enemy the daze targets.
   * @param dazeChance the chance that the attack will inflict Daze as an integer percentage.
   * @param heal whether the attack is a healing attack.
   * @param purge whether the attack inflicts Purge.
   * @param leech whether the attack leeches health from enemies.
   * @param type the type of the attack.
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
   * @param potentialEffectChance the chance to inflict the potential buff or debuff as an integer
   *     percentage.
   * @param physicalDefenseUp the amount of Physical Defense Up the attack grants.
   * @param physicalAttackUp the amount of Physical Attack Up the attack grants.
   * @param etherDefenseUp the amount of Ether Defense Up the attack grants.
   * @param potentialUp the amount of Potential Up the attack grants.
   * @param speedUp the amount of Speed Up the attack grants.
   */
  public EtherAttack(
      @NotNull String user,
      @NotNull String title,
      @NotNull String description,
      int ep,
      int hits,
      boolean aoe,
      int accuracy,
      double multiplier,
      @NotNull Set<EnemyType> dazeTarget,
      int dazeChance,
      boolean heal,
      boolean purge,
      boolean leech,
      @NotNull EtherAttackType type,
      int burnTime,
      int poisonTime,
      @NotNull EffectMultiplier physicalDefenseEffect,
      int physicalDefenseEffectTime,
      int physicalDefenseEffectChance,
      @NotNull EffectMultiplier physicalAttackEffect,
      int physicalAttackEffectTime,
      int physicalAttackEffectChance,
      @NotNull EffectMultiplier etherDefenseEffect,
      int etherDefenseEffectTime,
      int etherDefenseEffectChance,
      @NotNull EffectMultiplier potentialEffect,
      int potentialEffectTime,
      int potentialEffectChance,
      int physicalDefenseUp,
      int physicalAttackUp,
      int etherDefenseUp,
      int potentialUp,
      int speedUp) {
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
    setUser(user);
    setEp(ep);
    this.dazeTarget = new HashSet<>(dazeTarget);
    setPurge(purge);
    setType(type);
    setPhysicalDefenseUp(physicalDefenseUp);
    setPhysicalAttackUp(physicalAttackUp);
    setEtherDefenseUp(etherDefenseUp);
    setPotentialUp(potentialUp);
    setSpeedUp(speedUp);
  }

  /**
   * Constructs an Ether Attack using values copied from another Ether Attack.
   *
   * @param etherAttack the Ether Attack to copy.
   */
  public EtherAttack(@NotNull EtherAttack etherAttack) {
    super(etherAttack);
    setUser(etherAttack.getUser());
    setEp(etherAttack.getEp());
    dazeTarget = new HashSet<>(etherAttack.getDazeTarget());
    setPurge(etherAttack.isPurge());
    setType(etherAttack.getType());
    setPhysicalDefenseUp(etherAttack.getPhysicalDefenseUp());
    setPhysicalAttackUp(etherAttack.getPhysicalAttackUp());
    setEtherDefenseUp(etherAttack.getEtherDefenseUp());
    setPotentialUp(etherAttack.getPotentialUp());
    setSpeedUp(etherAttack.getSpeedUp());
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
  public void setUser(@NotNull String user) {
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
    this.ep = Math.max(0, Math.min(ep, 8));
    if (this.ep != ep)
      System.err.println(
          "Invalid EP cost given. EP cost has been set to the nearest valid value, "
              + this.ep
              + ".");
  }

  /** {@return the types of enemy the daze targets.} */
  @JsonIgnore
  public @NotNull Set<EnemyType> getDazeTarget() {
    return dazeTarget;
  }

  /**
   * A special serializer for compatibility with existing code.
   *
   * @return A string representation of the set of types of enemy the attack can daze.
   * @see EtherAttack#getDazeTarget()
   */
  @JsonProperty("Daze_Target")
  public String getDazeTargetJson() {
    if (dazeTarget.isEmpty()) return "";

    StringBuilder output = new StringBuilder();
    for (EnemyType enemyType : dazeTarget) {
      output.append(enemyType.toString()).append(" and ");
    }
    return output.substring(0, output.length() - 5);
  }

  /**
   * A special deserializer to enable compatibility with existing code.
   *
   * @param dazeTarget A string containing the names of all the relevant EnemyTypes. Treated without
   *     case-sensitivity.
   */
  @JsonProperty("Daze_Target")
  public void setDazeTargetJson(String dazeTarget) {
    this.dazeTarget.clear();
    for (EnemyType enemyType : EnemyType.values()) {
      if (dazeTarget.toLowerCase().contains(enemyType.toString().toLowerCase())) {
        this.dazeTarget.add(enemyType);
      }
    }
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
  public void setType(@NotNull EtherAttackType type) {
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
    this.physicalDefenseUp = Math.max(0, Math.min(physicalDefenseUp, 8));
    if (this.physicalDefenseUp != physicalDefenseUp) {
      System.err.println(
          "Invalid Physical Defense Up given. Physical Defense Up has been set to the nearest valid value, "
              + this.physicalDefenseUp
              + ".");
    }
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
    this.physicalAttackUp = Math.max(0, Math.min(physicalAttackUp, 8));
    if (this.physicalAttackUp != physicalAttackUp) {
      System.err.println(
          "Invalid Physical Attack Up given. Physical Attack Up has been set to the nearest valid value, "
              + this.physicalAttackUp
              + ".");
    }
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
    this.etherDefenseUp = Math.max(0, Math.min(etherDefenseUp, 8));
    if (this.etherDefenseUp != etherDefenseUp) {
      System.err.println(
          "Invalid Ether Defense Up given. Ether Defense Up has been set to the nearest valid value, "
              + this.etherDefenseUp
              + ".");
    }
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
  public int getPotentialUp() {
    return potentialUp;
  }

  /**
   * Special serializer to enable compatibility with existing code.
   *
   * @return {@code false} if 0, otherwise the integer value of {@code etherAttackUp}.
   * @see EtherAttack#getPotentialUp()
   */
  @JsonProperty("ETH_ATK_UP")
  public Object getEtherAttackUpJson() {
    if (potentialUp == 0) return false;
    else return potentialUp;
  }

  /**
   * Sets the amount of Ether Attack Up the attack grants.
   *
   * @param potentialUp the amount of Ether Attack Up the attack grants.
   */
  @JsonIgnore
  public void setPotentialUp(int potentialUp) {
    this.potentialUp = Math.max(0, Math.min(potentialUp, 8));
    if (this.potentialUp != potentialUp) {
      System.err.println(
          "Invalid Ether Attack Up given. Ether Attack Up has been set to the nearest valid value, "
              + this.potentialUp
              + ".");
    }
  }

  /**
   * Special deserializer to enable compatibility with existing code.
   *
   * @param ethAtkUp The value read from the JSON file.
   * @see EtherAttack#setPotentialUp(int)
   */
  @JsonProperty("ETH_ATK_UP")
  public void setEtherAttackUpJson(Object ethAtkUp) {
    if (ethAtkUp instanceof Boolean && !((Boolean) ethAtkUp)) this.potentialUp = 0;
    else if (ethAtkUp instanceof Integer) setPotentialUp((Integer) ethAtkUp);
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
    this.speedUp = Math.max(0, Math.min(speedUp, 8));
    if (this.speedUp != speedUp) {
      System.err.println(
          "Invalid Speed Up given. Speed Up has been set to the nearest valid value, "
              + this.speedUp
              + ".");
    }
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
        && potentialUp == that.potentialUp
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
        potentialUp,
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
        + ", potentialUp="
        + potentialUp
        + ", speedUp="
        + speedUp
        + "} "
        + super.toString();
  }
}
