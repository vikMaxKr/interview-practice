package com.vikash.mongo.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TransactionsResponse {

    private String accountNumber;
    private boolean success;
}
