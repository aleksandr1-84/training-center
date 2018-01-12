package com.netcracker.crudapp.service;

import com.netcracker.crudapp.model.BitcoinTransaction;
import com.netcracker.crudapp.repository.BitcoinTransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class BitcoinTransactionService {
    public final BitcoinTransactionRepository repository;

    public BitcoinTransactionService(BitcoinTransactionRepository repository){
        this.repository=repository;
    }

    public BitcoinTransaction add(BitcoinTransaction transaction){
        return repository.save(transaction);
    }

    public BitcoinTransaction get(long id){
        return repository.findOne(id);
    }

    public Iterable<BitcoinTransaction> getAll() {
        return repository.findAll();
    }

    public void delete(long id){
        repository.delete(id);
    }

    public void delete(BitcoinTransaction transaction){
        repository.delete(transaction);
    }

    public BitcoinTransaction edit(BitcoinTransaction transaction){
        BitcoinTransaction old = repository.findOne(transaction.getId());
        if(old != null){
            return repository.save(transaction);
        }
        else{
            return null;
        }
    }
}
