package com.ambiencetown.zedegridop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/**
 * Represents an attack in the Zedegri DOP engine. Notably, attacks are not necessarily offensive:
 * attacks may also inflict healing and buffs to teammates.
 *
 * <p>This class includes logic for dealing with JSON serialization and deserialization using
 * Jackson. The {@code heal} field is treated specially: it is serialized as {@code 0} or {@code 1},
 * corresponding to {@code false} and {@code true} respectively.
 *
 * @author Fiora Satou
 * @author Serenity Montgomery
 */
public abstract class Attack {
  /** The title of the attack. */
  private String title;

  /** The description of the attack. */
  private String description;

  /** The number of hits the attack deals. */
  private int hits;

  /** Whether the attack hits multiple enemies. */
  private boolean aoe;

  /** The accuracy of the attack as an integer percentage. */
  private int accuracy;

  /** Modifies the attack damage by a float multiplier. */
  private double multiplier;

  /** The chance that the attack will inflict Daze as an integer percentage. */
  private int dazeChance;

  /** Whether the attack is a healing attack. */
  private boolean heal;

  /** Whether the attack leeches health from enemies. */
  private boolean leech;

  /** The number of turns to inflict Burn. */
  private int burnTime;

  /** The number of turns to inflict Poison. */
  private int poisonTime;

  /** The physical defense buff or debuff applied by the attack. */
  private EffectMultiplier physicalDefenseEffect;

  /** The number of turns the physical defense buff or debuff lasts. */
  private int physicalDefenseEffectTime;

  /** The chance to inflict the physical defense buff or debuff as an integer percentage. */
  private int physicalDefenseEffectChance;

  /** The physical attack buff or debuff applied by the attack. */
  private EffectMultiplier physicalAttackEffect;

  /** The number of turns the physical attack buff or debuff lasts. */
  private int physicalAttackEffectTime;

  /** The chance to inflict the physical attack buff or debuff as an integer percentage. */
  private int physicalAttackEffectChance;

  /** The ether defense buff or debuff applied by the attack. */
  private EffectMultiplier etherDefenseEffect;

  /** The number of turns the ether defense buff or debuff lasts. */
  private int etherDefenseEffectTime;

  /** The chance to inflict the ether defense buff or debuff as an integer percentage. */
  private int etherDefenseEffectChance;

  /** The potential buff or debuff applied by the attack. */
  private EffectMultiplier potentialEffect;

  /** The number of turns the potential buff or debuff lasts. */
  private int potentialEffectTime;

  /** The chance to inflict the potential buff or debuff as an integer percentage. */
  private int potentialEffectChance;

  /** Constructs a new Attack with the default values. */
  protected Attack() {
    this.title = "None";
    this.description = "";
    this.hits = 0;
    this.aoe = false;
    this.accuracy = 0;
    this.multiplier = 0.0;
    this.dazeChance = 0;
    this.heal = false;
    this.leech = false;
    this.burnTime = 0;
    this.poisonTime = 0;
    this.physicalDefenseEffect = EffectMultiplier.TIMES_05;
    this.physicalDefenseEffectTime = 0;
    this.physicalDefenseEffectChance = 0;
    this.physicalAttackEffect = EffectMultiplier.TIMES_05;
    this.physicalAttackEffectTime = 0;
    this.physicalAttackEffectChance = 0;
    this.etherDefenseEffect = EffectMultiplier.TIMES_05;
    this.etherDefenseEffectTime = 0;
    this.etherDefenseEffectChance = 0;
    this.potentialEffect = EffectMultiplier.TIMES_05;
    this.potentialEffectTime = 0;
    this.potentialEffectChance = 0;
  }

