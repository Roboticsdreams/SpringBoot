package com.bookstore.service;


	import static org.junit.Assert.assertEquals;
	import static org.mockito.Mockito.times;
	import static org.mockito.Mockito.verify;
	import static org.mockito.Mockito.when;

	import java.util.ArrayList;
	import java.util.List;

	import org.junit.Before;
	import org.junit.Test;
	import org.junit.runner.RunWith;
	import org.mockito.InjectMocks;
	import org.mockito.Mock;
	import org.mockito.MockitoAnnotations;
	import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

	import com.bookstore.model.Book;
	import com.bookstore.repository.BookRepository;

	@RunWith(SpringJUnit4ClassRunner.class)
	public class BookServiceTest {
		
		@Mock
		private BookRepository bookRepository;
		
		@InjectMocks
		private BookServiceImpl bookService;
		
		@Before
		public void setup(){
			MockitoAnnotations.initMocks(this);
		}
		
		@Test
		public void testGetAllBook(){
			List<Book> bookList = new ArrayList<Book>();
			bookList.add(new Book("1", "Book1", "Author1", "Publisher1", 1000, 5));
			bookList.add(new Book("2", "Book2", "Author2", "Publisher2", 2000, 5));
			bookList.add(new Book("3", "Book3", "Author3", "Publisher3", 3000, 5));
			when(bookRepository.findAll()).thenReturn(bookList);
			
			List<Book> result = bookService.getAllBooks();
			assertEquals(3, result.size());
		}
		
		@Test
		public void testGetBookById(){
			Book book = new Book("1", "Book1", "Author1", "Publisher1", 1000, 5);
			when(bookRepository.findOne("1")).thenReturn(book);
			Book resultBook = bookService.getBookById("1");
			assertEquals("1", resultBook.getId());
			assertEquals("Book1", resultBook.getName());
			assertEquals("Author1", resultBook.getAuthor());
			assertEquals("Publisher1", resultBook.getPublisher());
			assertEquals(1000, resultBook.getUnitPrice());
			assertEquals(5, resultBook.getAvailQuantity());
		}
		
		@Test
		public void saveBook(){
			Book book = new Book("8", "Book8", "Author8", "Publisher8", 8000, 5);
			when(bookRepository.save(book)).thenReturn(book);
			Book resultBook = bookService.saveBook(book);
			assertEquals("8", resultBook.getId());
			assertEquals("Book8", resultBook.getName());
			assertEquals("Author8", resultBook.getAuthor());
			assertEquals("Publisher8", resultBook.getPublisher());
			assertEquals(8000, resultBook.getUnitPrice());
			assertEquals(5, resultBook.getAvailQuantity());
		}
		
		@Test
		public void removeBook(){
			Book book = new Book("8", "Book8", "Author8", "Publisher8", 8000, 5);
			bookService.removeBook(book);
	        verify(bookRepository, times(1)).delete(book);
		}
		
		

	}