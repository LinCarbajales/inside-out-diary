package dev.lin.singletons;

import dev.lin.repositories.EntryRepository;

public class EntryRepositorySingleton {
    
    private static EntryRepository INSTANCE;

    private EntryRepositorySingleton() {}

    public static EntryRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new EntryRepository();
        }
        return INSTANCE;
    }

}