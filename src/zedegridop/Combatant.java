package zedegridop;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.Contract;

import java.util.Objects;

public class Combatant {
    private String name;
    private int hp;
    private int defense;
    private int etherDefense;
    private int speed;
    private int attack;
    private int potential;

    @Contract(pure = true)
    protected Combatant() {
        this.name = "None";
        this.hp = 0;
        this.defense = 0;
        this.etherDefense = 0;
        this.speed = 255;
        this.attack = 0;
        this.potential = 0;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("HP")
    public int getHp() {
        return hp;
    }

    @JsonProperty("HP")
    public void setHp(int hp) {
        this.hp = hp;
    }

    @JsonProperty("DEF")
    public int getDef() {
        return defense;
    }

    @JsonProperty("DEF")
    public void setDef(int def) {
        this.defense = def;
    }

    @JsonProperty("EthDEF")
    public int getEtherDefense() {
        return etherDefense;
    }

    @JsonProperty("EthDEF")
    public void setEtherDefense(int etherDefense) {
        this.etherDefense = etherDefense;
    }

    @JsonProperty("Speed")
    public int getSpeed() {
        return speed;
    }

    @JsonProperty("Speed")
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @JsonProperty("Attack")
    public int getAttack() {
        return attack;
    }

    @JsonProperty("Attack")
    public void setAttack(int attack) {
        this.attack = attack;
    }

    @JsonProperty("Potent")
    public int getPotential() {
        return potential;
    }

    @JsonProperty("Potent")
    public void setPotential(int potential) {
        this.potential = potential;
    }

    @Contract(value = "null -> false", pure = true)
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Combatant combatant)) return false;
        return hp == combatant.hp && defense == combatant.defense && etherDefense == combatant.etherDefense && speed == combatant.speed && attack == combatant.attack && potential == combatant.potential && Objects.equals(name, combatant.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hp, defense, etherDefense, speed, attack, potential);
    }

    @Override
    public String toString() {
        return "Combatant{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", defense=" + defense +
                ", etherDefense=" + etherDefense +
                ", speed=" + speed +
                ", attack=" + attack +
                ", potential=" + potential +
                '}';
    }
}
