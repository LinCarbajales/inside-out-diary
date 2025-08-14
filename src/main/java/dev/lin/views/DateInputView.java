package dev.lin.views;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateInputView extends View {
    
    public static LocalDate inputDate() {
        LocalDate momentDate = null;
        while (momentDate == null) {
            System.out.print("Introduce la fecha (dd/mm/aaaa): ");
            String userDate = SCANNER.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
            try {
                momentDate = LocalDate.parse(userDate, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha incorrecto. Usa el formato dd/mm/aaaa");
            }
        }
        return momentDate;
    }
}