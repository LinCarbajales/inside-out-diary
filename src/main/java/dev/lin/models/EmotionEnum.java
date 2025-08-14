package dev.lin.models;

public enum EmotionEnum {
    ALEGRIA(1, "Alegría"),
    TRISTEZA(2, "Tristeza"),
    IRA(3, "Ira"),
    ASCO(4, "Asco"),
    MIEDO(5, "Miedo"),
    ANSIEDAD(6, "Ansiedad"),
    ENVIDIA(7, "Envidia"),
    VERGUENZA(8, "Vergüenza"),
    ABURRIMIENTO(9, "Aburrimiento"),
    NOSTALGIA(10, "Nostalgia");

    private final int number;
    private final String name;

    EmotionEnum(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public static String getEmotion(int number) {
        for (EmotionEnum e : values()) {
            if (e.number == number) return e.name;
        }
        return null;
    }
    public static EmotionEnum fromNumber(int number) {
        for (EmotionEnum e : values()) {
            if (e.number == number) return e;
        }
        return null;
    }

    public String getName() {
        return name;
    }
}