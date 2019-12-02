package br.com.basis.kassioschaider.desafioangularspring.servico.impl;

import br.com.basis.kassioschaider.desafioangularspring.dominio.Empresa;
import br.com.basis.kassioschaider.desafioangularspring.repositorio.EmpresaRepositorio;
import br.com.basis.kassioschaider.desafioangularspring.servico.EmpresaServico;
import br.com.basis.kassioschaider.desafioangularspring.servico.dto.EmpresaDTO;
import br.com.basis.kassioschaider.desafioangularspring.servico.dto.EmpresaRespostaDTO;
import br.com.basis.kassioschaider.desafioangularspring.servico.mapper.EmpresaMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmpresaServicoImpl implements EmpresaServico {

    @Autowired
    private EmpresaRepositorio empresaRepositorio;

    @Autowired
    private EmpresaMapper empresaMapper;

    @Override
    public List<EmpresaDTO> obterTodos() {
        return empresaMapper.toDto(empresaRepositorio.findAll());
    }

    @Override
    public EmpresaDTO cadastrar(EmpresaDTO empresaDTO) {
        Empresa empresa = empresaMapper.toEntity(empresaDTO);
        return empresaMapper.toDto(empresaRepositorio.save(empresa));
    }
}
