package dev.lin.views;

import dev.lin.controllers.MomentController;
import dev.lin.dtos.MomentViewDTO;
import dev.lin.models.EmotionEnum;
import dev.lin.models.RatingEnum;
import dev.lin.singletons.MomentControllerSingleton;
import dev.lin.models.FilterOptionEnum;

import java.util.List;
import java.time.LocalDate;

public class FilterMomentsView extends View {

    private static MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static void printFilterMenu() {
        
        String filterMenu = """
                Filtrar por:
                1. Emoción
                2. Fecha
                3. Calificación
                Ingrese una opción:
                """;

        System.out.print(filterMenu);

        int option;
        try {
            option = SCANNER.nextInt();
            SCANNER.nextLine(); 
        } catch (java.util.InputMismatchException e) {
            System.out.println("Elige un número del 1 al 3.");
            SCANNER.nextLine(); 
            printFilterMenu();
            return;
        }

        FilterOptionEnum filterOption = FilterOptionEnum.fromInt(option);

        if (filterOption == null) {
            System.out.println("Elige un número del 1 al 3.");
            printFilterMenu();
            return;
        }

        switch (filterOption) {
            case EMOTION -> {
                EmotionEnum momentEmotion = EmotionSelectorView.selectEmotion();
                List<MomentViewDTO> moments = CONTROLLER.getMomentsFiltered(momentEmotion);
                MomentDisplayView.displayMoments(moments);
            }
            case DATE -> {
                LocalDate momentDate = DateInputView.inputDate();
                List<MomentViewDTO> moments = CONTROLLER.getMomentsFiltered(momentDate);
                MomentDisplayView.displayMoments(moments);
            }
            case RATING -> {
                RatingEnum momentRating = RatingSelectorView.printRatingMenu();
                List<MomentViewDTO> moments = CONTROLLER.getMomentsFiltered(momentRating);
                MomentDisplayView.displayMoments(moments);
            }
        }

        HomeView.printMenu();
    }
}