package br.com.basis.kassioschaider.desafioangularspring.servico.dto;

import br.com.basis.kassioschaider.desafioangularspring.dominio.Empresa;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class EmpresaDTO {

    private Long id;
    private String nome;

    public EmpresaDTO(Empresa empresa) {
        this.id = empresa.getId();
        this.nome = empresa.getNome();
    }

    public static List<EmpresaDTO> paraDto(List<Empresa> empresas) {
        return empresas.stream().map(EmpresaDTO::new).collect(Collectors.toList());
    }
}
