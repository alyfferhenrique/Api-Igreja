package com.example.Igreja.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Igreja.models.IgrejaModel;
import com.example.Igreja.services.IgrejaService;


@RestController
@RequestMapping("/Igrejas")
public class IgrejaController {

       final IgrejaService igrejaService;

    public IgrejaController(IgrejaService igrejaService) {
        this.igrejaService = igrejaService;

    }
    
    @GetMapping
    public ResponseEntity<List<IgrejaModel>> getAllIgreja(){
        return ResponseEntity.ok(igrejaService.getAllIgrejas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<IgrejaModel>> getByIdIgreja(@NonNull @PathVariable Long id){
        return ResponseEntity.ok(igrejaService.getByIdIgreja(id));
               
    }

    @PostMapping
    public ResponseEntity<IgrejaModel> createIgreja(@NonNull @RequestBody IgrejaModel igrejaModel){
        return ResponseEntity.ok(igrejaService.createIgreja(igrejaModel));

    }
    @PutMapping("/{id}")
    public ResponseEntity<IgrejaModel> updateUser(@NonNull @PathVariable Long id, @RequestBody IgrejaModel igrejaModel) {
    igrejaService.updateIgreja(id, igrejaModel);
    return ResponseEntity.noContent().build();
}

    @DeleteMapping("/{id}")
    public ResponseEntity<IgrejaModel> deleteUser(@NonNull @PathVariable Long id){
        igrejaService.deleteIgreja(id);
            return ResponseEntity.noContent().build();

    }
    
}
