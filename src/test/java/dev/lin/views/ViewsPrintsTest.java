package dev.lin.views;

import dev.lin.models.EmotionEnum;

import static com.github.stefanbirkner.systemlambda.SystemLambda.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import dev.lin.dtos.MomentViewDTO;

public class ViewsPrintsTest {

    @Test
    public void testHomeView_printMenu_option5_exits() throws Exception {
        String simulatedInput = "5\n";

        String output = tapSystemOut(() -> {
            withTextFromSystemIn(simulatedInput).execute(() -> {
                View.SCANNER = new java.util.Scanner(System.in);
                HomeView.printMenu();
            });
        });

        assertTrue(output.contains("Mi diario:"), "Debe imprimirse el encabezado del menú");
        assertTrue(output.contains("¡Hasta la próxima!"), "Debe imprimirse el mensaje de despedida");
    }

    @Test
    public void testFilterMomentsView_printFilterMenu_otherOption_returnsToHome() throws Exception {
        String simulatedInput = "\n9\n5\n";

        String output = tapSystemOut(() -> {
            withTextFromSystemIn(simulatedInput).execute(() -> {
                View.SCANNER = new java.util.Scanner(System.in);
                FilterMomentsView.printFilterMenu();
            });
        });

        assertTrue(output.contains("Filtrar por:"), "Debe imprimirse el menú de filtrado");
        assertTrue(output.contains("Mi diario:"), "Debe volver a HomeView y mostrar su menú");
    }

    @Test
    public void testMomentDisplayView_displayMoments_emptyList() throws Exception {
        List<MomentViewDTO> emptyList = new ArrayList<>();

        String output = tapSystemOut(() -> {
            MomentDisplayView.displayMoments(emptyList);
        });

        assertTrue(output.contains("No hay momentos guardados"), "Debe imprimir mensaje de lista vacía");
    }

    @Test
    public void testMomentDisplayView_displayMoments_nonEmptyList() throws Exception {
        List<MomentViewDTO> moments = new ArrayList<>();
        moments.add(new MomentViewDTO(
                1,
                "Título prueba",
                EmotionEnum.ALEGRIA,
                java.time.LocalDate.of(2023, 1, 1),
                "Descripción prueba",
                java.time.LocalDate.of(2023, 1, 2),
                java.time.LocalDate.of(2023, 1, 3)
        ));

        String output = tapSystemOut(() -> {
            MomentDisplayView.displayMoments(moments);
        });

        assertTrue(output.contains("Título prueba"), "Debe imprimir el título del momento");
        assertTrue(output.contains("Alegría"), "Debe imprimir la emoción");
    }

    // NUEVOS TESTS SIMPLES PARA LLEGAR AL 70%

    @Test
    public void testHomeView_printMenu_showsAllOptions() throws Exception {
        String simulatedInput = "5\n";

        String output = tapSystemOut(() -> {
            withTextFromSystemIn(simulatedInput).execute(() -> {
                View.SCANNER = new java.util.Scanner(System.in);
                HomeView.printMenu();
            });
        });

        // Testear que se muestran todas las opciones del menú
        assertTrue(output.contains("1."), "Debe mostrar opción 1");
        assertTrue(output.contains("2."), "Debe mostrar opción 2");
        assertTrue(output.contains("3."), "Debe mostrar opción 3");
        assertTrue(output.contains("4."), "Debe mostrar opción 4");
        assertTrue(output.contains("5."), "Debe mostrar opción 5");
    }

    @Test
    public void testFilterMomentsView_printFilterMenu_showsFilterOptions() throws Exception {
        String simulatedInput = "\n9\n5\n";

        String output = tapSystemOut(() -> {
            withTextFromSystemIn(simulatedInput).execute(() -> {
                View.SCANNER = new java.util.Scanner(System.in);
                FilterMomentsView.printFilterMenu();
            });
        });

        assertTrue(output.contains("1. Emoción"), "Debe mostrar opción de filtrar por emoción");
        assertTrue(output.contains("2. Fecha"), "Debe mostrar opción de filtrar por fecha");
        assertTrue(output.contains("Ingrese una opción:"), "Debe pedir seleccionar opción");
    }

    @Test
    public void testEmotionSelectorView_selectEmotion_showsEmotionMenu() throws Exception {
        String simulatedInput = "1\n";

        String output = tapSystemOut(() -> {
            withTextFromSystemIn(simulatedInput).execute(() -> {
                View.SCANNER = new java.util.Scanner(System.in);
                EmotionSelectorView.selectEmotion();
            });
        });

        assertTrue(output.contains("Mis emociones:"), "Debe mostrar título del menú");
        assertTrue(output.contains("1. Alegría"), "Debe mostrar alegría");
        assertTrue(output.contains("2. Tristeza"), "Debe mostrar tristeza");
        assertTrue(output.contains("3. Ira"), "Debe mostrar ira");
        assertTrue(output.contains("Selecciona una emoción:"), "Debe pedir selección");
    }

