package dev.lin.db;

import java.util.ArrayList;
import java.util.List;
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

    public int getTotalMoments() {
        return moments.size();
    }

}