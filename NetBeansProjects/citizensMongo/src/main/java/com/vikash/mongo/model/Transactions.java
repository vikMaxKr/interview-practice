package com.vikash.mongo.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Transactions {

    private String postedDate;
    private String sequenceNo;
}
