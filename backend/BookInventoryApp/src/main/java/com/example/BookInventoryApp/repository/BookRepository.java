package com.example.BookInventoryApp.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.BookInventoryApp.model.Book;

@Repository
public class BookRepository {
    private final Map<Integer, Book> bookStore = new HashMap<>();
    private int currentId = 1;

    public BookRepository() {
        save(new Book(0, "Book 1", "Hari", new BigDecimal("499.00")));
        save(new Book(0, "Book 2", "Kiran", new BigDecimal("599.00")));
        save(new Book(0, "Book 3", "Stuart", new BigDecimal("699.00")));
        save(new Book(0, "Book 4", "Nothing", new BigDecimal("799.00")));
        save(new Book(0, "Book 5", "Veronika", new BigDecimal("899.00")));
        save(new Book(0, "Book 6", "Veronika", new BigDecimal("999.00")));
    }

    public Book save(Book book){
        book.setBookId(currentId++);
        bookStore.put(book.getBookId(), book);
        return book;
    }

    public Optional<Book> findById(int id) {
        return Optional.ofNullable(bookStore.get(id));
    }

    public List<Book> findByAuthor(String auth) {
        List<Book> booksByAuthor = new ArrayList<>();
        for(int id: bookStore.keySet()){
            Book cur = bookStore.get(id);
            if (cur.getAuthor().equalsIgnoreCase(auth)) {
                booksByAuthor.add(cur);
            }
        }
        return booksByAuthor;
    }

    public List<Book> findAll() {
        return new ArrayList<>(bookStore.values());
    }

    
    public int size(){
        return bookStore.size();
    }
}
