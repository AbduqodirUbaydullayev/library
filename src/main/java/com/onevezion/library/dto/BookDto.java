package com.onevezion.library.dto;

import com.onevezion.library.model.Book;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private Long id;
    @NotNull(message = "Title must not be null.")
    @NotBlank(message = "Title must not be empty.")
    private String title;
    @NotNull(message = "Author must not be null.")
    @NotBlank(message = "Author must not be empty.")
    private String author;
    private String description;

    public Book toBook(){
        return Book.builder()
                .id(this.id)
                .title(this.title)
                .author(this.author)
                .description(this.description)
                .build();
    }

}
