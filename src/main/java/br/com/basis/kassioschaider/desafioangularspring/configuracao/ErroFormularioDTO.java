package br.com.basis.kassioschaider.desafioangularspring.configuracao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ErroFormularioDTO {

    private String campo;
    private String erro;
}
