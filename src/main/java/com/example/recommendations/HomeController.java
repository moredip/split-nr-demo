package com.example.recommendations;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/humans.txt")
    public String humans(){
        return "Pete Hodgson";
    }
}
