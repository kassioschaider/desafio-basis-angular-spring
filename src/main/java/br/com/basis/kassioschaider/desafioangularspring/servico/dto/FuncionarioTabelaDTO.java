package br.com.basis.kassioschaider.desafioangularspring.servico.dto;

import java.io.Serializable;

public class FuncionarioTabelaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    private String dataNascimento;

    private String cpf;

    private Long idEmpresa;
}
