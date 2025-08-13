package dev.lin.controllers;

import java.time.LocalDate;
import java.util.List;

import dev.lin.dtos.MomentDTO;
import dev.lin.dtos.MomentViewDTO;
import dev.lin.mappers.MomentMapper;
import dev.lin.models.Moment;
import dev.lin.repositories.MomentRepository;
import dev.lin.singletons.MomentRepositorySingleton;

public class MomentController {
    
    private MomentRepository repository;

    public MomentController() {
        this.repository = MomentRepositorySingleton.getInstance();
    }

    //Store
    public void StoreMoment(MomentDTO momentDTO) {
        Moment momentToSave = MomentMapper.toEntity(momentDTO);
        repository.StoreMoment(momentToSave);
    }

    //To view
    public List<MomentViewDTO> SendList() {
        List<Moment> moments = repository.getAllMoments();
        return MomentMapper.toDTOList(moments);
    }

    //To delete
    public boolean deleteMoment(int id) {
        return repository.deleteMoment(id);
    }

    //Filter
    
    // SOBRECARGA: mismo nombre, solo emoción
    public List<MomentViewDTO> getMomentsFiltered(String emotionName) {
        List<Moment> moments = repository.getMomentsFiltered(emotionName);
        return MomentMapper.toDTOList(moments);
    }

    // SOBRECARGA: mismo nombre, solo fecha
    public List<MomentViewDTO> getMomentsFiltered(LocalDate date) {
        List<Moment> moments = repository.getMomentsFiltered(date);
        return MomentMapper.toDTOList(moments);
    }
}
