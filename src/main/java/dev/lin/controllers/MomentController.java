package dev.lin.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import dev.lin.dtos.MomentDTO;
import dev.lin.dtos.MomentViewDTO;
import dev.lin.mappers.MomentMapper;
import dev.lin.models.Moment;
import dev.lin.repositories.MomentRepository;
import dev.lin.singletons.MomentRepositorySingleton;
import dev.lin.repositories.CSVMomentRepository;
import dev.lin.models.EmotionEnum;
import dev.lin.models.RatingEnum;

public class MomentController {
    
    private MomentRepository repository;
    private CSVMomentRepository csvMomentRepository;

    public MomentController() {
        this.repository = MomentRepositorySingleton.getInstance();
        this.csvMomentRepository = new CSVMomentRepository();
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
    public List<MomentViewDTO> getMomentsFiltered(EmotionEnum emotion) {
        List<Moment> moments = repository.getMomentsFiltered(emotion);
        return MomentMapper.toDTOList(moments);
    }

    // SOBRECARGA: mismo nombre, solo fecha
    public List<MomentViewDTO> getMomentsFiltered(LocalDate date) {
        List<Moment> moments = repository.getMomentsFiltered(date);
        return MomentMapper.toDTOList(moments);
    }

    // SOBRECARGA: mismo nombre, solo calificación
    public List<MomentViewDTO> getMomentsFiltered(RatingEnum rating) {
        List<Moment> moments = repository.getMomentsFiltered(rating);
        return MomentMapper.toDTOList(moments);
    }

    //Enviar momentos al CSV
    public void exportMomentsToCsv(String filePath) throws IOException {
        List<Moment> moments = repository.getAllMoments();
        csvMomentRepository.saveMomentsToCsv(moments, filePath);
    }
}
