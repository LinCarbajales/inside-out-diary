package dev.lin.views;

import dev.lin.controllers.MomentController;
import dev.lin.dtos.MomentViewDTO;
import dev.lin.singletons.MomentControllerSingleton;
import java.util.List;

public class RecoverListView extends View {

    private static MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static void printRecover() {
        List<MomentViewDTO> moments = CONTROLLER.SendList();
        System.out.println(moments);
    
    if (moments.isEmpty()) {
            System.out.println("No hay entradas en el diario.");
        } else {
            moments.forEach(dto -> {
                System.out.println("Momento " + dto.getId());
                System.out.println("Título: " + dto.getTitle());
                System.out.println("Emoción: " + dto.getEmotion().getName());
                System.out.println("Fecha: " + dto.getDate());
                System.out.println("Descripción: " + dto.getDescription());
                System.out.println("---------------");
            });
        }
        HomeView.printMenu();
    }
}  