  /**
   * Constructs a new Attack with parameterized values.
   *
   * @param title the title of the attack.
   * @param description the description of the attack.
   * @param hits the number of hits the attack deals.
   * @param aoe whether the attack hits multiple enemies.
   * @param accuracy the accuracy of the attack as an integer percentage.
   * @param multiplier modifies the attack damage by a float multiplier.
   * @param dazeChance the chance that the attack will inflict Daze as an integer percentage.
   * @param heal whether the attack is a healing attack.
   * @param leech whether the attack leeches health from enemies.
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
   */
  protected Attack(
      String title,
      String description,
      int hits,
      boolean aoe,
      int accuracy,
      double multiplier,
      int dazeChance,
      boolean heal,
      boolean leech,
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
    // Use setters for input validation
    setTitle(title);
    setDescription(description);
    setHits(hits);
    setAoe(aoe);
    setAccuracy(accuracy);
    setMultiplier(multiplier);
    setDazeChance(dazeChance);
    setHeal(heal);
    setLeech(leech);
    setBurnTime(burnTime);
    setPoisonTime(poisonTime);
    setPhysicalDefenseEffect(physicalDefenseEffect);
    setPhysicalDefenseEffectTime(physicalDefenseEffectTime);
    setPhysicalDefenseEffectChance(physicalDefenseEffectChance);
    setPhysicalAttackEffect(physicalAttackEffect);
    setPhysicalAttackEffectTime(physicalAttackEffectTime);
    setPhysicalAttackEffectChance(physicalAttackEffectChance);
    setEtherDefenseEffect(etherDefenseEffect);
    setEtherDefenseEffectTime(etherDefenseEffectTime);
    setEtherDefenseEffectChance(etherDefenseEffectChance);
    setPotentialEffect(potentialEffect);
    setPotentialEffectTime(potentialEffectTime);
    setPotentialEffectChance(potentialEffectChance);
  }

  /**
   * Constructs a new Attack with values copied from another Attack.
   *
   * @param attack The Attack to copy.
   */
  protected Attack(Attack attack) {
    setTitle(attack.getTitle());
    setDescription(attack.getDescription());
    setHits(attack.getHits());
    setAoe(attack.isAoe());
    setAccuracy(attack.getAccuracy());
    setMultiplier(attack.getMultiplier());
    setDazeChance(attack.getDazeChance());
    setHeal(attack.isHeal());
    setLeech(attack.isLeech());
    setBurnTime(attack.getBurnTime());
    setPoisonTime(attack.getPoisonTime());
    setPhysicalDefenseEffect(attack.getPhysicalDefenseEffect());
    setPhysicalDefenseEffectTime(attack.getPhysicalDefenseEffectTime());
    setPhysicalDefenseEffectChance(attack.getPhysicalDefenseEffectChance());
    setPhysicalAttackEffect(attack.getPhysicalAttackEffect());
    setPhysicalAttackEffectTime(attack.getPhysicalAttackEffectTime());
    setPhysicalAttackEffectChance(attack.getPhysicalAttackEffectChance());
    setEtherDefenseEffect(attack.getEtherDefenseEffect());
    setEtherDefenseEffectTime(attack.getEtherDefenseEffectTime());
    setEtherDefenseEffectChance(attack.getEtherDefenseEffectChance());
    setPotentialEffect(attack.getPotentialEffect());
    setPotentialEffectTime(attack.getPotentialEffectTime());
    setPotentialEffectChance(attack.getPotentialEffectChance());
  }

  /** {@return the title of the attack.} */
  @JsonProperty("Title")
  public String getTitle() {
    return title;
  }

  /**
   * Sets the title of the attack.
   *
   * @param title the title of the attack.
   */
  @JsonProperty("Title")
  public void setTitle(@NotNull String title) {
    this.title = title;
  }

  /** {@return the description of the attack.} */
  @JsonProperty("Desc")
  public String getDescription() {
    return description;
  }

  /**
   * Sets the description of the attack.
   *
   * @param description the description of the attack.
   */
  @JsonProperty("Desc")
  public void setDescription(@NotNull String description) {
    this.description = description;
  }

  /** {@return the number of hits the attack deals.} */
  @JsonProperty("Hits")
  public int getHits() {
    return hits;
  }

  /**
   * Sets the number of hits the attack deals.
   *
   * @param hits the number of hits the attack deals.
   */
  @JsonProperty("Hits")
  public void setHits(int hits) {
    this.hits = Math.max(0, Math.min(hits, 16));
  }

  /** {@return whether the attack hits multiple enemies.} */
  @JsonProperty("AOE")
  public boolean isAoe() {
    return aoe;
  }

  /**
   * Sets whether the attack hits multiple enemies.
   *
   * @param aoe whether the attack hits multiple enemies.
   */
  @JsonProperty("AOE")
  public void setAoe(boolean aoe) {
    this.aoe = aoe;
  }

  /** {@return the accuracy of the attack as an integer percentage.} */
  @JsonProperty("Acc")
  public int getAccuracy() {
    return accuracy;
  }

