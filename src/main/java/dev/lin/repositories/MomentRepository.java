package dev.lin.repositories;

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

}