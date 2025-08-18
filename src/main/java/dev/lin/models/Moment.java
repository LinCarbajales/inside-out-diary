package dev.lin.models;

import java.time.LocalDate;

public class Moment {

    private int id;
    private String title;
    private EmotionEnum emotion;
    private LocalDate date;
    private String description;
    private LocalDate creationDate;
    private LocalDate update;
    private RatingEnum rating;

    public Moment(int id) {
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

    public String getDescription() {
        return description;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public LocalDate getUpdate() {
        return update;
    }

    public RatingEnum getRating() {
        return rating;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setEmotion(EmotionEnum emotion) {
        this.emotion = emotion;
    }
    
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setUpdate(LocalDate update) {
        this.update = update;
    }

    public void setRating(RatingEnum rating) {
        this.rating = rating;
    }

}