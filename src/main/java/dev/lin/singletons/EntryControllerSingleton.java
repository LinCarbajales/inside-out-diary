package dev.lin.singletons;

import dev.lin.controllers.EntryController;

public class EntryControllerSingleton {
    
    private static final EntryController INSTANCE = new EntryController();

    private EntryControllerSingleton() {}
    
    public static EntryController getInstance() {
        return INSTANCE;
    }
}
