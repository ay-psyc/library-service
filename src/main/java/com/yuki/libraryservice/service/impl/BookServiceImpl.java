package com.yuki.libraryservice.service.impl;

import com.yuki.libraryservice.dto.BookResponse;
import com.yuki.libraryservice.dto.CreateBookRequest;
import com.yuki.libraryservice.dto.UpdateBookRequest;
import com.yuki.libraryservice.entity.Book;
import com.yuki.libraryservice.exception.BookAlreadyExistsException;
import com.yuki.libraryservice.exception.BookNotFoundException;
import com.yuki.libraryservice.mapper.BookMapper;
import com.yuki.libraryservice.repository.BookRepository;
import com.yuki.libraryservice.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookResponse createBook(CreateBookRequest request) {
        String isbn = request.getIsbn();
        if (bookRepository.existsByIsbn(isbn)) {
            throw new BookAlreadyExistsException("Book already exists");
        }

        Book book = bookMapper.toEntity(request);
        Book savedBook = bookRepository.save(book);
        return bookMapper.toResponse(savedBook);
    }

    @Override
    public List<BookResponse> getAllBooks() {
        List<Book> bookList = bookRepository.findAll();
        return bookList.stream().map(book -> bookMapper.toResponse(book)).toList();
    }

    @Override
    public BookResponse getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found"));
        return bookMapper.toResponse(book);
    }

    @Override
    public BookResponse updateBook(Long id, UpdateBookRequest request) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found"));
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setIsbn(request.getIsbn());
        Book savedBook = bookRepository.save(book);
        return bookMapper.toResponse(savedBook);
    }

    @Override
    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found"));
        bookRepository.delete(book);
    }
}