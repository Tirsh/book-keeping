package com.tirsh.dao;

import com.tirsh.model.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonDAO {
    JdbcTemplate jdbcTemplate;

    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Person getById(int id) {
        return jdbcTemplate.query("SELECT * FROM people WHERE person_id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class)).stream().findFirst().orElse(null);
    }

    public void create(Person person) {
        jdbcTemplate.update("INSERT INTO people(name, birthday) VALUES (?, ?)", person.getName(), person.getBirthday());
    }

    public List<Person> showAll() {
        return jdbcTemplate.query("SELECT * FROM people", new BeanPropertyRowMapper<>(Person.class));
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM people WHERE person_id=?", id);
    }

    public void update(int id, Person person) {
        jdbcTemplate.update("UPDATE people SET name=?, birthday=? WHERE person_id=?", person.getName(), person.getBirthday(), id);
    }
}
