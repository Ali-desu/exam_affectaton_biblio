package com.sa.exam_biblio.dao.impl;

import com.sa.exam_biblio.dao.BookDAO;
import com.sa.exam_biblio.model.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class BookDAOImpl implements BookDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
    private EntityManager em = emf.createEntityManager();

    @Override
    public void addBook(Book book) {
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
    }

    @Override
    public List<Book> getAllBooks() {
        return em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
    }

    @Override
    public Book getBookById(Long bookId) {
        return em.find(Book.class, bookId);
    }
}
