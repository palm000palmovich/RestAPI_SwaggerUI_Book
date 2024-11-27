package com.example.Pook.controllers;

import com.example.Pook.model.Book;
import com.example.Pook.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("{id}")  //GET  http://localhost:8080/books/23
    public Book getBookInfo(@PathVariable long id){
        return bookService.findBook(id);
    }

    @PostMapping    //POST
    public Book createBook(Book book){
        return bookService.createBook(book);
    }
}
