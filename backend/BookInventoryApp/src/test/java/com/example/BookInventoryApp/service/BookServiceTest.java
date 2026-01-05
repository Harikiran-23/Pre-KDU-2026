package com.example.BookInventoryApp.service;

import com.example.BookInventoryApp.model.Book;
import com.example.BookInventoryApp.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    private BookService bookService;
    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        bookRepository = new BookRepository(); // contains 5 preloaded books
        bookService = new BookService(bookRepository);
    }

    @Test
    void shouldReturnBookWhenBookExists() {
        Book book = bookService.getBookById(1);

        assertNotNull(book);
        assertEquals(1, book.getBookId());
        assertEquals("Book 1", book.getTitle());
    }

    @Test
    void shouldAddNewBookSuccessfully() {
        Book newBook = new Book();
        newBook.setTitle("Testing book");
        newBook.setAuthor("Myself");
        newBook.setPrice(new BigDecimal("1000.00"));

        Book savedBook = bookService.addBook(newBook);

        assertNotNull(savedBook.getBookId());
        assertEquals("Testing book", savedBook.getTitle());
        assertEquals(6, savedBook.getBookId()); // after 5 preloaded books
    }

    @Test
    void shouldRetrieveNewlyAddedBookById() {
        Book newBook = new Book();
        newBook.setTitle("New Book");
        newBook.setAuthor("Someone");
        newBook.setPrice(new BigDecimal("2000.00"));

        Book saved = bookService.addBook(newBook);
        Book fetched = bookService.getBookById(saved.getBookId());

        assertEquals(saved.getBookId(), fetched.getBookId());
        assertEquals("New Book", fetched.getTitle());
    }

    @Test
    void shouldThrowExceptionWhenBookDoesNotExist() {
        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> bookService.getBookById(999)
        );

        assertEquals("Book not found", exception.getMessage());
    }

    @Test
    void repositoryShouldHavePreloadedBooks() {
        Book book = bookService.getBookById(3);

        assertNotNull(book);
        assertEquals("Book 3", book.getTitle());
    }
}
