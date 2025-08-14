package dev.lin.views;

import dev.lin.models.EmotionEnum;
import dev.lin.dtos.MomentViewDTO;
import static com.github.stefanbirkner.systemlambda.SystemLambda.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

public class ViewsPrintsTest {

    @Test
    public void testHomeView_printMenu_exitOption() throws Exception {
        String output = tapSystemOut(() -> {
            withTextFromSystemIn("5\n").execute(() -> {
                View.SCANNER = new java.util.Scanner(System.in);
                HomeView.printMenu();
            });
        });
        assertTrue(output.contains("Mi diario:"));
        assertTrue(output.contains("¡Hasta la próxima!"));
    }

    @Test
    public void testHomeView_printMenu_invalidOption() throws Exception {
        String output = tapSystemOut(() -> {
            withTextFromSystemIn("99\n5\n").execute(() -> {
                View.SCANNER = new java.util.Scanner(System.in);
                HomeView.printMenu();
            });
        });
        assertTrue(output.contains("Elige una opción del 1 al 5."));
        assertTrue(output.contains("Mi diario:"));
    }

    @Test
    public void testHomeView_printMenu_invalidInputType() throws Exception {
        String output = tapSystemOut(() -> {
            withTextFromSystemIn("abc\n5\n").execute(() -> {
                View.SCANNER = new java.util.Scanner(System.in);
                HomeView.printMenu();
            });
        });
        assertTrue(output.contains("Elige una opción del 1 al 5."));
    }

    @Test
    public void testEmotionSelectorView_selectEmotion_menuAndInvalid() throws Exception {
        String output = tapSystemOut(() -> {
            withTextFromSystemIn("99\n1\n").execute(() -> {
                View.SCANNER = new java.util.Scanner(System.in);
                EmotionSelectorView.selectEmotion();
            });
        });
        assertTrue(output.contains("Mis emociones:"));
        assertTrue(output.contains("Selecciona un número del 1 al 10:"));
    }

    @Test
    public void testEmotionSelectorView_selectEmotion_validSelection() throws Exception {
        String output = tapSystemOut(() -> {
            withTextFromSystemIn("3\n").execute(() -> {
                View.SCANNER = new java.util.Scanner(System.in);
                EmotionEnum result = EmotionSelectorView.selectEmotion();
                assertEquals(EmotionEnum.IRA, result);
            });
        });
        assertTrue(output.contains("Mis emociones:"));
        assertTrue(output.contains("3. Ira"));
    }

    @Test
    public void testDateInputView_inputDate_invalidAndValid() throws Exception {
        String output = tapSystemOut(() -> {
            withTextFromSystemIn("fecha-incorrecta\n15/08/2024\n").execute(() -> {
                View.SCANNER = new java.util.Scanner(System.in);
                DateInputView.inputDate();
            });
        });
        assertTrue(output.contains("Formato de fecha incorrecto"));
        assertTrue(output.contains("Introduce la fecha"));
    }

    @Test
    public void testDateInputView_inputDate_validFormatDirectly() throws Exception {
        String output = tapSystemOut(() -> {
            withTextFromSystemIn("25/12/2023\n").execute(() -> {
                View.SCANNER = new java.util.Scanner(System.in);
                DateInputView.inputDate();
            });
        });
        assertTrue(output.contains("Introduce la fecha (dd/mm/aaaa):"));
        assertFalse(output.contains("Formato de fecha incorrecto"));
    }

    @Test
    public void testMomentDisplayView_displayMoments_emptyAndNonEmpty() throws Exception {
        String emptyOutput = tapSystemOut(() -> {
            MomentDisplayView.displayMoments(new ArrayList<>());
        });
        assertTrue(emptyOutput.contains("No se han encontrado momentos."));

        List<MomentViewDTO> moments = new ArrayList<>();
        moments.add(new MomentViewDTO(1, "Título", EmotionEnum.ALEGRIA, java.time.LocalDate.now(), "Desc", java.time.LocalDate.now(), java.time.LocalDate.now()));
        String nonEmptyOutput = tapSystemOut(() -> {
            MomentDisplayView.displayMoments(moments);
        });
        assertTrue(nonEmptyOutput.contains("Título"));
        assertTrue(nonEmptyOutput.contains("Alegría"));
    }

    @Test
    public void testMomentDisplayView_displayMoments_multipleMoments() throws Exception {
        List<MomentViewDTO> moments = new ArrayList<>();
        moments.add(new MomentViewDTO(1, "Primer momento", EmotionEnum.ALEGRIA, java.time.LocalDate.now(), "Descripción 1", java.time.LocalDate.now(), java.time.LocalDate.now()));
        moments.add(new MomentViewDTO(2, "Segundo momento", EmotionEnum.TRISTEZA, java.time.LocalDate.now(), "Descripción 2", java.time.LocalDate.now(), java.time.LocalDate.now()));
        
        String output = tapSystemOut(() -> {
            MomentDisplayView.displayMoments(moments);
        });
        
        assertTrue(output.contains("Lista de momentos:"));
        assertTrue(output.contains("1. Primer momento"));
        assertTrue(output.contains("2. Segundo momento"));
        assertTrue(output.contains("Alegría"));
        assertTrue(output.contains("Tristeza"));
    }

    @Test
    public void testRecoverListView_printRecover_showsHomeMenu() throws Exception {
        String output = tapSystemOut(() -> {
            withTextFromSystemIn("5\n").execute(() -> {
                View.SCANNER = new java.util.Scanner(System.in);
                RecoverListView.printRecover();
            });
        });
        assertTrue(output.contains("Mi diario:"));
    }

