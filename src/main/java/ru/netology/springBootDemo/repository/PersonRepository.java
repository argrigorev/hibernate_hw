package ru.netology.springBootDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.netology.springBootDemo.entity.Person;
import ru.netology.springBootDemo.entity.PersonId;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, PersonId> {

    @Query("SELECT p FROM Person p WHERE p.cityOfLiving = :city")
    List<Person> findByCity(@Param("city") String city);

    @Query("SELECT p FROM Person p WHERE p.personId.age < :age ORDER BY p.personId.age ASC")
    List<Person> findByAgeLessThan(@Param("age") int age);

    @Query("SELECT p FROM Person p WHERE p.personId.name = :name AND p.personId.surname = :surname")
    Optional<Person> findByNameAndSurname(@Param("name") String name, @Param("surname") String surname);
}
