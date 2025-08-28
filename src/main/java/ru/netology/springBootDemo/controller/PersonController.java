package ru.netology.springBootDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.springBootDemo.entity.Person;
import ru.netology.springBootDemo.service.PersonService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Добро пожаловать! Этот эндпоинт доступен без авторизации.";
    }

    @GetMapping("/by-city")
    public List<Person> findByCity(@RequestParam String city) {
        return personService.findByCity(city);
    }

    @GetMapping("/by-age")
    public List<Person> findByAgeLessThan(@RequestParam int age) {
        return personService.findByPersonIdAgeLessThan(age);
    }

    @GetMapping("/by-name-surname")
    public Optional<Person> findByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return personService.findByNameAndSurname(name, surname);
    }
}
