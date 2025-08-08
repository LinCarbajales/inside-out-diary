package dev.lin.views;

import dev.lin.controllers.EntryController;
import dev.lin.dtos.EntryDTO;
import dev.lin.singletons.EntryControllerSingleton;

public class EntryPostView extends View {

    private static EntryController CONTROLLER = EntryControllerSingleton.getInstance();

    public static void printStoreMenu() {
        
        SCANNER.nextLine();
        System.out.println("Escribe el título del momento:");
        String entryTitle = SCANNER.nextLine();
        System.out.println(entryTitle);

        // Bloque de texto
        String text = """
                Mis emociones:
                1. Alegría
                2. Tristeza
                3. Ira
                4. Asco
                5. Miedo
                6. Ansiedad
                7. Envidia
                8. Vergüenza
                9. Aburrimiento
                10. Nostalgia
                Selecciona una emoción:
                """;

        System.out.print(text);
    
        String entryEmotion = null;
        while (entryEmotion == null) {
            int emotionNum = SCANNER.nextInt();
            SCANNER.nextLine();
        
            entryEmotion = CONTROLLER.getEmotion(emotionNum);
            if (entryEmotion == null) {
                System.out.print("Selecciona un número del 1 al 10: ");
            }
        }
        System.out.println(entryEmotion);

        System.out.print("Introduce la fecha: ")


/* 
        String characterName = SCANNER.next();
        System.out.println("Introduce la fecha:");
        String country = SCANNER.next();
        System.out.println("Describe el momento:");  

        EntryDTO entry = new entryDTO(entryTitle);
        CONTROLLER.StoreEntry(entry); */
    }
    
} 
