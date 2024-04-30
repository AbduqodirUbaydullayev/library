package com.onevezion.library.repository;

import com.onevezion.library.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BookRepositoryImpl implements BookRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Book book) {
        jdbcTemplate.update("INSERT INTO books (title, author, description) VALUES (?, ?, ?)",
                book.getTitle(), book.getAuthor(), book.getDescription());
    }

    @Override
    public List<Book> getAllBooks() {
        return jdbcTemplate.query("SELECT * FROM books ",
                (rs, rowNum) -> Book.builder()
                        .id(rs.getLong("id"))
                        .author(rs.getString("author"))
                        .title(rs.getString("title"))
                        .description(rs.getString("description")).build()
        );
    }

    @Override
    public List<Map.Entry<String, Long>> getAuthorsWithMostOccurrences(Character character) {
        character = Character.toUpperCase(character);
        return jdbcTemplate.query(
                "SELECT author, SUM(LENGTH(title) - LENGTH(REPLACE(UPPER(title), ?, ''))) AS occurrences " +
                        " FROM books " +
                        " GROUP BY author " +
                        " HAVING SUM(LENGTH(title) - LENGTH(REPLACE(UPPER(title), ?, ''))) > 0 " +
                        " LIMIT 10",
                (rs, rowNum) -> Map.entry(rs.getString("author"), rs.getLong("occurrences")),
                character, character);
    }

}
