package zedegri;

public class Attack {
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

    public int getEtherAttackChance() {
        return etherAttackChance;
    }

    public void setEtherAttackChance(int etherAttackChance) {
        this.etherAttackChance = etherAttackChance;
    }

    public int getEtherAttackTime() {
        return etherAttackTime;
    }

    public void setEtherAttackTime(int etherAttackTime) {
        this.etherAttackTime = etherAttackTime;
    }

    public int getEtherAttackDebuff() {
        return etherAttackDebuff;
    }

    public void setEtherAttackDebuff(int etherAttackDebuff) {
        this.etherAttackDebuff = etherAttackDebuff;
    }

    public int getEtherDefenseChance() {
        return etherDefenseChance;
    }

    public void setEtherDefenseChance(int etherDefenseChance) {
        this.etherDefenseChance = etherDefenseChance;
    }

    public int getEtherDefenseTime() {
        return etherDefenseTime;
    }

    public void setEtherDefenseTime(int etherDefenseTime) {
        this.etherDefenseTime = etherDefenseTime;
    }

    public int getEtherDefenseDebuff() {
        return etherDefenseDebuff;
    }

    public void setEtherDefenseDebuff(int etherDefenseDebuff) {
        this.etherDefenseDebuff = etherDefenseDebuff;
    }

    public int getPhysicalAttackChance() {
        return physicalAttackChance;
    }

    public void setPhysicalAttackChance(int physicalAttackChance) {
        this.physicalAttackChance = physicalAttackChance;
    }

    public int getPhysicalAttackTime() {
        return physicalAttackTime;
    }

    public void setPhysicalAttackTime(int physicalAttackTime) {
        this.physicalAttackTime = physicalAttackTime;
    }

    public int getPhysicalAttackDebuff() {
        return physicalAttackDebuff;
    }

    public void setPhysicalAttackDebuff(int physicalAttackDebuff) {
        this.physicalAttackDebuff = physicalAttackDebuff;
    }

    public int getPhysicalDefenseChance() {
        return physicalDefenseChance;
    }

    public void setPhysicalDefenseChance(int physicalDefenseChance) {
        this.physicalDefenseChance = physicalDefenseChance;
    }

    public int getPhysicalDefenseTime() {
        return physicalDefenseTime;
    }

    public void setPhysicalDefenseTime(int physicalDefenseTime) {
        this.physicalDefenseTime = physicalDefenseTime;
    }

    public int getPhysicalDefenseDebuff() {
        return physicalDefenseDebuff;
    }

    public void setPhysicalDefenseDebuff(int physicalDefenseDebuff) {
        this.physicalDefenseDebuff = physicalDefenseDebuff;
    }

    public int getPoisonTime() {
        return poisonTime;
    }

    public void setPoisonTime(int poisonTime) {
        this.poisonTime = poisonTime;
    }

    public int getBurnTime() {
        return burnTime;
    }

    public void setBurnTime(int burnTime) {
        this.burnTime = burnTime;
    }

    public boolean isLeech() {
        return leech;
    }

    public void setLeech(boolean leech) {
        this.leech = leech;
    }

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    public int getDazePercent() {
        return dazePercent;
    }

    public void setDazePercent(int dazePercent) {
        this.dazePercent = dazePercent;
    }

    public double getMult() {
        return mult;
    }

    public void setMult(double mult) {
        this.mult = mult;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public boolean isAoe() {
        return aoe;
    }

    public void setAoe(boolean aoe) {
        this.aoe = aoe;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
