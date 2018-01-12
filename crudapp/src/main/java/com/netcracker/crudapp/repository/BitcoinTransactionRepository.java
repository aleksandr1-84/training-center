package com.netcracker.crudapp.repository;

import com.netcracker.crudapp.model.BitcoinTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BitcoinTransactionRepository extends CrudRepository<BitcoinTransaction, Long>{
}
