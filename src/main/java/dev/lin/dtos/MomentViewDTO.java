package dev.lin.dtos;

import java.time.LocalDate;
import dev.lin.models.EmotionEnum;
import dev.lin.models.RatingEnum;

public record MomentViewDTO(int id, String title, EmotionEnum emotion, RatingEnum rating, LocalDate date, String description, LocalDate creationDate, LocalDate update) {

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public EmotionEnum getEmotion() {
        return emotion;
    }
    
    public RatingEnum getRating() {
        return rating;
    }
    
    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public LocalDate getUpdate() {
        return update;
    }

}
