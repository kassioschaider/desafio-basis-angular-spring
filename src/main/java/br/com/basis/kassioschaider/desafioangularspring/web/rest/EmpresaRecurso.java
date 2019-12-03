package br.com.basis.kassioschaider.desafioangularspring.web.rest;

import br.com.basis.kassioschaider.desafioangularspring.servico.EmpresaServico;
import br.com.basis.kassioschaider.desafioangularspring.servico.dto.EmpresaDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
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
    public ResponseEntity<EmpresaDTO> cadastrar(@RequestBody @Valid EmpresaDTO empresaDTO, UriComponentsBuilder uriBuilder) {
        EmpresaDTO result = empresaServico.cadastrar(empresaDTO);
        return ResponseEntity.created(uriBuilder.path("/empresas/{id}")
            .buildAndExpand(result.getId()).toUri())
            .body(result);
    }

    @PutMapping("/empresas/{id}")
    public ResponseEntity<EmpresaDTO> atualizar(@RequestBody @Valid EmpresaDTO empresaDTO, UriComponentsBuilder uriBuilder) {
        EmpresaDTO result = empresaServico.atualizar(empresaDTO);
        return ResponseEntity.created(uriBuilder.path("empresas/{id}")
            .buildAndExpand(result.getId()).toUri())
            .body(result);
    }

    @GetMapping("/empresas/{id}")
    public ResponseEntity<EmpresaDTO> obterPorId(@PathVariable Long id, UriComponentsBuilder uriBuilder) {
        EmpresaDTO result = empresaServico.obterPorId(id);
        return ResponseEntity.created(uriBuilder.path("empresas/{id}")
                .buildAndExpand(result.getId()).toUri())
                .body(result);
    }
}