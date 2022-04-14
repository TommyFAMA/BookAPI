package com.example.book;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
   @Mock
   private BookRepository mockRepo;

   @InjectMocks
   BookService bookservice;

   @Test
   void shouldFindAllBooks() {
      when(mockRepo.findAll())
      .thenReturn(List.of(
         new Book(1,"Book1","Author1"),
         new Book(2,"Book2","Author2")
         ));

      int book_count = bookservice.list().size();
      
      //verify that findAll() is invoked once on the mock mockRepo
      verify(mockRepo).findAll();

      //verify the number of books
      assertEquals(2, book_count);
   }
}