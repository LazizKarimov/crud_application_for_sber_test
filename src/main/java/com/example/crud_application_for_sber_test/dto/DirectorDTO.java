package com.example.crud_application_for_sber_test.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DirectorDTO {
    private Long id;
    private String name;
    @JsonProperty("last_name")
    private String lastName;
    private int age;
}
