package com.yuki.libraryservice.service.impl;

import com.yuki.libraryservice.dto.BookResponse;
import com.yuki.libraryservice.dto.CreateBookRequest;
import com.yuki.libraryservice.entity.Book;
import com.yuki.libraryservice.mapper.BookMapper;
import com.yuki.libraryservice.repository.BookRepository;
import com.yuki.libraryservice.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookResponse createBook(CreateBookRequest request) {
        Book book = bookMapper.toEntity(request);
        Book savedBook = bookRepository.save(book);
        return bookMapper.toResponse(savedBook);
    }
}