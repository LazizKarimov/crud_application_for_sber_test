package com.example.crud_application_for_sber_test.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * DTO class representing a director.
 */
@Data
public class DirectorDTO {
    private Long id; // The unique identifier of the director.
    private String name; // The first name of the director.
    @JsonProperty("last_name")
    private String lastName; // The last name of the director.
    private int age; // The age of the director.
}
