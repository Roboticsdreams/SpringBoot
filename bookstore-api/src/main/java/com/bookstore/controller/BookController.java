package com.bookstore.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.exception.BookException;
import com.bookstore.model.Book;
import com.bookstore.model.Response;
import com.bookstore.service.BookService;
import com.bookstore.util.PayloadValidator;

@RestController
public class BookController {
	
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="/books", method=RequestMethod.GET)
	public ResponseEntity<List<Book>> getAllBook(){
    	logger.info("Returning all the ToDo´s");
		return new ResponseEntity<List<Book>>(bookService.getAllBooks(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
	public ResponseEntity<Book> getToDoById(@PathVariable("id") String id) throws BookException{
    	logger.info("Book id to return " + id);
    	Book book = bookService.getBookById(id);
    	if (book == null){
            throw new BookException("Book doesn´t exist");
    	}
		return new ResponseEntity<Book>(bookService.getBookById(id), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/books", method = RequestMethod.POST)
   	public ResponseEntity<Book> saveBook(@RequestBody Book payload) throws BookException{
    	logger.info("Book to save " + payload);
    	if (!PayloadValidator.validateCreatePayload(payload)){
            throw new BookException("Payload malformed, id must not be defined");
    	}
		return new ResponseEntity<Book>(bookService.saveBook(payload), HttpStatus.OK);
   	}
    
    @RequestMapping(value = "/books", method = RequestMethod.PATCH)
   	public ResponseEntity<Book> updateBook(@RequestBody Book payload) throws BookException{
    	logger.info("Book to update " + payload);
    	Book book = bookService.getBookById(payload.getId());
    	if (book == null){
            throw new BookException("Book to update doesn´t exist");
    	}
		return new ResponseEntity<Book>(bookService.saveBook(payload), HttpStatus.OK);
   	}
    
    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Response> removeBookById(@PathVariable("id") String id) throws BookException{
    	logger.info("Book id to remove " + id);
    	Book book = bookService.getBookById(id);
    	if (book == null){
            throw new BookException("Book to delete doesn´t exist");
    	}
		bookService.removeBook(book);
		return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "Book has been deleted"), HttpStatus.OK);
	}
}