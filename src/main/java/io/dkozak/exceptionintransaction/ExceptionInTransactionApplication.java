package io.dkozak.exceptionintransaction;

import io.dkozak.exceptionintransaction.dao.BookRepository;
import io.dkozak.exceptionintransaction.domain.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class ExceptionInTransactionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExceptionInTransactionApplication.class, args);
    }

    @Bean
    public CommandLineRunner bookInserter(BookRepository bookRepository) {
        return args -> {
            bookRepository.save(new Book("Valka s mrozi"));
            bookRepository.save(new Book("Cesta zpet z hospody za 80 dni"));
            bookRepository.save(new Book("42 odstinu modri"));
        };
    }
}
