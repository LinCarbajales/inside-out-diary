package dev.lin.db;

import java.util.ArrayList;
import java.util.List;
import dev.lin.models.Entry;
import dev.lin.contracts.InterfaceDB;

public class DiaryDatabase implements InterfaceDB {
    
    private List<Entry> entries;

    public DiaryDatabase() {
        this.entries = new ArrayList<>();
    }

    @Override
    public void store(Entry entry) {
        entries.add(entry);
    }

    @Override
    public List<Entry> getAllEntries() {
        return new ArrayList<>(entries);
    }

    public int getTotalEntries() {
        return entries.size();
    }

}