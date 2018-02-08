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
        model.addAttribute("jbcLibrary", new JBCLibrary());
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


//    @Autowired
//    BorrowRepository borrowRepository;

    //View Borrowed Books page
    @RequestMapping("/borrow")
    public String listBorrowedBooks(Model model){
        model.addAttribute("jbcLibraries", jbcLibraryRepository.findAll());
        return "borrow";
    }




    //Add Checked book to Borrow Repository page
    @GetMapping("/add_borrow")
    public String addBorrowedBook(Model model){
        model.addAttribute("jbcLibrary", new JBCLibrary());
        return "borrow";
    }

    //Process Borrow Checkbox
    @PostMapping("/borrow_process")
    public String borrowForm(@Valid @ModelAttribute("jbcLibrary") JBCLibrary jbcLibrary, BindingResult result) {
        if (result.hasErrors()){
            return "borrow";
        }
        jbcLibraryRepository.save(jbcLibrary);
        return "redirect:/";
    }

    @RequestMapping("/checkbox-process")
    public String checked(@RequestParam(defaultValue = "false") boolean borrowed){
        if (borrowed==true) {
            System.out.println("Book is checked out");
            return "borrow_show";
        }
        else
            System.out.println("Book is not checked out");

        //${jbcLibrary.borrowed}==true;
        return "redirect:/";
    }

//    @RequestMapping(value="/jbcLibrary.borrowed/{id}", method=RequestMethod.GET)
//    public String setCheckBox(@PathVariable("id")boolean borrowed, Model model){
//        model.addAttribute("true", this.setCheckBox("false"));
//        return "Updated value";
//    }






//    @RequestMapping("/checkbox-process")
//    public String checked(@RequestParam() boolean borrowed){
//        if (borrowed==false) {
//            System.out.println("Book is not checked out");
//            //borrowed=false;
//            return "borrow_show";
//        }
//        else
//            System.out.println("Book is checked out");
//        jbcLibraryRepository.save(jbcLibrary.borrowed);
//
//        //${jbcLibrary.borrowed}==true;
//        return "redirect:/";
//    }







}
