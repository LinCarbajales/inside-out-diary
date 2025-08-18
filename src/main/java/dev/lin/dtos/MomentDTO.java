package dev.lin.dtos;

import java.time.LocalDate;
import dev.lin.models.EmotionEnum;
import dev.lin.models.RatingEnum;

public record MomentDTO(int id, String title, EmotionEnum emotion, RatingEnum rating, LocalDate date, String description) {

}
