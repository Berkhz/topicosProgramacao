package demo.src.main.java.com.example.demo;

import jakarta.persistence.*;

@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Double salario;

    // Construtores
    public Funcionario() {}

    public Funcionario(String nome, Double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    // Getters e Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Double getSalario() { return salario; }
    public void setSalario(Double salario) { this.salario = salario; }
}
