package org.example.exam24_25.Model.DAO;

import org.example.exam24_25.Model.Borrow;
import org.example.exam24_25.Model.User;
import org.example.exam24_25.Model.Document;


import jakarta.persistence.*;

import java.util.*;

public class BorrowDaoImpl implements BorrowDao {
    private EntityManagerFactory emf;
    private EntityManager em;

    public BorrowDaoImpl() {
        emf = Persistence.createEntityManagerFactory("exam24_25");
        em = emf.createEntityManager();
    }

    public List<Borrow> listCurrentBorrows() {
        return em.createQuery("SELECT b FROM Borrow b WHERE b.returnDate IS NULL", Borrow.class).getResultList();
    }

    public void borrowDocument(User user, Document document) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Borrow borrow = new Borrow();
        borrow.setUser(user);
        borrow.setDocument(document);
        borrow.setDateBorrow(new Date());
        em.persist(borrow);
        transaction.commit();
    }

    public void returnDocument(Long borrowId) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Borrow borrow = em.find(Borrow.class, borrowId);
        if (borrow != null) {
            borrow.setReturnDate(new Date());
            em.merge(borrow);
        }
        transaction.commit();
    }
}
