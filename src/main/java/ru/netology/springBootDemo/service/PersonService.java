package ru.netology.springBootDemo.service;

import org.springframework.stereotype.Service;
import ru.netology.springBootDemo.entity.Person;
import ru.netology.springBootDemo.repository.PersonRepository;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findByCity(String city) {
        return personRepository.getPersonsByCity(city);
    }
}
