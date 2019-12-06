package br.com.basis.kassioschaider.desafioangularspring.repositorio;

import br.com.basis.kassioschaider.desafioangularspring.dominio.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepositorio extends JpaRepository<Empresa, Long> {}
