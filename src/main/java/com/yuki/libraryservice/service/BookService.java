package com.yuki.libraryservice.service;

import com.yuki.libraryservice.dto.BookResponse;
import com.yuki.libraryservice.dto.CreateBookRequest;

public interface BookService {
     BookResponse createBook(CreateBookRequest request);
}