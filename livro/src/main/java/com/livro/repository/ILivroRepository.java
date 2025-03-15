package com.livro.repository;

import com.livro.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILivroRepository extends JpaRepository<Livro, Long> {
}
