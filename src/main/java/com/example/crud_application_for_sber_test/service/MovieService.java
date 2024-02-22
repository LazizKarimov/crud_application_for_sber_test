package com.example.crud_application_for_sber_test.service;

import com.example.crud_application_for_sber_test.dto.MovieDTO;
import com.example.crud_application_for_sber_test.entity.Movie;
import com.example.crud_application_for_sber_test.mapper.MovieMapper;
import com.example.crud_application_for_sber_test.repository.MovieRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service class for managing Movie entities.
 */
@Service
public class MovieService {
    private static final Logger logger = LoggerFactory.getLogger(MovieService.class);
    private final MovieMapper movieMapper;
    private final MovieRepository movieRepository;

    public MovieService(MovieMapper movieMapper, MovieRepository movieRepository) {
        this.movieMapper = movieMapper;
        this.movieRepository = movieRepository;
    }

    /**
     * Saves a MovieDTO object as a Movie entity.
     *
     * @param movieDTO The MovieDTO object to save.
     * @return The saved MovieDTO object.
     */
    @Transactional
    public MovieDTO save(MovieDTO movieDTO) {
        logger.info("Saving movie: {}", movieDTO.getName());
        Movie movie = movieMapper.convertToEntity(movieDTO);
        movieDTO.setId(movieRepository.save(movie).getId());
        return movieDTO;
    }

    /**
     * Updates a MovieDTO object as a Movie entity.
     *
     * @param movieDTO The MovieDTO object to update.
     * @return The updated MovieDTO object.
     */
    @Transactional
    public MovieDTO update(MovieDTO movieDTO) {
        logger.info("Updating movie with id: {}", movieDTO.getId());
        Movie existingMovie = movieRepository.findById(movieDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Movie with id " + movieDTO.getId() + " not found"));

        existingMovie.setName(movieDTO.getName());
        existingMovie.setYear(movieDTO.getYear());

        return movieMapper.convertToDTO(movieRepository.save(existingMovie));
    }

    /**
     * Deletes a Movie entity by its ID.
     *
     * @param id The ID of the Movie entity to delete.
     */
    @Transactional
    public void delete(Long id) {
        logger.info("Deleting movie with id: {}", id);
        movieRepository.deleteById(id);
    }

    /**
     * Retrieves a list of all MovieDTO objects.
     *
     * @return The list of MovieDTO objects.
     */
    public List<MovieDTO> getAll() {
        logger.info("Getting all movies");
        List<Movie> movies = movieRepository.findAll();
        return movieMapper.convertToDTOList(movies);
    }

    /**
     * Retrieves a MovieDTO object by its ID.
     *
     * @param id The ID of the Movie entity to retrieve.
     * @return The MovieDTO object.
     */
    @Transactional
    public MovieDTO getById(Long id) {
        logger.info("Getting movie with id: {}", id);
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Movie with id " + id + " not found"));

        return movieMapper.convertToDTO(movie);
    }
}
