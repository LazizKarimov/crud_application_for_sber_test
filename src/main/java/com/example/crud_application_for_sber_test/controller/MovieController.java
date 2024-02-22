package com.example.crud_application_for_sber_test.controller;


import com.example.crud_application_for_sber_test.dto.MovieDTO;
import com.example.crud_application_for_sber_test.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/movie")
@RestController
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    @PostMapping
    public MovieDTO createMovie( @RequestBody MovieDTO movieDTO ) {
        return movieService.save(movieDTO);
    }


    @PutMapping
    public MovieDTO updateMovie( @RequestBody MovieDTO movieDTO) {
        return movieService.update( movieDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.delete(id);
    }

    @GetMapping
    public List<MovieDTO> getAllMovies() {
        return movieService.getAll();
    }

    @GetMapping("/{id}")
    public MovieDTO getMovieById(@PathVariable Long id) {
        return movieService.getById(id);
    }
}
