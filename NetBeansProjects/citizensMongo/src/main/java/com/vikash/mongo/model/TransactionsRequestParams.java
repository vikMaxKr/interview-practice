package com.vikash.mongo.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TransactionsRequestParams {

    Integer limit;
    Integer offset;
}
