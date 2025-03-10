package com.vikash.mongo.controllerAdvice;

import com.vikash.mongo.exception.TransactionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({WebExchangeBindException.class})
    public ResponseEntity<Error> handleBindException(WebExchangeBindException ex) {
        List<FieldError> fieldErrorList= ex.getBindingResult().getFieldErrors();
        List<ErrorDetails> errorDetails=new ArrayList<>();
        fieldErrorList.forEach(fieldError -> {
            var errorDetail = ErrorDetails.builder()
                    .code("0009")
                    .description(HttpStatus.BAD_REQUEST.name())
                    .messageDetails(fieldError.getDefaultMessage())
                    .build();
            errorDetails.add(errorDetail);
        });
        var error = Error.builder()
                .result("FATAL")
                .source("odc-transactions-transactions")
                .errorDetails(errorDetails)
                .build();

        log.error("input validation error details "+error.toString());

        return ResponseEntity.badRequest().body(error);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ExceptionHandler({TransactionException.class})
    public ResponseEntity<Error> handleTransactionException(TransactionException ex) {

        //TODO:

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
