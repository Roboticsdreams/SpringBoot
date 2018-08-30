package com.bookstore.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bookstore.model.Book;

public class PayloadValidatorTest {

	@Test
	public void validatePayLoad() {
		Book book = new Book("1", "Book", "Author", "Publisher", 1000, 5);
		assertEquals(true, PayloadValidator.validateCreatePayload(book));
	}
	
	@Test
	public void validateInvalidPayLoad() {
		Book book = new Book("", "Book", "Author", "Publisher", 1000, 5);
		assertEquals(true, PayloadValidator.validateCreatePayload(book));
	}
	
	

}