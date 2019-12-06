package br.com.basis.kassioschaider.desafioangularspring.servico.mapper;

import br.com.basis.kassioschaider.desafioangularspring.dominio.Funcionario;
import br.com.basis.kassioschaider.desafioangularspring.servico.dto.FuncionarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Classe de Mapper FuncionarioMapper
 */
@Mapper(componentModel = "spring", uses = {})
public interface FuncionarioMapper extends EntityMapper<FuncionarioDTO, Funcionario> {

    @Override
    @Mapping(source = "idEmpresa", target = "empresa.id")
    Funcionario toEntity(FuncionarioDTO dto);

    @Override
    @Mapping(source = "empresa.id", target = "idEmpresa")
    FuncionarioDTO toDto(Funcionario entity);
}
