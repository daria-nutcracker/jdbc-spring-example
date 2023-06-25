package ru.itgirls.jdbcspringexample.Repositories;

import ru.itgirls.jdbcspringexample.Books.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findAllBooks ();
    Book findBookById (Long id);
}