  /**
   * Sets the accuracy of the attack as an integer percentage. Inputs will be bound between 0 and
   * 100.
   *
   * @param accuracy the accuracy of the attack.
   */
  @JsonProperty("Acc")
  public void setAccuracy(int accuracy) {
    this.accuracy = constrainToIntegerPercentage(accuracy);
  }

  /** {@return the attack damage modifier as a float multiplier.} */
  @JsonProperty("Mult")
  public double getMultiplier() {
    return multiplier;
  }

  /**
   * Sets the attack damage modifier as a float multiplier.
   *
   * @param multiplier the attack damage modifier as a float multiplier.
   */
  @JsonProperty("Mult")
  public void setMultiplier(double multiplier) {
    this.multiplier = multiplier;
  }

  /** {@return the chance that the attack will inflict Daze as an integer percentage.} */
  @JsonProperty("Daze_Percent")
  public int getDazeChance() {
    return dazeChance;
  }

  /**
   * Sets the chance that the attack will inflict Daze as an integer percentage. The input will be
   * bound between 0-100; values outside of these bounds will be rounded to the nearest valid
   * integer.
   *
   * @param dazeChance the chance that the attack will inflict Daze as an integer percentage.
   */
  @JsonProperty("Daze_Percent")
  public void setDazeChance(int dazeChance) {
    this.dazeChance = constrainToIntegerPercentage(dazeChance);
  }

  /** {@return whether the attack is a healing attack.} */
  @JsonIgnore
  public boolean isHeal() {
    return heal;
  }

  /**
   * Special serializer to enable compatibility with existing code.
   *
   * @return {@code 1} if {@code true}, otherwise returns {@code false}.
   * @see Attack#isHeal()
   */
  @JsonProperty("Heal")
  public int getHealJson() {
    return heal ? 1 : 0;
  }

  /**
   * Sets whether the attack is a healing attack.
   *
   * @param heal whether the attack is a healing attack.
   */
  @JsonIgnore
  public void setHeal(boolean heal) {
    this.heal = heal;
  }

  /**
   * Special deserializer to enable compatibility with existing code.
   *
   * @param heal The value read from the JSON file.
   * @see Attack#setHeal(boolean)
   */
  @JsonProperty("Heal")
  public void setHealJson(int heal) {
    this.heal = heal != 0;
  }

  /** {@return whether the attack leeches health from enemies.} */
  @JsonProperty("Leech")
  public boolean isLeech() {
    return leech;
  }

  /**
   * Sets whether the attack leeches health from enemies.
   *
   * @param leech whether the attack leeches health from enemies.
   */
  @JsonProperty("Leech")
  public void setLeech(boolean leech) {
    this.leech = leech;
  }

  /** {@return the number of turns to inflict Burn.} */
  @JsonProperty("BURN_TM")
  public int getBurnTime() {
    return burnTime;
  }

  /**
   * Sets the number of turns to inflict Burn.
   *
   * @param burnTime the number of turns to inflict Burn.
   */
  @JsonProperty("BURN_TM")
  public void setBurnTime(int burnTime) {
    this.burnTime = Math.max(0, Math.min(burnTime, 32));
  }

  /** {@return the number of turns to inflict Poison.} */
  @JsonProperty("POISON_TM")
  public int getPoisonTime() {
    return poisonTime;
  }

  /**
   * Sets the number of turns to inflict Poison.
   *
   * @param poisonTime the number of turns to inflict Poison.
   */
  @JsonProperty("POISON_TM")
  public void setPoisonTime(int poisonTime) {
    this.poisonTime = Math.max(0, Math.min(poisonTime, 32));
  }

  /** {@return the physical defense buff or debuff applied by the attack.} */
  @JsonIgnore
  public EffectMultiplier getPhysicalDefenseEffect() {
    return physicalDefenseEffect;
  }

  /**
   * Special serializer to enable compatibility with existing code.
   *
   * @return The integer representation of the physical defense buff or debuff.
   * @see Attack#getPhysicalDefenseEffect()
   */
  @JsonProperty("PHYS_DEF_DB")
  public int getPhysicalDefenseEffectJson() {
    return physicalDefenseEffect.toInt();
  }

