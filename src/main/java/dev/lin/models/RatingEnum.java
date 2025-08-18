package dev.lin.models;

public enum RatingEnum {
    BUENO(1, "Bueno"),
    MALO(2, "Malo");

    private final int value;
    private final String displayName;

    RatingEnum(int value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    public int getValue() {
        return value;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static RatingEnum fromInt(int value) {
        for (RatingEnum type : values()) {
            if (type.value == value) {
                return type;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return displayName;
    }
}