package dev.lin.mappers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dev.lin.dtos.MomentDTO;
import dev.lin.dtos.MomentViewDTO;
import dev.lin.models.Moment;

public class MomentMapper {
    
    public static Moment toEntity(MomentDTO dto) {
        Moment moment = new Moment(dto.id());
        moment.setTitle(dto.title());
        moment.setEmotion(dto.emotion());
        moment.setDate(dto.date());
        moment.setDescription(dto.description());
        moment.setCreationDate(LocalDate.now());
        moment.setUpdate(LocalDate.now());
        return moment;
    }

   public static MomentViewDTO toDTO(Moment entity) {
        return new MomentViewDTO(
            entity.getId(),
            entity.getTitle(),
            entity.getEmotion(),
            entity.getDate(),
            entity.getDescription(),
            entity.getCreationDate(),
            entity.getUpdate()
        );
    } 

    public static List<MomentViewDTO> toDTOList(List<Moment> moments) {
        List<MomentViewDTO> dtos = new ArrayList<>();
        for (Moment moment : moments) {
            dtos.add(MomentMapper.toDTO(moment));
        }
        return dtos;
    }

}