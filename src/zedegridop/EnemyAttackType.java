package zedegridop;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public enum EnemyAttackType {
    TEAM_HEAL,
    HEAL,
    LEECH,
    HEAVY_PHYSICAL_ATTACK,
    HEAVY_ETHER_ATTACK,
    PHYSICAL_DEFENSE_UP,
    ETHER_DEFENSE_UP,
    DAZE,
    FLICKER,
    PHYSICAL_ATTACK_UP_2,
    PHYSICAL_ATTACK_UP_15,
    POTENTIAL_UP_2,
    POTENTIAL_UP_15,
    PHYSICAL_DEFENSE_DOWN,
    ETHER_DEFENSE_DOWN,
    PHYSICAL_ATTACK_DOWN,
    POTENTIAL_DOWN,
    BURN,
    POISON,
    PHYSICAL_ATTACK,
    ETHER_ATTACK;

    @JsonCreator
    public static @Nullable EnemyAttackType fromString(String name) {
        for (EnemyAttackType type : EnemyAttackType.values()) {
            if (name.equals(type.toString())) {
                return type;
            }
        }
        return null;
    }

    @Contract(pure = true)
    @Override
    public @NotNull String toString() {
        return switch (this) {
            case TEAM_HEAL -> "Team Heal";
            case HEAL -> "Heal";
            case LEECH -> "Leech";
            case HEAVY_PHYSICAL_ATTACK -> "Heavy Phys Attack";
            case HEAVY_ETHER_ATTACK -> "Heavy Ether Attack";
            case PHYSICAL_DEFENSE_UP -> "Phys Def Up";
            case ETHER_DEFENSE_UP -> "Eth Def Up";
            case DAZE -> "Daze";
            case FLICKER -> "Flicker";
            case PHYSICAL_ATTACK_UP_2 -> "Phys Attack Up 2";
            case PHYSICAL_ATTACK_UP_15 -> "Phys Attack Up 1.5";
            case POTENTIAL_UP_2 -> "Potential Up 2";
            case POTENTIAL_UP_15 -> "Potential Up 1.5";
            case PHYSICAL_DEFENSE_DOWN -> "Phys Def Down";
            case ETHER_DEFENSE_DOWN -> "Eth Def Down";
            case PHYSICAL_ATTACK_DOWN -> "Phys Attack Down";
            case POTENTIAL_DOWN -> "Potential Down";
            case BURN -> "Burn";
            case POISON -> "Poison";
            case PHYSICAL_ATTACK -> "Phys Attack";
            case ETHER_ATTACK -> "Eth Attack";
        };
    }
}
