package com.mcbalsa.directory.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcbalsa.directory.Repository.PersonRepository;
import com.mcbalsa.directory.Service.PersonService;
import com.mcbalsa.directory.dto.PersonRequestDTO;
import com.mcbalsa.directory.dto.PersonResponseDTO;
import com.mcbalsa.directory.models.Person;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person createNew(PersonRequestDTO PersonRequestDTO) {
        return personRepository.save(
            Person.builder()
                .firstName(PersonRequestDTO.getFirstName())
                .lastName(PersonRequestDTO.getLastName())
                .ssn(PersonRequestDTO.getSsn())
                .build()
        );
    }

    @Override

    public Person updatePerson(PersonResponseDTO personRespDto) {
        Optional<Person> existingPerson = personRepository.findById(personRespDto.getId());
        if(existingPerson.isEmpty())
            throw new RuntimeException(String.format("No person found for id %s", personRespDto.getId()));
        existingPerson.get().setFirstName(personRespDto.getFirstName());
        existingPerson.get().setLastName(personRespDto.getLastName());
        existingPerson.get().setSsn(personRespDto.getSsn());
        return personRepository.save(existingPerson.get());
    }

    @Override
    public List<PersonResponseDTO> getAllPeople() {
        List<Person> people = personRepository.findAll();

        return people.stream().map(this::mapToPersonResponseDTO).toList();
    }

    private PersonResponseDTO mapToPersonResponseDTO(Person person) {
        return PersonResponseDTO.builder()
            .id(person.getId())
            .firstName(person.getFirstName())
            .lastName(person.getLastName())
            .ssn(person.getSsn())
            .build();
    }

    @Override
    public Boolean deleteById(String id) {
        personRepository.deleteById(id);
        if (personRepository.findById(id).isEmpty())
            return Boolean.TRUE;
        return Boolean.FALSE;
    }    
}
