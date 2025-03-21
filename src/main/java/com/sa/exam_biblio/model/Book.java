package com.sa.exam_biblio.model;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Book extends Document {
    private String author;
    private String isbn;
    private LocalDate datePublishion;

    public Book() {}

    public Book(String title, LocalDate dateCreat, String author, String isbn, LocalDate datePublishion) {
        super(title, dateCreat);
        this.author = author;
        this.isbn = isbn;
        this.datePublishion = datePublishion;
    }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public LocalDate getDatePublishion() { return datePublishion; }
    public void setDatePublishion(LocalDate datePublishion) { this.datePublishion = datePublishion; }
}