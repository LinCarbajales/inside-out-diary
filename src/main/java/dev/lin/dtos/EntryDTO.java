package dev.lin.dtos;

import java.time.LocalDate;
import dev.lin.models.EmotionEnum;

public record EntryDTO(int id, String title, EmotionEnum emotion, LocalDate date, String moment, LocalDate creationDate, LocalDate update) {

}
