package com.sa.exam_biblio.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String mail;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Borrow> borrows = new HashSet<>();

    public User() {}

    public User(String name, String mail) {
        this.name = name;
        this.mail = mail;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getMail() { return mail; }
    public void setMail(String mail) { this.mail = mail; }
    public Set<Borrow> getBorrows() { return borrows; }
}
