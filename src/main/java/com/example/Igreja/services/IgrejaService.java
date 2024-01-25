package com.example.Igreja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.example.Igreja.models.IgrejaModel;
import com.example.Igreja.repositories.IgrejaRepository;



@Service
public class IgrejaService {

    final IgrejaRepository igrejaRepository;

    public IgrejaService(IgrejaRepository igrejaRepository){
        this.igrejaRepository = igrejaRepository;
    }

    public List<IgrejaModel> getAllIgrejas(){
        return igrejaRepository.findAll();
    }

    public Optional<IgrejaModel> getByIdIgreja(@NonNull Long id){
        return igrejaRepository.findById(id);
    }

    public IgrejaModel createIgreja(@NonNull IgrejaModel igrejaModel){
        return igrejaRepository.save(igrejaModel);

    }

    public void updateIgreja(@NonNull Long id,IgrejaModel updateIgreja) {
        if (igrejaRepository.existsById(id)) {
            updateIgreja.setId(id);
            igrejaRepository.save(updateIgreja);
        }
    }

    public void deleteIgreja(@NonNull Long id) {
        igrejaRepository.deleteById(id);
    }
    
}
    

