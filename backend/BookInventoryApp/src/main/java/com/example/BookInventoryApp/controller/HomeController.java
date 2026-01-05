package com.example.BookInventoryApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BookInventoryApp.model.Book;
import com.example.BookInventoryApp.service.BookService;

@RestController
@RequestMapping("/api/books")
public class HomeController {
//    @Autowired
    private final BookService service;

    public HomeController(BookService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody com.example.BookInventoryApp.model.Book book){
        Book savedBook = service.addBook(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable int id) {
        try {
            return ResponseEntity.ok(service.getBookById(id));
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/author/{auth}")
    public ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable String auth){
        return ResponseEntity.ok(service.getBooksByAuthor(auth));
    }

    @GetMapping("/data")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(service.getAllBooks());
    }
}
