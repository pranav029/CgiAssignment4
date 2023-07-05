package com.cgi.assignment.CgiApp.services;

import com.cgi.assignment.CgiApp.dto.ResponseDto;
import com.cgi.assignment.CgiApp.entities.Book;
import com.cgi.assignment.CgiApp.exceptions.ResourceNotFoundException;
import com.cgi.assignment.CgiApp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public ResponseDto<Book> addBook(Book book) {
        Book newBook = bookRepository.save(book);
        return new ResponseDto<Book>("Book added successfully", true, newBook, null);
    }

    @Override
    public ResponseDto<Void> deleteBook(Integer bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book", "Id", bookId.toString()));
        bookRepository.delete(book);
        return new ResponseDto<>("Book deleted successfully", true, null, null);
    }

    @Override
    public ResponseDto<List<Book>> getAllBooks() {
        Iterable<Book> itrBooks = bookRepository.findAll();
        List<Book> books = StreamSupport.stream(itrBooks.spliterator(), false).toList();
        return new ResponseDto<>(null, true, books, null);
    }
}
