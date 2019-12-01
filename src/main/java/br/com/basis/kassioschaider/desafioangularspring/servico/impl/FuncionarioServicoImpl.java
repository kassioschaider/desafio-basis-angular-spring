package br.com.basis.kassioschaider.desafioangularspring.servico.impl;

import br.com.basis.kassioschaider.desafioangularspring.dominio.Funcionario;
import br.com.basis.kassioschaider.desafioangularspring.repositorio.FuncionarioRepositorio;
import br.com.basis.kassioschaider.desafioangularspring.servico.FuncionarioServico;
import br.com.basis.kassioschaider.desafioangularspring.servico.dto.FuncionarioDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FuncionarioServicoImpl implements FuncionarioServico {

    @Autowired
    private final FuncionarioRepositorio funcionarioRepositorio;

    @Override
    public List<FuncionarioDTO> obterTodos() {
        List<Funcionario> funcionarios = funcionarioRepositorio.findAll();
        return FuncionarioDTO.paraDto(funcionarios);
    }
}
