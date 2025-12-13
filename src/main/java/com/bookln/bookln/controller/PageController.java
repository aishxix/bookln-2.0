package com.bookln.bookln.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


public class PageController {
    @GetMapping("/")
    public  String home(){
        return "index.html";
    }
}
