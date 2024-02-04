package com.bookstoreapi.service;

import com.bookstoreapi.entity.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    Book saveBook(Book book);
    List<Book> getAllBooks();
    Optional<Book> getBookByID(Long bookId);
    void deleteBook(Book book);
    void deleteAllBooks();
}
