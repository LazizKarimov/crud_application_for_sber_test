package com.example.crud_application_for_sber_test.mapper;


import com.example.crud_application_for_sber_test.dto.MovieDTO;
import com.example.crud_application_for_sber_test.entity.Movie;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for converting between Movie and MovieDTO objects.
 */
@Component
public class MovieMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    /**
     * Converts a MovieDTO object to a Movie entity.
     *
     * @param movieDTO The MovieDTO object to convert.
     * @return The corresponding Movie entity.
     */
    public Movie convertToEntity(MovieDTO movieDTO) {
        return modelMapper.map(movieDTO, Movie.class);
    }

    /**
     * Converts a Movie entity to a MovieDTO object.
     *
     * @param movie The Movie entity to convert.
     * @return The corresponding MovieDTO object.
     */
    public MovieDTO convertToDTO(Movie movie) {
        return modelMapper.map(movie, MovieDTO.class);
    }

    /**
     * Converts a list of Movie entities to a list of MovieDTO objects.
     *
     * @param movies The list of Movie entities to convert.
     * @return The corresponding list of MovieDTO objects.
     */
    public List<MovieDTO> convertToDTOList(List<Movie> movies) {
        return movies.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
