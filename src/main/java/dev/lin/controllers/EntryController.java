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

    //Store
    public void StoreEntry(EntryDTO entryDTO) {
        Entry entryToSave = EntryMapper.toEntity(entryDTO);
        repository.StoreEntry(entryToSave);
    }

}
