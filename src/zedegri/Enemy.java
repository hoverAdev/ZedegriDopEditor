package zedegri;

import java.util.LinkedList;
import java.util.List;

public class Enemy extends Combatant {
    private String type;
    private List<EnemyAttack> attacks;

    public Enemy() {
        super();
        this.attacks = new LinkedList<>();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<EnemyAttack> getAttacks() {
        return attacks;
    }

    public void setAttacks(List<EnemyAttack> attacks) {
        this.attacks = attacks;
    }

    public static Enemy fromJson(String filePath) {
        return new Enemy();
    }

    public String toJson() {
        return "";
    }
}
