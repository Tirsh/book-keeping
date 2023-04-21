package com.tirsh.dao;

import com.tirsh.model.Book;
import com.tirsh.model.Person;
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

    public Book getById(int id){
        return jdbcTemplate.query("SELECT * FROM books WHERE id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class)).stream().findFirst().orElse(null);
    }

    public void create(Book book){
        jdbcTemplate.update("INSERT INTO books(title, author, year) VALUES (? ,?, ?)",
                book.getTitle(), book.getAuthor(), book.getYear());
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM books WHERE id=?", id);
    }

    public void update(int id, Book book){
        jdbcTemplate.update("UPDATE books SET title=?, author=?, year=? WHERE id=?", book.getTitle(),  book.getAuthor(), book.getYear(), id);
    }

    public List<Book> getBooksByPersonId(int id) {
        return jdbcTemplate.query("SELECT * FROM books WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class));
    }

    public void setUserId(int id, int userId){
        jdbcTemplate.update("UPDATE books SET user_id=? WHERE id=?", userId, id);
    }

    public void setNullUserId(int id){
        jdbcTemplate.update("UPDATE books SET user_id=NULL WHERE id=?", id);
    }
}
