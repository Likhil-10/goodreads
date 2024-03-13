package com.hi.demo;

import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
//import com.hi.demo.*;

public class BookServices implements BookRepository {
    private HashMap<Integer, Book> hmap = new HashMap<>();
    private int uniqueId=3;

    public BookServices() {
        Book b1 = new Book(1, "harry potter","harry_potter.jpg");
        Book b2 = new Book(2, "Rise","rise.jpeg");
        hmap.put(b1.getId(), b1);
        hmap.put(b2.getId(), b2);
    }

    @Override
    public ArrayList<Book> getBooks() {
        Collection<Book> bookCollection = hmap.values();
        ArrayList<Book> books = new ArrayList<>(bookCollection);
        return books;
    }

    @Override
    public Book getBookById(int bookId) {
        Book book = hmap.get(bookId);
        if(book == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return book;
    }

    @Override
    public Book addBook(Book book)
    {
        book.id=uniqueId;
        hmap.put(uniqueId, book);
        uniqueId++;
        return book;
    }

    @Override
    public Book updateBook(int id,Book book)
    {
        Book up=hmap.get(id);

        if(up==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        if(book.name!=null) up.name=book.name;
        if(book.img!=null) up.img=book.img;

        return up;
    }

}
