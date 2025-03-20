package com.example.demo.service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

   public Usuario salvar(Usuario usuario) {
       try{
           return usuarioRepository.save(usuario);
       }catch (Exception error){
           throw new RuntimeException(error);
       }

   }

   public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();

   }

   public Usuario atualizar(Usuario usuario){
        return usuarioRepository.save(usuario);

   }

   public void deletar(Long id) {
        usuarioRepository.deleteById(id);
   }



}
