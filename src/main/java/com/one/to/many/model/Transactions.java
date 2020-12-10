package com.one.to.many.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "tbl_transactions")
@JsonIgnoreProperties(value = {"users"})
public class Transactions extends AuditModel {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long txn_id;
  
  @Column(name = "txn_amount", nullable = false)
  private double txnAmount;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private Users users;
  
  public Transactions() {
  }
  
  public long getTxn_id() {
	return txn_id;
  }
  
  public void setTxn_id(long txn_id) {
	this.txn_id = txn_id;
  }
  
  public double getTxnAmount() {
	return txnAmount;
  }
  
  public void setTxnAmount(double txnAmount) {
	this.txnAmount = txnAmount;
  }
  
  public Users getUsers() {
	return users;
  }
  
  public void setUsers(Users users) {
	this.users = users;
  }
}
