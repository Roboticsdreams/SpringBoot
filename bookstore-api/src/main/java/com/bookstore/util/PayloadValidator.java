package com.bookstore.util;

import com.bookstore.model.Book;
import com.bookstore.service.BookService;

public class PayloadValidator {
	
	private PayloadValidator() {
		super();
	}
	
	BookService bookService;
	
	public static boolean validateCreatePayload(Book book){
		return (book.getId() == null) ? false : true;
	}

}
