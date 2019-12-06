package br.com.basis.kassioschaider.desafioangularspring.servico.impl;

import br.com.basis.kassioschaider.desafioangularspring.dominio.Empresa;
import br.com.basis.kassioschaider.desafioangularspring.repositorio.EmpresaRepositorio;
import br.com.basis.kassioschaider.desafioangularspring.servico.EmpresaServico;
import br.com.basis.kassioschaider.desafioangularspring.servico.dto.EmpresaDTO;
import br.com.basis.kassioschaider.desafioangularspring.servico.mapper.EmpresaMapper;
import br.com.basis.kassioschaider.desafioangularspring.servico.mapper.FuncionarioMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmpresaServicoImpl implements EmpresaServico {

    @Autowired
    private EmpresaRepositorio empresaRepositorio;

    @Autowired
    private EmpresaMapper empresaMapper;

    @Autowired
    private FuncionarioMapper funcionarioMapper;

    @Override
    public List<EmpresaDTO> obterTodos() {
        return empresaMapper.toDto(empresaRepositorio.findAll());
    }

    @Override
    public EmpresaDTO cadastrar(EmpresaDTO empresaDTO) {
        Empresa empresa = empresaMapper.toEntity(empresaDTO);
        return empresaMapper.toDto(empresaRepositorio.save(empresa));
    }

    @Override
    public EmpresaDTO atualizar(EmpresaDTO empresaDTO) {
        Empresa empresa = empresaMapper.toEntity(empresaDTO);
        return empresaMapper.toDto(empresaRepositorio.save(empresa));
    }

    @Override
    public EmpresaDTO obterPorId(Long id) {
        Empresa empresa = empresaRepositorio.getOne(id);

        EmpresaDTO empresaDTO = empresaMapper.toDto(empresa);
        empresaDTO.setFuncionarios(funcionarioMapper.toDto(empresa.getFuncionarios()));

        return empresaDTO;
    }

    @Override
    public void excluirPorId(Long id) {
        empresaRepositorio.deleteById(id);
    }
}
