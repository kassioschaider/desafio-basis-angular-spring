package br.com.basis.kassioschaider.desafioangularspring.web.rest;

import br.com.basis.kassioschaider.desafioangularspring.dominio.Empresa;
import br.com.basis.kassioschaider.desafioangularspring.repositorio.EmpresaRepositorio;
import br.com.basis.kassioschaider.desafioangularspring.servico.EmpresaServico;
import br.com.basis.kassioschaider.desafioangularspring.servico.dto.EmpresaDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class EmpresaRecurso {

    @Autowired
    private EmpresaServico empresaServico;

    @GetMapping("/empresas")
    public List<EmpresaDTO> obterTodos() {
        return empresaServico.obterTodos();
    }

    @PostMapping("/empresas")
    public ResponseEntity<Empresa> cadastrar(@RequestBody Empresa empresa) {
//        Empresa empresaResult = empresaServico.save(empresa);
//        return new ResponseEntity<Empresa>(empresaResult, HttpStatus.OK);
        return null;
    }
}
