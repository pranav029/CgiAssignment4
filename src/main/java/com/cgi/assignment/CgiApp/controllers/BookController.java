package com.cgi.assignment.CgiApp.controllers;

import com.cgi.assignment.CgiApp.dto.ResponseDto;
import com.cgi.assignment.CgiApp.entities.Book;
import com.cgi.assignment.CgiApp.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public ResponseEntity<ResponseDto<Book>> insertBook(@RequestBody Book book) {
        ResponseDto<Book> responseDto = bookService.addBook(book);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<ResponseDto<Void>> deleteBook(@PathVariable Integer bookId) {
        ResponseDto<Void> responseDto = bookService.deleteBook(bookId);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseDto<List<Book>>> getAllBooks() {
        ResponseDto<List<Book>> responseDto = bookService.getAllBooks();
        return ResponseEntity.ok(responseDto);
    }
}
