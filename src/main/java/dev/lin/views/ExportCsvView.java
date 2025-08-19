package dev.lin.views;

import dev.lin.controllers.MomentController;
import dev.lin.singletons.MomentControllerSingleton;
import java.io.IOException;

public class ExportCsvView extends View {
    
    private static MomentController CONTROLLER = MomentControllerSingleton.getInstance();
    private static final String CSV_FILE_PATH = "moments.csv";

    public static void printExport() {
        System.out.println("Exportando momentos a " + CSV_FILE_PATH + "...");
        
        try {
            CONTROLLER.exportMomentsToCsv(CSV_FILE_PATH);
            System.out.println("Momento exportado a " + CSV_FILE_PATH + " con éxito.");
        } catch (IOException e) {
            System.out.println("Error al exportar los momentos: " + e.getMessage());
        }
        
        HomeView.printMenu();
    }
}