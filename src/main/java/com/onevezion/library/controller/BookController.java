package com.onevezion.library.controller;

import com.onevezion.library.dto.BookDto;
import com.onevezion.library.service.BookService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@Validated
@RestController
@RequestMapping("api/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDto>> books() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody @Valid BookDto bookDto) {
        bookService.create(bookDto);
        return new ResponseEntity<>("Book added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/grouped-by-author")
    public ResponseEntity<Map<String, List<BookDto>>> groupedByAuthor() {
        return new ResponseEntity<>(bookService.getAllGroupedByAuthorBooks(), HttpStatus.OK);
    }

    @GetMapping("/search-by-character")
    public ResponseEntity<List<Map.Entry<String, Long>>> getAuthorsWithMostOccurrences(
            @RequestParam("character")
            @NotBlank(message = "Character cannot be blank")
            @Size(max = 1, message = "Character length must be 1")
            @Pattern(regexp = "[a-zA-Z]", message = "Character must be a letter")
            String character) {
        return new ResponseEntity<>(bookService.getAuthorsWithMostOccurrences(character.charAt(0)), HttpStatus.OK);
    }

}
