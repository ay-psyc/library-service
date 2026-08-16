package com.yuki.libraryservice.controller;

import com.yuki.libraryservice.dto.response.BookResponse;
import com.yuki.libraryservice.dto.request.CreateBookRequest;
import com.yuki.libraryservice.dto.request.UpdateBookRequest;
import com.yuki.libraryservice.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookResponse> createBook(@Valid @RequestBody CreateBookRequest request) {
        BookResponse response = bookService.createBook(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> getAllBooks() {
        List<BookResponse> allBooks = bookService.getAllBooks();
        return ResponseEntity.ok(allBooks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable Long id) {
        BookResponse bookById = bookService.getBookById(id);
        return ResponseEntity.ok(bookById);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> updateBook(@PathVariable Long id, @RequestBody @Valid UpdateBookRequest request) {
        BookResponse bookResponse = bookService.updateBook(id, request);
        return ResponseEntity.ok(bookResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}