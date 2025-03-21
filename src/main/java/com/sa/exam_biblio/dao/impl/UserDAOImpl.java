package com.sa.exam_biblio.dao.impl;

import com.sa.exam_biblio.dao.UserDAO;
import com.sa.exam_biblio.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
    private EntityManager em = emf.createEntityManager();

    @Override
    public void addUser(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    @Override
    public User getUserById(Long userId) {
        return em.find(User.class, userId);
    }

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public List<User> getUsersWithLoans() {
        return em.createQuery("SELECT DISTINCT b.user FROM Borrow b WHERE b.returnDate IS NULL", User.class).getResultList();
    }
}
