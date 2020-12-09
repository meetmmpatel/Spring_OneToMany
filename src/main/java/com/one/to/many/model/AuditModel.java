package com.one.to.many.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass  //mark this class as perent or super class
@EntityListeners(AuditingEntityListener.class) //reading HTTP method
@JsonIgnoreProperties(
		value = {"createdAt", "updatedAt"},
		allowGetters = true
) //auto insert create and update date in to database..
public abstract class AuditModel implements Serializable {
  
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_at", nullable = false, updatable = false)
  @CreatedDate //POST. new data entry
  private Date createdAt; //for new customer we will insert date of insert
  
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "updated_at", nullable = false, updatable = true)
  @LastModifiedDate //PUT
  private Date updatedAt; //if change any existing customer data..(PUT)
  
  public Date getCreatedAt() {
	return createdAt;
  }
  
  public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
  }
  
  public Date getUpdatedAt() {
	return updatedAt;
  }
  
  public void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
  }
}