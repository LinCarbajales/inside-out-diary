package dev.lin.db;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;

import dev.lin.models.Moment;
import dev.lin.contracts.InterfaceDB;

public class DiaryDatabase implements InterfaceDB {
    
    private List<Moment> moments;

    public DiaryDatabase() {
        this.moments = new ArrayList<>();
    }

    @Override
    public void store(Moment moment) {
        moments.add(moment);
        System.out.println("Nuevo momento guardado:");
        System.out.println(moment.getId() + ". " +
                            moment.getTitle() + ". " + 
                            "Ocurrió el: " + moment.getDate() +
                            ". Emoción: " + moment.getEmotion().getName() +
                            ". Descripción: " + moment.getDescription());
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
    public List<Moment> getMomentsFiltered(String emotionName) {
    return moments.stream()
        .filter(moment -> moment.getEmotion().getName().equalsIgnoreCase(emotionName))
        .collect(Collectors.toList());
}

    @Override
    public List<Moment> getMomentsFiltered(LocalDate date) {
    return moments.stream()
        .filter(moment -> moment.getDate().equals(date))
        .collect(Collectors.toList());
}

}