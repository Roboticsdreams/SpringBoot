package com.bookstore.service;

import java.util.List;

import com.bookstore.model.Book;

public interface BookService {

	public List<Book> getAllBooks();
	public Book getBookById(String id);
	public Book saveBook(Book book);
	public void removeBook(Book book);

}
