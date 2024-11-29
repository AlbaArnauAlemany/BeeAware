package ch.unil.doplab.beeaware.Domain;

/**
 * Represents the intensity of a reaction used to construct a Symptom.
 * The reaction intensity is categorized into six levels ranging from no reaction to very high reaction.
 */

public enum Reaction {
    NO_REACTION(0),
    VERY_LOW_REACTION(1),
    LOW_REACTION(2),
    MODERATE_REACTION(3),
    HIGH_REACTION(4),
    VERY_HIGH_REACTION(5);

    private int value;

    Reaction(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Reaction fromValue(int value) {
        return switch (value) {
            case 0 -> NO_REACTION;
            case 1 -> VERY_LOW_REACTION;
            case 2 -> LOW_REACTION;
            case 3 -> MODERATE_REACTION;
            case 4 -> HIGH_REACTION;
            case 5 -> VERY_HIGH_REACTION;
            default -> throw new IllegalArgumentException("Invalid level value: " + value);
        };
    }

    @Override
    public String toString() {
        return name().replace('_', ' ');
    }
}
