package com.exemplo.demo.service;

import com.exemplo.demo.dto.LivroDto;
import com.exemplo.demo.model.Livro;
import com.exemplo.demo.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    public List<Livro> listarTodos() {
        return repository.findAll();
    }

    public Optional<Livro> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Livro criar(LivroDto dto) {
        Livro livro = new Livro();
        livro.setTitulo(dto.getTitulo());
        livro.setAutor(dto.getAutor());
        livro.setStatus(dto.getStatus());
        livro.setDataPublicacao(dto.getDataPublicacao());
        return repository.save(livro);
    }

    public Optional<Livro> atualizar(Long id, LivroDto dto) {
        return repository.findById(id).map(livro -> {
            livro.setTitulo(dto.getTitulo());
            livro.setAutor(dto.getAutor());
            livro.setStatus(dto.getStatus());
            livro.setDataPublicacao(dto.getDataPublicacao());
            return repository.save(livro);
        });
    }

    public boolean deletar(Long id) {
        return repository.findById(id).map(livro -> {
            repository.delete(livro);
            return true;
        }).orElse(false);
    }
}