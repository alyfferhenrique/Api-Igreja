package com.example.Igreja.controllers;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Igreja.models.UsuarioModel;
import com.example.Igreja.services.UsuarioService;

import io.micrometer.common.lang.NonNull;


@RestController
@RequestMapping("/api/users")
public class UsuarioController {


    final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;

    }
    
    @GetMapping
    public ResponseEntity<List<UsuarioModel>> getAllUsers(){
        return ResponseEntity.ok(usuarioService.getAllUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UsuarioModel>> getByID(@PathVariable @NonNull Long id){
        if (id != null) {
            usuarioService.getById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
               
    }

    @PostMapping
    public ResponseEntity<UsuarioModel> createUser(@RequestBody @NonNull UsuarioModel usuarioModel){
        if (usuarioModel != null) {
            usuarioService.createUser(usuarioModel);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.badRequest().build();
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioModel> updateUser(@NonNull @PathVariable Long id, @RequestBody UsuarioModel usuarioModel){
        if (id != null) {
            usuarioService.updateUser(id, usuarioModel);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UsuarioModel> deleteUser(@PathVariable @NonNull  Long id){
        if (id != null) {
            usuarioService.deleteUser(id);;
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.badRequest().build();
        }

    }
}
