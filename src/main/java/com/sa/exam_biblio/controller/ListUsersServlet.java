package com.sa.exam_biblio.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sa.exam_biblio.dao.impl.UserDAOImpl;
import com.sa.exam_biblio.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/users")
public class ListUsersServlet extends HttpServlet {
    private final UserDAOImpl userDAO = new UserDAOImpl();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        objectMapper.registerModule(new JavaTimeModule());
        List<User> users = userDAO.getAllUsers();
        PrintWriter out = resp.getWriter();
        out.print(objectMapper.writeValueAsString(users));
        out.flush();
    }
}
