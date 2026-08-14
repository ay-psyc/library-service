package com.yuki.libraryservice.service;

import com.yuki.libraryservice.dto.BookResponse;
import com.yuki.libraryservice.dto.CreateBookRequest;

import java.util.List;

public interface BookService {
     BookResponse createBook(CreateBookRequest request);

     List<BookResponse> getAllBooks();

     BookResponse getBookById(Long id);
}