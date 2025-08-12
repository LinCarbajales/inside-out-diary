package dev.lin.views;

import dev.lin.controllers.MomentController;
import dev.lin.dtos.MomentViewDTO;
import dev.lin.models.EmotionEnum;
import dev.lin.singletons.MomentControllerSingleton;
import java.util.List;

public class FilterMomentsView extends View {

    private static MomentController CONTROLLER = MomentControllerSingleton.getInstance();

    public static void printFilterMenu() {

        SCANNER.nextLine();
        
        String filterMenu = """
                Filtrar por:
                1. Emoción
                2. Fecha
                Ingrese una opción:
                """;

        System.out.print(filterMenu);

        int option = SCANNER.nextInt();

        if (option == 1) {
            String emotionMenu = """
                Mis emociones:
                1. Alegría
                2. Tristeza
                3. Ira
                4. Asco
                5. Miedo
                6. Ansiedad
                7. Envidia
                8. Vergüenza
                9. Aburrimiento
                10. Nostalgia
                Selecciona una emoción:
                """;

        System.out.print(emotionMenu);

        EmotionEnum momentEmotion = null;
        while (momentEmotion == null) {
            int emotionNum = SCANNER.nextInt();
            SCANNER.nextLine();

            momentEmotion = EmotionEnum.fromNumber(emotionNum);
    
        if (momentEmotion == null) {
            System.out.print("Selecciona un número del 1 al 10: ");
            }
        }
        
        List<MomentViewDTO> moments = CONTROLLER.getMomentsByEmotion(momentEmotion.getName());
            if (moments.isEmpty()) {
            System.out.println("No hay entradas correspondientes a esta emoción.");
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
        // if (option == 2) RecoverListView.printRecover();
       
        HomeView.printMenu();
            }
        }
    }
