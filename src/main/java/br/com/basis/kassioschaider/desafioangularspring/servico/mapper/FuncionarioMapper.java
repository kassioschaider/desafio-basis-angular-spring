package br.com.basis.kassioschaider.desafioangularspring.servico.mapper;

import br.com.basis.kassioschaider.desafioangularspring.dominio.Funcionario;
import br.com.basis.kassioschaider.desafioangularspring.servico.dto.FuncionarioDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {})
public interface FuncionarioMapper {

    Funcionario toEntity(FuncionarioDTO dto);

    FuncionarioDTO toDto(Funcionario entity);
}
