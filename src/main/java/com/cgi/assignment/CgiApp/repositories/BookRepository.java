package com.cgi.assignment.CgiApp.repositories;

import com.cgi.assignment.CgiApp.entities.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
}
