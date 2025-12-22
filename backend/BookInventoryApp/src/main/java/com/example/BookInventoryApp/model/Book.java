package com.example.BookInventoryApp.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Book {
    
    private int bookId;
    private String title;
    private String author;
    private BigDecimal price;

    public Book(){
        System.out.println("Created a book Object");
    }

    public Book(int id, String title, String author, BigDecimal price) {
        this.bookId = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }


    public int getBookId() { return bookId; }
    public void setBookId(int id) { this.bookId = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }


    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", price=" + price + "]";
    }
   
    
}
