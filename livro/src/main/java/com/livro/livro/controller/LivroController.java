package com.livro.livro.controller;

import com.livro.livro.model.Livro;
import com.livro.livro.repository.ILivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/livro")
public class LivroController {

    @Autowired
    private final ILivroRepository repository;

    public LivroController(ILivroRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/criarLivro")
    public Livro CriarLivro(@RequestBody Livro livro) {
        return repository.save(livro);
    }

    @GetMapping("/buscarLivro/{id}")
    public Livro BuscarLivro(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow();
    }

    @PutMapping("/editarLivro/{id}")
    public Livro EditarLivro(@RequestBody Livro novoLivro, @PathVariable Long id) {
        return repository.findById(id)
                .map(livro -> {
                    livro.setNome(novoLivro.getNome());
                    livro.setAutor(novoLivro.getAutor());
                    return repository.save(novoLivro);
                })
                .orElseGet(() -> {
                    return repository.save(novoLivro);
                });
    }

    @DeleteMapping("/deletarLivro/{id}")
    public void DeletarLivro(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
