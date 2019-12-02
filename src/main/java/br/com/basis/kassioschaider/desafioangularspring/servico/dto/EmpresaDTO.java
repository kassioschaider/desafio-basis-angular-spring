package br.com.basis.kassioschaider.desafioangularspring.servico.dto;

import br.com.basis.kassioschaider.desafioangularspring.dominio.Empresa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@NoArgsConstructor
public class EmpresaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String endereco;
    private String cnpj;
}
