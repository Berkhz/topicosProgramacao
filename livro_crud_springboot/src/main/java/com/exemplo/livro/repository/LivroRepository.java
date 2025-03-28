package com.exemplo.livro.repository;

import com.exemplo.livro.model.Livro;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LivroRepository {
    private final JdbcTemplate jdbcTemplate;

    public LivroRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Livro livro) {
        jdbcTemplate.update(
            "INSERT INTO livros (titulo, autor, categoria, data_publicacao) VALUES (?, ?, ?, ?)",
            livro.getTitulo(), livro.getAutor(), livro.getCategoria().name(), livro.getDataPublicacao()
        );
    }

    public List<Livro> findAll() {
        return jdbcTemplate.query("SELECT * FROM livros", this::mapRow);
    }

    private Livro mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Livro(
            rs.getInt("id"),
            rs.getString("titulo"),
            rs.getString("autor"),
            Enum.valueOf(com.exemplo.livro.model.Categoria.class, rs.getString("categoria")),
            rs.getDate("data_publicacao").toLocalDate()
        );
    }
}