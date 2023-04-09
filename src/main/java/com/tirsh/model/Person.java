package com.tirsh.model;

import java.time.LocalDateTime;

public class Person {
    private int person_id;
    private String name;
    private LocalDateTime localDateTime;

    public Person(int person_id, String name) {
        this.person_id = person_id;
        this.name = name;
    }

    public Person() {
    }

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

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
