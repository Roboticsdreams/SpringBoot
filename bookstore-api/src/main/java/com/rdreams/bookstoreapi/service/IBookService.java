package com.rdreams.bookstoreapi.service;

import com.rdreams.bookstoreapi.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    List<Book> getAllBooks();
    Optional<Book> getBookById(Long id);
    Book saveBook(Book book);
    void deleteBook(Book book);
    void deleteAllBooks();

}
