package dev.lin.mappers;

import java.util.List;
import java.util.stream.Collectors;

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

    public static EntryDTO toDTO(Entry entity) {
        return new EntryDTO(
            entity.getId(),
            entity.getTitle(),
            entity.getEmotion(),
            entity.getDate(),
            entity.getMoment(),
            entity.getCreationDate(),
            entity.getUpdate()
        );
    }

    public static List<EntryDTO> toDTOList(List<Entry> entries) {
        return entries.stream()
                     .map(EntryMapper::toDTO)
                     .collect(Collectors.toList());
    }

}