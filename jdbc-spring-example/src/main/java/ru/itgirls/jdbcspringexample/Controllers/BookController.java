package ru.itgirls.jdbcspringexample.Controllers;

import ru.itgirls.jdbcspringexample.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itgirls.jdbcspringexample.Books.Book;

import java.util.List;
@RestController
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    public BookController (BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/book/all")
    public List<Book> getAllBooks() {
        return bookRepository.findAllBooks();
    }

//    @GetMapping("/book/id")
//    public List<Book> getBookById() {
//        return bookRepository.findBookById();
//    }
}