package com.example.bank.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer from_account_id;
    private Integer to_account_id;
    private String type;
    private Double amount;
    private String description;

    @CreationTimestamp
    private LocalDateTime created_at;

    public Transactions(Integer from_account_id, Integer to_account_id, String type, Double amount, String description) {
        this.from_account_id = from_account_id;
        this.to_account_id = to_account_id;
        this.type = type;
        this.amount = amount;
        this.description = description;
    }

    public Transactions() {

    }
}
