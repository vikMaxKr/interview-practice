package com.vikash.mongo.exception;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.io.Serial;

@Getter
@Setter
public class TransactionException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 2345699876533333L;

    final String accountNumber;

    public TransactionException(@NonNull final String errorMessage, final String accountNumber ) {
        super(errorMessage);
        this.accountNumber = accountNumber;
    }


}
