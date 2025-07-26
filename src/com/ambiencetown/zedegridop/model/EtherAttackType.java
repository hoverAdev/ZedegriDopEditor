package com.ambiencetown.zedegridop.model;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Represents a type of {@link EtherAttack}.
 *
 * @author Fiora Satou
 * @author Serenity Montgomery
 */
public enum EtherAttackType {
  /** Damages or debuffs an opponent. */
  ATTACK,
  /** Buffs or heals self. */
  SELF,
  /** Buffs or heals the team. */
  TEAM;

  /**
   * Selects the corresponding {@code EtherAttackType} from JSON input. For use with Jackson (<a
   * href="https://repo.maven.apache.org/maven2/com/fasterxml/jackson/core/jackson-databind/2.19.0/">
   * Maven</a>).
   *
   * @param name The {@code String}-formatted name of the type.
   * @return The corresponding {@code EtherAttackType}.<br>
   *     {@code null} if no matching type is found.
   */
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
    return switch (this) {
      case ATTACK -> "Attack";
      case SELF -> "Self";
      case TEAM -> "Team";
    };
  }
}
