package com.hi.demo;
import java.util.ArrayList;

//import com.hi.demo.*;
public interface BookRepository {

    ArrayList<Book> getBooks();
    
    Book getBookById(int bookId);

    Book addBook(Book book);

    Book updateBook(int id, Book book);

    void deleteBook(int id);

}

