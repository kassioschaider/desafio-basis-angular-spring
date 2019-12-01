package br.com.basis.kassioschaider.desafioangularspring.servico.dto;

import br.com.basis.kassioschaider.desafioangularspring.dominio.Funcionario;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class FuncionarioDTO {

    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private Long idEmpresa;

    public FuncionarioDTO(Funcionario funcionario) {
        this.id = funcionario.getId();
        this.nome = funcionario.getNome();
        this.dataNascimento = funcionario.getDataNascimento();
        this.cpf = funcionario.getCpf();
        this.idEmpresa = funcionario.getEmpresa().getId();
    }

    public static List<FuncionarioDTO> paraDto(List<Funcionario> funcionarios) {
        return funcionarios.stream().map(FuncionarioDTO::new).collect(Collectors.toList());
    }
}
