package br.com.basis.kassioschaider.desafioangularspring.web.rest;

import br.com.basis.kassioschaider.desafioangularspring.servico.FuncionarioServico;
import br.com.basis.kassioschaider.desafioangularspring.servico.dto.FuncionarioDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
public class FuncionarioRecurso {

    @Autowired
    private FuncionarioServico funcionarioServico;

    @GetMapping("/funcionarios")
    public List<FuncionarioDTO> obterTodos() {
        return funcionarioServico.obterTodos();
    }

    @PostMapping("/funcionarios")
    public ResponseEntity<FuncionarioDTO> cadastrar(@RequestBody @Valid FuncionarioDTO funcionarioDTO, UriComponentsBuilder uriBuilder) {
        FuncionarioDTO result = funcionarioServico.cadastrar(funcionarioDTO);
        return ResponseEntity.created(uriBuilder.path("/funcionarios/{id}")
                .buildAndExpand(result.getId()).toUri())
                .body(result);
    }

    @PutMapping("/funcionarios/{id}")
    public ResponseEntity<FuncionarioDTO> atualizar(@RequestBody @Valid FuncionarioDTO funcionarioDTO, UriComponentsBuilder uriBuilder) {
        FuncionarioDTO result = funcionarioServico.atualizar(funcionarioDTO);
        return ResponseEntity.created(uriBuilder.path("funcionarios/{id}")
                .buildAndExpand(result.getId()).toUri())
                .body(result);
    }

    @GetMapping("/funcionarios/{id}")
    public ResponseEntity<FuncionarioDTO> obterPorId(@PathVariable Long id, UriComponentsBuilder uriBuilder) {
        FuncionarioDTO result = funcionarioServico.obterPorId(id);
        return ResponseEntity.created(uriBuilder.path("funcionarios/{id}")
                .buildAndExpand(result.getId()).toUri())
                .body(result);
    }

    @DeleteMapping("/funcionarios/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id, UriComponentsBuilder uriBuilder) {
//        funcionarioServico.excluirPorId(id);
//        return ResponseEntity.created(uriBuilder.path("funcionarios/{id}")
//                .buildAndExpand(id)
//                .body(result);
        return null;
    }
}