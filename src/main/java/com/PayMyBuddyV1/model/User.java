package com.PayMyBuddyV1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data

@AllArgsConstructor
@NoArgsConstructor


@Entity
public class User {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column( nullable = false , length = 20)
        private String firstName;

        @Column( nullable = false , length = 20)
        private String lastName;

        @Column(unique = true , nullable = false , length = 45)
        private String email;

        @Column( nullable = false , length = 70)
        private String password;

        @ManyToMany
        @JoinColumn( nullable = false)
        private List<Connection> connections;

        @OneToOne(cascade = {CascadeType.ALL})
        @JoinColumn( nullable = false)
        private Account account;

}