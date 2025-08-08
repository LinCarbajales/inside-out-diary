package dev.lin.dtos;

import java.time.LocalDate;

public record EntryDTO(int id, String title, String emotion, LocalDate date, String moment) {
    
}
