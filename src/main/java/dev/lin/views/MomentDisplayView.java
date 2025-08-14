package dev.lin.views;

import dev.lin.dtos.MomentViewDTO;
import java.util.List;

public class MomentDisplayView {
    
    public static void displayMoments(List<MomentViewDTO> moments) {
        if (moments.isEmpty()) {
            System.out.println("No se han encontrado momentos.");
        } else {
            System.out.println("Lista de momentos:");
            moments.forEach(dto -> {
                System.out.println(dto.getId() + ". " +
                            dto.getTitle() + ". " + 
                            "Ocurrió el: " + dto.getDate() +
                            " Emoción: " + dto.getEmotion().getName() +
                            ". Descripción: " + dto.getDescription() + 
                            " Fecha de creación: " + dto.getCreationDate());
            });
        }
    }
}