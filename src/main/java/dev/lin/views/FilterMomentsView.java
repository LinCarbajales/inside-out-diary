package dev.lin.views;

import dev.lin.controllers.MomentController;
import dev.lin.dtos.MomentViewDTO;
import dev.lin.models.EmotionEnum;
import dev.lin.singletons.MomentControllerSingleton;

import java.util.List;
import java.time.LocalDate;

public class FilterMomentsView extends View {

    private static MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static void printFilterMenu() {
        
        String filterMenu = """
                Filtrar por:
                1. Emoción
                2. Fecha
                Ingrese una opción:
                """;

        System.out.print(filterMenu);

        int option = SCANNER.nextInt();

        if (option == 1) {
            EmotionEnum momentEmotion = EmotionSelectorView.selectEmotion();
            List<MomentViewDTO> moments = CONTROLLER.getMomentsFiltered(momentEmotion.getName(), null);
            MomentDisplayView.displayMoments(moments);
        }

        if (option == 2) {
            SCANNER.nextLine();
            LocalDate momentDate = DateInputView.inputDate();
            List<MomentViewDTO> moments = CONTROLLER.getMomentsFiltered(null, momentDate);
            MomentDisplayView.displayMoments(moments);
        }
       
        HomeView.printMenu();
    }
}
    
