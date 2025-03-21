package com.sa.exam_biblio;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sa.exam_biblio.dao.impl.*;
import com.sa.exam_biblio.model.*;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT); // Pretty print JSON

        // Instancier les DAO
        UserDAOImpl userDAO = new UserDAOImpl();
        DocumentDAOImpl documentDAO = new DocumentDAOImpl();
        BookDAOImpl bookDAO = new BookDAOImpl();
        MagazineDAOImpl magazineDAO = new MagazineDAOImpl();

        // Récupérer les données depuis la base de données
        List<User> users = userDAO.getAllUsers();
        List<Book> books = bookDAO.getAllBooks();
        List<Magazine> magazines = magazineDAO.getAllMagazines();
        List<Document> currentLoans = documentDAO.getCurrentLoans();

        // Convertir et afficher en JSON
        try {
            System.out.println("📌 Users in JSON format:");
            System.out.println(objectMapper.writeValueAsString(users));

            System.out.println("\n📚 Books in JSON format:");
            System.out.println(objectMapper.writeValueAsString(books));

            System.out.println("\n📰 Magazines in JSON format:");
            System.out.println(objectMapper.writeValueAsString(magazines));

            System.out.println("\n🔄 Current Loans in JSON format:");
            System.out.println(objectMapper.writeValueAsString(currentLoans));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
