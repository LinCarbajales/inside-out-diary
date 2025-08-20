package dev.lin.repositories;

import java.io.IOException;
import java.util.List;

import dev.lin.db.CSVStorage;
import dev.lin.dtos.MomentViewDTO;

public class CSVRepository {
    
    private final CSVStorage csvStorage;
    
    public CSVRepository() {
        this.csvStorage = new CSVStorage();
    }
    
    public void saveMomentsToCsv(List<MomentViewDTO> moments, String filePath) throws IOException {
        csvStorage.saveMomentsToCsv(moments, filePath);
    }
}