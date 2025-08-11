package dev.lin.contracts;

import java.util.List;
import dev.lin.models.Entry;

public interface InterfaceDB {
    void store(Entry entry);
    List<Entry> getAllEntries();
}