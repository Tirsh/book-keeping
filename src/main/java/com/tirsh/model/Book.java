package com.tirsh.model;

import javax.validation.constraints.*;

public class Book {
    private int id;
    private Person user_id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getUser_id() {
        return user_id;
    }

    public void setUser_id(Person user_id) {
        this.user_id = user_id;
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
