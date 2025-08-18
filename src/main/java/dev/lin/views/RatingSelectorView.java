package dev.lin.views;

import dev.lin.models.RatingEnum;

public class RatingSelectorView extends View {

    public static RatingEnum printRatingMenu() {
        String ratingMenu = """
                Fue un momento:
                1. Bueno
                2. Malo
                Ingresa una opción:
                """;

        System.out.print(ratingMenu);

        int option;
        try {
            option = SCANNER.nextInt();
            SCANNER.nextLine(); 
        } catch (java.util.InputMismatchException e) {
            System.out.println("Elige 1 o 2.");
            SCANNER.nextLine(); 
            return printRatingMenu();
        }

        RatingEnum Rating = RatingEnum.fromInt(option);

        if (Rating == null) {
            System.out.println("Elige 1 o 2.");
            return printRatingMenu();
        }

        return Rating;
    }
}