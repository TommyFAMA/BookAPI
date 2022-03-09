package com.example.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {
   @Autowired
   private BookRepository repo;

   public BookService() {
      System.out.println("BookService() is called...");
   }

   // Fetch all books
   public List<Book> list() {
     List<Book> books = repo.findAll();
   return books;
   }

   // Get book by ID
   public Book get(int id) {
      Book b  =  repo.findById(id).orElse(null);
      return b;
   }

   // Add a book
   public void create(Book book) {
      repo.save(book);
   }

   public void update(Book book) {
      repo.save(book);
   }

   public void delete(int id){
      repo.deleteById(id);
   }
}