package dev.lin.dtos;

import java.time.LocalDate;
import dev.lin.models.EmotionEnum;

public record MomentFilterDTO(EmotionEnum emotion, LocalDate date) {


    public EmotionEnum getEmotion() {
        return emotion;
    }
    
    public LocalDate getDate() {
        return date;
    }

}

