package dev.lin.repositories;

import java.util.List;
import java.time.LocalDate;

import dev.lin.db.MomentDatabase;
import dev.lin.models.Moment;
import dev.lin.models.EmotionEnum;
import dev.lin.models.RatingEnum;

public class MomentRepository {
    
    private MomentDatabase momentDB;

    public MomentRepository() {
        this.momentDB = new MomentDatabase();
    }

    public void StoreMoment(Moment moment) {        
        momentDB.store(moment);
    }

    public List<Moment> getAllMoments() {
        return momentDB.getAllMoments();
    }

    public boolean deleteMoment(int id) {
        return momentDB.deleteMoment(id);
    }

    public List<Moment> getMomentsFiltered(EmotionEnum emotion) {
        return momentDB.getMomentsFiltered(emotion);
    }

    public List<Moment> getMomentsFiltered(LocalDate date) {
        return momentDB.getMomentsFiltered(date);
    }

    public List<Moment> getMomentsFiltered(RatingEnum rating) {
        return momentDB.getMomentsFiltered(rating);
    }

}