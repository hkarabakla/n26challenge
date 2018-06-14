package com.huseyinkarabakla.n26.mocks;

import com.huseyinkarabakla.n26.constants.TestConstants;
import com.huseyinkarabakla.n26.model.Transaction;

import java.util.Date;

public class TransactionMocks
{

    public static Transaction getTransactionMock() {
        return new Transaction(TestConstants.AMOUNT_ONE, new Date().getTime());
    }

    private TransactionMocks()
    {
    }
}
