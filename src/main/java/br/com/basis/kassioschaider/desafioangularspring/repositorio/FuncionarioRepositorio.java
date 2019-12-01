package br.com.basis.kassioschaider.desafioangularspring.repositorio;

import br.com.basis.kassioschaider.desafioangularspring.dominio.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepositorio extends JpaRepository<Funcionario, Long> {
}
