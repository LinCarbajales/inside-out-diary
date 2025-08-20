package dev.lin.repositories;

import java.io.IOException;
import java.util.List;

import dev.lin.db.CSVMomentStorage;
import dev.lin.models.Moment;

public class CSVMomentRepository {
    
    private final CSVMomentStorage csvMomentStorage;
    
    public CSVMomentRepository() {
        this.csvMomentStorage = new CSVMomentStorage();
    }
    
    public void saveMomentsToCsv(List<Moment> moments, String filePath) throws IOException {
        csvMomentStorage.saveToCsv(moments, filePath);
    }
}