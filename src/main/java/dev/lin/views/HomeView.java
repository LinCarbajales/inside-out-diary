package dev.lin.views;

import dev.lin.models.HomeOptionEnum;

public class HomeView extends View{

    public static void printMenu() {

        String text = """
                Mi diario:
                1. Añadir momento
                2. Ver todos los momentos disponibles
                3. Eliminar un momento
                4. Filtrar los momentos
                5. Exportar a CSV
                6. Salir
                Seleccione una opción:
                """;

        System.out.print(text);
        
        try {
            int option = SCANNER.nextInt();
            SCANNER.nextLine();
            boolean found = HomeOptionEnum.execute(option);
            if (!found) {
                System.out.println("Elige una opción del 1 al 6.");
                printMenu();
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Elige una opción del 1 al 6.");
            SCANNER.nextLine();
            printMenu();
        }
    }
}