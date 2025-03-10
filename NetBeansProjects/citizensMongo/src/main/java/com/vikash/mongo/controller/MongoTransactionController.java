package com.vikash.mongo.controller;

import com.vikash.mongo.apo.CaptureResponseTime;
import com.vikash.mongo.model.TransactionsRequest;
import com.vikash.mongo.model.TransactionsRequestParams;
import com.vikash.mongo.model.TransactionsResponse;
import com.vikash.mongo.service.TransactionsService;
import com.vikash.mongo.validation.RequestValidator;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Pattern;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

import static com.vikash.mongo.util.Utility.generateTrackingId;

@Slf4j
@Validated
@RestController
@RequestMapping("v1/deposit-account")
public class MongoTransactionController {

    private final RequestValidator requestValidator;
    private final TransactionsService transactionsService;

    public MongoTransactionController(RequestValidator requestValidator, TransactionsService transactionsService) {
        this.requestValidator = requestValidator;
        this.transactionsService = transactionsService;
    }


    @CaptureResponseTime(name = "Mongo-Transaction API", addHeader = false)
    @PostMapping("/transactions/query")
    public ResponseEntity<TransactionsResponse> fetchMongoTransactions(
        @RequestHeader(name="requestId") @Pattern(regexp = "^[a-zA-Z0-9]{1,36}$",
        message = "Invalid traceId")String requestId,
        @RequestHeader(name="channelId") @Pattern(regexp = "^[a-zA-Z0-9]{1,36}$",
                message = "Invalid traceId")String channelId,
        @RequestParam(name="limit", required = false,defaultValue = "100")
        @Max(value = 2000,message = "limit should be more than 2000.")Integer limit,
        @RequestParam(name="offset", required = false,defaultValue = "0")
        @Max(value = 2000,message = "offset should be more than 2000.")Integer offset,
        @Valid @RequestBody TransactionsRequest transactionsRequest)
    {
        var trackingId=generateTrackingId(requestId,channelId);
        log.info("trackingId: {}, channelId: {} and timestamp: {} :: Entered MongoTransactionController ", trackingId, channelId, Instant.now());
        var transactionsQuery= TransactionsRequestParams.builder().limit(limit).offset(offset).build();
        requestValidator.validateRequest(transactionsRequest);
        transactionsService.fetchTransactions(transactionsRequest,transactionsQuery,channelId,
                trackingId);
        return null;
    }


}
