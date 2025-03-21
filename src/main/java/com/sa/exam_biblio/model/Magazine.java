package com.sa.exam_biblio.model;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Magazine extends Document {
    private String publisher;
    private String issueNumber;
    private LocalDate dateIssue;

    public Magazine() {}

    public Magazine(String title, LocalDate dateCreat, String publisher, String issueNumber, LocalDate dateIssue) {
        super(title, dateCreat);
        this.publisher = publisher;
        this.issueNumber = issueNumber;
        this.dateIssue = dateIssue;
    }

    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }
    public String getIssueNumber() { return issueNumber; }
    public void setIssueNumber(String issueNumber) { this.issueNumber = issueNumber; }
    public LocalDate getDateIssue() { return dateIssue; }
    public void setDateIssue(LocalDate dateIssue) { this.dateIssue = dateIssue; }
}