    @Test
    public void testMomentPostView_printStoreMenu_completeFlow() throws Exception {
        String output = tapSystemOut(() -> {
            withTextFromSystemIn("Mi primer momento\n1\n15/08/2024\nUna descripción del momento\n5\n").execute(() -> {
                View.SCANNER = new java.util.Scanner(System.in);
                MomentPostView.printStoreMenu();
            });
        });
        
        assertTrue(output.contains("Escribe el título del momento:"));
        assertTrue(output.contains("Título: Mi primer momento"));
        assertTrue(output.contains("Mis emociones:"));
        assertTrue(output.contains("Has elegido: Alegría"));
        assertTrue(output.contains("Introduce la fecha (dd/mm/aaaa):"));
        assertTrue(output.contains("Fecha del momento: 2024-08-15"));
        assertTrue(output.contains("Escribe la descripción del momento:"));
        assertTrue(output.contains("Momento guardado con éxito."));
        assertTrue(output.contains("Mi diario:")); // Vuelve al menú principal
    }

    @Test
    public void testMomentPostView_printStoreMenu_withInvalidDateRetry() throws Exception {
        String output = tapSystemOut(() -> {
            withTextFromSystemIn("Momento con fecha incorrecta\n2\nfecha-mal\n20/06/2023\nDescripción del momento\n5\n").execute(() -> {
                View.SCANNER = new java.util.Scanner(System.in);
                MomentPostView.printStoreMenu();
            });
        });
        
        assertTrue(output.contains("Título: Momento con fecha incorrecta"));
        assertTrue(output.contains("Has elegido: Tristeza"));
        assertTrue(output.contains("Formato de fecha incorrecto"));
        assertTrue(output.contains("Fecha del momento: 2023-06-20"));
        assertTrue(output.contains("Momento guardado con éxito."));
    }

    @Test
    public void testFilterMomentsView_printFilterMenu_emotionOption() throws Exception {
        String output = tapSystemOut(() -> {
            withTextFromSystemIn("1\n4\n5\n").execute(() -> {
                View.SCANNER = new java.util.Scanner(System.in);
                FilterMomentsView.printFilterMenu();
            });
        });
        
        assertTrue(output.contains("Filtrar por:"));
        assertTrue(output.contains("1. Emoción"));
        assertTrue(output.contains("2. Fecha"));
        assertTrue(output.contains("Ingrese una opción:"));
        assertTrue(output.contains("Mis emociones:")); // Muestra el selector de emociones
        assertTrue(output.contains("Mi diario:")); // Vuelve al menú principal
    }

    @Test
    public void testFilterMomentsView_printFilterMenu_dateOption() throws Exception {
        String output = tapSystemOut(() -> {
            withTextFromSystemIn("2\n15/08/2024\n5\n").execute(() -> {
                View.SCANNER = new java.util.Scanner(System.in);
                FilterMomentsView.printFilterMenu();
            });
        });
        
        assertTrue(output.contains("Filtrar por:"));
        assertTrue(output.contains("2. Fecha"));
        assertTrue(output.contains("Introduce la fecha (dd/mm/aaaa):")); // Muestra el selector de fecha
        assertTrue(output.contains("Mi diario:")); // Vuelve al menú principal
    }

    @Test
    public void testFilterMomentsView_printFilterMenu_invalidOption() throws Exception {
        String output = tapSystemOut(() -> {
            withTextFromSystemIn("3\n1\n1\n5\n").execute(() -> {
                View.SCANNER = new java.util.Scanner(System.in);
                FilterMomentsView.printFilterMenu();
            });
        });
        
        assertTrue(output.contains("Elige 1 o 2."));
        assertTrue(output.contains("Filtrar por:")); // Se muestra de nuevo el menú
    }

    @Test
    public void testFilterMomentsView_printFilterMenu_invalidInputType() throws Exception {
        String output = tapSystemOut(() -> {
            withTextFromSystemIn("abc\n2\n01/01/2024\n5\n").execute(() -> {
                View.SCANNER = new java.util.Scanner(System.in);
                FilterMomentsView.printFilterMenu();
            });
        });
        
        assertTrue(output.contains("Elige 1 o 2."));
        assertTrue(output.contains("Introduce la fecha (dd/mm/aaaa):")); // Después del error, funciona correctamente
    }

    @Test
    public void testDeleteMomentView_printDeleteMoment_validId() throws Exception {
        String output = tapSystemOut(() -> {
            withTextFromSystemIn("1\n5\n").execute(() -> {
                View.SCANNER = new java.util.Scanner(System.in);
                DeleteMomentView.printDeleteMoment();
            });
        });
        
        assertTrue(output.contains("Introduce el número identificador del momento a eliminar:"));
        // Nota: El resultado dependerá de si existe o no el momento con ID 1
        assertTrue(output.contains("Mi diario:")); // Vuelve al menú principal
    }

    @Test
    public void testDeleteMomentView_printDeleteMoment_invalidInput() throws Exception {
        String output = tapSystemOut(() -> {
            withTextFromSystemIn("abc\n5\n").execute(() -> {
                View.SCANNER = new java.util.Scanner(System.in);
                DeleteMomentView.printDeleteMoment();
            });
        });
        
        assertTrue(output.contains("Error: Introduce un número identificador válido."));
        assertTrue(output.contains("Mi diario:")); // Vuelve al menú principal
    }
}