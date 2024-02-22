package com.example.crud_application_for_sber_test.mapper;


import com.example.crud_application_for_sber_test.dto.MovieDTO;
import com.example.crud_application_for_sber_test.entity.Movie;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public Movie convertToEntity(MovieDTO movieDTO) {
        return modelMapper.map(movieDTO, Movie.class);
    }

    public MovieDTO convertToDTO(Movie movie) {
        return modelMapper.map(movie, MovieDTO.class);
    }

    public List<MovieDTO> convertToDTOList(List<Movie> movies) {
        return movies.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
