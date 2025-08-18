package dev.lin.dtos;

import java.time.LocalDate;
import dev.lin.models.EmotionEnum;
import dev.lin.models.RatingEnum;

public record MomentFilterDTO(EmotionEnum emotion, LocalDate date, RatingEnum rating) {


    public EmotionEnum getEmotion() {
        return emotion;
    }
    
    public LocalDate getDate() {
        return date;
    }

    public RatingEnum getRating() {
        return rating;
    }

}

