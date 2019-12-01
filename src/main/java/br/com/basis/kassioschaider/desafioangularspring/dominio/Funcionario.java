package br.com.basis.kassioschaider.desafioangularspring.dominio;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Funcionario {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dataNasciemnto;
    private String cpf;
    @ManyToOne
    private Empresa empresa;
}
