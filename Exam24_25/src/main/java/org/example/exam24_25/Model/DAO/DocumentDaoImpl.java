package org.example.exam24_25.Model.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.exam24_25.Model.Document;

import java.util.List;

public class DocumentDaoImpl implements DocumentDao {
    private EntityManagerFactory emf;
    private EntityManager em;

    public DocumentDaoImpl() {
        emf = Persistence.createEntityManagerFactory("exam24_25");
        em = emf.createEntityManager();
    }

    @Override
    public List<Document> getAllDocuments() {
        List<Document> documents = em.createQuery("Select d from Document d", Document.class).getResultList();
        System.out.println("Fetched documents: " + documents);  // Log the result
        return documents;
    }

    @Override
    public Document getDocumentById(Long docId) {
        return em.find(Document.class, docId);
    }

}
