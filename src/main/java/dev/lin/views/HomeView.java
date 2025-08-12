package dev.lin.views;

public class HomeView extends View{

    public static void printMenu() {

        // Bloque de texto
        String text = """
                Mi diario:
                1. Añadir momento
                2. Ver todos los momentos disponibles
                3. Eliminar un momento
                4. Filtrar los momentos
                5. Salir
                Seleccione una opción:
                """;

        System.out.print(text);

        // Solicitamos un número al usuario
        int option = SCANNER.nextInt();

        if (option == 1) MomentPostView.printStoreMenu();
        if (option == 2) RecoverListView.printRecover();
        if (option == 3) DeleteMomentView.printDeleteMoment();

        if (option == 5) System.out.println("¡Hasta la próxima!");

    }

}