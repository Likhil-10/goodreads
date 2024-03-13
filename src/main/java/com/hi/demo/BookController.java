package com.hi.demo;

import java.util.*;
import java.text.SimpleDateFormat;
//import com.hi.demo.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
public class BookController {
    BookServices bookService = new BookServices();

    @GetMapping("/date")
    public String date() {
        
        Date d=new Date();
        SimpleDateFormat sd=new SimpleDateFormat("dd/mm/yyyy");

        String s=sd.format(d);

        return s;
    }

    @GetMapping("/books")
    public ArrayList<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/books/{bookid}")
    public Book getBookById(@PathVariable("bookid") int bookid) {
        
        return bookService.getBookById(bookid);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book)
    {
        return bookService.addBook(book);
    }
    
    @PutMapping("/books/{bookid}")
    public Book updateBook(@RequestBody Book book, @PathVariable("bookid") int bookid)
    {
        return bookService.updateBook(bookid, book);
    }

    @DeleteMapping("/books/{bookid}")
    public void deleBook(@PathVariable("bookid") int id)
    {
        bookService.deleteBook(id);
    }
}