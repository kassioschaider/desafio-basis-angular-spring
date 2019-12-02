package br.com.basis.kassioschaider.desafioangularspring.servico.mapper;

import br.com.basis.kassioschaider.desafioangularspring.dominio.Empresa;
import br.com.basis.kassioschaider.desafioangularspring.servico.dto.EmpresaDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface EmpresaMapper {

    Empresa toEntity(EmpresaDTO dto);

    EmpresaDTO toDto(Empresa entity);

    List<Empresa> toEntity(List<EmpresaDTO> empresaDTOS);

    List<EmpresaDTO> toDto(List<Empresa> empresas);
}
