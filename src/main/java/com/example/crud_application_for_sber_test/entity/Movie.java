package com.example.crud_application_for_sber_test.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entity class representing a movie.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movie")
@Builder
public class Movie {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // The unique identifier of the movie.

    @Column(name = "name")
    private String name; // The name of the movie.

    @Column(name = "year")
    private Integer year; // The release year of the movie.

    @ManyToOne
    @JoinColumn(name = "director_id", referencedColumnName = "id")
    private Director movieDirector; // The director of the movie.
}
