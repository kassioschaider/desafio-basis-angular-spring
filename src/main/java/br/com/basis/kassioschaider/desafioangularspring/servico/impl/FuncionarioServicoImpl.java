package br.com.basis.kassioschaider.desafioangularspring.servico.impl;

import br.com.basis.kassioschaider.desafioangularspring.repositorio.FuncionarioRepositorio;
import br.com.basis.kassioschaider.desafioangularspring.servico.FuncionarioServico;
import br.com.basis.kassioschaider.desafioangularspring.servico.dto.FuncionarioDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FuncionarioServicoImpl implements FuncionarioServico {

    @Autowired
    private FuncionarioRepositorio funcionarioRepositorio;


    @Override
    public List<FuncionarioDTO> obterTodos() {
//        return funcionarioRepositorio.findAll()
//                .stream().map(funcionarioMapper::toDto)
//                .collect(Collectors.toList());
        return null;
    }
}
