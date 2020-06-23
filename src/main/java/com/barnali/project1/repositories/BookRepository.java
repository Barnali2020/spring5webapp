package com.barnali.project1.repositories;

import com.barnali.project1.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
