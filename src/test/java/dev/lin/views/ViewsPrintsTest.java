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
    public void testRecoverListView_printRecover_showsHomeMenu() throws Exception {
        String output = tapSystemOut(() -> {
            withTextFromSystemIn("5\n").execute(() -> {
                View.SCANNER = new java.util.Scanner(System.in);
                RecoverListView.printRecover();
            });
        });
        assertTrue(output.contains("Mi diario:"));
    }
}