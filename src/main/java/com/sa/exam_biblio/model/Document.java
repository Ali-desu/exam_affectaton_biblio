package com.sa.exam_biblio.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private LocalDate dateCreat;

    @OneToMany(mappedBy = "document", cascade = CascadeType.ALL)
    private Set<Borrow> borrows = new HashSet<>();

    public Document() {}

    public Document(String title, LocalDate dateCreat) {
        this.title = title;
        this.dateCreat = dateCreat;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public LocalDate getDateCreat() { return dateCreat; }
    public void setDateCreat(LocalDate dateCreat) { this.dateCreat = dateCreat; }
    public Set<Borrow> getBorrows() { return borrows; }
}
