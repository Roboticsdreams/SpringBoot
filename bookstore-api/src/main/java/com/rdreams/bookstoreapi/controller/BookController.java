package com.rdreams.bookstoreapi.controller;

import com.rdreams.bookstoreapi.exception.ResourceNotFoundException;
import com.rdreams.bookstoreapi.model.Book;
import com.rdreams.bookstoreapi.service.IBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/api/v1")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        log.info("Getting /books");
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(value = "id") Long bookId) throws ResourceNotFoundException {
        log.info("Getting /books/"+bookId);
        Book book = bookService.getBookById(bookId).orElseThrow(
                () -> new ResourceNotFoundException("Book not found for this id :: " + bookId)
        );
        return ResponseEntity.ok().body(book);
    }

    @PostMapping("/books")
    public Book saveBook(@RequestBody Book book) throws ResourceNotFoundException {
        log.info("Posting /books");
        return bookService.saveBook(book);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(
            @PathVariable(value = "id") Long bookId,
            @RequestBody Book book
    ) throws ResourceNotFoundException {
        log.info("Putting /books/"+bookId);
        Book newbook = bookService.getBookById(bookId).orElseThrow(
                () -> new ResourceNotFoundException("Book not found for this id :: " + bookId)
        );
        newbook.setName(book.getName());
        final Book updatedBook = bookService.saveBook(newbook);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/books/{id}")
    public Map<String, Boolean> deleteBook(@PathVariable(value = "id") Long bookId)
            throws ResourceNotFoundException {
        log.info("Deleting /books/"+bookId);
        Book book = bookService.getBookById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found for this id :: " + bookId));

        bookService.deleteBook(book);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @DeleteMapping("/books")
    public ResponseEntity<Integer> deleteAllBooks() {
        log.info("Deleting /books");
        bookService.deleteAllBooks();
        return ResponseEntity.ok(200);
    }
}
