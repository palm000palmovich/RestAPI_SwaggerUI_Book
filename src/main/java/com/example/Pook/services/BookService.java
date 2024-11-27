package com.example.Pook.services;

import com.example.Pook.model.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookService {
    private final HashMap<Long,Book> books = new HashMap<>();
    private long lastId = 0;


    public Book createBook(Book book){
        book.setId(++lastId);
        books.put(lastId, book);
        return book;
    }

    public Book findBook(Long id){
        return books.get(id);
    }

    public Book editBook(Book book){
        if (books.containsKey(book.getId())){
            books.put(book.getId(), book);
            return book;
        }
        return null;
    }

    public Book deleteBook(Long id){
        return books.remove(id);
    }

    public List<Book> getAllBooks(){
        if (books == null){return null;}

        List<Book> bookList = new ArrayList<>();
        for (Book i : books.values()){bookList.add(i);}

        return bookList;
    }

}
