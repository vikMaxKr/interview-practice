package com.vikash.mongo.service;

import com.vikash.mongo.model.TransactionsRequest;
import com.vikash.mongo.model.TransactionsRequestParams;
import com.vikash.mongo.model.TransactionsResponse;
import com.vikash.mongo.repository.TransactionsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Slf4j
@Service
public class TransactionsService {

    private final TransactionsRepository transactionsRepository;

    public TransactionsService(TransactionsRepository transactionsRepository) {
        this.transactionsRepository = transactionsRepository;
    }


    public ResponseEntity<TransactionsResponse> fetchTransactions(TransactionsRequest transactionsRequest,
                                                                  TransactionsRequestParams transactionsRequestParams,
                                                                  String channelId, String requestId){

        log.info("trackingId: {}, channelId: {} and timestamp: {} :: Entered MongoTransactionService ", requestId, channelId, Instant.now());
         return  null;

    }
}
