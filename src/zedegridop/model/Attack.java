package zedegridop.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public abstract class Attack {
    private String title;
    private String description;
    private int hits;
    private boolean aoe;
    private int accuracy;
    private double mult;
    private int dazePercent;
    private int heal;
    private boolean leech;
    private int burnTime;
    private int poisonTime;
    private int physicalDefenseDebuff;
    private int physicalDefenseTime;
    private int physicalDefenseChance;
    private int physicalAttackDebuff;
    private int physicalAttackTime;
    private int physicalAttackChance;
    private int etherDefenseDebuff;
    private int etherDefenseTime;
    private int etherDefenseChance;
    private int etherAttackDebuff;
    private int etherAttackTime;
    private int etherAttackChance;

    public Attack() {
        this.title = "None";
        this.description = "";
        this.hits = 0;
        this.aoe = false;
        this.accuracy = 0;
        this.mult = 0.0;
        this.dazePercent = 0;
        this.heal = 0;
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

    @JsonProperty("Title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("Title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("Desc")
    public String getDescription() {
        return description;
    }

    @JsonProperty("Desc")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("Hits")
    public int getHits() {
        return hits;
    }

    @JsonProperty("Hits")
    public void setHits(int hits) {
        this.hits = hits;
    }

    @JsonProperty("AOE")
    public boolean isAoe() {
        return aoe;
    }

    @JsonProperty("AOE")
    public void setAoe(boolean aoe) {
        this.aoe = aoe;
    }

    @JsonProperty("Acc")
    public int getAccuracy() {
        return accuracy;
    }

    @JsonProperty("Acc")
    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    @JsonProperty("Mult")
    public double getMult() {
        return mult;
    }

    @JsonProperty("Mult")
    public void setMult(double mult) {
        this.mult = mult;
    }

    @JsonProperty("Daze_Percent")
    public int getDazePercent() {
        return dazePercent;
    }

    @JsonProperty("Daze_Percent")
    public void setDazePercent(int dazePercent) {
        this.dazePercent = dazePercent;
    }

    @JsonProperty("Heal")
    public int getHeal() {
        return heal;
    }

    @JsonProperty("Heal")
    public void setHeal(int heal) {
        this.heal = heal;
    }

    @JsonProperty("Leech")
    public boolean isLeech() {
        return leech;
    }

    @JsonProperty("Leech")
    public void setLeech(boolean leech) {
        this.leech = leech;
    }

    @JsonProperty("BURN_TM")
    public int getBurnTime() {
        return burnTime;
    }

    @JsonProperty("BURN_TM")
    public void setBurnTime(int burnTime) {
        this.burnTime = burnTime;
    }

    @JsonProperty("POISON_TM")
    public int getPoisonTime() {
        return poisonTime;
    }

    @JsonProperty("POISON_TM")
    public void setPoisonTime(int poisonTime) {
        this.poisonTime = poisonTime;
    }

    @JsonProperty("PHYS_DEF_DB")
    public int getPhysicalDefenseDebuff() {
        return physicalDefenseDebuff;
    }

    @JsonProperty("PHYS_DEF_DB")
    public void setPhysicalDefenseDebuff(int physicalDefenseDebuff) {
        this.physicalDefenseDebuff = physicalDefenseDebuff;
    }

    @JsonProperty("PHYS_DEF_TM")
    public int getPhysicalDefenseTime() {
        return physicalDefenseTime;
    }

    @JsonProperty("PHYS_DEF_TM")
    public void setPhysicalDefenseTime(int physicalDefenseTime) {
        this.physicalDefenseTime = physicalDefenseTime;
    }

    @JsonProperty("PHYS_DEF_CH")
    public int getPhysicalDefenseChance() {
        return physicalDefenseChance;
    }

    @JsonProperty("PHYS_DEF_CH")
    public void setPhysicalDefenseChance(int physicalDefenseChance) {
        this.physicalDefenseChance = physicalDefenseChance;
    }

    @JsonProperty("PHYS_ATK_DB")
    public int getPhysicalAttackDebuff() {
        return physicalAttackDebuff;
    }

    @JsonProperty("PHYS_ATK_DB")
    public void setPhysicalAttackDebuff(int physicalAttackDebuff) {
        this.physicalAttackDebuff = physicalAttackDebuff;
    }

    @JsonProperty("PHYS_ATK_TM")
    public int getPhysicalAttackTime() {
        return physicalAttackTime;
    }

    @JsonProperty("PHYS_ATK_TM")
    public void setPhysicalAttackTime(int physicalAttackTime) {
        this.physicalAttackTime = physicalAttackTime;
    }

    @JsonProperty("PHYS_ATK_CH")
    public int getPhysicalAttackChance() {
        return physicalAttackChance;
    }

    @JsonProperty("PHYS_ATK_CH")
    public void setPhysicalAttackChance(int physicalAttackChance) {
        this.physicalAttackChance = physicalAttackChance;
    }

    @JsonProperty("ETH_DEF_DB")
    public int getEtherDefenseDebuff() {
        return etherDefenseDebuff;
    }

    @JsonProperty("ETH_DEF_DB")
    public void setEtherDefenseDebuff(int etherDefenseDebuff) {
        this.etherDefenseDebuff = etherDefenseDebuff;
    }

    @JsonProperty("ETH_DEF_TM")
    public int getEtherDefenseTime() {
        return etherDefenseTime;
    }

    @JsonProperty("ETH_DEF_TM")
    public void setEtherDefenseTime(int etherDefenseTime) {
        this.etherDefenseTime = etherDefenseTime;
    }

    @JsonProperty("ETH_DEF_CH")
    public int getEtherDefenseChance() {
        return etherDefenseChance;
    }

    @JsonProperty("ETH_DEF_CH")
    public void setEtherDefenseChance(int etherDefenseChance) {
        this.etherDefenseChance = etherDefenseChance;
    }

    @JsonProperty("ETH_ATK_DB")
    public int getEtherAttackDebuff() {
        return etherAttackDebuff;
    }

    @JsonProperty("ETH_ATK_DB")
    public void setEtherAttackDebuff(int etherAttackDebuff) {
        this.etherAttackDebuff = etherAttackDebuff;
    }

    @JsonProperty("ETH_ATK_TM")
    public int getEtherAttackTime() {
        return etherAttackTime;
    }

    @JsonProperty("ETH_ATK_TM")
    public void setEtherAttackTime(int etherAttackTime) {
        this.etherAttackTime = etherAttackTime;
    }

    @JsonProperty("ETH_ATK_CH")
    public int getEtherAttackChance() {
        return etherAttackChance;
    }

    @JsonProperty("ETH_ATK_CH")
    public void setEtherAttackChance(int etherAttackChance) {
        this.etherAttackChance = etherAttackChance;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Attack attack)) return false;
        return hits == attack.hits && aoe == attack.aoe && accuracy == attack.accuracy && Double.compare(mult, attack.mult) == 0 && dazePercent == attack.dazePercent && heal == attack.heal && leech == attack.leech && burnTime == attack.burnTime && poisonTime == attack.poisonTime && physicalDefenseDebuff == attack.physicalDefenseDebuff && physicalDefenseTime == attack.physicalDefenseTime && physicalDefenseChance == attack.physicalDefenseChance && physicalAttackDebuff == attack.physicalAttackDebuff && physicalAttackTime == attack.physicalAttackTime && physicalAttackChance == attack.physicalAttackChance && etherDefenseDebuff == attack.etherDefenseDebuff && etherDefenseTime == attack.etherDefenseTime && etherDefenseChance == attack.etherDefenseChance && etherAttackDebuff == attack.etherAttackDebuff && etherAttackTime == attack.etherAttackTime && etherAttackChance == attack.etherAttackChance && Objects.equals(title, attack.title) && Objects.equals(description, attack.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, hits, aoe, accuracy, mult, dazePercent, heal, leech, burnTime, poisonTime, physicalDefenseDebuff, physicalDefenseTime, physicalDefenseChance, physicalAttackDebuff, physicalAttackTime, physicalAttackChance, etherDefenseDebuff, etherDefenseTime, etherDefenseChance, etherAttackDebuff, etherAttackTime, etherAttackChance);
    }

    @Override
    public String toString() {
        return "Attack{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", hits=" + hits +
                ", aoe=" + aoe +
                ", accuracy=" + accuracy +
                ", mult=" + mult +
                ", dazePercent=" + dazePercent +
                ", heal=" + heal +
                ", leech=" + leech +
                ", burnTime=" + burnTime +
                ", poisonTime=" + poisonTime +
                ", physicalDefenseDebuff=" + physicalDefenseDebuff +
                ", physicalDefenseTime=" + physicalDefenseTime +
                ", physicalDefenseChance=" + physicalDefenseChance +
                ", physicalAttackDebuff=" + physicalAttackDebuff +
                ", physicalAttackTime=" + physicalAttackTime +
                ", physicalAttackChance=" + physicalAttackChance +
                ", etherDefenseDebuff=" + etherDefenseDebuff +
                ", etherDefenseTime=" + etherDefenseTime +
                ", etherDefenseChance=" + etherDefenseChance +
                ", etherAttackDebuff=" + etherAttackDebuff +
                ", etherAttackTime=" + etherAttackTime +
                ", etherAttackChance=" + etherAttackChance +
                '}';
    }
}
