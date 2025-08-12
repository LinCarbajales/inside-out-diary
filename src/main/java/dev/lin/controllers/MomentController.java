package dev.lin.controllers;

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
}
