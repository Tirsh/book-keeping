package com.tirsh.model;
import javax.validation.constraints.*;

public class Book {
    private int id;
    private Integer user_id;

    @NotEmpty(message = "Title should not be empty!!!")
    @Size(min = 2, max = 50, message = "Title should be between 2 and 100 characters!")
    private String title;

    @NotEmpty(message = "Author should not be empty!!!")
    @Size(min = 2, max = 50, message = "Author should be between 2 and 100 characters!")
    private String author;


    @Min(value = 0, message = "Year should be greater then zero!")
    private int year;

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
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
