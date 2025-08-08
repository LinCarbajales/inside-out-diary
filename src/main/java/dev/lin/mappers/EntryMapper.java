package dev.lin.mappers;

import dev.lin.dtos.EntryDTO;
import dev.lin.models.Entry;

/* 
 * Para Mappeo Automatico:
 * https://mapstruct.org/
 * 
 * https://modelmapper.org/
 */

public class EntryMapper {
    
    // Mappeo Manual
    public static Entry toEntity(EntryDTO dto) {
        

        //REVISAR
        Entry entry = new Entry(dto.id());
        entry.setEmotion(dto.emotion());

        return entry;
    }

}