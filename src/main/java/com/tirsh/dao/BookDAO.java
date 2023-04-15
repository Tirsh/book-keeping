package com.tirsh.dao;

import com.tirsh.model.Book;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookDAO {
    JdbcTemplate jdbcTemplate;

    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> getAll(){
        return jdbcTemplate.query("SELECT * FROM books", new BeanPropertyRowMapper<>(Book.class));
    }

    public void create(Book book){
        jdbcTemplate.update("INSERT INTO books(title, author, year) VALUES (? ,?, ?)",
                book.getTitle(), book.getAuthor(), book.getYear());
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM books WHERE bool_id=?", id);
    }
}
