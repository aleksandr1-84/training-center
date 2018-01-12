package com.netcracker.crudapp;

import com.netcracker.crudapp.model.BitcoinTransaction;
import com.netcracker.crudapp.service.BitcoinTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Filler   implements CommandLineRunner {
    @Autowired
    public BitcoinTransactionService service;

    @Override
    public void run(String... strings) throws Exception {
        BitcoinTransaction transaction = new BitcoinTransaction();
        transaction.setSender("Vladimir");
        transaction.setRecipient("Donald");
        transaction.setAmount(6);
        service.add(transaction);

        transaction = new BitcoinTransaction();
        transaction.setSender("Michael Someone");
        transaction.setRecipient("Daniel Someone");
        transaction.setAmount(1.12f);
        service.add(transaction);

        transaction = new BitcoinTransaction();
        transaction.setSender("Microsoft corp");
        transaction.setRecipient("Apple corp");
        transaction.setAmount(8.5f);
        service.add(transaction);
    }
}
