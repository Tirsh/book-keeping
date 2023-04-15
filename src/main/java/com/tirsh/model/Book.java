package com.tirsh.model;

import javax.validation.constraints.*;

public class Book {
    private int bool_id;
    private Person personId;
//    @NotEmpty(message = "Name should not be empty")
//    @Size(min = 2, max = 30, message = "More then 2, less then 30")
    private String title;
//    @NotEmpty(message = "Name should not be empty")
//    @Size(min = 2, max = 30, message = "More then 2, less then 30")
    private String author;
//    @Min(value = 2000, message = "Too old")
//    @Max(value = 2050, message = "Incorrect")
    private int year;

    public Book() {
    }

    public int getBool_id() {
        return bool_id;
    }

    public void setBool_id(int bool_id) {
        this.bool_id = bool_id;
    }

    public Person getPersonId() {
        return personId;
    }

    public void setPersonId(Person personId) {
        this.personId = personId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
