package io.dkozak.exceptionintransaction.controller;

import io.dkozak.exceptionintransaction.domain.Book;
import io.dkozak.exceptionintransaction.service.BookRequestDispatcher;
import io.dkozak.exceptionintransaction.service.BookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    private final BookService bookService;

    private final BookRequestDispatcher bookRequestDispatcher;

    public BookController(BookService bookService, BookRequestDispatcher bookRequestDispatcher) {
        this.bookService = bookService;
        this.bookRequestDispatcher = bookRequestDispatcher;
    }

    @RequestMapping("/book")
    public List<Book> get() {
        return bookService.getBooks();
    }


    @RequestMapping("/ex")
    public List<Book> exception() {
        return bookRequestDispatcher.getBooks();
    }
}
