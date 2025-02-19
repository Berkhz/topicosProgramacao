package com.livro.livro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import org.springframework.data.annotation.Id;

@Entity
public class Livro
{
    @Id
    @GeneratedValue Long Id;
    private String Nome;
    private String Autor;

    Livro(Long Id, String Nome, String Autor) {
        this.Id = Id;
        this.Nome = Nome;
        this.Autor = Autor;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String autor) {
        Autor = autor;
    }
}
