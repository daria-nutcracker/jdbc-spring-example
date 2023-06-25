package ru.itgirls.jdbcspringexample.Books;

import org.springframework.stereotype.Component;


public class Book {
    private Long id;
    private String name;
    public Book (Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Book (Book book) {
        this.id = book.id;
        this.name = book.name;
    }
    public Book () {}

    public void SetName (String name) {
        this.name = name;
    }

    public void SetId (Long id) {
        this.id =id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
