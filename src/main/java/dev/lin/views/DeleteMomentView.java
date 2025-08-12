package dev.lin.views;

import dev.lin.controllers.MomentController;
import dev.lin.singletons.MomentControllerSingleton;

public class DeleteMomentView extends View {
   
    private static MomentController CONTROLLER = MomentControllerSingleton.getInstance();
    
    public static void printDeleteMoment() {
        
        System.out.print("Introduce el número identificador del momento a eliminar: ");
        
        try {
            int id = SCANNER.nextInt();
            boolean deleted = CONTROLLER.deleteMoment(id);
            
            if (deleted) {
                System.out.println("Momento " + id + " eliminado correctamente.");
            } else {
            System.out.println("No existe el momento con identificador " + id + ".");
            }           
        } catch (Exception e) {
            System.out.println("Error: Introduce un número identificador válido.");
        }
        HomeView.printMenu();
    }
}