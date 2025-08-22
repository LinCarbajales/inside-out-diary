package dev.lin.repositories;

import java.io.IOException;
import java.util.List;

import dev.lin.daos.CSVMomentDAO;
import dev.lin.models.Moment;

public class CSVMomentRepository {
    
    private final CSVMomentDAO csvMomentDao;
    
    public CSVMomentRepository() {
        this.csvMomentDao = new CSVMomentDAO();
    }
    
    public void saveMomentsToCsv(List<Moment> moments, String filePath) throws IOException {
        csvMomentDao.saveToCsv(moments, filePath);
    }
}