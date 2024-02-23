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
    /**
     * The unique identifier of the movie.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * The name of the movie.
     */
    @Column(name = "name")
    private String name;
    /**
     * The release year of the movie.
     */
    @Column(name = "\"year\"")
    private Integer year;
    /**
     * The director of the movie.
     */
    @ManyToOne
    @JoinColumn(name = "director_id", referencedColumnName = "id")
    private Director movieDirector;
}
