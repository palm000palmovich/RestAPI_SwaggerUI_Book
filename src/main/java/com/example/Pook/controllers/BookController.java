package com.example.Pook.controllers;

import com.example.Pook.model.Book;
import com.example.Pook.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(path = "/book")
public class BookController {
    @Autowired
    private BookService bookService;


    ///////---------//////////-----------///////////---------////////
    //Если такой кинги нет, то вернет код 404
    @GetMapping("{id}")  //GET  http://localhost:8080/books/23
    public ResponseEntity<Book> getBookInfo(@PathVariable Long id){

        Book book = bookService.findBook(id);
        if (book == null){return ResponseEntity.notFound().build();} return ResponseEntity.ok(book);
    }
    ///////---------//////////-----------///////////---------////////


    @PostMapping    //POST
    public Book createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }


    ///////---------//////////-----------///////////---------////////
    //Если такой кинги нет, то вернет код 404
    @PutMapping    //PUT
    public ResponseEntity<Book> editBook(@RequestBody Book book){
        Book foundBook = bookService.editBook(book);
        if (foundBook == null){return ResponseEntity.notFound().build();}
        return ResponseEntity.ok(foundBook);
    }
    ///////---------//////////-----------///////////---------////////

    @DeleteMapping("{id}")  //DELETE
    public Book deleteBook(@PathVariable Long id){
        return bookService.deleteBook(id);
    }

    @GetMapping
    public ResponseEntity<Collection<Book>> getAllBooks(){
        List<Book> books = bookService.getAllBooks();
        if (books == null){ResponseEntity.notFound().build();}

        return ResponseEntity.ok(books);
    }
}
