package dev.lin.dtos;

public class ReleaseYearDTO {
    private int year;
    private Integer endYear; // Puede ser null
    
    public int getYear() {
        return year;
    }
    
    public Integer getEndYear() {
        return endYear;
    }
}