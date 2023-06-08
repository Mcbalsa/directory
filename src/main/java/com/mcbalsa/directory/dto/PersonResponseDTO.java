package com.mcbalsa.directory.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PersonResponseDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String ssn;
}