  /**
   * Sets the physical buff or debuff applied by the attack.
   *
   * @param physicalDefenseEffect the physical buff or debuff applied by the attack.
   */
  @JsonIgnore
  public void setPhysicalDefenseEffect(@NotNull EffectMultiplier physicalDefenseEffect) {
    this.physicalDefenseEffect = physicalDefenseEffect;
  }

  /**
   * Special deserializer to enable compatibility with existing code.
   *
   * @param physDefDb The value read from the JSON file.
   * @see Attack#setPhysicalDefenseEffect(EffectMultiplier)
   */
  @JsonProperty("PHYS_DEF_DB")
  public void setPhysicalDefenseEffectJson(int physDefDb) {
    this.physicalDefenseEffect = EffectMultiplier.fromInt(physDefDb);
  }

  /** {@return the number of turns the physical defense buff or debuff lasts.} */
  @JsonProperty("PHYS_DEF_TM")
  public int getPhysicalDefenseEffectTime() {
    return physicalDefenseEffectTime;
  }

  /**
   * Sets the number of turns the physical defense buff or debuff lasts.
   *
   * @param physicalDefenseEffectTime the number of turns the physical defense buff or debuff lasts.
   */
  @JsonProperty("PHYS_DEF_TM")
  public void setPhysicalDefenseEffectTime(int physicalDefenseEffectTime) {
    this.physicalDefenseEffectTime = Math.max(0, Math.min(physicalDefenseEffectTime, 32));
  }

  /**
   * {@return the chance to inflict the physical defense buff or debuff as an integer percentage.}
   */
  @JsonProperty("PHYS_DEF_CH")
  public int getPhysicalDefenseEffectChance() {
    return physicalDefenseEffectChance;
  }

  /**
   * Sets the chance to inflict the physical defense buff or debuff as an integer percentage. The
   * input will be bound between 0-100; values outside of these bounds will be rounded to the
   * nearest valid integer.
   *
   * @param physicalDefenseEffectChance the chance to inflict the physical defense buff or debuff as
   *     an integer percentage.
   */
  @JsonProperty("PHYS_DEF_CH")
  public void setPhysicalDefenseEffectChance(int physicalDefenseEffectChance) {
    this.physicalDefenseEffectChance = constrainToIntegerPercentage(physicalDefenseEffectChance);
  }

  /** {@return the physical attack buff or debuff applied by the attack.} */
  @JsonIgnore
  public EffectMultiplier getPhysicalAttackEffect() {
    return physicalAttackEffect;
  }

  /**
   * Special serializer to enable compatibility with existing code.
   *
   * @return the integer representation of the physical attack buff or debuff.
   * @see Attack#getPhysicalAttackEffect()
   */
  @JsonProperty("PHYS_ATK_DB")
  public int getPhysicalAttackEffectJson() {
    return physicalAttackEffect.toInt();
  }

  /**
   * Sets the physical attack buff or debuff applied by the attack.
   *
   * @param physicalAttackEffect the physical attack buff or debuff applied by the attack.
   */
  @JsonIgnore
  public void setPhysicalAttackEffect(@NotNull EffectMultiplier physicalAttackEffect) {
    this.physicalAttackEffect = physicalAttackEffect;
  }

  /**
   * Special deserializer to enable compatibility with existing code.
   *
   * @param physAtkDb the value read from the JSON file.
   * @see Attack#setPhysicalAttackEffect(EffectMultiplier)
   */
  @JsonProperty("PHYS_ATK_DB")
  public void setPhysicalAttackEffectJson(int physAtkDb) {
    this.physicalAttackEffect = EffectMultiplier.fromInt(physAtkDb);
  }

  /** {@return the number of turns the physical attack buff or debuff lasts.} */
  @JsonProperty("PHYS_ATK_TM")
  public int getPhysicalAttackEffectTime() {
    return physicalAttackEffectTime;
  }

  /**
   * Sets the number of turns the physical attack buff or debuff lasts.
   *
   * @param physicalAttackEffectTime the number of turns the physical attack buff or debuff lasts.
   */
  @JsonProperty("PHYS_ATK_TM")
  public void setPhysicalAttackEffectTime(int physicalAttackEffectTime) {
    this.physicalAttackEffectTime = Math.max(0, Math.min(physicalAttackEffectTime, 32));
  }

  /**
   * {@return the chance to inflict the physical attack buff or debuff as an integer percentage.}
   */
  @JsonProperty("PHYS_ATK_CH")
  public int getPhysicalAttackEffectChance() {
    return physicalAttackEffectChance;
  }

