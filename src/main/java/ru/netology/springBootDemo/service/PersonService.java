package ru.netology.springBootDemo.service;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.netology.springBootDemo.entity.Person;
import ru.netology.springBootDemo.entity.PersonId;
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
