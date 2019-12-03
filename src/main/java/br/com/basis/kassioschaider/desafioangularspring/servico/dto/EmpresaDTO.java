package br.com.basis.kassioschaider.desafioangularspring.servico.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotNull
    @NotEmpty
    @Length(min = 3, max = 50)
    private String nome;

    @NotNull
    @NotEmpty
    @Length(min = 3, max = 100)
    private String endereco;

    @NotNull
    @NotEmpty
    @CNPJ
    private String cnpj;

    private List<FuncionarioDTO> funcionarios;
}
