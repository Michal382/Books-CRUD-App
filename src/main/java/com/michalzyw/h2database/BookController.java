package com.michalzyw.h2database;

import com.michalzyw.h2database.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.michalzyw.h2database.entity.Book;
import com.michalzyw.h2database.service.BookService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {

    @Autowired
    BookService service;

    @GetMapping("/")
    public String findAll(Model model){
        model.addAttribute("books", service.findallBooks());
        return "all-books";

    }

    @GetMapping("/add")
    public String launchAddBookPage(Model model){
        model.addAttribute("book", new Book());
        return "add-book";

    }

    @PostMapping("/addbook")
    public String createBook(Book book){
        service.addBook(book);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String launchEditPage(Model model, @PathVariable("id") int id){
        model.addAttribute("book", service.findBookById(id));
        return "edit-book";
    }

    @PostMapping("/updatebook")
    public String updateBook(Book book){
        service.updateBook(book);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") int id){
        service.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/test")
    public String test(){
        Book bk = new Book();
        bk.setId(1);
        bk.setName("TEST BOOK");
        bk.setPublication("JAVA APK");
        bk.setNumOfPages(355);
        bk.setAuthor("MŻ");
        service.addBook(bk);
        return "index";
    }
}
