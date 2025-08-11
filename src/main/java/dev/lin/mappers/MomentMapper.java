package dev.lin.mappers;

import java.util.List;
import java.util.stream.Collectors;

import dev.lin.dtos.MomentDTO;
import dev.lin.models.Moment;

public class MomentMapper {
    
    public static Moment toEntity(MomentDTO dto) {
        Moment moment = new Moment(dto.id());
        moment.setTitle(dto.title());
        moment.setEmotion(dto.emotion());
        moment.setDate(dto.date());
        moment.setDescription(dto.description());
        moment.setCreationDate(dto.creationDate());
        moment.setUpdate(dto.update());
        return moment;
    }

    public static MomentDTO toDTO(Moment entity) {
        return new MomentDTO(
            entity.getId(),
            entity.getTitle(),
            entity.getEmotion(),
            entity.getDate(),
            entity.getDescription(),
            entity.getCreationDate(),
            entity.getUpdate()
        );
    }

    public static List<MomentDTO> toDTOList(List<Moment> moments) {
        return moments.stream()
                     .map(MomentMapper::toDTO)
                     .collect(Collectors.toList());
    }

}