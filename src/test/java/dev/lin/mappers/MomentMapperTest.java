package dev.lin.mappers;

import dev.lin.dtos.MomentDTO;
import dev.lin.dtos.MomentViewDTO;
import dev.lin.models.EmotionEnum;
import dev.lin.models.Moment;
import dev.lin.models.RatingEnum;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MomentMapperTest {

    @Test
    void testToEntity() {
        MomentDTO dto = new MomentDTO(1, "Título", EmotionEnum.ALEGRIA, RatingEnum.BUENO, LocalDate.of(2023, 5, 1), "Descripción");
        Moment entity = MomentMapper.toEntity(dto);

        assertEquals(dto.id(), entity.getId());
        assertEquals(dto.title(), entity.getTitle());
        assertEquals(dto.emotion(), entity.getEmotion());
        assertEquals(dto.date(), entity.getDate());
        assertEquals(dto.description(), entity.getDescription());
        assertNotNull(entity.getCreationDate());
        assertNotNull(entity.getUpdate());
    }

    @Test
    void testToDTO() {
        Moment moment = new Moment(2);
        moment.setTitle("Otro título");
        moment.setEmotion(EmotionEnum.TRISTEZA);
        moment.setDate(LocalDate.of(2023, 1, 2));
        moment.setDescription("Otra descripción");
        moment.setCreationDate(LocalDate.of(2023, 1, 1));
        moment.setUpdate(LocalDate.of(2023, 1, 2));

        MomentViewDTO dto = MomentMapper.toDTO(moment);

        assertEquals(moment.getId(), dto.id());
        assertEquals(moment.getTitle(), dto.title());
        assertEquals(moment.getEmotion(), dto.emotion());
        assertEquals(moment.getDate(), dto.date());
        assertEquals(moment.getDescription(), dto.description());
        assertEquals(moment.getCreationDate(), dto.creationDate());
        assertEquals(moment.getUpdate(), dto.update());
    }

    @Test
    void testToDTOList() {
        Moment moment1 = new Moment(1);
        moment1.setTitle("Uno");
        moment1.setEmotion(EmotionEnum.ALEGRIA);
        moment1.setDate(LocalDate.of(2023, 1, 1));
        moment1.setDescription("Desc 1");
        moment1.setCreationDate(LocalDate.of(2023, 1, 1));
        moment1.setUpdate(LocalDate.of(2023, 1, 1));

        Moment moment2 = new Moment(2);
        moment2.setTitle("Dos");
        moment2.setEmotion(EmotionEnum.ALEGRIA);
        moment2.setDate(LocalDate.of(2023, 1, 2));
        moment2.setDescription("Desc 2");
        moment2.setCreationDate(LocalDate.of(2023, 1, 2));
        moment2.setUpdate(LocalDate.of(2023, 1, 2));

        List<Moment> moments = Arrays.asList(moment1, moment2);
        List<MomentViewDTO> dtos = MomentMapper.toDTOList(moments);

        assertEquals(2, dtos.size());
        assertEquals(moment1.getId(), dtos.get(0).id());
        assertEquals(moment2.getId(), dtos.get(1).id());
    }
}