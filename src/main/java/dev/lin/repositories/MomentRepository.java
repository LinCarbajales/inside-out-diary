package dev.lin.repositories;

import java.util.List;
import java.time.LocalDate;

import dev.lin.contracts.InterfaceDB;
import dev.lin.db.DiaryDatabase;
import dev.lin.models.Moment;

public class MomentRepository {
    
    private InterfaceDB diaryDB;

    public MomentRepository() {
        this.diaryDB = new DiaryDatabase();
    }

    public void StoreMoment(Moment moment) {        
        diaryDB.store(moment);
    }

    public List<Moment> getAllMoments() {
        return diaryDB.getAllMoments();
    }

    public boolean deleteMoment(int id) {
        return diaryDB.deleteMoment(id);
    }

    public List<Moment> getMomentsFiltered(String emotionName, LocalDate date) {
        return diaryDB.getMomentsFiltered(emotionName, date);
    }
}