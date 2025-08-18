package dev.lin.models;

public enum FilterOptionEnum {
    EMOTION(1),
    DATE(2),
    RATING(3);

    private final int value;

    FilterOptionEnum(int value) {
        this.value = value;
    }

    public static FilterOptionEnum fromInt(int option) {
        for (FilterOptionEnum fo : values()) {
            if (fo.value == option) {
                return fo;
            }
        }
        return null;
    }
}