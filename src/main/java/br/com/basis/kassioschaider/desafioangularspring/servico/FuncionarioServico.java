package br.com.basis.kassioschaider.desafioangularspring.servico;

import br.com.basis.kassioschaider.desafioangularspring.servico.dto.FuncionarioDTO;

import java.util.List;
import java.util.Optional;

public interface FuncionarioServico {

    List<FuncionarioDTO> obterTodos();

    FuncionarioDTO cadastrar(FuncionarioDTO funcionarioDTO);

    FuncionarioDTO atualizar(FuncionarioDTO funcionarioDTO);

    Optional<FuncionarioDTO> obterPorId(Long id);

    void excluirPorId(Long id);
}
