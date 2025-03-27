package com.example.demo.controller;

import com.example.demo.model.Funcionario;
import com.example.demo.repository.FuncionarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    private final FuncionarioRepository funcionarioRepository;

    // Constructor injection
    public FuncionarioController(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @GetMapping
    public List<Funcionario> listarTodos() {
        return funcionarioRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Funcionario> salvar(@RequestBody Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionario);
    }

    @PutMapping
    public ResponseEntity<Funcionario> atualizar(@RequestBody Funcionario funcionario) {
        if (funcionarioRepository.existsById(funcionario.getId())) {
            // Save the updated Funcionario and return the updated entity
            Funcionario updatedFuncionario = funcionarioRepository.save(funcionario);
            return ResponseEntity.ok(updatedFuncionario);
        }
        // Return 404 Not Found if the Funcionario doesn't exist
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (funcionarioRepository.existsById(id)) {
            funcionarioRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
















