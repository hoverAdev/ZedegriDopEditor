package zedegridop;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Player extends Combatant {
    private int ap;
    private int ep;

    public Player() {
        super();
        this.ap = 0;
        this.ep = 0;
    }

    @JsonProperty("AP")
    public int getAp() {
        return ap;
    }

    @JsonProperty("AP")
    public void setAp(int ap) {
        this.ap = ap;
    }

    @JsonProperty("EP")
    public int getEp() {
        return ep;
    }

    @JsonProperty("EP")
    public void setEp(int ep) {
        this.ep = ep;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Player player)) return false;
        if (!super.equals(o)) return false;
        return ap == player.ap && ep == player.ep;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ap, ep);
    }

    @Override
    public String toString() {
        return "Player{" +
                "ap=" + ap +
                ", ep=" + ep +
                "} " + super.toString();
    }
}
