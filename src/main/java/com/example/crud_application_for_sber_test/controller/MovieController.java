package com.example.crud_application_for_sber_test.controller;


import com.example.crud_application_for_sber_test.dto.MovieDTO;
import com.example.crud_application_for_sber_test.service.MovieService;
import org.springframework.web.bind.annotation.*;

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


}
