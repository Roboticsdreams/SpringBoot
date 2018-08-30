package com.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bookstore.model.Book;
import com.bookstore.repository.BookRepository;


@SpringBootApplication
public class Application  {
    
	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	@Bean
	public CommandLineRunner setup(BookRepository bookRepository) {
		return (args) -> {
			bookRepository.deleteAll();
			bookRepository.save(new Book("1", "Book", "Author", "Publisher", 1000, 5));
			bookRepository.save(new Book("2", "Book2", "Author2", "Publisher2", 2000, 5));
			bookRepository.save(new Book("3", "Book3", "Author3", "Publisher3", 3000, 5));
			bookRepository.save(new Book("4", "Book4", "Author4", "Publisher4", 4000, 5));
			bookRepository.save(new Book("5", "Book5", "Author5", "Publisher5", 4000, 5));
			logger.info("The sample data has been generated");
		};
	}
}