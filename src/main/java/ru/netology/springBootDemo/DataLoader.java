package ru.netology.springBootDemo;

import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.netology.springBootDemo.service.PersonService;

@Component
public class DataLoader implements CommandLineRunner {

    private final PersonService personService;

    public DataLoader(PersonService personService) {
        this.personService = personService;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        personService.loadInitialData();
    }
}