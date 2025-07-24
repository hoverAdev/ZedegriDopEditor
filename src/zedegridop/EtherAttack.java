package zedegridop;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class EtherAttack extends Attack {
    private String user;
    private int ep;
    private String dazeTarget;
    private boolean purge;
    private EtherAttackType type;
    private boolean physicalDefenseUp;
    private boolean physicalAttackUp;
    private boolean etherDefenseUp;
    private boolean etherAttackUp;
    private int speedUp;

    public EtherAttack() {
        user = "";
        ep = 0;
        dazeTarget = "";
        purge = false;
        type = EtherAttackType.ATTACK;
        physicalDefenseUp = false;
        physicalAttackUp = false;
        etherDefenseUp = false;
        etherAttackUp = false;
        speedUp = 0;
    }

    @JsonProperty("User")
    public String getUser() {
        return user;
    }

    @JsonProperty("User")
    public void setUser(String user) {
        this.user = user;
    }

    @JsonProperty("EP")
    public int getEp() {
        return ep;
    }

    @JsonProperty("EP")
    public void setEp(int ep) {
        this.ep = ep;
    }

    @JsonProperty("Daze_Target")
    public String getDazeTarget() {
        return dazeTarget;
    }

    @JsonProperty("Daze_Target")
    public void setDazeTarget(String dazeTarget) {
        this.dazeTarget = dazeTarget;
    }

    @JsonProperty("Purge")
    public boolean isPurge() {
        return purge;
    }

    @JsonProperty("Purge")
    public void setPurge(boolean purge) {
        this.purge = purge;
    }

    @JsonProperty("Type")
    public EtherAttackType getType() {
        return type;
    }

    @JsonProperty("Type")
    public void setType(EtherAttackType type) {
        this.type = type;
    }

    @JsonProperty("PHYS_DEF_UP")
    public boolean isPhysicalDefenseUp() {
        return physicalDefenseUp;
    }

    @JsonProperty("PHYS_DEF_UP")
    public void setPhysicalDefenseUp(boolean physicalDefenseUp) {
        this.physicalDefenseUp = physicalDefenseUp;
    }

    @JsonProperty("PHYS_ATK_UP")
    public boolean isPhysicalAttackUp() {
        return physicalAttackUp;
    }

    @JsonProperty("PHYS_ATK_UP")
    public void setPhysicalAttackUp(boolean physicalAttackUp) {
        this.physicalAttackUp = physicalAttackUp;
    }

    @JsonProperty("ETH_DEF_UP")
    public boolean isEtherDefenseUp() {
        return etherDefenseUp;
    }

    @JsonProperty("ETH_DEF_UP")
    public void setEtherDefenseUp(boolean etherDefenseUp) {
        this.etherDefenseUp = etherDefenseUp;
    }

    @JsonProperty("ETH_ATK_UP")
    public boolean isEtherAttackUp() {
        return etherAttackUp;
    }

    @JsonProperty("ETH_ATK_UP")
    public void setEtherAttackUp(boolean etherAttackUp) {
        this.etherAttackUp = etherAttackUp;
    }

    @JsonProperty("SPD_UP")
    public int getSpeedUp() {
        return speedUp;
    }

    @JsonProperty("SPD_UP")
    public void setSpeedUp(int speedUp) {
        this.speedUp = speedUp;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof EtherAttack that)) return false;
        if (!super.equals(o)) return false;
        return ep == that.ep && purge == that.purge && physicalDefenseUp == that.physicalDefenseUp && physicalAttackUp == that.physicalAttackUp && etherDefenseUp == that.etherDefenseUp && etherAttackUp == that.etherAttackUp && speedUp == that.speedUp && Objects.equals(user, that.user) && Objects.equals(dazeTarget, that.dazeTarget) && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), user, ep, dazeTarget, purge, type, physicalDefenseUp, physicalAttackUp, etherDefenseUp, etherAttackUp, speedUp);
    }

    @Override
    public String toString() {
        return "EtherAttack{" +
                "user='" + user + '\'' +
                ", ep=" + ep +
                ", dazeTarget='" + dazeTarget + '\'' +
                ", purge=" + purge +
                ", type=" + type +
                ", physicalDefenseUp=" + physicalDefenseUp +
                ", physicalAttackUp=" + physicalAttackUp +
                ", etherDefenseUp=" + etherDefenseUp +
                ", etherAttackUp=" + etherAttackUp +
                ", speedUp=" + speedUp +
                "} " + super.toString();
    }
}
