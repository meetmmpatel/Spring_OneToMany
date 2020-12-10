package com.one.to.many.repository;

import com.one.to.many.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionRepository extends JpaRepository<Transactions, Long> {

  
}
