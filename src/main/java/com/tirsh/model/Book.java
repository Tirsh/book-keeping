package com.tirsh.model;
import jakarta.validation.constraints.*;

public class Book {
    private int id;
    private Person personId;
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "More then 2, less then 30")
    private String title;
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "More then 2, less then 30")
    private String author;
    @Min(value = 2000, message = "Too old")
    @Max(value = 2050, message = "Incorrect")
    private int year;

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Book(int id, Person personId, String title, String author, int year) {
        this.id = id;
        this.personId = personId;
        this.title = title;
        this.author = author;
        this.year = year;
    }
}