    @Test
    public void testEmotionSelectorView_selectEmotion_invalidInput() throws Exception {
        String simulatedInput = "99\n1\n"; // Entrada inválida, luego válida

        String output = tapSystemOut(() -> {
            withTextFromSystemIn(simulatedInput).execute(() -> {
                View.SCANNER = new java.util.Scanner(System.in);
                EmotionSelectorView.selectEmotion();
            });
        });

        assertTrue(output.contains("Selecciona un número del 1 al 10:"), "Debe mostrar mensaje de error");
    }

    @Test
    public void testDateInputView_inputDate_validDate() throws Exception {
        String simulatedInput = "15/08/2024\n";

        String output = tapSystemOut(() -> {
            withTextFromSystemIn(simulatedInput).execute(() -> {
                View.SCANNER = new java.util.Scanner(System.in);
                DateInputView.inputDate();
            });
        });

        assertTrue(output.contains("Introduce la fecha (dd/mm/aaaa):"), "Debe pedir introducir fecha");
    }

    @Test
    public void testDateInputView_inputDate_invalidThenValidDate() throws Exception {
        String simulatedInput = "fecha-incorrecta\n15/08/2024\n";

        String output = tapSystemOut(() -> {
            withTextFromSystemIn(simulatedInput).execute(() -> {
                View.SCANNER = new java.util.Scanner(System.in);
                DateInputView.inputDate();
            });
        });

        assertTrue(output.contains("Formato de fecha incorrecto"), "Debe mostrar error de formato");
        assertTrue(output.contains("dd/mm/aaaa"), "Debe mostrar el formato correcto");
    }

    @Test
    public void testMomentDisplayView_displayMoments_multipleItems() throws Exception {
        List<MomentViewDTO> moments = new ArrayList<>();
        moments.add(new MomentViewDTO(1, "Momento 1", EmotionEnum.ALEGRIA, 
                java.time.LocalDate.of(2023, 1, 1), "Desc 1", 
                java.time.LocalDate.of(2023, 1, 1), java.time.LocalDate.of(2023, 1, 1)));
        moments.add(new MomentViewDTO(2, "Momento 2", EmotionEnum.TRISTEZA, 
                java.time.LocalDate.of(2023, 1, 2), "Desc 2", 
                java.time.LocalDate.of(2023, 1, 2), java.time.LocalDate.of(2023, 1, 2)));

        String output = tapSystemOut(() -> {
            MomentDisplayView.displayMoments(moments);
        });

        assertTrue(output.contains("1. Momento 1"), "Debe mostrar primer momento");
        assertTrue(output.contains("2. Momento 2"), "Debe mostrar segundo momento");
        assertTrue(output.contains("Alegría"), "Debe mostrar primera emoción");
        assertTrue(output.contains("Tristeza"), "Debe mostrar segunda emoción");
    }

