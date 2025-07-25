package zedegridop.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Enemy extends Combatant {
    private String type;
    private List<EnemyAttack> attacks;

    public Enemy() {
        super();
        this.attacks = new ArrayList<>();
    }

    @JsonProperty("Type")
    public String getType() {
        return type;
    }

    @JsonProperty("Type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("Attacks")
    public List<EnemyAttack> getAttacks() {
        return attacks;
    }

    @JsonProperty("Attacks")
    public void setAttacks(List<EnemyAttack> attacks) {
        this.attacks = attacks;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Enemy enemy)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(type, enemy.type) && Objects.equals(attacks, enemy.attacks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type, attacks);
    }

    @Override
    public String toString() {
        return "Enemy{" +
                "type='" + type + '\'' +
                ", attacks=" + attacks +
                "} " + super.toString();
    }
}
