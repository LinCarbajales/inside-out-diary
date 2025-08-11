package dev.lin.views;

import dev.lin.controllers.MomentController;
import dev.lin.dtos.MomentDTO;
import dev.lin.singletons.MomentControllerSingleton;
import dev.lin.models.EmotionEnum;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class MomentPostView extends View {

    private static MomentController CONTROLLER = MomentControllerSingleton.getInstance();
    private static int nextId = 1;

    public static void printStoreMenu() {
        
        SCANNER.nextLine();

        int momentId = nextId++;

        System.out.println("Escribe el título del momento:");
        String momentTitle = SCANNER.nextLine();
        System.out.println("Título: " + momentTitle);

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
    
        EmotionEnum momentEmotion = null;
        while (momentEmotion == null) {
            int emotionNum = SCANNER.nextInt();
            SCANNER.nextLine();

            momentEmotion = EmotionEnum.fromNumber(emotionNum);
    
        if (momentEmotion == null) {
            System.out.print("Selecciona un número del 1 al 10: ");
            }
        }
        System.out.println("Has elegido: " + momentEmotion.getName());

        LocalDate momentDate = null;
        while (momentDate == null) {
            System.out.print("Introduce la fecha (dd/mm/aaaa): ");
            String userDate = SCANNER.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
            try {
                momentDate = LocalDate.parse(userDate, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha incorrecto. Usa el formato dd/mm/aaaa");
            }
        }

        System.out.println("Fecha del momento: " + momentDate);

        System.out.println("Escribe la descripción del momento:");
        String momentDescription = SCANNER.nextLine();

        MomentDTO moment = new MomentDTO(momentId, momentTitle, momentEmotion, momentDate, momentDescription);
        CONTROLLER.StoreMoment(moment);
        
        System.out.println("Momento guardado con éxito.");
        HomeView.printMenu();
    }
    
} 