  /**
   * Sets the chance to inflict the physical attack buff or debuff as an integer percentage.
   *
   * @param physicalAttackEffectChance the chance to inflict the physical attack buff or debuff as
   *     an integer percentage.
   */
  @JsonProperty("PHYS_ATK_CH")
  public void setPhysicalAttackEffectChance(int physicalAttackEffectChance) {
    this.physicalAttackEffectChance = constrainToIntegerPercentage(physicalAttackEffectChance);
  }

  /** {@return the ether defense buff or debuff applied by the attack.} */
  @JsonIgnore
  public EffectMultiplier getEtherDefenseEffect() {
    return etherDefenseEffect;
  }

  /**
   * Special serializer to enable compatibility with existing code.
   *
   * @return the integer representation of the ether defense buff or debuff.
   * @see Attack#getEtherDefenseEffect()
   */
  @JsonProperty("ETH_DEF_DB")
  public int getEtherDefenseEffectJson() {
    return etherDefenseEffect.toInt();
  }

  /**
   * Sets the ether defense buff or debuff applied by the attack.
   *
   * @param etherDefenseEffect the ether defense buff or debuff applied by the attack.
   */
  @JsonIgnore
  public void setEtherDefenseEffect(@NotNull EffectMultiplier etherDefenseEffect) {
    this.etherDefenseEffect = etherDefenseEffect;
  }

  /**
   * Special deserializer to enable compatibility with existing code.
   *
   * @param ethDefDb The value read from the JSON file.
   * @see Attack#setEtherDefenseEffect(EffectMultiplier)
   */
  @JsonProperty("ETH_DEF_DB")
  public void setEtherDefenseEffectJson(int ethDefDb) {
    this.etherDefenseEffect = EffectMultiplier.fromInt(ethDefDb);
  }

  /** {@return the number of turns the ether defense buff or debuff lasts.} */
  @JsonProperty("ETH_DEF_TM")
  public int getEtherDefenseEffectTime() {
    return etherDefenseEffectTime;
  }

  /**
   * Sets the number of turns the ether defense buff or debuff lasts.
   *
   * @param etherDefenseEffectTime the number of turns the ether defense buff or debuff lasts.
   */
  @JsonProperty("ETH_DEF_TM")
  public void setEtherDefenseEffectTime(int etherDefenseEffectTime) {
    this.etherDefenseEffectTime = Math.max(0, Math.min(etherDefenseEffectTime, 32));
  }

  /** {@return the chance to inflict the ether defense buff or debuff as an integer percentage.} */
  @JsonProperty("ETH_DEF_CH")
  public int getEtherDefenseEffectChance() {
    return etherDefenseEffectChance;
  }

  /**
   * Sets the chance to inflict the ether defense buff or debuff as an integer percentage.
   *
   * @param etherDefenseEffectChance the chance to inflict the ether defense buff or debuff as an
   *     integer percentage.
   */
  @JsonProperty("ETH_DEF_CH")
  public void setEtherDefenseEffectChance(int etherDefenseEffectChance) {
    this.etherDefenseEffectChance = constrainToIntegerPercentage(etherDefenseEffectChance);
  }

  /** {@return the potential buff or debuff applied by the attack.} */
  @JsonIgnore
  public EffectMultiplier getPotentialEffect() {
    return potentialEffect;
  }

  /**
   * Special serializer to enable compatibility with existing code.
   *
   * @return the integer representation of the potential buff or debuff.
   * @see Attack#getPotentialEffect()
   */
  @JsonProperty("ETH_ATK_DB")
  public int getPotentialEffectJson() {
    return potentialEffect.toInt();
  }

  /**
   * Sets the potential buff or debuff applied by the attack.
   *
   * @param potentialEffect the potential buff or debuff applied by the attack.
   */
  @JsonIgnore
  public void setPotentialEffect(@NotNull EffectMultiplier potentialEffect) {
    this.potentialEffect = potentialEffect;
  }

  /**
   * Special deserializer to enable compatibility with existing code.
   *
   * @param ethAtkDb the value read from the JSON file.
   * @see Attack#setPotentialEffect(EffectMultiplier)
   */
  @JsonProperty("ETH_ATK_DB")
  public void setPotentialEffectJson(int ethAtkDb) {
    this.potentialEffect = EffectMultiplier.fromInt(ethAtkDb);
  }