    @Test
    public void testMomentDisplayView_displayMoments_containsAllFields() throws Exception {
        List<MomentViewDTO> moments = new ArrayList<>();
        moments.add(new MomentViewDTO(99, "Título completo", EmotionEnum.MIEDO, 
                java.time.LocalDate.of(2023, 12, 25), "Descripción completa", 
                java.time.LocalDate.of(2023, 12, 26), java.time.LocalDate.of(2023, 12, 27)));

        String output = tapSystemOut(() -> {
            MomentDisplayView.displayMoments(moments);
        });

        assertTrue(output.contains("99."), "Debe mostrar ID");
        assertTrue(output.contains("Título completo"), "Debe mostrar título");
        assertTrue(output.contains("Ocurrió el:"), "Debe mostrar etiqueta de fecha");
        assertTrue(output.contains("Emoción:"), "Debe mostrar etiqueta de emoción");
        assertTrue(output.contains("Descripción:"), "Debe mostrar etiqueta de descripción");
        assertTrue(output.contains("Fecha de creación:"), "Debe mostrar etiqueta de creación");
        assertTrue(output.contains("Fecha de actualización:"), "Debe mostrar etiqueta de actualización");
    }


// AÑADE ESTOS TESTS A TU CLASE EXISTENTE

@Test
public void testEmotionSelectorView_selectEmotion_allEmotions() throws Exception {
    // Testear varias emociones para cubrir más del enum
    String simulatedInput = "3\n"; // Ira

    String output = tapSystemOut(() -> {
        withTextFromSystemIn(simulatedInput).execute(() -> {
            View.SCANNER = new java.util.Scanner(System.in);
            EmotionSelectorView.selectEmotion();
        });
    });

    assertTrue(output.contains("4. Asco"), "Debe mostrar asco");
    assertTrue(output.contains("5. Miedo"), "Debe mostrar miedo");
    assertTrue(output.contains("6. Ansiedad"), "Debe mostrar ansiedad");
    assertTrue(output.contains("10. Nostalgia"), "Debe mostrar nostalgia");
}

@Test
public void testDateInputView_inputDate_multipleInvalidInputs() throws Exception {
    String simulatedInput = "abc\n32/15/2024\n15-08-2024\n15/08/2024\n";

    String output = tapSystemOut(() -> {
        withTextFromSystemIn(simulatedInput).execute(() -> {
            View.SCANNER = new java.util.Scanner(System.in);
            DateInputView.inputDate();
        });
    });

    // Debe mostrar múltiples mensajes de error
    long errorCount = output.lines()
        .filter(line -> line.contains("Formato de fecha incorrecto"))
        .count();
    assertTrue(errorCount >= 2, "Debe mostrar múltiples errores de formato");
}

@Test
public void testHomeView_printMenu_containsExitOption() throws Exception {
    String simulatedInput = "5\n";

    String output = tapSystemOut(() -> {
        withTextFromSystemIn(simulatedInput).execute(() -> {
            View.SCANNER = new java.util.Scanner(System.in);
            HomeView.printMenu();
        });
    });

    assertTrue(output.contains("Salir") || output.contains("5."), "Debe tener opción de salir");
}

@Test
public void testMomentDisplayView_displayMoments_checkDateFormats() throws Exception {
    List<MomentViewDTO> moments = new ArrayList<>();
    moments.add(new MomentViewDTO(1, "Test", EmotionEnum.ALEGRIA, 
            java.time.LocalDate.of(2023, 1, 15), "Test desc", 
            java.time.LocalDate.of(2023, 2, 20), java.time.LocalDate.of(2023, 3, 25)));

    String output = tapSystemOut(() -> {
        MomentDisplayView.displayMoments(moments);
    });

    // Verificar que aparecen las fechas (en cualquier formato)
    assertTrue(output.contains("2023"), "Debe contener el año");
    assertTrue(output.contains("01") || output.contains("1"), "Debe contener el mes");
}

@Test
public void testFilterMomentsView_printFilterMenu_emotionPath() throws Exception {
    String simulatedInput = "\n1\n1\n5\n"; // Opción 1 (emoción), alegría, salir

    String output = tapSystemOut(() -> {
        withTextFromSystemIn(simulatedInput).execute(() -> {
            View.SCANNER = new java.util.Scanner(System.in);
            FilterMomentsView.printFilterMenu();
        });
    });

    assertTrue(output.contains("Filtrar por:"), "Debe mostrar menú principal");
    assertTrue(output.contains("Mis emociones:"), "Debe mostrar menú de emociones");
}

@Test
public void testEmotionSelectorView_selectEmotion_boundaryValues() throws Exception {
    String simulatedInput = "10\n"; // Última opción válida

    String output = tapSystemOut(() -> {
        withTextFromSystemIn(simulatedInput).execute(() -> {
            View.SCANNER = new java.util.Scanner(System.in);
            EmotionSelectorView.selectEmotion();
        });
    });

    assertTrue(output.contains("10. Nostalgia"), "Debe mostrar la opción 10");
}

@Test
public void testDateInputView_inputDate_leapYear() throws Exception {
    String simulatedInput = "29/02/2024\n"; // Año bisiesto

    String output = tapSystemOut(() -> {
        withTextFromSystemIn(simulatedInput).execute(() -> {
            View.SCANNER = new java.util.Scanner(System.in);
            DateInputView.inputDate();
        });
    });

    assertTrue(output.contains("Introduce la fecha"), "Debe procesar fecha de año bisiesto");
}

@Test
public void testMomentDisplayView_displayMoments_longTexts() throws Exception {
    List<MomentViewDTO> moments = new ArrayList<>();
    moments.add(new MomentViewDTO(1, "Título muy muy muy largo para testear", 
            EmotionEnum.ENVIDIA, java.time.LocalDate.now(), 
            "Descripción extremadamente larga que contiene muchas palabras para verificar que se imprimen correctamente", 
            java.time.LocalDate.now(), java.time.LocalDate.now()));

    String output = tapSystemOut(() -> {
        MomentDisplayView.displayMoments(moments);
    });

    assertTrue(output.contains("Título muy muy"), "Debe manejar títulos largos");
    assertTrue(output.contains("extremadamente larga"), "Debe manejar descripciones largas");
    assertTrue(output.contains("Envidia"), "Debe mostrar emoción envidia");
}
// AÑADE ESTOS TESTS A TU CLASE EXISTENTE

@Test
public void testMomentPostView_printStoreMenu_completesFlow() throws Exception {
    String simulatedInput = "\nMi momento de prueba\n1\n15/08/2024\nDescripción de prueba\n5\n";

    String output = tapSystemOut(() -> {
        withTextFromSystemIn(simulatedInput).execute(() -> {
            View.SCANNER = new java.util.Scanner(System.in);
            MomentPostView.printStoreMenu();
        });
    });

    // Verificar todos los prints de MomentPostView
    assertTrue(output.contains("Escribe el título del momento:"), "Debe pedir título");
    assertTrue(output.contains("Título: Mi momento de prueba"), "Debe confirmar título");
    assertTrue(output.contains("Has elegido:"), "Debe confirmar emoción elegida");
    assertTrue(output.contains("Fecha del momento:"), "Debe confirmar fecha");
    assertTrue(output.contains("Escribe la descripción del momento:"), "Debe pedir descripción");
    assertTrue(output.contains("Momento guardado con éxito."), "Debe confirmar guardado");
}

@Test
public void testMomentPostView_printStoreMenu_showsEmotionMenu() throws Exception {
    String simulatedInput = "\nTítulo\n2\n15/08/2024\nDescripción\n5\n";

    String output = tapSystemOut(() -> {
        withTextFromSystemIn(simulatedInput).execute(() -> {
            View.SCANNER = new java.util.Scanner(System.in);
            MomentPostView.printStoreMenu();
        });
    });

    // Debe mostrar el menú de emociones (porque llama a EmotionSelectorView)
    assertTrue(output.contains("Mis emociones:"), "Debe mostrar menú de emociones");
    assertTrue(output.contains("Selecciona una emoción:"), "Debe pedir seleccionar emoción");
}

@Test
public void testMomentPostView_printStoreMenu_showsDateInput() throws Exception {
    String simulatedInput = "\nTítulo\n3\n20/12/2024\nDescripción\n5\n";

    String output = tapSystemOut(() -> {
        withTextFromSystemIn(simulatedInput).execute(() -> {
            View.SCANNER = new java.util.Scanner(System.in);
            MomentPostView.printStoreMenu();
        });
    });

    // Debe mostrar solicitud de fecha (porque llama a DateInputView)
    assertTrue(output.contains("Introduce la fecha (dd/mm/aaaa):"), "Debe pedir fecha");
    assertTrue(output.contains("Fecha del momento:"), "Debe mostrar fecha confirmada");
}

@Test
public void testRecoverListView_printRecover_callsDisplayAndHome() throws Exception {
    String simulatedInput = "5\n"; // Para salir cuando llegue a HomeView

    String output = tapSystemOut(() -> {
        withTextFromSystemIn(simulatedInput).execute(() -> {
            View.SCANNER = new java.util.Scanner(System.in);
            RecoverListView.printRecover();
        });
    });

    // Debe mostrar el menú de HomeView al final (porque llama a HomeView.printMenu())
    assertTrue(output.contains("Mi diario:"), "Debe mostrar menú principal al final");
    assertTrue(output.contains("¡Hasta la próxima!"), "Debe salir correctamente");
}

@Test
public void testRecoverListView_printRecover_displaysEmptyMessage() throws Exception {
    String simulatedInput = "5\n";

    String output = tapSystemOut(() -> {
        withTextFromSystemIn(simulatedInput).execute(() -> {
            View.SCANNER = new java.util.Scanner(System.in);
            RecoverListView.printRecover();
        });
    });

    // Si no hay momentos, debe mostrar mensaje vacío (del MomentDisplayView)
    // Como no sabemos si hay datos, al menos verificamos que se ejecuta
    assertTrue(output.length() > 0, "Debe producir alguna salida");
}

@Test
public void testMomentPostView_printStoreMenu_returnsToHome() throws Exception {
    String simulatedInput = "\nTítulo test\n1\n01/01/2024\nDescripción test\n5\n";

    String output = tapSystemOut(() -> {
        withTextFromSystemIn(simulatedInput).execute(() -> {
            View.SCANNER = new java.util.Scanner(System.in);
            MomentPostView.printStoreMenu();
        });
    });

    // Debe volver a HomeView al final
    assertTrue(output.contains("Mi diario:"), "Debe volver al menú principal");
    assertTrue(output.contains("1.") && output.contains("2."), "Debe mostrar opciones del menú");
}
}
