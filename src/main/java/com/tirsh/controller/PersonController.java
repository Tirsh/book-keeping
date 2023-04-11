package com.tirsh.controller;

import com.tirsh.dao.PersonDAO;
import com.tirsh.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/people")
public class PersonController {
    PersonDAO personDAO;

    public PersonController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String show(Model model){
        model.addAttribute("people", personDAO.showAll());
        System.out.println("data");
        System.out.println(personDAO.showAll());
        return "/index";
    }
    @GetMapping("/add")
    public String add(){
        personDAO.create(new Person(1, "Val", LocalDate.parse("2002-03-29")));
        personDAO.create(new Person(1, "Ba", LocalDate.parse("2011-03-20")));
        return "/people/index";
    }
}
