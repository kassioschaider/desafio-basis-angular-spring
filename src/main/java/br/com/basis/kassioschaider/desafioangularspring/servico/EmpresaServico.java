package br.com.basis.kassioschaider.desafioangularspring.servico;

import br.com.basis.kassioschaider.desafioangularspring.servico.dto.EmpresaDTO;

import java.util.List;

public interface EmpresaServico {

    List<EmpresaDTO> obterTodos();

    EmpresaDTO cadastrar(EmpresaDTO empresaDTO);
}
