package dev.lin.views;

import dev.lin.controllers.MomentController;
import dev.lin.dtos.MomentDTO;
import dev.lin.singletons.MomentControllerSingleton;
import java.time.LocalDate;

public class RecoverListView extends View {

    private static MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static void printRecover() {
        System.out.print("Placeholder");
    }
    
}
