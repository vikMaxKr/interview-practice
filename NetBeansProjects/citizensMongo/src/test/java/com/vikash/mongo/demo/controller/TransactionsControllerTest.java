package com.vikash.mongo.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vikash.mongo.controller.MongoTransactionController;
import com.vikash.mongo.model.Transactions;
import com.vikash.mongo.model.TransactionsRequest;
import com.vikash.mongo.model.TransactionsResponse;
import com.vikash.mongo.service.TransactionsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.vikash.mongo.demo.util.TestUtil.readFile;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MongoTransactionController.class)
public class TransactionsControllerTest {

    @Autowired MockMvc mockMvc;

    @MockBean TransactionsService transactionsService;

    @Test
    @DisplayName("Returns transactions based on request filters")
    void givenRequestFilters_whenGetTransactions_thenReturnTransactions() throws Exception {

        //given
        var transactionRequest= TransactionsRequest.builder()
                .accountNumber("112")
                .accountType("CHK")
                .sourceSystem("xyz")
                .build();
        var transactions=Transactions.builder()
                .postedDate("2024-12-04")
                .sequenceNo("123456")
                .build();
        var transactionResponse=TransactionsResponse.builder()
                .accountNumber("12345")
                .success(true)
                .build();
        var expectedResponse=readFile("src/test/resources/response/api/success.json");

        //when
        var actualResponse=mockMvc.perform(MockMvcRequestBuilders.post("v1/deposit-account/")
                .contentType(MediaType.APPLICATION_JSON)
                .header("channelId", "OLB")
                .header("requestId", "12dfdddddddrdrdxcfhf")
                .content(asJsonString(transactionRequest)))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        //then

        assertEquals(expectedResponse, actualResponse, JSONCompareMode.STRICT);

    }

    @Test
    @DisplayName("Returns 400 when required fields are missing")
    void givenRequestFilters_whenGetTransactions_thenReturn400() throws Exception {

        //given
        var transactionRequest= TransactionsRequest.builder()
                .accountNumber("")
                .accountType("CHK")
                .sourceSystem("xyz")
                .build();

        var expectedResponse=readFile("src/test/resources/response/api/mandatory-fields-missings.json");

        //when
        var actualResponse=mockMvc.perform(MockMvcRequestBuilders.post("v1/deposit-account/transactions/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("channelId", "OLB")
                        .header("requestId", "12dfdddddddrdrdxcfhf")
                        .content(asJsonString(transactionRequest)))
                .andExpect(status().is(400))
                .andReturn().getResponse().getContentAsString();

        //then
        assertEquals(expectedResponse, actualResponse, JSONCompareMode.LENIENT );

    }


    private static String asJsonString(TransactionsRequest transactionRequest) {
        try{
            return new ObjectMapper().writeValueAsString(transactionRequest);
        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
