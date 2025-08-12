package dev.lin.dtos;

import java.time.LocalDate;
import dev.lin.models.EmotionEnum;

public record MomentViewDTO(int id, String title, EmotionEnum emotion, LocalDate date, String description) {

public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public EmotionEnum getEmotion() {
        return emotion;
    }
    
    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

}
