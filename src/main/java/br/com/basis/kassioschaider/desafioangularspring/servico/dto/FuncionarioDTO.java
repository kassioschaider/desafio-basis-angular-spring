package br.com.basis.kassioschaider.desafioangularspring.servico.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty(message = "Não pode estar vazio!")
    @Length(min = 3, max = 50, message = "O nome deve estar entre 3 e 50 letras!")
    @Pattern(regexp = "^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]*$", message = "Apenas letras compõe um Nome!")
    private String nome;

    @NotNull(message = "Não pode estar vazio!")
    private LocalDate dataNascimento;

    @NotEmpty(message = "Não pode estar vazio!")
    @CPF(message = "Foi inserido um inválido!")
    private String cpf;

    @NotNull(message = "Precisa inserir uma Empresa para o Funcionário!")
    private Long idEmpresa;
}
