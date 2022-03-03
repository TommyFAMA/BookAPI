package com.example.book;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/books")
public class BookController {
    private List<Book> books;

    public BookController() {
        System.out.println("BookController() called...");
        books = new ArrayList<>();
        books.add(new Book(1,"Hacking with Spring Boot 2.3","Greg L. Turnquist"));
        books.add(new Book(2,"97 Things Every Java Programmer Should Know", "Kevlin Henney and Trisha Gee"));
        books.add(new Book(3,"Spring Boot: Up and Running","Greg L. Turnquist "));
    }

    @GetMapping
    public List<Book> list() {
        return books;
    }

    @GetMapping("/{id}")
    public Book get(@PathVariable int id) {
        for (Book i: books){
            if (i.getBookid()==id)
                return i;
        }
        return null; //book not found
    }
}