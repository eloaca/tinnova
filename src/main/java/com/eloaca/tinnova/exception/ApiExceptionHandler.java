package com.eloaca.tinnova.exception;

import com.eloaca.tinnova.controller.rs.erro.Erro;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request){
        var campos = new ArrayList<Erro.Campo>();
        exception.getBindingResult()
                .getAllErrors()
                .stream()
                .map(error ->
                        new Erro.Campo(((FieldError) error).getField(),
                                messageSource.getMessage(error, LocaleContextHolder.getLocale()))).forEach(campos::add);

        var problema = new Erro
                ("Ha campos invalidos. Verifique e tente novamente", LocalDateTime.now(), status.value(), campos);

        return handleExceptionInternal(exception, problema, headers, status, request);
    }

    @ExceptionHandler(VeiculoException.class)
    public ResponseEntity<Object> handleNegocio(VeiculoException exception,
                                                WebRequest request){

        var status = HttpStatus.BAD_REQUEST;
        var erro = new Erro(exception.getMessage(), LocalDateTime.now(), status.value());

        return handleExceptionInternal(exception, erro, new HttpHeaders(), status, request);
    }
}