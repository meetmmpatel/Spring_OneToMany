package com.one.to.many.controller;

import com.one.to.many.exceptions.TxnNotFoundException;
import com.one.to.many.exceptions.UserNotfoundExceptions;
import com.one.to.many.model.Transactions;
import com.one.to.many.repository.TransactionRepository;
import com.one.to.many.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.TransactionalException;

@RestController
public class TxnController {
  
  @Autowired
  private TransactionRepository transactionRepository;
  
  @Autowired
  private UserRepository userRepository;
  
  @GetMapping("/txn")
  public ResponseEntity<Page<Transactions>> getAllTxns(Pageable pageable) {
	return ResponseEntity.ok(transactionRepository.findAll(pageable));
  }
  
  @PostMapping("users/{id}/txn")
  public Transactions postTxns(@PathVariable(value = "id") long id,
							   @RequestBody Transactions transactions) {
	
	return userRepository.findById(id).map(user -> {
	  transactions.setUsers(user);
	  return transactionRepository.save(transactions);
	}).orElseThrow(() -> new TxnNotFoundException("Transaction can be posted for given user"));
	
  }
  
  
  
  
}
