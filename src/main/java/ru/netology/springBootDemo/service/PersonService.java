package ru.netology.springBootDemo.service;

import org.springframework.stereotype.Service;
import ru.netology.springBootDemo.entity.Person;
import ru.netology.springBootDemo.entity.PersonId;
import ru.netology.springBootDemo.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findByCity(String city) {
        return personRepository.findByCity(city);
    }

    public List<Person> findByPersonIdAgeLessThan(int age) {
        return personRepository.findByAgeLessThan(age);
    }

    public Optional<Person> findByNameAndSurname(String name, String surname) {
        return personRepository.findByNameAndSurname(name, surname);
    }

    public void save(Person person) {
        personRepository.save(person);
    }

    public void loadInitialData() {
        personRepository.save(new Person(
                new PersonId("Ivan", "Petrov", 30),
                "+79991112222",
                "Moscow"
        ));

        personRepository.save(new Person(
                new PersonId("Anna", "Sidorova", 25),
                "+79999999999",
                "Moscow"
        ));

        personRepository.save(new Person(
                new PersonId("Petr", "Ivanov", 40),
                "+78957777777",
                "Saint Petersburg"
        ));
    }
}
