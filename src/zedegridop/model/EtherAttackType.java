package zedegridop.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum EtherAttackType {
    ATTACK,
    SELF,
    TEAM;

    @JsonCreator
    public static EtherAttackType fromString(String name) {
        for (EtherAttackType type : EtherAttackType.values()) {
            if (name.equals(type.toString())) {
                return type;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return switch(this) {
            case ATTACK -> "Attack";
            case SELF -> "Self";
            case TEAM -> "Team";
        };
    }
}
