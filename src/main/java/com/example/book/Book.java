package com.example.book;

import javax.persistence.*;

@Entity //Added @Entity annotation
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int bookid;
    private String title;
    private String author;
    
    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    //Added default constructor
    public Book(){ 
    }
    
    //Added constructor with  parameter title and author
    public Book(String title, String author) { 
        this.title = title;
        this.author = author;
    }
    
    public Book(int bookid, String title, String author) {
        this.bookid = bookid;
        this.title = title;
        this.author = author;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book [author=" + author + ", bookid=" 
                + bookid + ", title=" + title + "]";
    }
}