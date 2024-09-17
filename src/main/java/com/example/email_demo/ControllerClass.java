package com.example.email_demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller
 */
@Controller
public class ControllerClass {

    @GetMapping("/")
    public String home() {
        return "Regi";
    }
    
}