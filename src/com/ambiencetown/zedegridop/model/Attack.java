package com.ambiencetown.zedegridop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

/**
 * Represents an attack in the Zedegri DOP engine. Notably, attacks are not necessarily offensive:
 * attacks may also inflict healing and buffs to teammates.
 *
 * <p>This class includes logic for dealing with JSON serialization and deserialization using
 * Jackson (<a
 * href="https://repo.maven.apache.org/maven2/com/fasterxml/jackson/core/jackson-databind/2.19.0/">
 * Maven</a>). The {@code heal} field is treated specially: it is serialized as {@code 0} or {@code
 * 1}, corresponding to {@code false} and {@code true} respectively.
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

  /** TODO: Ask Fiora */
  private double mult;

  /** TODO: Ask Fiora */
  private int dazePercent;

  /** Whether the attack is a healing attack. */
  private boolean heal;

  /** Whether the attack leeches health from enemies. */
  private boolean leech;

  /** The number of turns to inflict Burn. */
  private int burnTime;

  /** The number of turns to inflict Poison. */
  private int poisonTime;

  /** TODO: Ask Fiora */
  private int physicalDefenseDebuff;

  /** The number of turns to inflict Physical Defense Down. */
  private int physicalDefenseTime;

  /** TODO: Ask Fiora */
  private int physicalDefenseChance;

  /** TODO: Ask Fiora */
  private int physicalAttackDebuff;

  /** The number of turns to inflict Physical Attack Down. */
  private int physicalAttackTime;

  /** TODO: Ask Fiora */
  private int physicalAttackChance;

  /** TODO: Ask Fiora */
  private int etherDefenseDebuff;

  /** The number of turns to inflict Ether Defense Down. */
  private int etherDefenseTime;

  /** TODO: Ask Fiora */
  private int etherDefenseChance;

  /** TODO: Ask Fiora */
  private int etherAttackDebuff;

  /** The number of turns to inflict Ether Attack Down. */
  private int etherAttackTime;

  /** TODO: Ask Fiora */
  private int etherAttackChance;

  /** Constructs an Attack with the default values. */
  protected Attack() {
    this.title = "None";
    this.description = "";
    this.hits = 0;
    this.aoe = false;
    this.accuracy = 0;
    this.mult = 0.0;
    this.dazePercent = 0;
    this.heal = false;
    this.leech = false;
    this.burnTime = 0;
    this.poisonTime = 0;
    this.physicalDefenseDebuff = 0;
    this.physicalDefenseTime = 0;
    this.physicalDefenseChance = 0;
    this.physicalAttackDebuff = 0;
    this.physicalAttackTime = 0;
    this.physicalAttackChance = 0;
    this.etherDefenseDebuff = 0;
    this.etherDefenseTime = 0;
    this.etherDefenseChance = 0;
    this.etherAttackDebuff = 0;
    this.etherAttackTime = 0;
    this.etherAttackChance = 0;
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
  public void setTitle(String title) {
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
  public void setDescription(String description) {
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
    this.hits = hits;
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
    if (accuracy < 0) accuracy = 0;
    else if (accuracy > 100) accuracy = 100;

    this.accuracy = accuracy;
  }

  /** TODO */
  @JsonProperty("Mult")
  public double getMult() {
    return mult;
  }

  /** TODO */
  @JsonProperty("Mult")
  public void setMult(double mult) {
    this.mult = mult;
  }

  /** TODO */
  @JsonProperty("Daze_Percent")
  public int getDazePercent() {
    return dazePercent;
  }

  /** TODO */
  @JsonProperty("Daze_Percent")
  public void setDazePercent(int dazePercent) {
    this.dazePercent = dazePercent;
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
    this.burnTime = burnTime;
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
    this.poisonTime = poisonTime;
  }

  /** TODO */
  @JsonProperty("PHYS_DEF_DB")
  public int getPhysicalDefenseDebuff() {
    return physicalDefenseDebuff;
  }

  /** TODO */
  @JsonProperty("PHYS_DEF_DB")
  public void setPhysicalDefenseDebuff(int physicalDefenseDebuff) {
    this.physicalDefenseDebuff = physicalDefenseDebuff;
  }

  /** {@return the number of turns to inflict Physical Defense Down.} */
  @JsonProperty("PHYS_DEF_TM")
  public int getPhysicalDefenseTime() {
    return physicalDefenseTime;
  }

  /**
   * Sets the number of turns to inflict Physical Defense Down.
   *
   * @param physicalDefenseTime the number of turns to inflict Physical Defense Down.
   */
  @JsonProperty("PHYS_DEF_TM")
  public void setPhysicalDefenseTime(int physicalDefenseTime) {
    this.physicalDefenseTime = physicalDefenseTime;
  }

  /** TODO */
  @JsonProperty("PHYS_DEF_CH")
  public int getPhysicalDefenseChance() {
    return physicalDefenseChance;
  }

  /** TODO */
  @JsonProperty("PHYS_DEF_CH")
  public void setPhysicalDefenseChance(int physicalDefenseChance) {
    this.physicalDefenseChance = physicalDefenseChance;
  }

  /** TODO */
  @JsonProperty("PHYS_ATK_DB")
  public int getPhysicalAttackDebuff() {
    return physicalAttackDebuff;
  }

  /** TODO */
  @JsonProperty("PHYS_ATK_DB")
  public void setPhysicalAttackDebuff(int physicalAttackDebuff) {
    this.physicalAttackDebuff = physicalAttackDebuff;
  }

  /** {@return the number of turns to inflict Physical Attack Down.} */
  @JsonProperty("PHYS_ATK_TM")
  public int getPhysicalAttackTime() {
    return physicalAttackTime;
  }

  /**
   * Sets the number of turns to inflict Physical Attack Down.
   *
   * @param physicalAttackTime the number of turns to inflict Physical Attack Down
   */
  @JsonProperty("PHYS_ATK_TM")
  public void setPhysicalAttackTime(int physicalAttackTime) {
    this.physicalAttackTime = physicalAttackTime;
  }

  /** TODO */
  @JsonProperty("PHYS_ATK_CH")
  public int getPhysicalAttackChance() {
    return physicalAttackChance;
  }

  /** TODO */
  @JsonProperty("PHYS_ATK_CH")
  public void setPhysicalAttackChance(int physicalAttackChance) {
    this.physicalAttackChance = physicalAttackChance;
  }

  /** TODO */
  @JsonProperty("ETH_DEF_DB")
  public int getEtherDefenseDebuff() {
    return etherDefenseDebuff;
  }

  /** TODO */
  @JsonProperty("ETH_DEF_DB")
  public void setEtherDefenseDebuff(int etherDefenseDebuff) {
    this.etherDefenseDebuff = etherDefenseDebuff;
  }

  /** {@return the number of turns to inflict Ether Defense Down.} */
  @JsonProperty("ETH_DEF_TM")
  public int getEtherDefenseTime() {
    return etherDefenseTime;
  }

  /**
   * Sets the number of turns to inflict Ether Defense Down.
   *
   * @param etherDefenseTime the number of turns to inflict Ether Defense Down.
   */
  @JsonProperty("ETH_DEF_TM")
  public void setEtherDefenseTime(int etherDefenseTime) {
    this.etherDefenseTime = etherDefenseTime;
  }

  /** TODO */
  @JsonProperty("ETH_DEF_CH")
  public int getEtherDefenseChance() {
    return etherDefenseChance;
  }

  /** TODO */
  @JsonProperty("ETH_DEF_CH")
  public void setEtherDefenseChance(int etherDefenseChance) {
    this.etherDefenseChance = etherDefenseChance;
  }

  /** TODO */
  @JsonProperty("ETH_ATK_DB")
  public int getEtherAttackDebuff() {
    return etherAttackDebuff;
  }

  /** TODO */
  @JsonProperty("ETH_ATK_DB")
  public void setEtherAttackDebuff(int etherAttackDebuff) {
    this.etherAttackDebuff = etherAttackDebuff;
  }

  /** {@return the number of turns to inflict Ether Attack Down.} */
  @JsonProperty("ETH_ATK_TM")
  public int getEtherAttackTime() {
    return etherAttackTime;
  }

  /**
   * Sets the number of turns to inflict Ether Attack Down.
   *
   * @param etherAttackTime the number of turns to inflict Ether Attack Down.
   */
  @JsonProperty("ETH_ATK_TM")
  public void setEtherAttackTime(int etherAttackTime) {
    this.etherAttackTime = etherAttackTime;
  }

  /** TODO */
  @JsonProperty("ETH_ATK_CH")
  public int getEtherAttackChance() {
    return etherAttackChance;
  }

  /** TODO */
  @JsonProperty("ETH_ATK_CH")
  public void setEtherAttackChance(int etherAttackChance) {
    this.etherAttackChance = etherAttackChance;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Attack attack)) return false;
    return hits == attack.hits
        && aoe == attack.aoe
        && accuracy == attack.accuracy
        && Double.compare(mult, attack.mult) == 0
        && dazePercent == attack.dazePercent
        && heal == attack.heal
        && leech == attack.leech
        && burnTime == attack.burnTime
        && poisonTime == attack.poisonTime
        && physicalDefenseDebuff == attack.physicalDefenseDebuff
        && physicalDefenseTime == attack.physicalDefenseTime
        && physicalDefenseChance == attack.physicalDefenseChance
        && physicalAttackDebuff == attack.physicalAttackDebuff
        && physicalAttackTime == attack.physicalAttackTime
        && physicalAttackChance == attack.physicalAttackChance
        && etherDefenseDebuff == attack.etherDefenseDebuff
        && etherDefenseTime == attack.etherDefenseTime
        && etherDefenseChance == attack.etherDefenseChance
        && etherAttackDebuff == attack.etherAttackDebuff
        && etherAttackTime == attack.etherAttackTime
        && etherAttackChance == attack.etherAttackChance
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
        mult,
        dazePercent,
        heal,
        leech,
        burnTime,
        poisonTime,
        physicalDefenseDebuff,
        physicalDefenseTime,
        physicalDefenseChance,
        physicalAttackDebuff,
        physicalAttackTime,
        physicalAttackChance,
        etherDefenseDebuff,
        etherDefenseTime,
        etherDefenseChance,
        etherAttackDebuff,
        etherAttackTime,
        etherAttackChance);
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
        + ", mult="
        + mult
        + ", dazePercent="
        + dazePercent
        + ", heal="
        + heal
        + ", leech="
        + leech
        + ", burnTime="
        + burnTime
        + ", poisonTime="
        + poisonTime
        + ", physicalDefenseDebuff="
        + physicalDefenseDebuff
        + ", physicalDefenseTime="
        + physicalDefenseTime
        + ", physicalDefenseChance="
        + physicalDefenseChance
        + ", physicalAttackDebuff="
        + physicalAttackDebuff
        + ", physicalAttackTime="
        + physicalAttackTime
        + ", physicalAttackChance="
        + physicalAttackChance
        + ", etherDefenseDebuff="
        + etherDefenseDebuff
        + ", etherDefenseTime="
        + etherDefenseTime
        + ", etherDefenseChance="
        + etherDefenseChance
        + ", etherAttackDebuff="
        + etherAttackDebuff
        + ", etherAttackTime="
        + etherAttackTime
        + ", etherAttackChance="
        + etherAttackChance
        + '}';
  }
}
