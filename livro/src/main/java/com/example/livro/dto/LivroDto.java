package com.example.livro.dto;

import com.example.livro.model.LivroModel;

public class LivroDto {

    private Long id;
    private String nome;
    private String categoria;

    public LivroDto() {}

    public LivroDto(LivroModel livro) {
        this.id = livro.getId();
        this.nome = livro.getNome();
        this.categoria = livro.getCategoria();
    }

    public LivroModel transformaParaObjeto() {
        LivroModel model = new LivroModel();
        model.setId(this.id);
        model.setNome(this.nome);
        model.setCategoria(this.categoria);
        return model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}