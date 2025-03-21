package com.sa.exam_biblio;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sa.exam_biblio.dao.impl.*;
import com.sa.exam_biblio.model.*;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class Main {
    public static void main(String[] args) {
        try {
            // Create ObjectMapper instance and configure it for pretty printing
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

            // Instancier les DAO
            UserDAOImpl userDAO = new UserDAOImpl();
            DocumentDAOImpl documentDAO = new DocumentDAOImpl();
            BookDAOImpl bookDAO = new BookDAOImpl();
            MagazineDAOImpl magazineDAO = new MagazineDAOImpl();

            // Ajouter des utilisateurs
            User user1 = new User("Alice", "alice@example.com");
            User user2 = new User("Bob", "bob@example.com");
            userDAO.addUser(user1);
            userDAO.addUser(user2);

            // Ajouter des livres
            Book book1 = new Book("Java Programming", LocalDate.of(2021, 5, 10),
                    "John Doe", "123456", LocalDate.of(2021, 6, 1));
            Book book2 = new Book("Data Structures", LocalDate.of(2020, 8, 15),
                    "Jane Smith", "654321", LocalDate.of(2020, 9, 10));
            bookDAO.addBook(book1);
            bookDAO.addBook(book2);

            // Ajouter des magazines
            Magazine magazine1 = new Magazine("Tech Monthly", LocalDate.of(2023, 1, 5),
                    "Tech Publishers", "ISSUE_001", LocalDate.of(2023, 2, 1));
            Magazine magazine2 = new Magazine("AI Today", LocalDate.of(2023, 3, 10),
                    "AI Publishers", "ISSUE_002", LocalDate.of(2023, 4, 1));
            magazineDAO.addMagazine(magazine1);
            magazineDAO.addMagazine(magazine2);

            // Afficher tous les documents en JSON
            System.out.println("📚 Liste des documents :");
            List<Document> allDocuments = documentDAO.getAllDocuments();
            String documentsJson = mapper.writeValueAsString(allDocuments);
            System.out.println(documentsJson);

            // Emprunter un livre
            System.out.println("\n🔄 Alice emprunte 'Java Programming'");
            documentDAO.borrowDocument(user1.getId(), book1.getId());

            // Afficher les emprunts en cours en JSON
            System.out.println("\n📌 Emprunts en cours :");
            List<Document> currentLoans = documentDAO.getCurrentLoans();
            String loansJson = mapper.writeValueAsString(currentLoans);
            System.out.println(loansJson);

            // Retourner un document
            System.out.println("\n✅ Alice retourne 'Java Programming'");
            documentDAO.returnDocument(user1.getId(), book1.getId());

            // Vérifier les emprunts après retour en JSON
            System.out.println("\n📌 Emprunts après retour :");
            currentLoans = documentDAO.getCurrentLoans();
            if (currentLoans.isEmpty()) {
                System.out.println("{\"message\": \"Aucun emprunt en cours.\"}");
            } else {
                String updatedLoansJson = mapper.writeValueAsString(currentLoans);
                System.out.println(updatedLoansJson);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}