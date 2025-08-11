package dev.lin.views;

import dev.lin.controllers.EntryController;
import dev.lin.dtos.EntryDTO;
import dev.lin.singletons.EntryControllerSingleton;
import dev.lin.models.EmotionEnum;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class EntryPostView extends View {

    private static EntryController CONTROLLER = EntryControllerSingleton.getInstance();
    private static int nextId = 1;

    public static void printStoreMenu() {
        
        SCANNER.nextLine();

        int entryId = nextId++;

        System.out.println("Escribe el título del momento:");
        String entryTitle = SCANNER.nextLine();
        System.out.println("Título: " + entryTitle);

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
    
        EmotionEnum entryEmotion = null;
        while (entryEmotion == null) {
            int emotionNum = SCANNER.nextInt();
            SCANNER.nextLine();

            entryEmotion = EmotionEnum.fromNumber(emotionNum);
    
        if (entryEmotion == null) {
            System.out.print("Selecciona un número del 1 al 10: ");
            }
        }
        System.out.println("Has elegido: " + entryEmotion.getName());

        LocalDate entryDate = null;
        while (entryDate == null) {
            System.out.print("Introduce la fecha (dd/mm/aaaa): ");
            String userDate = SCANNER.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
            try {
                entryDate = LocalDate.parse(userDate, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha incorrecto. Usa el formato dd/mm/aaaa");
            }
        }

        System.out.println("Fecha del momento: " + entryDate);

        System.out.println("Escribe la descripción del momento:");
        String entryDescription = SCANNER.nextLine();

        LocalDate entryCreationDate = LocalDate.now();
        LocalDate entryUpdate = entryCreationDate;

        EntryDTO entry = new EntryDTO(entryId, entryTitle, entryEmotion, entryDate, entryDescription, entryCreationDate, entryUpdate);
        CONTROLLER.StoreEntry(entry);
        
        System.out.println("Momento guardado con éxito.");
        HomeView.printMenu();
    }
    
} 
