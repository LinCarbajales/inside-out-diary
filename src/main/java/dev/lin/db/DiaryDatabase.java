package dev.lin.db;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;

import dev.lin.models.EmotionEnum;
import dev.lin.models.Moment;
import dev.lin.contracts.InterfaceDB;
import dev.lin.models.RatingEnum;

public class DiaryDatabase implements InterfaceDB {
    
    private List<Moment> moments;

    public DiaryDatabase() {
        this.moments = new ArrayList<>();
    }

    @Override
    public void store(Moment moment) {
        moments.add(moment);
    }

    @Override
    public List<Moment> getAllMoments() {
        return moments;
    }

    @Override
    public boolean deleteMoment(int id) {
        boolean removed = moments.removeIf(moment -> moment.getId() == id);        
        return removed;
    }

    @Override
    public List<Moment> getMomentsFiltered(EmotionEnum emotion) {
    return moments.stream()
        .filter(moment -> moment.getEmotion().equals(emotion))
        .collect(Collectors.toList());
    }

    @Override
    public List<Moment> getMomentsFiltered(LocalDate date) {
    return moments.stream()
        .filter(moment -> moment.getDate().equals(date))
        .collect(Collectors.toList());
    }

    @Override
    public List<Moment> getMomentsFiltered(RatingEnum rating) {
    return moments.stream()
        .filter(moment -> moment.getRating().equals(rating))
        .collect(Collectors.toList());
    }

}