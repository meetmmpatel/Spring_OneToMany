package com.one.to.many.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tbl_users")
public class Users extends AuditModel {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;
    
    @Column(name = "user_name", nullable = false, length = 255)
    private String name;
    
    @Column(name = "user_address", nullable = false, length = 255)
    private String address;
    
    @Column(name = "user_email", nullable = false, length = 100)
    private String email;
    
    @OneToMany(cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "user_id")
    private Set<Transactions> transactionsSet;
    
    public Users() {
    }
    
    public long getUserId() {
        return userId;
    }
    
    public void setUserId(long userId) {
        this.userId = userId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public Set<Transactions> getTransactionsSet() {
        return transactionsSet;
    }
    
    public void setTransactionsSet(Set<Transactions> transactionsSet) {
        this.transactionsSet = transactionsSet;
    }
}
