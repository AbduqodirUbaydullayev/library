package com.onevezion.library.model;

import com.onevezion.library.dto.BookDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "description")
    private String description;


    public BookDto toBookDto(){
        return BookDto.builder()
                .id(this.getId())
                .title(this.getTitle())
                .author(this.getAuthor())
                .description(this.getDescription())
                .build();
    }

}
