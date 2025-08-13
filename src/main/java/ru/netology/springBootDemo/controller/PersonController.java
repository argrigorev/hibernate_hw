package ru.netology.springBootDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.springBootDemo.entity.Person;
import ru.netology.springBootDemo.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/by-city")
    public List<Person> findByCity(String city) {
        return personService.findByCity(city);
    }
}
