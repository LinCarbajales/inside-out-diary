package dev.lin.dtos;

import java.time.LocalDate;
import dev.lin.models.EmotionEnum;

public record MomentDTO(int id, String title, EmotionEnum emotion, LocalDate date, String description, LocalDate creationDate, LocalDate update) {

}
