package br.com.basis.kassioschaider.desafioangularspring.recurso;

import br.com.basis.kassioschaider.desafioangularspring.dominio.Funcionario;
import br.com.basis.kassioschaider.desafioangularspring.servico.dto.FuncionarioDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FuncionarioRecurso {

    @GetMapping("/funcionarios")
    public List<FuncionarioDTO> obterTodos() {
        return null;
    }
}
