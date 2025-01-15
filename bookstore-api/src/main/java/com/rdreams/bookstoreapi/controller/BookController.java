package com.rdreams.bookstoreapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rdreams.bookstoreapi.exception.ResourceNotFoundException;
import com.rdreams.bookstoreapi.model.Book;
import com.rdreams.bookstoreapi.service.IBookService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private IBookService bookService;

   @GetMapping("")
    public List<Book> getAllBooks() {
        log.info("Getting /books");
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(value = "id") Long bookId) throws ResourceNotFoundException {
        log.info("Getting /books/"+bookId);
        Book book = bookService.getBookByID(bookId).orElseThrow(
                () -> new ResourceNotFoundException("Book not found for this id :: " + bookId)
        );
        return ResponseEntity.ok().body(book);
    }

    @PostMapping("")
    public Book saveBook(@RequestBody Book book) throws ResourceNotFoundException {
        log.info("Posting /books");
        return bookService.saveBook(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(
            @PathVariable(value = "id") Long bookId,
            @RequestBody Book book
    ) throws ResourceNotFoundException {
        log.info("Putting /books/"+bookId);
        Book newbook = bookService.getBookByID(bookId).orElseThrow(
                () -> new ResourceNotFoundException("Book not found for this id :: " + bookId)
        );
        newbook.setName(book.getName());
        newbook.setAuthorname(book.getAuthorname());
        newbook.setCategory(book.getCategory());
        newbook.setPrice(book.getPrice());
        final Book updatedBook = bookService.saveBook(newbook);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteBook(@PathVariable(value = "id") Long bookId)
            throws ResourceNotFoundException {
        log.info("Deleting /books/"+bookId);
        Book book = bookService.getBookByID(bookId).orElseThrow(
                () -> new ResourceNotFoundException("Book not found for this id :: " + bookId)
        );

        bookService.deleteBook(book);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @DeleteMapping("")
    public ResponseEntity<Integer> DeleteAllBooks() {
        log.info("Deleting /books");
        bookService.deleteAllBooks();
        return ResponseEntity.ok(200);
    }

}
