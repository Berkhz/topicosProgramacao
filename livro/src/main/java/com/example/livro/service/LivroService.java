package com.example.livro.service;

import com.example.livro.model.LivroModel;
import com.example.livro.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<LivroModel> findAll() {
        return livroRepository.findAll();
    }

    public LivroModel criarLivro(LivroModel bookModel) {
        return livroRepository.save(bookModel);
    }

    public void deletarLivro(Long id) {
        livroRepository.deleteById(id);
    }
}
