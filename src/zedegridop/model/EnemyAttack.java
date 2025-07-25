package zedegridop.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class EnemyAttack extends Attack {
    private int number;
    private EnemyAttackType type;
    private String target;
    private boolean usePotential;
    private int flicker;
    private int points;

    public EnemyAttack() {
        this.number = 0;
        this.type = EnemyAttackType.PHYSICAL_ATTACK;
        this.target = "Enemy";
        this.usePotential = false;
        this.flicker = 0;
        this.points = 0;
    }

    @JsonProperty("Num")
    public int getNumber() {
        return number;
    }

    @JsonProperty("Num")
    public void setNumber(int number) {
        this.number = number;
    }

    @JsonProperty("Type")
    public EnemyAttackType getType() {
        return type;
    }

    @JsonProperty("Type")
    public void setType(EnemyAttackType type) {
        this.type = type;
    }

    @JsonProperty("Target")
    public String getTarget() {
        return target;
    }

    @JsonProperty("Target")
    public void setTarget(String target) {
        this.target = target;
    }

    @JsonProperty("Use_Pot")
    public boolean isUsePotential() {
        return usePotential;
    }

    @JsonProperty("Use_Pot")
    public void setUsePotential(boolean usePotential) {
        this.usePotential = usePotential;
    }

    @JsonProperty("Flicker")
    public int getFlicker() {
        return flicker;
    }

    @JsonProperty("Flicker")
    public void setFlicker(int flicker) {
        this.flicker = flicker;
    }

    @JsonProperty("Points")
    public int getPoints() {
        return points;
    }

    @JsonProperty("Points")
    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof EnemyAttack that)) return false;
        if (!super.equals(o)) return false;
        return number == that.number && usePotential == that.usePotential && flicker == that.flicker && points == that.points && type == that.type && Objects.equals(target, that.target);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), number, type, target, usePotential, flicker, points);
    }

    @Override
    public String toString() {
        return "EnemyAttack{" +
                "number=" + number +
                ", type=" + type +
                ", target='" + target + '\'' +
                ", usePotential=" + usePotential +
                ", flicker=" + flicker +
                ", points=" + points +
                "} " + super.toString();
    }
}
