package com.easyschools.restservices.entities;


import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    private  Long id;


    @Column(name = "USER_NAME" , length = 50 , unique=true)
    private String username;

    @Column(name = "FIRST_NAME" , length = 50 , nullable=false)
    private String firstname;

    @Column(name = "LAST_NAME" , length = 50 , nullable=false)
    private String lastname;

    @Column(name = "EMAIL" , length = 150 , nullable=false)
    private String email;

    @Column(name = "ROLE" , length = 50 , nullable=false)
    private String role;

    @Column(name = "SSN" , length = 50 , unique=true)
    private String ssn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
}