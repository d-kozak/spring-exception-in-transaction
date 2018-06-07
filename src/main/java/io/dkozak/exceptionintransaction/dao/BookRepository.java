package io.dkozak.exceptionintransaction.dao;

import io.dkozak.exceptionintransaction.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
