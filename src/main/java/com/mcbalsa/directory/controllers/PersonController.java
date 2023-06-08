package com.mcbalsa.directory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mcbalsa.directory.Service.PersonService;
import com.mcbalsa.directory.dto.PersonRequestDTO;
import com.mcbalsa.directory.dto.PersonResponseDTO;
import com.mcbalsa.directory.models.Person;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/person")
@RequiredArgsConstructor
public class PersonController {
    @Autowired
    PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person createNew(@RequestBody PersonRequestDTO personRequest) {
        return personService.createNew(personRequest);
    }

    @GetMapping("GetAll")
    @ResponseStatus(HttpStatus.OK)
    public List<PersonResponseDTO> getAllPeople() {
        return personService.getAllPeople();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public Boolean deleteBook(@RequestParam String id) {
        return personService.deleteById(id);
    }
    
    @PutMapping
    Person updatePerson(@RequestBody PersonResponseDTO personResponseDTO) {
        return personService.updatePerson(personResponseDTO);
    }
}
