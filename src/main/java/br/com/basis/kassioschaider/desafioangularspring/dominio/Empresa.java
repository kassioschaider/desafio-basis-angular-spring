package br.com.basis.kassioschaider.desafioangularspring.dominio;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Empresa {

    private Long id;
    private String nome;
    private String endereco;
    private String cnpj;
    private List<Funcionario> funcionarios = new ArrayList<>();
}
