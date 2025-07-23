package zedegri;

public class Player extends Combatant {
    private int ap;
    private int ep;

    public Player() {
        super();
        this.ap = 0;
        this.ep = 0;
    }

    public int getAp() {
        return ap;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }

    public int getEp() {
        return ep;
    }

    public void setEp(int ep) {
        this.ep = ep;
    }

    public static Player fromJson(String filePath) {
        return new Player();
    }

    public String toJson() {
        return "";
    }
}