  /** {@return the number of turns the potential buff or debuff lasts.} */
  @JsonProperty("ETH_ATK_TM")
  public int getPotentialEffectTime() {
    return potentialEffectTime;
  }

  /**
   * Sets the number of turns the potential buff or debuff lasts.
   *
   * @param potentialEffectTime the number of turns the potential buff or debuff lasts.
   */
  @JsonProperty("ETH_ATK_TM")
  public void setPotentialEffectTime(int potentialEffectTime) {
    this.potentialEffectTime = Math.max(0, Math.min(potentialEffectTime, 32));
  }

  /** {@return the chance to inflict the potential buff or debuff as an integer percentage.} */
  @JsonProperty("ETH_ATK_CH")
  public int getPotentialEffectChance() {
    return potentialEffectChance;
  }

  /**
   * Sets the chance to inflict the potential buff or debuff as an integer percentage. The input
   * will be bound between 0-100; values outside of these bounds will be rounded to the nearest
   * valid integer.
   *
   * @param potentialEffectChance the chance to inflict the potential buff or debuff as an integer
   *     percentage.
   */
  @JsonProperty("ETH_ATK_CH")
  public void setPotentialEffectChance(int potentialEffectChance) {
    this.potentialEffectChance = constrainToIntegerPercentage(potentialEffectChance);
  }

  /**
   * Limits an integer to the integer percentage range 0-100 inclusive. Values outside the bounds
   * will be rounded to the nearest valid value.
   *
   * @param value The integer to constrain.
   * @return The constrained integer percentage.
   */
  private int constrainToIntegerPercentage(int value) {
    return Math.max(Math.min(value, 100), 0);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Attack attack)) return false;
    return hits == attack.hits
        && aoe == attack.aoe
        && accuracy == attack.accuracy
        && Double.compare(multiplier, attack.multiplier) == 0
        && dazeChance == attack.dazeChance
        && heal == attack.heal
        && leech == attack.leech
        && burnTime == attack.burnTime
        && poisonTime == attack.poisonTime
        && physicalDefenseEffect == attack.physicalDefenseEffect
        && physicalDefenseEffectTime == attack.physicalDefenseEffectTime
        && physicalDefenseEffectChance == attack.physicalDefenseEffectChance
        && physicalAttackEffect == attack.physicalAttackEffect
        && physicalAttackEffectTime == attack.physicalAttackEffectTime
        && physicalAttackEffectChance == attack.physicalAttackEffectChance
        && etherDefenseEffect == attack.etherDefenseEffect
        && etherDefenseEffectTime == attack.etherDefenseEffectTime
        && etherDefenseEffectChance == attack.etherDefenseEffectChance
        && potentialEffect == attack.potentialEffect
        && potentialEffectTime == attack.potentialEffectTime
        && potentialEffectChance == attack.potentialEffectChance
        && Objects.equals(title, attack.title)
        && Objects.equals(description, attack.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
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
  }

  @Override
  public String toString() {
    return "Attack{"
        + "title='"
        + title
        + '\''
        + ", description='"
        + description
        + '\''
        + ", hits="
        + hits
        + ", aoe="
        + aoe
        + ", accuracy="
        + accuracy
        + ", multiplier="
        + multiplier
        + ", dazeChance="
        + dazeChance
        + ", heal="
        + heal
        + ", leech="
        + leech
        + ", burnTime="
        + burnTime
        + ", poisonTime="
        + poisonTime
        + ", physicalDefenseEffect="
        + physicalDefenseEffect
        + ", physicalDefenseEffectTime="
        + physicalDefenseEffectTime
        + ", physicalDefenseEffectChance="
        + physicalDefenseEffectChance
        + ", physicalAttackEffect="
        + physicalAttackEffect
        + ", physicalAttackEffectTime="
        + physicalAttackEffectTime
        + ", physicalAttackEffectChance="
        + physicalAttackEffectChance
        + ", etherDefenseEffect="
        + etherDefenseEffect
        + ", etherDefenseEffectTime="
        + etherDefenseEffectTime
        + ", etherDefenseEffectChance="
        + etherDefenseEffectChance
        + ", potentialEffect="
        + potentialEffect
        + ", potentialEffectTime="
        + potentialEffectTime
        + ", potentialEffectChance="
        + potentialEffectChance
        + '}';
  }
}
