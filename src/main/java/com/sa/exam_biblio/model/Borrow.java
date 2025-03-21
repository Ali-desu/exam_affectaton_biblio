package com.sa.exam_biblio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "borrow")
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "document_id", nullable = false)
    @JsonIgnore
    private Document document;

    private LocalDate dateBorrow;
    private LocalDate returnDate;

    public Borrow() {}

    public Borrow(User user, Document document, LocalDate dateBorrow) {
        this.user = user;
        this.document = document;
        this.dateBorrow = dateBorrow;
        this.returnDate = null; // Pas encore retourné
    }

    public Long getId() { return id; }
    public User getUser() { return user; }
    public Document getDocument() { return document; }
    public LocalDate getDateBorrow() { return dateBorrow; }
    public void setDateBorrow(LocalDate dateBorrow) { this.dateBorrow = dateBorrow; }
    public LocalDate getReturnDate() { return returnDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }
}
