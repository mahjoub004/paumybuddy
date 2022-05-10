package com.PayMyBuddyV1.model;

import lombok.Data;


import javax.persistence.*;
@Data

@Entity
public class Account {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer accountId;
        private Double amount;
        private String iban;

        public void setAmount(Double amount) {
                this.amount = amount;
        }
}
