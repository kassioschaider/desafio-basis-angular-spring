package br.com.basis.kassioschaider.desafioangularspring.web.rest;

import br.com.basis.kassioschaider.desafioangularspring.dominio.Funcionario;
import br.com.basis.kassioschaider.desafioangularspring.servico.FuncionarioServico;
import br.com.basis.kassioschaider.desafioangularspring.servico.dto.FuncionarioDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class FuncionarioRecurso {

    @Autowired
    private FuncionarioServico funcionarioServico;

    @GetMapping("/funcionarios")
    public List<FuncionarioDTO> obterTodos() {
        return funcionarioServico.obterTodos();
    }
}
