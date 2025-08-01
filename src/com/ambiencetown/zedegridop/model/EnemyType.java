package com.ambiencetown.zedegridop.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.jetbrains.annotations.*;

/**
 * A type of enemy in the Zedegri DOP engine.
 *
 * @author Fiora Satou
 * @author Serenity Montgomery
 */
public enum EnemyType {
  /** An animal-type enemy. */
  ANIMAL,
  /** A human enemy. */
  HUMAN,
  /** A Zedegri-type enemy. */
  ZEDEGRI,
  /** A ghost-type enemy. */
  GHOST,
  /** An undazeable enemy. */
  UNDAZEABLE;

  /**
   * Selects the corresponding {@code EnemyType} from JSON input. For use with Jackson.
   *
   * @param value The {@code String}-formatted name of the type.
   * @return The corresponding {@code EnemyType}. <br>
   *     {@code null} if no match is found.
   */
  @JsonCreator
  public static @Nullable EnemyType fromString(String value) {
    return switch (value) {
      case "Animal" -> ANIMAL;
      case "Human" -> HUMAN;
      case "Zedegri" -> ZEDEGRI;
      case "Ghost" -> GHOST;
      case "Undazeable" -> UNDAZEABLE;
      default -> null;
    };
  }

  @Override
  @JsonValue
  public @NotNull String toString() {
    return switch (this) {
      case ANIMAL -> "Animal";
      case HUMAN -> "Human";
      case ZEDEGRI -> "Zedegri";
      case GHOST -> "Ghost";
      case UNDAZEABLE -> "Undazeable";
    };
  }
}
