package com.mcbalsa.directory.Service;

import org.springframework.stereotype.Service;

import com.mcbalsa.directory.Repository.PersonRepository;
import com.mcbalsa.directory.models.Person;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonService {

    private PersonRepository personRepository;

    public void insertPerson(Person person) {
        personRepository.insert(person);
        log.info("Person {} is saved");
    }
}
