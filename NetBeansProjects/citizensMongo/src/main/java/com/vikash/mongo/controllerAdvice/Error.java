package com.vikash.mongo.controllerAdvice;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Error {

    private String result;
    private String source;
    private List<ErrorDetails> errorDetails;
}
