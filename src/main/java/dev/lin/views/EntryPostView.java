package dev.lin.views;

import dev.lin.controllers.EntryController;
import dev.lin.dtos.EntryDTO;
import dev.lin.singletons.EntryControllerSingleton;

public class EntryPostView extends View {

    private static EntryController CONTROLLER = CharacterControllerSingleton.getInstance();

    public static void printStoreMenu() {
        System.out.println("Ingrese el nombre del personaje:");
        String characterName = SCANNER.next();
        System.out.println("Ingrese el país del personaje:");
        String country = SCANNER.next();

        EntryDTO character = new EntryDTO(emotion, date, moment);
        CONTROLLER.StoreEntry(entry);
    }
    
}
