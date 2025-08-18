package dev.lin.contracts;

import java.time.LocalDate;
import java.util.List;
import dev.lin.models.Moment;
import dev.lin.models.EmotionEnum;
import dev.lin.models.RatingEnum;

public interface InterfaceDB {
    void store(Moment moment);
    List<Moment> getAllMoments();
    boolean deleteMoment(int id);
    List<Moment> getMomentsFiltered(EmotionEnum emotion);
    List<Moment> getMomentsFiltered(LocalDate date);
    List<Moment> getMomentsFiltered(RatingEnum rating);
}