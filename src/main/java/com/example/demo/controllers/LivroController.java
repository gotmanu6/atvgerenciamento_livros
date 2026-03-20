package com.example.demo.controllers;


import com.example.demo.models.LivroModel;
import com.example.demo.services.LivrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/livros")

public class LivroController {
    @Autowired
    private LivrosService livrosService;

    @GetMapping
    public ResponseEntity<List<LivroModel>> findAll() {
        List<LivroModel> requeste = livrosService.findAll();
        return ResponseEntity.ok().body(requeste);
    }

    @PostMapping
    public ResponseEntity<LivroModel> criarPessoa(@RequestBody LivroModel livroModel) {
        LivroModel requeste = livrosService.criarLivro(livroModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(livroModel.getId())
                .toUri();
        return ResponseEntity.created(uri).body(requeste);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        return livrosService.deletar(id);
    }

    @GetMapping("/{id}")
    public Optional<LivroModel> buscarId(@PathVariable Long id) {
        return livrosService.findById(id);
    }

    @PutMapping("/{id}")
    public LivroModel atualizar(@PathVariable Long id, @RequestBody LivroModel livroModel) {
        return livrosService.atualizar(id, livroModel);
    }

}
