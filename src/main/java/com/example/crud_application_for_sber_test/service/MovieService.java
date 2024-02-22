package com.example.crud_application_for_sber_test.service;

import com.example.crud_application_for_sber_test.dto.MovieDTO;
import com.example.crud_application_for_sber_test.entity.Movie;
import com.example.crud_application_for_sber_test.mapper.MovieMapper;
import com.example.crud_application_for_sber_test.repository.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    private final MovieMapper movieMapper;
    private final MovieRepository movieRepository;

    public MovieService(MovieMapper movieMapper, MovieRepository movieRepository) {
        this.movieMapper = movieMapper;
        this.movieRepository = movieRepository;
    }

    public MovieDTO save(MovieDTO movieDTO) {
        Movie movie = movieMapper.convertToEntity(movieDTO);
        movieDTO.setId(movieRepository.save(movie).getId());
        return movieDTO;
    }


}
