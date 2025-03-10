package com.vikash.mongo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionsRequest {

    @NotEmpty(message = "accountNumber is required")
    String accountNumber;
    @NotEmpty(message = "accountType is required")
    String accountType;
    String sourceSystem;

}
