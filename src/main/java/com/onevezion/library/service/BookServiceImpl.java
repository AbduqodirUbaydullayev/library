package com.onevezion.library.service;

import com.onevezion.library.dto.BookDto;
import com.onevezion.library.model.Book;
import com.onevezion.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void create(BookDto bookDto) {
        bookRepository.create(bookDto.toBook());
    }

    @Override
    public List<BookDto> getAllBooks() {
        return bookRepository.getAllBooks().stream()
                .sorted((book1, book2) -> book2.getTitle().compareToIgnoreCase(book1.getTitle()))
                .map(Book::toBookDto)
                .toList();
    }

    @Override
    public Map<String, List<BookDto>> getAllGroupedByAuthorBooks() {
        return bookRepository.getAllBooks().stream()
                .map(Book::toBookDto)
                .collect(Collectors.groupingBy(BookDto::getAuthor));
    }

    @Override
    public List<Map.Entry<String, Long>> getAuthorsWithMostOccurrences(Character character) {
        return bookRepository.getAuthorsWithMostOccurrences(character);
    }

}
