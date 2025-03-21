package com.sa.exam_biblio.dao;

import com.sa.exam_biblio.model.Book;
import java.util.List;

public interface BookDAO {
    void addBook(Book book);
    List<Book> getAllBooks();
    Book getBookById(Long bookId);
}
