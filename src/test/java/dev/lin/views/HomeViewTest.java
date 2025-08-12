package dev.lin.views;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class HomeViewTest {
    
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    
    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }
    
    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        System.setIn(System.in);
    }
    
    @Test
    void testPrintMenu_DisplaysCorrectMenu() {
        // Arrange
        String input = "6\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        // Act & Assert (no exception thrown)
        assertDoesNotThrow(() -> HomeView.printMenu());
        
        // Assert menu content
        String output = outputStream.toString();
        assertTrue(output.contains("Mi diario:"));
        assertTrue(output.contains("1. Añadir momento"));
        assertTrue(output.contains("2. Ver todos los momentos disponibles"));
        assertTrue(output.contains("3. Eliminar un momento"));
        assertTrue(output.contains("4. Filtrar los momentos"));
        assertTrue(output.contains("5. Salir"));
        assertTrue(output.contains("Seleccione una opción:"));
    }
}