package com.example.BookInventoryApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BooksPageController {

    @GetMapping("/api/books")
    public String booksPage() {
        return "forward:/books.html";
    }
}
