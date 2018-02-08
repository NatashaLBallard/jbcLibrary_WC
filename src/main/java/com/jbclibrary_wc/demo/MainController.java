package com.jbclibrary_wc.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    JBCLibraryRepository jbcLibraryRepository;

    @RequestMapping("/")
    public String index(){
        return "index";
    }









}
