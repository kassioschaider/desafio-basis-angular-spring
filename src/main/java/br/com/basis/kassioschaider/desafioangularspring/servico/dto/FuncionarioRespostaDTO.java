package br.com.basis.kassioschaider.desafioangularspring.servico.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioRespostaDTO {
    private Long id;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private Long idEmpresa;
}
