package dev.lin.models;

import java.time.LocalDate;

public class Entry {

    private int id;
    private String title;
    private String emotion;
    private LocalDate date;
    private String moment;

    public Entry(int id) {
        this.id = id;
    }
    
    // Getter
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getEmotion() {
        return emotion;
    }
    
    public LocalDate getDate() {
        return date;
    }

    public String getMoment() {
        return moment;
    }

    // Setter
    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

}