package com.example.crud_application_for_sber_test.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO class representing a director.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DirectorDTO {
    /**
     * The unique identifier of the director.
     */
    private Long id;
    /**
     * The first name of the director.
     */
    private String name;
    /**
     * The last name of the director.
     */
    @JsonProperty("last_name")
    private String lastName;
    /**
     * The age of the director.
     */
    private int age;
}
