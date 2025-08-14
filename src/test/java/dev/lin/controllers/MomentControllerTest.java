package dev.lin.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import dev.lin.dtos.MomentViewDTO;
import dev.lin.models.EmotionEnum;
import dev.lin.models.Moment;
import dev.lin.repositories.MomentRepository;

public class MomentControllerTest {

    @Mock
    private MomentRepository repository;

    @InjectMocks
    private MomentController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSendListReturnsCorrectNumberOfMoments() {
        // 1. Configurar el escenario (Arrange)
        Moment moment1 = new Moment(1);
        moment1.setEmotion(EmotionEnum.ALEGRIA);
        Moment moment2 = new Moment(2);
        moment2.setEmotion(EmotionEnum.TRISTEZA);
        List<Moment> momentsFromRepo = Arrays.asList(moment1, moment2);

        when(repository.getAllMoments()).thenReturn(momentsFromRepo);

        // 2. Ejecutar la acción que queremos probar (Act)
        List<MomentViewDTO> result = controller.SendList();

        // 3. Verificar los resultados (Assert)
        assertEquals(2, result.size());
        assertEquals(EmotionEnum.ALEGRIA, result.get(0).getEmotion());

        verify(repository, times(1)).getAllMoments();
    }

    @Test
    void testDeleteMomentReturnsTrueWhenSuccessful() {
        // 1. Configurar el escenario (Arrange)
        int momentId = 1;
        when(repository.deleteMoment(momentId)).thenReturn(true);

        // 2. Ejecutar la acción (Act)
        boolean result = controller.deleteMoment(momentId);

        // 3. Verificar los resultados (Assert)
        assertTrue(result);

        verify(repository, times(1)).deleteMoment(momentId);
    }

    @Test
    void testDeleteMomentReturnsFalseWhenFailed() {
        int momentId = 1;
        when(repository.deleteMoment(momentId)).thenReturn(false);
        boolean result = controller.deleteMoment(momentId);

        assertFalse(result);

        verify(repository, times(1)).deleteMoment(momentId);
    }

    @Test
    void testGetMomentsFilteredByEmotionReturnsFilteredList() {

        String emotionName = "Tristeza";
        
        Moment moment1 = new Moment(1);
        moment1.setEmotion(EmotionEnum.TRISTEZA);
        moment1.setTitle("Han cancelado la fiesta");
        
        Moment moment2 = new Moment(2);
        moment2.setEmotion(EmotionEnum.TRISTEZA);
        moment2.setTitle("No me va el ordenador");

        List<Moment> filteredMoments = Arrays.asList(moment1, moment2);

        when(repository.getMomentsFiltered(emotionName)).thenReturn(filteredMoments);

        List<MomentViewDTO> result = controller.getMomentsFiltered(emotionName);

        assertEquals(2, result.size());

        boolean hasOtherEmotions = result.stream()
            .anyMatch(dto -> dto.getEmotion() != EmotionEnum.TRISTEZA);
        assertFalse(hasOtherEmotions);

        verify(repository, times(1)).getMomentsFiltered("Tristeza");
    }

    @Test
    void testGetMomentsFilteredByEmotionReturnsEmptyListWhenNoMatches() {
        String emotionName = "Envidia";
        
        when(repository.getMomentsFiltered(emotionName)).thenReturn(Collections.emptyList());

        List<MomentViewDTO> result = controller.getMomentsFiltered(emotionName);

        assertTrue(result.isEmpty());

        verify(repository, times(1)).getMomentsFiltered("Envidia");
    }

    @Test
    void testGetMomentsFilteredByDateReturnsFilteredList() {

        LocalDate date = LocalDate.of(2025, 8, 14);
        
        Moment moment1 = new Moment(1);
        moment1.setDate(LocalDate.of(2025, 8, 14));
        moment1.setTitle("He quedado con unas amigas");
        
        Moment moment2 = new Moment(2);
        moment2.setDate(LocalDate.of(2025, 8, 14));
        moment2.setTitle("No me va el ordenador");

        List<Moment> filteredMoments = Arrays.asList(moment1, moment2);

        when(repository.getMomentsFiltered(date)).thenReturn(filteredMoments);

        List<MomentViewDTO> result = controller.getMomentsFiltered(date);

        assertEquals(2, result.size());

        boolean hasOtherDates = result.stream()
            .anyMatch(dto -> !dto.getDate().equals(date));
        assertFalse(hasOtherDates);

        verify(repository, times(1)).getMomentsFiltered(LocalDate.of(2025, 8, 14));
    }
}