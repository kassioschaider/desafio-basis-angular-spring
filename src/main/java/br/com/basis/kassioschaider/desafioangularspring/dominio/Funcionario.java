package br.com.basis.kassioschaider.desafioangularspring.dominio;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class Funcionario {

    private Long id;
    private String nome;
    private LocalDate dataNasciemnto;
    private String cpf;
}
