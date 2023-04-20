package com.tirsh.controller;

import com.tirsh.dao.BookDAO;
import com.tirsh.dao.PersonDAO;
import com.tirsh.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@RequestMapping("/people")
public class PersonController {
    PersonDAO personDAO;
    BookDAO bookDAO;

    public PersonController(PersonDAO personDAO, BookDAO bookDAO) {
        this.bookDAO = bookDAO;
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String show(Model model){
        model.addAttribute("people", personDAO.showAll());
        return "/people/index";
    }
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("person", new Person());
        return "/people/add";
    }

    @PostMapping
    public String create(@ModelAttribute("person") @Valid Person person){
        System.out.println(person);
        personDAO.create(person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete (@PathVariable("id") int id){
        personDAO.delete(id);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit (@PathVariable("id") int id,Model model){
        model.addAttribute("person", personDAO.getById(id));
        return "/people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("person") Person person){
        personDAO.update(id, person);
        return "redirect:/people";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        Person person = personDAO.getById(id);
        model.addAttribute("person", person);
        model.addAttribute("books", bookDAO.getBooksByPersonId(id));
        return "/people/show";
    }
}
