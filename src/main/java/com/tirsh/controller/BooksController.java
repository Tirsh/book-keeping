package com.tirsh.controller;

import com.tirsh.dao.BookDAO;
import com.tirsh.dao.PersonDAO;
import com.tirsh.model.Book;
import com.tirsh.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BooksController {
    BookDAO bookDAO;
    PersonDAO personDAO;

    public BooksController(BookDAO bookDAO, PersonDAO personDAO) {
        this.personDAO = personDAO;
        this.bookDAO = bookDAO;
    }

    @GetMapping
    public String index(Model model){
        model.addAttribute("books", bookDAO.getAll());
        return "/books/index";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("book", new Book());
        return "/books/add";
    }

    @PostMapping
    public String create(@ModelAttribute("book") Book book){
        bookDAO.create(book);
        return "redirect:/books";
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable int id){
        bookDAO.delete(id);
        return "redirect:/books";
    }
    @GetMapping("/{id}/edit")
    public String edit (@PathVariable("id") int id,Model model){
        model.addAttribute("book", bookDAO.getById(id));
        return "/books/edit";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") int id, @ModelAttribute("book") Book book){
        System.out.println(book);
        bookDAO.update(id, book);
        return "redirect:/books";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("book", bookDAO.getById(id));
        model.addAttribute("newPerson", new Person());
        model.addAttribute("people", personDAO.showAll());
        return "/books/show";
    }

    @PatchMapping("/{id}/free")
    public String free(@PathVariable("id") int id){
        //TODO Edit
        bookDAO.getById(id).setUser_id(null);
        return "redirect:/books";
    }

    @PatchMapping("/{id}/take")
    public String take(@PathVariable("id") int id, @ModelAttribute("newPerson") Person person){
        //TODO person id
        System.out.println(person.getPerson_id());
        return "redirect:/books";
    }
}
