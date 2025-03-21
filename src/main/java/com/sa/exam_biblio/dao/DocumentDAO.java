package com.sa.exam_biblio.dao;

import com.sa.exam_biblio.model.Document;

import java.util.List;

public interface DocumentDAO {
    List<Document> getAllDocuments();
    List<Document> getCurrentLoans();
    void borrowDocument(Long userId, Long documentId);
    void returnDocument(Long userId, Long documentId);
    void addDocument(Document document);
}
