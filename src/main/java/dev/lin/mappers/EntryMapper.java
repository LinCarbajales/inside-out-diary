package dev.lin.mappers;

import dev.lin.dtos.EntryDTO;
import dev.lin.models.Entry;

public class EntryMapper {
    
    public static Entry toEntity(EntryDTO dto) {
        Entry entry = new Entry(dto.id());
        entry.setTitle(dto.title());
        entry.setEmotion(dto.emotion());
        entry.setDate(dto.date());
        entry.setMoment(dto.moment());
        entry.setCreationDate(dto.creationDate());
        entry.setUpdate(dto.update());
        return entry;
    }
}