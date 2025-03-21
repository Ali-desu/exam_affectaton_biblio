package com.sa.exam_biblio.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sa.exam_biblio.dao.impl.DocumentDAOImpl;
import com.sa.exam_biblio.model.Document;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/documents")
public class ListDocumentsServlet extends HttpServlet {
    private final DocumentDAOImpl documentDAO = new DocumentDAOImpl();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        objectMapper.registerModule(new JavaTimeModule());
        List<Document> documents = documentDAO.getAllDocuments();
        PrintWriter out = resp.getWriter();
        out.print(objectMapper.writeValueAsString(documents));
        out.flush();
    }
}