package com.vikash.mongo.repository;

import com.vikash.mongo.apo.CaptureResponseTime;
import com.vikash.mongo.model.Transactions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionsRepository {

    @CaptureResponseTime(name="Transaction Collection Repo", addHeader = false)
    public List<Transactions> getTransactions(String collectionName) {
   return null;
    }
}
