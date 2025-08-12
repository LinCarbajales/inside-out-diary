package dev.lin.views;

import dev.lin.controllers.MomentController;
import dev.lin.dtos.MomentViewDTO;
import dev.lin.singletons.MomentControllerSingleton;
import java.util.List;

public class RecoverListView extends View {

    private static MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static void printRecover() {
        List<MomentViewDTO> moments = CONTROLLER.SendList();
    
    if (moments.isEmpty()) {
            System.out.println("No hay entradas en el diario.");
        } else {
            moments.forEach(dto -> {
                System.out.println(dto.getId() + ". " +
                            dto.getTitle() + ". " + 
                            "Ocurrió el: " + dto.getDate() +
                            " Emoción: " + dto.getEmotion().getName() +
                            ". Descripción: " + dto.getDescription() + 
                            " Fecha de creación: " + dto.getCreationDate() +
                            " Fecha de actualización: " +dto.getUpdate());
            });
        }
        HomeView.printMenu();
    }
}  
