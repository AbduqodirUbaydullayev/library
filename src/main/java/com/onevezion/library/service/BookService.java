package com.onevezion.library.service;

import com.onevezion.library.dto.BookDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface BookService {

    void create(BookDto bookDto);
    List<BookDto> getAllBooks();
    Map<String, List<BookDto>> getAllGroupedByAuthorBooks();
    List<Map.Entry<String, Long>> getAuthorsWithMostOccurrences(Character character);

}
