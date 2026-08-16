package com.yuki.libraryservice.service;

import com.yuki.libraryservice.dto.response.BookResponse;
import com.yuki.libraryservice.dto.request.CreateBookRequest;
import com.yuki.libraryservice.dto.request.UpdateBookRequest;
import jakarta.validation.Valid;

import java.util.List;

public interface BookService {
     BookResponse createBook(CreateBookRequest request);

     List<BookResponse> getAllBooks();

     BookResponse getBookById(Long id);

     BookResponse updateBook(Long id, @Valid UpdateBookRequest request);

     void deleteBook(Long id);
}