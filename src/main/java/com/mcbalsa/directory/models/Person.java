package com.mcbalsa.directory.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("Person")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Person {
    @Id
    private String id;
    
    private String firstName;
    private String lastName;
    private String ssn;

    public Person(String firstName, String lastName, String ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
    }
}
