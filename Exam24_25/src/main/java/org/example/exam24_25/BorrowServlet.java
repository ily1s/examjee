package org.example.exam24_25;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.exam24_25.Model.Borrow;
import org.example.exam24_25.Model.DAO.BorrowDaoImpl;

import jakarta.persistence.*;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.util.List;

public class BorrowServlet extends HttpServlet {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("exam24_25");
    private EntityManager em = emf.createEntityManager();
    private BorrowDaoImpl borrowDAO = new BorrowDaoImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Borrow> borrows = borrowDAO.listCurrentBorrows();
        String json = new Gson().toJson(borrows);
        response.setContentType("application/json");
        response.getWriter().write(json);
    }
}

