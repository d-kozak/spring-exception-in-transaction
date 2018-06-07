package io.dkozak.exceptionintransaction.service;

import io.dkozak.exceptionintransaction.dao.BookRepository;
import io.dkozak.exceptionintransaction.domain.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class BookService {

    private static final Logger log = LoggerFactory.getLogger(BookService.class);

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public List<Book> getBooks() {
        try {
            log.info("throwing exception");
            throw new RuntimeException("boooo!");
        } catch (RuntimeException ex) {
            log.info("got cha!");
        }
        List<Book> books = bookRepository.findAll();
        log.info("loaded books: " + books);
        return books;
    }

    //    @Transactional(propagation = Propagation.REQUIRES_NEW) -- this way it works, because there is a new transaction created
    @Transactional // this way it fails, the transaction is marked rollback only
    public List<Book> getBooksUnsafe() {
        throw new RuntimeException("booo!");
    }
}
