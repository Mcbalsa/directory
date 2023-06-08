package com.mcbalsa.directory.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mcbalsa.directory.dto.PersonRequestDTO;
import com.mcbalsa.directory.dto.PersonResponseDTO;
import com.mcbalsa.directory.models.Person;

@Service
public interface PersonService {
    Person createNew(PersonRequestDTO personRequestDTO);
    
    Person updatePerson(PersonResponseDTO personRespDto);

    List<PersonResponseDTO> getAllPeople();

    Boolean deleteById(String id);
}
