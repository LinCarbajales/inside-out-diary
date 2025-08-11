package dev.lin.models;

import java.time.LocalDate;

public class Entry {

    private int id;
    private String title;
    private EmotionEnum emotion;
    private LocalDate date;
    private String moment;
    private LocalDate creationDate;
    private LocalDate update;

    public Entry(int id) {
        this.id = id;
    }
    
    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public EmotionEnum getEmotion() {
        return emotion;
    }
    
    public LocalDate getDate() {
        return date;
    }

    public String getMoment() {
        return moment;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public LocalDate getUpate() {
        return update;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setEmotion(EmotionEnum emotion) {  // Ya lo tienes
        this.emotion = emotion;
    }
    
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setMoment(String moment) {
        this.moment = moment;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setUpdate(LocalDate update) {
        this.update = update;
    }

}