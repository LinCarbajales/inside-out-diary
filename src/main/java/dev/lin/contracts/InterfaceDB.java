package dev.lin.contracts;

import java.time.LocalDate;
import java.util.List;
import dev.lin.models.Moment;

public interface InterfaceDB {
    void store(Moment moment);
    List<Moment> getAllMoments();
    boolean deleteMoment(int id);
    List<Moment> getMomentsByEmotion(String emotion);
}