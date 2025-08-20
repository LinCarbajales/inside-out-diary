package dev.lin.db;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import dev.lin.dtos.MomentViewDTO;

public class CSVStorage {
    public void saveMomentsToCsv(List<MomentViewDTO> moments, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            // Escribir la cabecera
            writer.append("id, titulo, emocion, calificacion, fecha, descripcion, fechaActualizacion\n");

            // Escribir los datos
            for (MomentViewDTO dto : moments) {
                writer.append(String.valueOf(dto.getId())).append(", ");
                writer.append(escapeCsv(dto.getTitle())).append(", ");
                writer.append(dto.getEmotion().getName()).append(", ");
                writer.append(dto.getRating().getDisplayName()).append(", ");
                writer.append(dto.getDate().toString()).append(", ");
                writer.append(escapeCsv(dto.getDescription())).append(", ");
                writer.append(dto.getUpdate().toString()).append("\n");
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
