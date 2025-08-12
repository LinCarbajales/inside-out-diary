package dev.lin.views;

import dev.lin.models.EmotionEnum;

public class EmotionSelectorView extends View {
    
    // Plantilla del menú de emociones
    private static final String EMOTION_MENU = """
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
    
    public static EmotionEnum selectEmotion() {
        System.out.print(EMOTION_MENU);
        
        EmotionEnum selectedEmotion = null;
        while (selectedEmotion == null) {
            int emotionNum = SCANNER.nextInt();
            SCANNER.nextLine(); // Consumir salto de línea
            
            selectedEmotion = EmotionEnum.fromNumber(emotionNum);
            
            if (selectedEmotion == null) {
                System.out.print("Selecciona un número del 1 al 10: ");
            }
        }
        
        return selectedEmotion;
    }
}