package com.example.book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(MyCommandRunner.class);

    @Autowired
    private BookRepository repository;

    @Override
    public void run(String...args) throws Exception {
        if (repository.findAll().isEmpty()){ //insert data if no data in the database
            Book b1, b2, b3;
            b1 = new Book("Hacking with Spring Boot 2.3","Greg L. Turnquist");
            b2 = new Book("97 Things Every Java Programmer Should Know", "Kevlin Henney and Trisha Gee");
            b3 = new Book("Spring Boot: Up and Running","Greg L. Turnquist ");
            repository.save(b1);
            repository.save(b2);
            repository.save(b3);
        }

        // fetch all books
        logger.info("Books found with findAll():");
        logger.info("-------------------------------");
        for (Book b : repository.findAll()) {
            logger.info(b.toString());
        }
    }
}