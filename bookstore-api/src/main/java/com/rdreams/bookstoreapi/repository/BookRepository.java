package com.rdreams.bookstoreapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rdreams.bookstoreapi.model.Book;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    Optional<Book> findByBookId(Long bookId);

}