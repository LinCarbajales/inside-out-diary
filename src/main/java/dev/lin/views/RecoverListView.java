package dev.lin.views;

import dev.lin.controllers.MomentController;
import dev.lin.dtos.MomentViewDTO;
import dev.lin.singletons.MomentControllerSingleton;
import java.util.List;

public class RecoverListView extends View {

    private static MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static void printRecover() {
        List<MomentViewDTO> moments = CONTROLLER.SendList();
        MomentDisplayView.displayMoments(moments);
        HomeView.printMenu();
    }
}  
