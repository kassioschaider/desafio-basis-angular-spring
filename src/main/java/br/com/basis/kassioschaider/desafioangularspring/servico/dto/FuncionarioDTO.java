package br.com.basis.kassioschaider.desafioangularspring.servico.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotNull
    @NotEmpty
    @Length(min = 3, max = 50)
    private String nome;

    @NotNull
    @NotEmpty
    private String dataNascimento;

    @NotNull
    @NotEmpty
    @CPF
    private String cpf;

    @NotNull
    private Long idEmpresa;
}
