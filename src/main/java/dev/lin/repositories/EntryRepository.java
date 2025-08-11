package dev.lin.repositories;

import dev.lin.db.DiaryDatabase;
import dev.lin.models.Entry;

public class EntryRepository {
    
    private DiaryDatabase diaryDB;

    public EntryRepository() {
        this.diaryDB = new DiaryDatabase();
    }

    public void StoreEntry(Entry entry) {
        
        diaryDB.store(entry);

    }

}