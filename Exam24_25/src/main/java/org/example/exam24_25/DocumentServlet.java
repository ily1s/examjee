package org.example.exam24_25;

import jakarta.persistence.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import com.google.gson.Gson;
import org.example.exam24_25.Model.DAO.DocumentDaoImpl;
import org.example.exam24_25.Model.Document;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DocumentServlet extends HttpServlet {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("exam24_25");
    private EntityManager em = emf.createEntityManager();
    private DocumentDaoImpl documentDAO = new DocumentDaoImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Document> documents = documentDAO.getAllDocuments();
        String json = new Gson().toJson(documents);
        response.setContentType("application/json");
        response.getWriter().write(json);
    }
}
