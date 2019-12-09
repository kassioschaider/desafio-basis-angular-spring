package br.com.basis.kassioschaider.desafioangularspring.configuracao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErroValidacaoHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ErroFormularioDTO> handle(MethodArgumentNotValidException exception) {
        List<ErroFormularioDTO> dtoList = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e -> {
            String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ErroFormularioDTO erro = new ErroFormularioDTO(fieldToTitle(e.getField()), mensagem);
            dtoList.add(erro);
        });

        return dtoList;
    }

    private String fieldToTitle(String field) {
        switch (field) {
            case "nome":
                return "Nome";
            case "dataNascimento":
                return "Data de Nascimento";
            case "cpf":
                return "CPF";
            case "idEmpresa":
                return "Empresa";
            case "endereco":
                return "Endereço";
            case "cnpj":
                return "CNPJ";
            default:
                return field;
        }
    }
}
