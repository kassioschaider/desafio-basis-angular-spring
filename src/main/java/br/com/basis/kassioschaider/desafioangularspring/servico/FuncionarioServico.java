package br.com.basis.kassioschaider.desafioangularspring.servico;

import br.com.basis.kassioschaider.desafioangularspring.servico.dto.FuncionarioDTO;

import java.util.List;

public interface FuncionarioServico {

    List<FuncionarioDTO> obterTodos();
}
