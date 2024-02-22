package com.example.crud_application_for_sber_test.mapper;

import com.example.crud_application_for_sber_test.dto.DirectorDTO;
import com.example.crud_application_for_sber_test.entity.Director;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DirectorMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public Director convertToEntity(DirectorDTO directorDTO) {
        return modelMapper.map(directorDTO, Director.class);
    }

    public DirectorDTO convertToDTO(Director director) {
        return modelMapper.map(director, DirectorDTO.class);
    }

    public List<DirectorDTO> convertToDTOList(List<Director> directors) {
        return directors.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
