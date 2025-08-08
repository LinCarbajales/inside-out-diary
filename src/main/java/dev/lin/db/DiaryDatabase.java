package dev.lin.db;

import java.util.ArrayList;
import java.util.List;
import dev.lin.models.Entry;


public class DiaryDatabase {
    
    private List<Character> entries;

    public DiaryDatabase() {
        this.entries = new ArrayList<>();
    }

    public void store(Entry entry) {
        entry.add(entry);
    }

    

}