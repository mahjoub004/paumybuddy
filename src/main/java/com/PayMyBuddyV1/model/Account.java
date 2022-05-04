package com.PayMyBuddyV1.model;

import lombok.Data;


import javax.persistence.*;
@Data

@Entity
public class Account {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        @SequenceGenerator(name = "USER_SEQ", sequenceName = "USER_SEQ")
        private Integer accountId;
        private Double amount;
        private String iban;
}
