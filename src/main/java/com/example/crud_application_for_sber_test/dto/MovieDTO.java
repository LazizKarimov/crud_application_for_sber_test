package com.example.crud_application_for_sber_test.dto;

import com.example.crud_application_for_sber_test.entity.Director;
import lombok.Data;

/**
 * DTO class representing a movie.
 */
@Data
public class MovieDTO {
    private Long id; // The unique identifier of the movie.
    private String name; // The name of the movie.
    private int year; // The release year of the movie.
    //    @JsonProperty("director_id")
    private Director director; // The director of the movie.
}
