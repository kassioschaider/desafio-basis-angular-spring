package br.com.basis.kassioschaider.desafioangularspring.servico.dto;

import br.com.basis.kassioschaider.desafioangularspring.dominio.Funcionario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDTO {

    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private Long idEmpresa;
}
