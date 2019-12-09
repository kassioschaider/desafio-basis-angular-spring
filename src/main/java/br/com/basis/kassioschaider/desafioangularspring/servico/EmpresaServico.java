package br.com.basis.kassioschaider.desafioangularspring.servico;

import br.com.basis.kassioschaider.desafioangularspring.servico.dto.EmpresaDTO;

import java.util.List;
import java.util.Optional;

public interface EmpresaServico {

    List<EmpresaDTO> obterTodos();

    EmpresaDTO cadastrar(EmpresaDTO empresaDTO);

    EmpresaDTO atualizar(EmpresaDTO empresaDTO);

    Optional<EmpresaDTO> obterPorId(Long id);

    void excluirPorId(Long id);
}
