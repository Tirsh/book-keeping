package com.tirsh.controller;

import com.tirsh.dao.BookDAO;
import com.tirsh.dao.PersonDAO;
import com.tirsh.model.Book;
import com.tirsh.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public String create(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "/books/add";
        }
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
    public String update(@PathVariable("id") int id, @ModelAttribute("book") @Valid Book book, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "/books/edit";
        }
        bookDAO.update(id, book);
        return "redirect:/books";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model, @ModelAttribute("person") Person person){
        model.addAttribute("book", bookDAO.getById(id));
        model.addAttribute("people", personDAO.showAll());
        return "/books/show";
    }

    @PatchMapping("/{id}/free")
    public String free(@PathVariable("id") int id){
        bookDAO.setNullUserId(id);
        return "redirect:/books";
    }

    @PatchMapping("/{id}/take")
    public String take(@PathVariable("id") int id, @ModelAttribute("person") Person person){
        bookDAO.setUserId(id, person.getPerson_id());
        return "redirect:/books";
    }
}
