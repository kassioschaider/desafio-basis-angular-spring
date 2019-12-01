package br.com.basis.kassioschaider.desafioangularspring.servico.impl;

import br.com.basis.kassioschaider.desafioangularspring.dominio.Empresa;
import br.com.basis.kassioschaider.desafioangularspring.repositorio.EmpresaRepositorio;
import br.com.basis.kassioschaider.desafioangularspring.servico.EmpresaServico;
import br.com.basis.kassioschaider.desafioangularspring.servico.dto.EmpresaDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmpresaServicoImpl implements EmpresaServico {

    @Autowired
    private final EmpresaRepositorio empresaRepositorio;

    @Override
    public List<EmpresaDTO> obterTodos() {
        List<Empresa> empresas = empresaRepositorio.findAll();
        return EmpresaDTO.paraDto(empresas);
    }
}
