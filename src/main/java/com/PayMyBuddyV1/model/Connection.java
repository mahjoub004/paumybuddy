package com.PayMyBuddyV1.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Connection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @ManyToOne
    User user1;
    @ManyToOne
    User user2;

}
