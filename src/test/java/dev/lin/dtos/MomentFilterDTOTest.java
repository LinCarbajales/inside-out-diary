package dev.lin.dtos;

import dev.lin.models.EmotionEnum;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MomentFilterDTOTest {

    @Test
    void testMomentFilterDTO() {
        // Arrange (Preparar los datos de prueba)
        EmotionEnum expectedEmotion = EmotionEnum.ALEGRIA;
        LocalDate expectedDate = LocalDate.of(2023, 10, 26);

        // Act (Crear una instancia del DTO)
        MomentFilterDTO dto = new MomentFilterDTO(expectedEmotion, expectedDate);

        // Assert (Verificar que los valores son correctos)
        assertEquals(expectedEmotion, dto.getEmotion());
        assertEquals(expectedDate, dto.getDate());
    }
}