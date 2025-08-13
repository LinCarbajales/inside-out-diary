package dev.lin.views;

public class HomeView extends View{

    public static void printMenu() {

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
        
        try {
            int option = SCANNER.nextInt();
            SCANNER.nextLine(); // Consumir el salto de línea
            boolean found = MenuOption.execute(option);
            if (!found) {
                System.out.println("Elige una opción del 1 al 5.");
                printMenu();
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Elige una opción del 1 al 5.");
            SCANNER.nextLine(); // Limpiar toda la línea
            printMenu();
        }
    }

    public enum MenuOption {
        ADD(1, MomentPostView::printStoreMenu),
        VIEW(2, RecoverListView::printRecover),
        DELETE(3, DeleteMomentView::printDeleteMoment),
        FILTER(4, FilterMomentsView::printFilterMenu),
        EXIT(5, () -> System.out.println("¡Hasta la próxima!"));

        private final int value;
        private final Runnable action;

        MenuOption(int value, Runnable action) {
            this.value = value;
            this.action = action;
        }

        public static boolean execute(int option) {
            for (MenuOption mo : values()) {
                if (mo.value == option) {
                    mo.action.run();
                    return true;
                }
            }
            return false;
        }
    }
}