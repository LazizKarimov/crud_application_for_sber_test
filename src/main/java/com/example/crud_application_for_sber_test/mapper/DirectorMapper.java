package com.example.crud_application_for_sber_test.mapper;

import com.example.crud_application_for_sber_test.dto.DirectorDTO;
import com.example.crud_application_for_sber_test.entity.Director;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Mapper class for converting between Director and DirectorDTO objects.
 */
@Component
public class DirectorMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    /**
     * Converts a DirectorDTO object to a Director entity.
     *
     * @param directorDTO The DirectorDTO object to convert.
     * @return The corresponding Director entity.
     */
    public Director convertToEntity(DirectorDTO directorDTO) {
        return modelMapper.map(directorDTO, Director.class);
    }

    /**
     * Converts a Director entity to a DirectorDTO object.
     *
     * @param director The Director entity to convert.
     * @return The corresponding DirectorDTO object.
     */
    public DirectorDTO convertToDTO(Director director) {
        return modelMapper.map(director, DirectorDTO.class);
    }

    /**
     * Converts a list of Director entities to a list of DirectorDTO objects.
     *
     * @param directors The list of Director entities to convert.
     * @return The corresponding list of DirectorDTO objects.
     */
    public List<DirectorDTO> convertToDTOList(List<Director> directors) {
        return directors.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}