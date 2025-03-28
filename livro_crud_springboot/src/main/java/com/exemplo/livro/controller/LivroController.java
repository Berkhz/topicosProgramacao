package com.exemplo.livro.controller;

import com.exemplo.livro.model.Livro;
import com.exemplo.livro.repository.LivroRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    private final LivroRepository repository;

    public LivroController(LivroRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public void criar(@RequestBody Livro livro) {
        repository.save(livro);
    }

    @GetMapping
    public List<Livro> listar() {
        return repository.findAll();
    }
}