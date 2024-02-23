package com.example.crud_application_for_sber_test.dto;

import com.example.crud_application_for_sber_test.entity.Director;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO class representing a movie.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
    /**
     * The unique identifier of the movie.
     */
    private Long id;
    /**
     * The name of the movie.
     */
    private String name;
    /**
     * The release year of the movie.
     */
    private int year;
    /**
     * The director of the movie.
     */
    private Director director;
}
