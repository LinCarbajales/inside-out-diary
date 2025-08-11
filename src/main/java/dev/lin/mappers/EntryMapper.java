package dev.lin.mappers;

import dev.lin.dtos.EntryDTO;
import dev.lin.models.Entry;

public class EntryMapper {
    
    public static Entry toEntity(EntryDTO dto) {
        
        Entry entry = new Entry(dto.id());
        entry.setEmotion(dto.emotion());

        return entry;
    }

}