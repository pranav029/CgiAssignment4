package com.cgi.assignment.CgiApp.services.book;

import com.cgi.assignment.CgiApp.dto.ResponseDto;
import com.cgi.assignment.CgiApp.entities.Book;

import java.util.List;

public interface BookService {
    ResponseDto<Book> addBook(Book book);

    ResponseDto<Void> deleteBook(Integer bookId);

    ResponseDto<List<Book>> getAllBooks();

    ResponseDto<Book> update(Integer bookId, Book book);
}
