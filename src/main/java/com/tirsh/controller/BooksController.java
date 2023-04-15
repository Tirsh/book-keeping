package com.tirsh.controller;

import com.tirsh.dao.BookDAO;
import com.tirsh.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BooksController {
    BookDAO bookDAO;

    public BooksController(BookDAO bookDAO) {
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
}
