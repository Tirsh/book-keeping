package com.tirsh.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

public class Person {
    private int person_id;

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    public Person() {
    }

//    public Person(int id, String name, LocalDate birthday) {
//        this.personId = id;
//        this.name = name;
//        this.birthday = birthday;
//    }


//    public int getId() {
//        return personId;
//    }
//
//    public void setId(int person_Id) {
//        this.personId = personId;
//    }


    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return String.format("%d - %s", person_id, name);
    }
}
