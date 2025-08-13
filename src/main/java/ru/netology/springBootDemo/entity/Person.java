package ru.netology.springBootDemo.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Persons")
public class Person {

    @EmbeddedId
    private PersonId personId;

    private String phoneNumber;
    private String cityOfLiving;

    public Person() {}

    public Person(PersonId personId, String phoneNumber, String cityOfLiving) {
        this.personId = personId;
        this.phoneNumber = phoneNumber;
        this.cityOfLiving = cityOfLiving;
    }

    public PersonId getPersonId() {
        return personId;
    }

    public void setPersonId(PersonId personId) {
        this.personId = personId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCityOfLiving() {
        return cityOfLiving;
    }

    public void setCityOfLiving(String cityOfLiving) {
        this.cityOfLiving = cityOfLiving;
    }
}
