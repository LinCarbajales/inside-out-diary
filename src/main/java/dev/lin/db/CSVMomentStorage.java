package dev.lin.db;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import dev.lin.models.Moment;

public class CSVMomentStorage {
    public void saveToCsv(List<Moment> moments, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            // Escribir la cabecera
            writer.append("id, titulo, emocion, calificacion, fecha, descripcion, fechaActualizacion\n");

            // Escribir los datos
            for (Moment moment : moments) {
                writer.append(String.valueOf(moment.getId())).append(", ");
                writer.append(escapeCsv(moment.getTitle())).append(", ");
                writer.append(moment.getEmotion().getName()).append(", ");
                writer.append(moment.getRating().getDisplayName()).append(", ");
                writer.append(moment.getDate().toString()).append(", ");
                writer.append(escapeCsv(moment.getDescription())).append(", ");
                writer.append(moment.getUpdate().toString()).append("\n");
            }
        }
    }

    private String escapeCsv(String value) {
        if (value == null) {
            return "";
        }
        if (value.contains(",") || value.contains("\"") || value.contains("\n")) {
            return "\"" + value.replace("\"", "\"\"") + "\"";
        }
        return value;
    }
}
