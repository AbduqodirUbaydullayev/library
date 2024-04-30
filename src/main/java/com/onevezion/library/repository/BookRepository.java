package com.onevezion.library.repository;

import com.onevezion.library.model.Book;

import java.util.List;
import java.util.Map;

public interface BookRepository {

    void create(Book book);
    List<Book> getAllBooks();
    List<Map.Entry<String, Long>> getAuthorsWithMostOccurrences(Character character);

}
