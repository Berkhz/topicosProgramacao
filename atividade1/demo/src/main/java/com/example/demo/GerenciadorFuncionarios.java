package demo.src.main.java.com.example.demo;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GerenciadorFuncionarios {

    private final FuncionarioRepository repository;

    public GerenciadorFuncionarios(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        repository.save(funcionario);
    }

    public List<Funcionario> listarFuncionarios() {
        return repository.findAll();
    }

    public void atualizarSalario(Integer id, Double salario) {
        Funcionario funcionario = repository.findById(id).orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
        funcionario.setSalario(salario);
        repository.save(funcionario);
    }

    public void removerFuncionario(Integer id) {
        repository.deleteById(id);
    }
}