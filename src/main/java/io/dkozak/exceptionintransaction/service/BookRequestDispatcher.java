package io.dkozak.exceptionintransaction.service;

import io.dkozak.exceptionintransaction.domain.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class BookRequestDispatcher {

    private static final Logger log = LoggerFactory.getLogger(BookService.class);

    private final BookService bookService;

    public BookRequestDispatcher(BookService bookService) {
        this.bookService = bookService;
    }

    @Transactional
    public List<Book> getBooks() {
        try {
            return bookService.getBooksUnsafe();
        } catch (Exception ex) {
            log.info("got cha!");
            return Collections.emptyList();
        }
    }
}
