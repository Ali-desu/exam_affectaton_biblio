package com.sa.exam_biblio.dao.impl;

import com.sa.exam_biblio.dao.MagazineDAO;
import com.sa.exam_biblio.model.Magazine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class MagazineDAOImpl implements MagazineDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
    private EntityManager em = emf.createEntityManager();

    @Override
    public void addMagazine(Magazine magazine) {
        em.getTransaction().begin();
        em.persist(magazine);
        em.getTransaction().commit();
    }

    @Override
    public List<Magazine> getAllMagazines() {
        return em.createQuery("SELECT m FROM Magazine m", Magazine.class).getResultList();
    }

    @Override
    public Magazine getMagazineById(Long magazineId) {
        return em.find(Magazine.class, magazineId);
    }
}
