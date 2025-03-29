package com.example.livro.controller;

import com.example.livro.dto.LivroDto;
import com.example.livro.model.LivroModel;
import com.example.livro.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<LivroModel>> findAll() {
        List<LivroModel> livros = livroService.findAll();
        return ResponseEntity.ok().body(livros);
    }

    @PostMapping
    public ResponseEntity<LivroModel> criarLivro(@RequestBody LivroDto bookDto) {
        LivroModel response = livroService.criarLivro(bookDto.transformaParaObjeto());
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPeloId(@PathVariable Long id) {
        livroService.deletarLivro(id);
        return ResponseEntity.noContent().build();
    }
}