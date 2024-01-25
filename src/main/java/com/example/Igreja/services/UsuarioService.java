package com.example.Igreja.services;



import java.util.List;
import java.util.Optional;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.example.Igreja.models.UsuarioModel;
import com.example.Igreja.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioModel> getAllUser(){
        return usuarioRepository.findAll();
    }

    public Optional<UsuarioModel> getById(@NonNull Long id){
        return usuarioRepository.findById(id);
    }

    public UsuarioModel createUser(@NonNull UsuarioModel usuarioModel){
        return usuarioRepository.save(usuarioModel);

    }

    public void updateUser(@NonNull Long id, UsuarioModel updatedUsuario) {
        if (usuarioRepository.existsById(id)) {
            updatedUsuario.setId(id);
            usuarioRepository.save(updatedUsuario);
        }
    }

    public void deleteUser(@NonNull Long id) {
        usuarioRepository.deleteById(id);
    }
    
}
