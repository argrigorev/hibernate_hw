package ru.netology.springBootDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.netology.springBootDemo.entity.Person;
import ru.netology.springBootDemo.entity.PersonId;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, PersonId> {

    List<Person> findByCityOfLiving(String city);

    List<Person> findByPersonIdAgeLessThanOrderByPersonIdAgeAsc(int age);

    Optional<Person> findByPersonIdNameAndPersonIdSurname(String name, String surname);
}
