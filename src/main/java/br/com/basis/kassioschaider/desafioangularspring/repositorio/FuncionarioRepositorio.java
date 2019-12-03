package br.com.basis.kassioschaider.desafioangularspring.repositorio;

import br.com.basis.kassioschaider.desafioangularspring.dominio.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepositorio extends JpaRepository<Funcionario, Long> {
    List<Funcionario> findByEmpresa_id(Long id);
}
