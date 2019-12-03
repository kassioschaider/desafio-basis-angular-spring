package br.com.basis.kassioschaider.desafioangularspring.servico;

import br.com.basis.kassioschaider.desafioangularspring.servico.dto.FuncionarioDTO;

import java.util.List;

public interface FuncionarioServico {

    List<FuncionarioDTO> obterTodos();

    FuncionarioDTO cadastrar(FuncionarioDTO funcionarioDTO);

    FuncionarioDTO atualizar(FuncionarioDTO funcionarioDTO);

    FuncionarioDTO obterPorId(Long id);

    void excluirPorId(Long id);
}
