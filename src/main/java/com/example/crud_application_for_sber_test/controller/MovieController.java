package com.example.crud_application_for_sber_test.controller;


import com.example.crud_application_for_sber_test.dto.MovieDTO;
import com.example.crud_application_for_sber_test.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for handling operations related to movies.
 */
@RequestMapping("/movie")
@RestController
public class MovieController {

    private final MovieService movieService;

    /**
     * Constructor for MovieController.
     *
     * @param movieService The service for movie operations.
     */
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    /**
     * Endpoint for creating a new movie.
     *
     * @param movieDTO The DTO representing the movie to be created.
     * @return The DTO of the created movie.
     */
    @PostMapping
    public MovieDTO createMovie(@RequestBody MovieDTO movieDTO) {
        return movieService.save(movieDTO);
    }

    /**
     * Endpoint for updating an existing movie.
     *
     * @param movieDTO The DTO representing the updated movie information.
     * @return The DTO of the updated movie.
     */
    @PutMapping
    public MovieDTO updateMovie(@RequestBody MovieDTO movieDTO) {
        return movieService.update(movieDTO);
    }

    /**
     * Endpoint for deleting a movie by id.
     *
     * @param id The id of the movie to be deleted.
     */
    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.delete(id);
    }

    /**
     * Endpoint for retrieving all movies.
     *
     * @return A list of DTOs representing all movies.
     */
    @GetMapping
    public List<MovieDTO> getAllMovies() {
        return movieService.getAll();
    }

    /**
     * Endpoint for retrieving a movie by id.
     *
     * @param id The id of the movie to retrieve.
     * @return The DTO representing the movie with the specified id.
     */
    @GetMapping("/{id}")
    public MovieDTO getMovieById(@PathVariable Long id) {
        return movieService.getById(id);
    }
}
