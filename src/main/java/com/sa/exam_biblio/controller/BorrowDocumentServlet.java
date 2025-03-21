package com.sa.exam_biblio.controller;

import com.sa.exam_biblio.dao.impl.DocumentDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/borrow")
public class BorrowDocumentServlet extends HttpServlet {
    private final DocumentDAOImpl documentDAO = new DocumentDAOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long userId = Long.parseLong(req.getParameter("userId"));
        Long documentId = Long.parseLong(req.getParameter("documentId"));

        try {
            documentDAO.borrowDocument(userId, documentId);
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().write("Document borrowed successfully");
        } catch (Exception e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("Error borrowing document: " + e.getMessage());
        }
    }
}
