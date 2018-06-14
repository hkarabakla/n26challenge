package com.huseyinkarabakla.n26.service;

import com.huseyinkarabakla.n26.constants.SystemConstants;
import com.huseyinkarabakla.n26.mocks.TransactionMocks;
import com.huseyinkarabakla.n26.model.Transaction;
import com.huseyinkarabakla.n26.storage.Storage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
public class TransactionServiceTests
{

    @MockBean
    private Storage storageMock;

    private TransactionService underTest;

    @Before
    public void setUp() {
        underTest = new TransactionService(storageMock);
    }

    @Test
    public void saveTransaction() {
        // GIVEN
        Transaction transactionMock = TransactionMocks.getTransactionMock();
        doNothing().when(storageMock).saveTransaction(transactionMock);

        // WHEN
        boolean result = underTest.saveTransaction(transactionMock);

        // THEN
        verify(storageMock).saveTransaction(transactionMock);
        assertTrue(result);
    }

    @Test
    public void saveTransactionInCaseOfInvalidTimestamp() {
        // GIVEN
        Transaction transactionMock = TransactionMocks.getTransactionMock();
        transactionMock.setTimestamp(transactionMock.getTimestamp() + SystemConstants.MINUTE_IN_MILISECONDS);

        // WHEN
        boolean result = underTest.saveTransaction(transactionMock);

        // THEN
        assertTrue(!result);
    }
}
