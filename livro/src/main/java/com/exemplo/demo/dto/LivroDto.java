package com.exemplo.demo.dto;

import com.exemplo.demo.model.StatusLivro;
import java.time.LocalDate;

public class LivroDto {

    private String titulo;
    private String autor;
    private StatusLivro status;
    private LocalDate dataPublicacao;

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public StatusLivro getStatus() { return status; }
    public void setStatus(StatusLivro status) { this.status = status; }

    public LocalDate getDataPublicacao() { return dataPublicacao; }
    public void setDataPublicacao(LocalDate dataPublicacao) { this.dataPublicacao = dataPublicacao; }
}