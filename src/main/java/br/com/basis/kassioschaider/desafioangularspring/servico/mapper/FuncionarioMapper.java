package br.com.basis.kassioschaider.desafioangularspring.servico.mapper;

import br.com.basis.kassioschaider.desafioangularspring.dominio.Funcionario;
import br.com.basis.kassioschaider.desafioangularspring.servico.dto.FuncionarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface FuncionarioMapper {

    @Mapping(target = "empresa.id", source = "idEmpresa")
    Funcionario toEntity(FuncionarioDTO dto);

    @Mapping(target = "idEmpresa", source = "empresa.id")
    FuncionarioDTO toDto(Funcionario entity);

//    @Mapping(target = "empresa.id", source = "idEmpresa")
    List<Funcionario> toEntity(List<FuncionarioDTO> funcionarioDTOS);

//    @Mapping(target = "idEmpresa", source = "empresa.id")
    List<FuncionarioDTO> toDto(List<Funcionario> funcionarios);
}
