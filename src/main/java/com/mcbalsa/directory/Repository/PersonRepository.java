package com.mcbalsa.directory.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mcbalsa.directory.models.Person;

public interface PersonRepository extends MongoRepository<Person, String>{
    
}
