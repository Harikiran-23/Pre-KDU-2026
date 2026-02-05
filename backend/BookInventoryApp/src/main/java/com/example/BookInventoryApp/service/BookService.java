package com.example.BookInventoryApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.BookInventoryApp.model.Book;
import com.example.BookInventoryApp.repository.BookRepository;

@Service
public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Book addBook(Book book) {
        return repository.save(book);
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }


    public Book getBookById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public List<Book> getBooksByAuthor(String auth){
        return repository.findByAuthor(auth);
    }
}
