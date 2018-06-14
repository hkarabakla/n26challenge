package com.huseyinkarabakla.n26.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huseyinkarabakla.n26.mocks.TransactionMocks;
import com.huseyinkarabakla.n26.model.Transaction;
import com.huseyinkarabakla.n26.service.TransactionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TransactionController.class)
public class TransactionControllerTests
{
    private final String rootMapping = "/transactions";

    @MockBean
    private TransactionService transactionServiceMock;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void saveTransaction() throws Exception
    {
        // GIVEN
        Transaction transactionMock = TransactionMocks.getTransactionMock();
        when(transactionServiceMock.saveTransaction(any(Transaction.class))).thenReturn(true);

        // WHEN
        // THEN
        mockMvc.perform(post(rootMapping).contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(transactionMock)))
            .andDo(print())
            .andExpect(status().isCreated());

        verify(transactionServiceMock).saveTransaction(any(Transaction.class));
    }

    @Test
    public void saveTransactionInCaseOfInvalidTransaction() throws Exception
    {
        // GIVEN
        Transaction transactionMock = TransactionMocks.getTransactionMock();
        when(transactionServiceMock.saveTransaction(any(Transaction.class))).thenReturn(false);

        // WHEN
        // THEN
        mockMvc.perform(post(rootMapping).contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(transactionMock)))
            .andDo(print())
            .andExpect(status().isNotFound());

        verify(transactionServiceMock).saveTransaction(any(Transaction.class));
    }
}
