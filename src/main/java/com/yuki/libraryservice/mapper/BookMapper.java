package com.yuki.libraryservice.mapper;

import com.yuki.libraryservice.dto.BookResponse;
import com.yuki.libraryservice.dto.CreateBookRequest;
import com.yuki.libraryservice.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public BookResponse toResponse(Book book) {
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn()
        );
    }

    public Book toEntity(CreateBookRequest request) {
        Book book = new Book();
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setIsbn(request.getIsbn());
        return book;
    }
}
