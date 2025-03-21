package com.sa.exam_biblio.dao.impl;

import com.sa.exam_biblio.dao.DocumentDAO;
import com.sa.exam_biblio.model.Borrow;
import com.sa.exam_biblio.model.Document;
import com.sa.exam_biblio.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class DocumentDAOImpl implements DocumentDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
    private EntityManager em = emf.createEntityManager();

    @Override
    public List<Document> getAllDocuments() {
        return em.createQuery("SELECT d FROM Document d", Document.class).getResultList();
    }

    @Override
    public List<Document> getCurrentLoans() {
        return em.createQuery("SELECT b.document FROM Borrow b WHERE b.returnDate IS NULL", Document.class).getResultList();
    }

    @Override
    public void borrowDocument(Long userId, Long documentId) {
        em.getTransaction().begin();

        User user = em.find(User.class, userId);
        Document document = em.find(Document.class, documentId);

        if (user == null || document == null) {
            em.getTransaction().rollback();
            throw new IllegalArgumentException("Utilisateur ou document introuvable");
        }

        Borrow borrow = new Borrow(user, document, LocalDate.now());
        em.persist(borrow);

        em.getTransaction().commit();
    }

    @Override
    public void returnDocument(Long userId, Long documentId) {
        em.getTransaction().begin();

        Borrow borrow = em.createQuery(
                        "SELECT b FROM Borrow b WHERE b.user.id = :userId AND b.document.id = :docId AND b.returnDate IS NULL",
                        Borrow.class)
                .setParameter("userId", userId)
                .setParameter("docId", documentId)
                .getSingleResult();

        if (borrow != null) {
            borrow.setReturnDate(LocalDate.now());
            em.merge(borrow);
        }

        em.getTransaction().commit();
    }

    @Override
    public void addDocument(Document document) {
        em.getTransaction().begin();
        em.persist(document);
        em.getTransaction().commit();
    }
}
