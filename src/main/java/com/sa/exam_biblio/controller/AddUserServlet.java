package com.sa.exam_biblio.controller;


import com.sa.exam_biblio.dao.impl.DocumentDAOImpl;
import com.sa.exam_biblio.dao.impl.UserDAOImpl;
import com.sa.exam_biblio.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {
    private final UserDAOImpl userDAO = new UserDAOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String mail = req.getParameter("mail");

        if (name == null || name.isEmpty() || mail == null || mail.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("Name and mail are required");
            return;
        }

        User user = new User();
        user.setName(name);
        user.setMail(mail);
        userDAO.addUser(user);
        resp.setStatus(HttpServletResponse.SC_CREATED);
        resp.getWriter().write("User added successfully");
    }
}