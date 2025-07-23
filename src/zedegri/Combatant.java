package zedegri;

public class Combatant {
    private String name;
    private int hp;
    private int def;
    private int ethDef;
    private int speed;
    private int attack;
    private int potential;

    protected Combatant() {
        this.name = "None";
        this.hp = 0;
        this.def = 0;
        this.ethDef = 0;
        this.speed = 255;
        this.attack = 0;
        this.potential = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getEthDef() {
        return ethDef;
    }

    public void setEthDef(int ethDef) {
        this.ethDef = ethDef;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getPotential() {
        return potential;
    }

    public void setPotential(int potential) {
        this.potential = potential;
    }

    @Override
    public String toString() {
        return name;
    }
}
