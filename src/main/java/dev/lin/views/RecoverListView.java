package dev.lin.views;

import dev.lin.controllers.EntryController;
import dev.lin.dtos.EntryDTO;
import dev.lin.singletons.EntryControllerSingleton;
import java.time.LocalDate;

public class RecoverListView extends View {

    private static EntryController CONTROLLER = EntryControllerSingleton.getInstance();

    public static void printRecover() {
        System.out.print("Placeholder");
    }
    
}
