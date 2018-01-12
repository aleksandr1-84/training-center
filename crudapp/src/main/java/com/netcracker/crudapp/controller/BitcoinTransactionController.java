package com.netcracker.crudapp.controller;

import com.netcracker.crudapp.model.BitcoinTransaction;
import com.netcracker.crudapp.service.BitcoinTransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BitcoinTransactionController {
    private final BitcoinTransactionService service;

    public BitcoinTransactionController(BitcoinTransactionService service){
        this.service=service;
    }

    @GetMapping("/getAll")
    public @ResponseBody
    Iterable<BitcoinTransaction> getAll() {
        return service.getAll();
    }

    @GetMapping("/get/{id}")
    public @ResponseBody
    ResponseEntity<?> get(@PathVariable Long id){
        try {
            BitcoinTransaction transaction = service.get(id);
            return new ResponseEntity<>(transaction, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    @PostMapping("/add")
    public ResponseEntity<?> post(@RequestBody BitcoinTransaction transaction) {
        try {
            transaction = service.add(transaction);
            return new ResponseEntity<>(transaction, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Object>(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Object>(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    @PostMapping("/edit/sender/{id}/{sender}")
    public ResponseEntity<?> editSender(@PathVariable Long id, @PathVariable String sender) {
        try {
            BitcoinTransaction transaction = service.get(id);
            transaction.setSender(sender);
            transaction = service.edit(transaction);
            return new ResponseEntity<>(transaction, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Object>(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    @PostMapping("/edit/recipient/{id}/{recipient}")
    public ResponseEntity<?> editRecipient(@PathVariable Long id, @PathVariable String recipient) {
        try {
            BitcoinTransaction transaction = service.get(id);
            transaction.setRecipient(recipient);
            transaction = service.edit(transaction);
            return new ResponseEntity<>(transaction, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Object>(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST
            );
        }
    }

    @PostMapping("/edit/amount/{id}/{amount:\\d+(?:\\.\\d+)?}")
    public ResponseEntity<?> editAmount(@PathVariable Long id, @PathVariable Float amount) {
        try {
            BitcoinTransaction transaction = service.get(id);
            transaction.setAmount(amount);
            transaction = service.edit(transaction);
            return new ResponseEntity<>(transaction, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Object>(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST
            );
        }
    }
}
