package br.com.basis.kassioschaider.desafioangularspring.servico.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty(message = "Não pode estar vazio!")
    @Length(min = 3, max = 50, message = "Deve estar entre 3 e 50 letras!")
    private String nome;

    @NotEmpty(message = "Não pode estar vazio!")
    @Length(min = 3, max = 100, message = "Deve estar entre 3 e 100 letras!")
    private String endereco;

    @NotEmpty(message = "Não pode estar vazio!")
    @CNPJ(message = "Foi inserido um inválido!")
    private String cnpj;

    private List<FuncionarioDTO> funcionarios;
}
