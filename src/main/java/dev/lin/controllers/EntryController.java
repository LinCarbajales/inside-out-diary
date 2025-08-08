package dev.lin.controllers;

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

    public void StoreCharacter(EntryDTO characterDTO) {
        Character characterToSave = EntryMapper.toEntity(EntryDTO);
        repository.StoreEntry(entryToSave);
    }

}
