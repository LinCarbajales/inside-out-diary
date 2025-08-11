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
        System.out.println("✅ Nueva entrada guardada:");
    System.out.println("   ID: " + moment.getId());
    System.out.println("   Título: " + moment.getTitle());
    System.out.println("   Emoción: " + moment.getEmotion().getName());
    System.out.println("   Fecha: " + moment.getDate());
    System.out.println("   Descripción: " + moment.getDescription());
    System.out.println("   Total entradas: " + moments.size());
    }

    @Override
    public List<Moment> getAllMoments() {
        return new ArrayList<>(moments);
    }

    public int getTotalMoments() {
        return moments.size();
    }

}