package dev.lin.db;

import dev.lin.models.Moment;
import dev.lin.models.EmotionEnum;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MomentDatabaseTest {

    private MomentDatabase db;
    private Moment moment1;
    private Moment moment2;
    private Moment moment3;

    @BeforeEach
    void setUp() {
        db = new MomentDatabase();
        moment1 = new Moment(1);
        moment1.setTitle("Día feliz");
        moment1.setEmotion(EmotionEnum.ALEGRIA);
        moment1.setDate(LocalDate.of(2023, 8, 10));
        moment1.setDescription("Descripción 1");

        moment2 = new Moment(2);
        moment2.setTitle("Día triste");
        moment2.setEmotion(EmotionEnum.TRISTEZA);
        moment2.setDate(LocalDate.of(2023, 8, 11));
        moment2.setDescription("Descripción 2");

        moment3 = new Moment(3);
        moment3.setTitle("Otro día feliz");
        moment3.setEmotion(EmotionEnum.ALEGRIA);
        moment3.setDate(LocalDate.of(2023, 8, 12));
        moment3.setDescription("Descripción 3");

        db.store(moment1);
        db.store(moment2);
        db.store(moment3);
    }

    @Test
    void testStoreAndGetAllMoments() {
        List<Moment> all = db.getAllMoments();
        assertEquals(3, all.size());
        assertTrue(all.contains(moment1));
        assertTrue(all.contains(moment2));
        assertTrue(all.contains(moment3));
    }

    @Test
    void testDeleteMoment() {
        boolean deleted = db.deleteMoment(2);
        assertTrue(deleted);
        List<Moment> all = db.getAllMoments();
        assertEquals(2, all.size());
        assertFalse(all.contains(moment2));
    }

    @Test
    void testDeleteMomentNotFound() {
        boolean deleted = db.deleteMoment(99);
        assertFalse(deleted);
        assertEquals(3, db.getAllMoments().size());
    }

    @Test
    void testGetMomentsFilteredByEmotion() {
        List<Moment> filtered = db.getMomentsFiltered(EmotionEnum.ALEGRIA);
        assertEquals(2, filtered.size());
        assertTrue(filtered.contains(moment1));
        assertTrue(filtered.contains(moment3));
    }

    @Test
    void testGetMomentsFilteredByEmotionCaseInsensitive() {
        List<Moment> filtered = db.getMomentsFiltered(EmotionEnum.ALEGRIA);
        assertEquals(2, filtered.size());
    }

    @Test
    void testGetMomentsFilteredByDate() {
        List<Moment> filtered = db.getMomentsFiltered(LocalDate.of(2023, 8, 10));
        assertEquals(1, filtered.size());
        assertEquals(moment1, filtered.get(0));
    }
}