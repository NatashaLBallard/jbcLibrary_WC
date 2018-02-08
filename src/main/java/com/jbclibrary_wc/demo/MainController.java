package com.jbclibrary_wc.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    JBCLibraryRepository jbcLibraryRepository;


    //Index page
    @RequestMapping("/")
    public String index(){
        return "index";
    }


    //List Books page
    @RequestMapping("/list")
    public String listBooks(Model model){
        model.addAttribute("jbcLibraries", jbcLibraryRepository.findAll());
        return "list";
    }


    //Add Books page
    @GetMapping("/add")
    public String addBooksForm(Model model){
        model.addAttribute("jbcLibrary", new JBCLibrary);
        return "bookform";
    }


    //Process New Book
    @PostMapping("/process")
    public String processForm(@Valid @ModelAttribute("jbcLibrary") JBCLibrary jbcLibrary, BindingResult result) {
        if (result.hasErrors()) {
            return "bookform";
        }
        jbcLibraryRepository.save(jbcLibrary);
        return "redirect:/";
    }





    //View Details of Book
    @RequestMapping("/detail/{id}")
    public String showBook(@PathVariable("id") long id, Model model) {
        model.addAttribute("jbcLibrary", jbcLibraryRepository.findOne(id));
        return "show";
    }


    //Update of Book
    @RequestMapping("/update/{id}")
    public String updateBook(@PathVariable("id") long id, Model model) {
        model.addAttribute("jbcLibrary", jbcLibraryRepository.findOne(id));
        return "bookform";
    }


    //Delete Book
    @RequestMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") long id) {
        jbcLibraryRepository.delete(id);
        return "redirect:/";
    }




    //-------------------


    @Autowired
    BorrowRepository borrowRepository;

    //View Borrowed Books page
    @RequestMapping("/borrow")
    public String listBorrowedBooks(Model model){
        model.addAttribute("borrowedBooks", new StatusSystem());
        return "borrow";
    }



    //Add Checked book to Borrow Repository page
    @GetMapping("/add_borrow")
    public String addBorrowedBook(Model model){
        model.addAttribute("borrowedBook", new StatusSystem());
        return "borrow";
    }

    //Process Borrow Checkbox
    @PostMapping("/borrow_process")
    public String borrowForm(@Valid @ModelAttribute("borrowedBook") StatusSystem statusSystem, BindingResult result) {
        if (result.hasErrors()){
            return "borrow";
        }
        borrowRepository.save(statusSystem);
        return "redirect:/";
    }


    //View Details of Book
    @RequestMapping("/detail-borrow/{id}")
    public String showBorrowedBook(@PathVariable("id") long id, Model model) {
        model.addAttribute("borrowedBook", borrowRepository.findOne(id));
        return "borrow_show";
    }


    //Update of Book
    @RequestMapping("/update-borrow/{id}")
    public String updateBorrowedBook(@PathVariable("id") long id, Model model) {
        model.addAttribute("borrowedBook", borrowRepository.findOne(id));
        return "borrow";
    }


    //Delete Book
    @RequestMapping("/delete-borrow/{id}")
    public String deleteBorrowedBook(@PathVariable("id") long id) {
        borrowRepository.delete(id);
        return "redirect:/";
    }







}
