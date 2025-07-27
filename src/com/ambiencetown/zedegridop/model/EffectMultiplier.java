package com.ambiencetown.zedegridop.model;

/** A stat multiplier for a buff or debuff in the Zedegri DOP Engine. */
public enum EffectMultiplier {
  /** The effect debuffs a stat by 0.5×. */
  TIMES_05,
  /** The effect buffs a stat by 1.5x, */
  TIMES_15,
  /** The effect buffs a stat by 2.0×. */
  TIMES_20;

  /** {@return the integer value of the multiplier for JSON serialization.} */
  public int toInt() {
    return switch (this) {
      case TIMES_05 -> 0;
      case TIMES_15 -> 1;
      case TIMES_20 -> 2;
    };
  }

  /**
   * Gets the corresponding multiplier from an integer input. Used for JSON deserialization.
   *
   * @param input The integer input corresponding to an effect multiplier. Typically read from JSON
   *     input.
   * @return The corresponding multiplier, or {@code null} if the input was invalid.
   */
  public static EffectMultiplier fromInt(int input) {
    return switch (input) {
      case 0 -> TIMES_05;
      case 1 -> TIMES_15;
      case 2 -> TIMES_20;
      default -> null;
    };
  }

  @Override
  public String toString() {
    return switch (this) {
      case TIMES_05 -> "0.5x";
      case TIMES_15 -> "1.5x";
      case TIMES_20 -> "2.0x";
    };
  }
}
