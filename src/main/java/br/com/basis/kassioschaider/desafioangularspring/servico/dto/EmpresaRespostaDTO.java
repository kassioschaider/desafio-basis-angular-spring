package br.com.basis.kassioschaider.desafioangularspring.servico.dto;

import br.com.basis.kassioschaider.desafioangularspring.dominio.Empresa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaRespostaDTO {

    private Long id;
    private String nome;
    private String endereco;
    private String cnpj;
}
