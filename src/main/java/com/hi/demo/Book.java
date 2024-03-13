package com.hi.demo;

public class Book {
    
    int id;
    String name;
    String img;

    public Book(int id, String name, String img)
    {
        this.id=id;
        this.name=name;
        this.img=img;
    }

    public int getId()
    {
        return this.id;
    }

    public String name()
    {
        return this.name;
    }
    
    public String img()
    {
        return this.img;
    }
}
