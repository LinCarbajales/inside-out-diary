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
        System.out.println("✅ Nueva entrada guardada:");
    System.out.println("   ID: " + entry.getId());
    System.out.println("   Título: " + entry.getTitle());
    System.out.println("   Emoción: " + entry.getEmotion().getName());
    System.out.println("   Fecha: " + entry.getDate());
    System.out.println("   Descripción: " + entry.getDescription());
    System.out.println("   Total entradas: " + entries.size());
    }

    @Override
    public List<Entry> getAllEntries() {
        return new ArrayList<>(entries);
    }

    public int getTotalEntries() {
        return entries.size();
    }

}