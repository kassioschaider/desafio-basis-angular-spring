package br.com.basis.kassioschaider.desafioangularspring.web.rest;

import br.com.basis.kassioschaider.desafioangularspring.servico.EmpresaServico;
import br.com.basis.kassioschaider.desafioangularspring.servico.dto.EmpresaDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class EmpresaRecurso {

    @Autowired
    private final EmpresaServico empresaServico;

    @GetMapping("/empresas")
    public List<EmpresaDTO> obterTodos() {
        return empresaServico.obterTodos();
    }
}
