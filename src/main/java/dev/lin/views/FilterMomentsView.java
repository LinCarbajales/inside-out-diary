package dev.lin.views;

import dev.lin.controllers.MomentController;
import dev.lin.dtos.MomentViewDTO;
import dev.lin.models.EmotionEnum;
import dev.lin.singletons.MomentControllerSingleton;
import java.util.List;

public class FilterMomentsView extends View {

    private static MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static void printFilterMenu() {

        SCANNER.nextLine();
        
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
        List<MomentViewDTO> moments = CONTROLLER.getMomentsByEmotion(momentEmotion.getName());
        MomentDisplayView.displayMoments(moments);

        // if (option == 2) RecoverListView.printRecover();
       
        HomeView.printMenu();
            }
        }
    }
