package dev.lin.views;

import dev.lin.controllers.MomentController;
import dev.lin.dtos.MomentDTO;
import dev.lin.singletons.MomentControllerSingleton;
import dev.lin.models.EmotionEnum;
import java.time.LocalDate;

public class MomentPostView extends View {

    private static MomentController CONTROLLER = MomentControllerSingleton.getInstance();
    private static int nextId = 1;

    public static void printStoreMenu() {
        
        SCANNER.nextLine();

        int momentId = nextId++;

        System.out.println("Escribe el título del momento:");
        String momentTitle = SCANNER.nextLine();
        System.out.println("Título: " + momentTitle);

        EmotionEnum momentEmotion = EmotionSelectorView.selectEmotion();
        System.out.println("Has elegido: " + momentEmotion.getName());

        LocalDate momentDate = DateInputView.inputDate();
        System.out.println("Fecha del momento: " + momentDate);

        System.out.println("Escribe la descripción del momento:");
        String momentDescription = SCANNER.nextLine();

        MomentDTO moment = new MomentDTO(momentId, momentTitle, momentEmotion, momentDate, momentDescription);
        CONTROLLER.StoreMoment(moment);
        
        System.out.println("Momento guardado con éxito.");
        HomeView.printMenu();
    }
    
} 
