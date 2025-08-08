package dev.lin.controllers;

import java.util.List;

import dev.lin.dtos.EntryDTO;
import dev.lin.mappers.EntryMapper;
import dev.lin.models.Entry;
import dev.lin.repositories.EntryRepository;
import dev.lin.singletons.EntryRepositorySingleton;

public class EntryController {
    
    private EntryRepository repository;

    public EntryController() {
        this.repository = EntryRepositorySingleton.getInstance();
    }

    // Emociones según número para la selección
    private static final List<String> emotionList = List.of(
    "Alegría", "Tristeza", "Ira", "Asco", "Miedo",
    "Ansiedad", "Envidia", "Vergüenza", "Aburrimiento", "Nostalgia"
    );

    public String getEmotion(int number) {
        if (number >= 1 && number <= emotionList.size()) {
            return emotionList.get(number - 1);
        }
        return null;
    }

    public boolean isValidEmotion(int number) {
        return number >= 1 && number <= emotionList.size();
    }

    //Store
    public void StoreCharacter(EntryDTO characterDTO) {
        Entry entryToSave = EntryMapper.toEntity(entryDTO);
        repository.StoreEntry(entryToSave);
    }

}
