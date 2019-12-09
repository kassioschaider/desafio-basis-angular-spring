package br.com.basis.kassioschaider.desafioangularspring.servico.impl;

import br.com.basis.kassioschaider.desafioangularspring.dominio.Funcionario;
import br.com.basis.kassioschaider.desafioangularspring.repositorio.FuncionarioRepositorio;
import br.com.basis.kassioschaider.desafioangularspring.servico.FuncionarioServico;
import br.com.basis.kassioschaider.desafioangularspring.servico.dto.FuncionarioDTO;
import br.com.basis.kassioschaider.desafioangularspring.servico.mapper.FuncionarioMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FuncionarioServicoImpl implements FuncionarioServico {

    @Autowired
    private FuncionarioRepositorio funcionarioRepositorio;

    @Autowired
    private FuncionarioMapper funcionarioMapper;

    @Override
    public List<FuncionarioDTO> obterTodos() {
        return funcionarioMapper.toDto(funcionarioRepositorio.findAll());
    }

    @Override
    public FuncionarioDTO cadastrar(FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = funcionarioMapper.toEntity(funcionarioDTO);
        return funcionarioMapper.toDto(funcionarioRepositorio.save(funcionario));
    }

    @Override
    public FuncionarioDTO atualizar(FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = funcionarioMapper.toEntity(funcionarioDTO);
        return funcionarioMapper.toDto(funcionarioRepositorio.save(funcionario));
    }

    @Override
    public Optional<FuncionarioDTO> obterPorId(Long id) {
        return funcionarioRepositorio.findById(id).map(funcionarioMapper::toDto);
    }

    @Override
    public void excluirPorId(Long id) {
        funcionarioRepositorio.deleteById(id);
    }
}
