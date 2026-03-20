package com.example.demo.services;

import com.example.demo.models.LivroModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivrosService {

    @Autowired
    private LivrosService livroRepository;

    public List<LivroModel> findAll() {
        return livroRepository.findAll();
    }

    public LivroModel criarLivro(LivroModel livroModel) {
        return livroRepository.criarLivro(livroModel);
    }

    public Optional<LivroModel> findById(Long id) {
        return livroRepository.findById(id);
    }

    public LivroModel atualizar(Long id, LivroModel livroModel) {
        LivroModel model = livroRepository.findById(id).get();
        model.setTitulo(livroModel.getTitulo());
        model.setAutor(livroModel.getAutor());
        model.setAnoPublicacao(livroModel.getAnoPublicacao());
        return livroRepository.atualizar(id, model);
    }

    public ResponseEntity<?> deletar(Long id) {
        livroRepository.deletar(id);
        return null;
    }
}