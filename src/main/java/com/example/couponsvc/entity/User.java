package com.example.couponsvc.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLE",joinColumns = @JoinColumn(name ="USER_ID"),inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private Set<Role> roles;
}
