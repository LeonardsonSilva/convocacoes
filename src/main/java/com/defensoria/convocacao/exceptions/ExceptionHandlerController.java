package com.defensoria.convocacao.exceptions;

// import java.util.HashMap;
// import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorMessageDTO> notFoundException(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessageDTO(e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorMessageDTO> methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        // TODO: utilizar variáveis de ambiente para ter respostas genéricas ou mais detalhadas.
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorMessageDTO("Formato incompatível. " + e.getMessage()));
    }
}
