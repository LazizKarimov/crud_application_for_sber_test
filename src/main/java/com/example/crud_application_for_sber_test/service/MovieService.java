package com.example.crud_application_for_sber_test.service;

import com.example.crud_application_for_sber_test.dto.MovieDTO;
import com.example.crud_application_for_sber_test.entity.Movie;
import com.example.crud_application_for_sber_test.mapper.MovieMapper;
import com.example.crud_application_for_sber_test.repository.MovieRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public MovieDTO update(MovieDTO movieDTO) {
        Movie existingMovie = movieRepository.findById(movieDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Movie with id " + movieDTO.getId() + " not found"));

        existingMovie.setName(movieDTO.getName());
        existingMovie.setYear(movieDTO.getYear());

        return movieMapper.convertToDTO(movieRepository.save(existingMovie));
    }

    public void delete(Long id) {
        movieRepository.deleteById(id);
    }

    public List<MovieDTO> getAll() {
        List<Movie> movies = movieRepository.findAll();
        return movieMapper.convertToDTOList(movies);
    }

    public MovieDTO getById(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Movie with id " + id + " not found"));
        return movieMapper.convertToDTO(movie);
    }
}
